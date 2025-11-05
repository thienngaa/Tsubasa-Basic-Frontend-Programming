CREATE DATABASE SalesDB;
USE SalesDB;
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerName VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE,
    Phone VARCHAR(20)
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
CREATE TABLE Promotions (
    PromotionID INT PRIMARY KEY AUTO_INCREMENT,
    PromotionName VARCHAR(100),
    DiscountPercent DECIMAL(5,2),
    StartDate DATE,
    EndDate DATE
);
CREATE TABLE Sales (
    SaleID INT PRIMARY KEY AUTO_INCREMENT,
    OrderID INT,
    ProductID INT,
    Quantity INT,
    SaleAmount DECIMAL(12,2),
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);
CREATE INDEX idx_customers_email ON Customers(Email);
CREATE INDEX idx_orders_orderdate ON Orders(OrderDate);
CREATE INDEX idx_sales_orderid ON Sales(OrderID);
DELIMITER //

CREATE PROCEDURE UpdateOrderTotalAmount (
    IN inOrderID INT,
    IN inNewTotalAmount DECIMAL(12,2)
)
BEGIN
    UPDATE Orders
    SET TotalAmount = inNewTotalAmount
    WHERE OrderID = inOrderID;
END //

DELIMITER ;
INSERT INTO Customers (CustomerName, Email, Phone)
VALUES 
('Nguyen Van A', 'a@example.com', '0901111222'),
('Tran Thi B', 'b@example.com', '0902222333');

INSERT INTO Orders (CustomerID, OrderDate, TotalAmount)
VALUES 
(1, '2025-11-05', 300.00),
(2, '2025-11-06', 450.00);
CALL UpdateOrderTotalAmount(1, 500.00);
SELECT * FROM Orders;
