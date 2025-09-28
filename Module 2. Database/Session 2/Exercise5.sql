CREATE DATABASE IF NOT EXISTS CompanyDB;
CREATE SCHEMA IF NOT EXISTS CompanyDB;
USE CompanyDB;

CREATE TABLE Products (
	ProductID	INT PRIMARY KEY,
    ProductName	NVARCHAR(100) NOT NULL, 
    Category	NVARCHAR(50) NOT NULL, 
    Price		DECIMAL(10,2) NOT NULL, 
    StockQuantity	INT NOT NULL
);

CREATE TABLE Orders (
	OrderID		INT PRIMARY KEY, 
    OrderDate	DATE NOT NULL, 
    ProductID 	INT NOT NULL REFERENCES Products(ProductID),
    Quantity	INT NOT NULL,
    TotalAmount	DECIMAL(10,2) NOT NULL CHECK (totalAmount >= 0)
);

INSERT INTO Products (ProductID, ProductName, Category, Price, StockQuantity)
VALUES
    (1, 'Dell XPS 13 Laptop', 'Computer', 32000.00, 15),
    (2, 'iPhone 15 Pro', 'Phone', 28000.00, 30),
    (3, 'Sony WH-1000XM5 Headphones', 'Audio', 8500.50, 50);
    
SELECT * FROM Product;

INSERT INTO Orders (OrderID, OrderDate, ProductID, Quantity, TotalAmount)
VALUES
    (1, '2025-09-28', 1, 2, 32000.00 * 2), 
    (2, '2025-09-29', 3, 1, 8500.50 * 1);

SELECT * FROM Orders;
