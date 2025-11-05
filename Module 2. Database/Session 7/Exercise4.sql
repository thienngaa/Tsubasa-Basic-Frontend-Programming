CREATE DATABASE SalesDB;
USE SalesDB;
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerName VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE,
    Phone VARCHAR(20),
    Address VARCHAR(255)
);
CREATE TABLE Products (
    ProductID INT PRIMARY KEY AUTO_INCREMENT,
    ProductName VARCHAR(100) NOT NULL,
    Price DECIMAL(10,2) NOT NULL,
    Stock INT DEFAULT 0
);
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerID INT,
    OrderDate DATE,
    TotalAmount DECIMAL(12,2),
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
-- Chỉ số cho cột Email trong bảng Customers
CREATE INDEX idx_customers_email ON Customers(Email);

-- Chỉ số cho cột OrderDate trong bảng Orders
CREATE INDEX idx_orders_orderdate ON Orders(OrderDate);
CREATE VIEW CustomerOrders AS
SELECT 
    o.OrderID,
    c.CustomerName,
    o.OrderDate,
    o.TotalAmount
FROM Orders o
JOIN Customers c ON o.CustomerID = c.CustomerID;
INSERT INTO Customers (CustomerName, Email, Phone, Address)
VALUES 
('Nguyen Van A', 'a@example.com', '0901111222', 'Hanoi'),
('Tran Thi B', 'b@example.com', '0903333444', 'HCM City');

INSERT INTO Orders (CustomerID, OrderDate, TotalAmount)
VALUES 
(1, '2025-11-05', 200.00),
(2, '2025-11-05', 180.00);
UPDATE Orders
SET TotalAmount = 250.00
WHERE OrderID = 1;
-- Xem lại dữ liệu trong view
SELECT * FROM CustomerOrders;

-- Xem thông tin của OrderID = 1
SELECT * FROM Orders WHERE OrderID = 1;
