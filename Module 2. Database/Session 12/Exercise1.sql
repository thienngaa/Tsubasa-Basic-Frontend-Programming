-- Tạo cơ sở dữ liệu
CREATE DATABASE IF NOT EXISTS ecommerce;
USE ecommerce;

-- 1. Bảng customers (Khách hàng)
CREATE TABLE IF NOT EXISTS customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(20),
    address TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. Bảng orders (Đơn hàng)
CREATE TABLE IF NOT EXISTS orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10,2) DEFAULT 0,
    status ENUM('Pending', 'Completed', 'Cancelled') DEFAULT 'Pending',
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE
);

-- 3. Bảng products (Sản phẩm)
CREATE TABLE IF NOT EXISTS products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 4. Bảng order_items (Chi tiết đơn hàng)
CREATE TABLE IF NOT EXISTS order_items (
    order_item_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- 5. Bảng inventory (Kho hàng)
CREATE TABLE IF NOT EXISTS inventory (
    product_id INT PRIMARY KEY,
    stock_quantity INT NOT NULL CHECK (stock_quantity >= 0),
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE
);

-- 6. Bảng payments (Thanh toán)
CREATE TABLE IF NOT EXISTS payments (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    amount DECIMAL(10,2) NOT NULL,
    payment_method ENUM('Credit Card', 'PayPal', 'Bank Transfer', 'Cash') NOT NULL,
    status ENUM('Pending', 'Completed', 'Failed') DEFAULT 'Pending',
    FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE
);

-- Trigger BEFORE INSERT (Kiểm tra tồn kho trước khi thêm order_items)
DELIMITER //

CREATE TRIGGER trg_before_order_items_insert
BEFORE INSERT ON order_items
FOR EACH ROW
BEGIN
    DECLARE available_stock INT;

    SELECT stock_quantity INTO available_stock
    FROM inventory
    WHERE product_id = NEW.product_id;

    IF NEW.quantity > available_stock THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Số lượng tồn kho không đủ!';
    END IF;
END //

DELIMITER ;

-- Trigger AFTER INSERT (Cập nhật total_amount trong orders)
DELIMITER //

CREATE TRIGGER trg_after_order_items_insert
AFTER INSERT ON order_items
FOR EACH ROW
BEGIN
    UPDATE orders o
    JOIN (
        SELECT order_id, SUM(quantity * price) AS total
        FROM order_items
        WHERE order_id = NEW.order_id
        GROUP BY order_id
    ) t ON o.order_id = t.order_id
    SET o.total_amount = t.total;
END //

DELIMITER ;

-- Trigger BEFORE UPDATE (Kiểm tra tồn kho khi cập nhật số lượng order_items)
DELIMITER //

CREATE TRIGGER trg_before_order_items_update
BEFORE UPDATE ON order_items
FOR EACH ROW
BEGIN
    DECLARE available_stock INT;

    SELECT stock_quantity INTO available_stock
    FROM inventory
    WHERE product_id = NEW.product_id;

    IF NEW.quantity > available_stock THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Số lượng tồn kho không đủ khi cập nhật!';
    END IF;
END //

DELIMITER ;

-- Trigger AFTER UPDATE (Cập nhật total_amount khi order_items thay đổi)
DELIMITER //

CREATE TRIGGER trg_after_order_items_update
AFTER UPDATE ON order_items
FOR EACH ROW
BEGIN
    UPDATE orders o
    JOIN (
        SELECT order_id, SUM(quantity * price) AS total
        FROM order_items
        WHERE order_id = NEW.order_id
        GROUP BY order_id
    ) t ON o.order_id = t.order_id
    SET o.total_amount = t.total;
END //

DELIMITER ;

-- Trigger BEFORE DELETE (Ngăn chặn xóa đơn hàng Completed)
DELIMITER //

CREATE TRIGGER trg_before_orders_delete
BEFORE DELETE ON orders
FOR EACH ROW
BEGIN
    IF OLD.status = 'Completed' THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Không thể xóa đơn hàng đã hoàn thành!';
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER trg_after_order_items_delete
AFTER DELETE ON order_items
FOR EACH ROW
BEGIN
    UPDATE inventory
    SET stock_quantity = stock_quantity + OLD.quantity
    WHERE product_id = OLD.product_id;
END //

DELIMITER ;

DROP TRIGGER IF EXISTS trg_before_order_items_insert;
DROP TRIGGER IF EXISTS trg_after_order_items_insert;
DROP TRIGGER IF EXISTS trg_before_order_items_update;
DROP TRIGGER IF EXISTS trg_after_order_items_update;
DROP TRIGGER IF EXISTS trg_before_orders_delete;
DROP TRIGGER IF EXISTS trg_after_order_items_delete;
