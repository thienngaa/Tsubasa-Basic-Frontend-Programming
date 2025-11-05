-- Thêm đơn hàng
INSERT INTO orders (customerId, orderDate)
VALUES (1, '2025-11-05');

-- Giả sử đơn hàng mới vừa thêm có orderId = 4 (AUTO_INCREMENT)
-- Thêm chi tiết cho đơn hàng 4
INSERT INTO order_details (orderId, productId, quantity, price)
VALUES
(4, 1, 1, 25000000),  -- iPhone 14
(4, 6, 2, 1500000);   -- Bàn phím Keychron
SELECT MAX(orderId) FROM orders;
SELECT SUM(quantity * price) AS TongDoanhThu
FROM order_details;
SELECT 
    AVG(TongTien) AS DoanhThuTrungBinh
FROM (
    SELECT orderId, SUM(quantity * price) AS TongTien
    FROM order_details
    GROUP BY orderId
) AS BangTam;
SELECT 
    o.orderId,
    o.customerId,
    o.orderDate,
    SUM(od.quantity * od.price) AS DoanhThu
FROM 
    orders o
JOIN 
    order_details od ON o.orderId = od.orderId
GROUP BY 
    o.orderId, o.customerId, o.orderDate
ORDER BY 
    DoanhThu DESC
LIMIT 1;
SELECT 
    p.productName,
    SUM(od.quantity) AS TongSoLuongBan
FROM 
    order_details od
JOIN 
    products p ON od.productId = p.productId
GROUP BY 
    p.productName
ORDER BY 
    TongSoLuongBan DESC
LIMIT 3;
