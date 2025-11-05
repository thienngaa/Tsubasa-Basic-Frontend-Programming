CREATE DATABASE InventoryManagement;
USE InventoryManagement;
CREATE TABLE Products (
    ProductID INT PRIMARY KEY AUTO_INCREMENT,
    ProductName VARCHAR(100) NOT NULL,
    Quantity INT NOT NULL DEFAULT 0,
    Price DECIMAL(10,2) NOT NULL
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

CREATE TRIGGER BeforeProductDelete
BEFORE DELETE ON Products
FOR EACH ROW
BEGIN
    IF OLD.Quantity > 10 THEN
        SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'Không thể xóa sản phẩm có số lượng lớn hơn 10!';
    END IF;
END //

DELIMITER ;
INSERT INTO Products (ProductName, Quantity, Price)
VALUES 
('Laptop', 15, 1500.00),   -- số lượng > 10
('Mouse', 5, 25.00);       -- số lượng <= 10
DELETE FROM Products WHERE ProductID = 1;
DELETE FROM Products WHERE ProductID = 2;
