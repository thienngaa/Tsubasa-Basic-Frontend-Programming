DELIMITER //

CREATE PROCEDURE sp_create_order(
    IN in_customer_id INT,
    IN in_product_id INT,
    IN in_quantity INT,
    IN in_price DECIMAL(10,2)
)
BEGIN
    DECLARE available_stock INT;
    DECLARE new_order_id INT;

    -- Bắt đầu transaction
    START TRANSACTION;

    -- Kiểm tra tồn kho
    SELECT stock_quantity INTO available_stock
    FROM inventory
    WHERE product_id = in_product_id
    FOR UPDATE;

    IF available_stock < in_quantity THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'Số lượng tồn kho không đủ!';
    ELSE
        -- Thêm đơn hàng mới
        INSERT INTO orders (customer_id, total_amount, status)
        VALUES (in_customer_id, 0, 'Pending');

        SET new_order_id = LAST_INSERT_ID();

        -- Thêm sản phẩm vào order_items
        INSERT INTO order_items (order_id, product_id, quantity, price)
        VALUES (new_order_id, in_product_id, in_quantity, in_price);

        -- Cập nhật kho
        UPDATE inventory
        SET stock_quantity = stock_quantity - in_quantity
        WHERE product_id = in_product_id;

        -- Cập nhật tổng tiền đơn hàng
        UPDATE orders
        SET total_amount = (SELECT SUM(quantity * price) 
                            FROM order_items 
                            WHERE order_id = new_order_id)
        WHERE order_id = new_order_id;

        -- Commit transaction
        COMMIT;
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE sp_pay_order(
    IN in_order_id INT,
    IN in_payment_method ENUM('Credit Card','PayPal','Bank Transfer','Cash')
)
BEGIN
    DECLARE current_status ENUM('Pending','Completed','Cancelled');

    START TRANSACTION;

    -- Lấy trạng thái đơn hàng
    SELECT status INTO current_status
    FROM orders
    WHERE order_id = in_order_id
    FOR UPDATE;

    IF current_status != 'Pending' THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Đơn hàng không ở trạng thái Pending!';
    ELSE
        -- Thêm bản ghi thanh toán
        INSERT INTO payments (order_id, amount, payment_method, status)
        SELECT order_id, total_amount, in_payment_method, 'Completed'
        FROM orders
        WHERE order_id = in_order_id;

        -- Cập nhật trạng thái đơn hàng
        UPDATE orders
        SET status = 'Completed'
        WHERE order_id = in_order_id;

        COMMIT;
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE sp_cancel_order(
    IN in_order_id INT
)
BEGIN
    DECLARE current_status ENUM('Pending','Completed','Cancelled');

    START TRANSACTION;

    -- Lấy trạng thái đơn hàng
    SELECT status INTO current_status
    FROM orders
    WHERE order_id = in_order_id
    FOR UPDATE;

    IF current_status != 'Pending' THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Chỉ đơn hàng Pending mới được hủy!';
    ELSE
        -- Hoàn trả kho
        UPDATE inventory i
        JOIN order_items oi ON i.product_id = oi.product_id
        SET i.stock_quantity = i.stock_quantity + oi.quantity
        WHERE oi.order_id = in_order_id;

        -- Xóa các sản phẩm trong order_items
        DELETE FROM order_items
        WHERE order_id = in_order_id;

        -- Cập nhật trạng thái đơn hàng
        UPDATE orders
        SET status = 'Cancelled'
        WHERE order_id = in_order_id;

        COMMIT;
    END IF;
END //

DELIMITER ;

DROP PROCEDURE IF EXISTS sp_create_order;
DROP PROCEDURE IF EXISTS sp_pay_order;
DROP PROCEDURE IF EXISTS sp_cancel_order;
