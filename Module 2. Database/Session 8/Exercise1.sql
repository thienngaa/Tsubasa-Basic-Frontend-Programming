CREATE DATABASE SalesDB;
USE SalesDB;
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerName VARCHAR(100) NOT NULL,
    Email VARCHAR(100),
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

CREATE PROCEDURE GetCustomerTotalRevenue (
    IN inCustomerID INT,
    IN inStartDate DATE,
    IN inEndDate DATE
)
BEGIN
    SELECT 
        c.CustomerName,
        SUM(s.SaleAmount) AS TotalRevenue
    FROM Sales s
    JOIN Orders o ON s.OrderID = o.OrderID
    JOIN Customers c ON o.CustomerID = c.CustomerID
    WHERE o.CustomerID = inCustomerID
      AND o.OrderDate BETWEEN inStartDate AND inEndDate
    GROUP BY c.CustomerName;
END //

DELIMITER ;
INSERT INTO Customers (CustomerName, Email, Phone)
VALUES 
('Nguyen Van A', 'a@example.com', '0901111222'),
('Tran Thi B', 'b@example.com', '0902222333');

INSERT INTO Products (ProductName, Price, Stock)
VALUES 
('Laptop', 1500.00, 10),
('Mouse', 20.00, 100),
('Keyboard', 50.00, 50);

INSERT INTO Orders (CustomerID, OrderDate, TotalAmount)
VALUES
(1, '2025-11-01', 1550.00),
(1, '2025-11-03', 70.00),
(2, '2025-11-05', 1600.00);

INSERT INTO Sales (OrderID, ProductID, Quantity, SaleAmount)
VALUES
(1, 1, 1, 1500.00),
(1, 2, 1, 20.00),
(2, 3, 1, 50.00),
(3, 1, 1, 1500.00),
(3, 2, 5, 100.00);
CALL GetCustomerTotalRevenue(1, '2025-11-01', '2025-11-10');
