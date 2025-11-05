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

CREATE TRIGGER AfterProductUpdate
AFTER UPDATE ON Products
FOR EACH ROW
BEGIN
    -- Chỉ ghi lại khi số lượng thay đổi
    IF OLD.Quantity <> NEW.Quantity THEN
        INSERT INTO InventoryChanges (ProductID, OldQuantity, NewQuantity)
        VALUES (NEW.ProductID, OLD.Quantity, NEW.Quantity);
    END IF;
END //

DELIMITER ;
