CREATE DATABASE SalesDB;
USE SalesDB;
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
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

CREATE PROCEDURE AddNewCustomer (
    IN inFirstName VARCHAR(50),
    IN inLastName VARCHAR(50),
    IN inEmail VARCHAR(100)
)
BEGIN
    INSERT INTO Customers (FirstName, LastName, Email)
    VALUES (inFirstName, inLastName, inEmail);
END //

DELIMITER ;
CALL AddNewCustomer('Nguyen', 'Van A', 'vana@example.com');
CALL AddNewCustomer('Tran', 'Thi B', 'thib@example.com');
SELECT * FROM Customers;
