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
    Price DECIMAL(10,2) NOT NULL
);
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerID INT,
    OrderDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
CREATE TABLE OrderDetails (
    OrderDetailID INT PRIMARY KEY AUTO_INCREMENT,
    OrderID INT,
    ProductID INT,
    Quantity INT NOT NULL,
    Price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);
-- Chỉ số cho Email trong Customers (thường tìm kiếm khách hàng bằng email)
CREATE INDEX idx_customers_email ON Customers(Email);

-- Chỉ số cho OrderDate trong Orders (thường lọc đơn hàng theo ngày)
CREATE INDEX idx_orders_orderdate ON Orders(OrderDate);
CREATE VIEW CustomerOrders AS
SELECT 
    o.OrderID,
    c.CustomerName,
    o.OrderDate,
    SUM(od.Quantity * od.Price) AS TotalAmount
FROM 
    Orders o
JOIN 
    Customers c ON o.CustomerID = c.CustomerID
JOIN 
    OrderDetails od ON o.OrderID = od.OrderID
GROUP BY 
    o.OrderID, c.CustomerName, o.OrderDate;
SELECT * FROM CustomerOrders;
