CREATE TABLE customers (
    customerId INT PRIMARY KEY AUTO_INCREMENT,
    customerName VARCHAR(100) NOT NULL,
    customerEmail VARCHAR(100)
);

CREATE TABLE orders (
    orderId INT PRIMARY KEY AUTO_INCREMENT,
    customerId INT,
    orderDate DATE,
    FOREIGN KEY (customerId) REFERENCES customers(customerId)
);

CREATE TABLE order_details (
    orderId INT,
    productId INT,
    quantity INT NOT NULL,
    price DECIMAL(15,2) NOT NULL,
    FOREIGN KEY (orderId) REFERENCES orders(orderId),
    FOREIGN KEY (productId) REFERENCES products(productId)
);

INSERT INTO customers (customerName, customerEmail)
VALUES
('Nguyen Van A', 'a@example.com'),
('Tran Thi B', 'b@example.com');

-- Thêm đơn hàng
INSERT INTO orders (customerId, orderDate)
VALUES
(1, '2025-11-01'),
(1, '2025-11-03'),
(2, '2025-11-04');

-- Thêm chi tiết đơn hàng
INSERT INTO order_details (orderId, productId, quantity, price)
VALUES
(1, 1, 1, 25000000),  -- iPhone 14
(1, 3, 2, 1500000),   -- Bàn phím Keychron
(2, 2, 1, 30000000),  -- MacBook Air
(3, 5, 1, 29000000);  -- Dell XPS 13

SELECT DISTINCT c.customerId, c.customerName, c.customerEmail
FROM customers c
JOIN orders o ON c.customerId = o.customerId;

SELECT c.customerId, c.customerName, c.customerEmail
FROM customers c
LEFT JOIN orders o ON c.customerId = o.customerId
WHERE o.orderId IS NULL;

SELECT 
    c.customerName,
    SUM(od.quantity * od.price) AS TongDoanhThu
FROM 
    customers c
JOIN 
    orders o ON c.customerId = o.customerId
JOIN 
    order_details od ON o.orderId = od.orderId
GROUP BY 
    c.customerName;

SELECT 
    c.customerName,
    p.productName,
    od.price
FROM 
    customers c
JOIN 
    orders o ON c.customerId = o.customerId
JOIN 
    order_details od ON o.orderId = od.orderId
JOIN 
    products p ON od.productId = p.productId
WHERE 
    od.price = (SELECT MAX(price) FROM order_details);
