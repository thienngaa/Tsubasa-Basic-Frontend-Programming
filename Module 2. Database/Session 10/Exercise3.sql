CREATE DATABASE InventoryManagement;
USE InventoryManagement;
CREATE TABLE Products (
    ProductID INT PRIMARY KEY AUTO_INCREMENT,
    ProductName VARCHAR(100) NOT NULL,
    Quantity INT NOT NULL DEFAULT 0,
    Price DECIMAL(10,2) NOT NULL,
    LastUpdated DATETIME DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE InventoryChanges (
    ChangeID INT PRIMARY KEY AUTO_INCREMENT,
    ProductID INT,
    OldQuantity INT,
    NewQuantity INT,
    ChangeDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    ChangedBy VARCHAR(100) DEFAULT USER(),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);
DELIMITER //

CREATE TRIGGER AfterProductUpdateSetDate
AFTER UPDATE ON Products
FOR EACH ROW
BEGIN
    -- Cập nhật LastUpdated với thời gian hiện tại
    UPDATE Products
    SET LastUpdated = NOW()
    WHERE ProductID = NEW.ProductID;
END //

DELIMITER ;
INSERT INTO Products (ProductName, Quantity, Price)
VALUES 
('Laptop', 10, 1500.00),
('Mouse', 50, 25.00);
UPDATE Products
SET Quantity = 15
WHERE ProductID = 1;
SELECT ProductID, ProductName, Quantity, LastUpdated
FROM Products;
