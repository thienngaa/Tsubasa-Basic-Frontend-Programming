CREATE DATABASE ProductManagement;
USE ProductManagement;

CREATE TABLE Product (
    Product_Id INT AUTO_INCREMENT PRIMARY KEY,
    Product_Name VARCHAR(100) NOT NULL UNIQUE,
    Product_Price FLOAT NOT NULL CHECK (Product_Price > 0),
    Product_Title VARCHAR(200) NOT NULL,
    Product_created DATE NOT NULL,
    Product_catalog VARCHAR(100) NOT NULL,
    Product_Status BIT DEFAULT 1
);
DELIMITER //
CREATE PROCEDURE PROC_GET_ALL_PRODUCT()
BEGIN
    SELECT * FROM Product;
END //
DELIMITER ;
DELIMITER //
CREATE PROCEDURE PROC_CHECK_CATALOG(
    IN catalog_in VARCHAR(100)
)
BEGIN
    SELECT COUNT(*) AS total
    FROM Product
    WHERE Product_catalog = catalog_in;
END //
DELIMITER ;
DELIMITER //
CREATE PROCEDURE PROC_INSERT_PRODUCT(
    IN name_in VARCHAR(100),
    IN price_in FLOAT,
    IN title_in VARCHAR(200),
    IN created_in DATE,
    IN catalog_in VARCHAR(100)
)
BEGIN
    INSERT INTO Product(Product_Name, Product_Price, Product_Title, Product_created, Product_catalog)
    VALUES (name_in, price_in, title_in, created_in, catalog_in);
END //
DELIMITER ;
DELIMITER //
CREATE PROCEDURE PROC_UPDATE_PRODUCT(
    IN id_in INT,
    IN name_in VARCHAR(100),
    IN price_in FLOAT,
    IN title_in VARCHAR(200),
    IN catalog_in VARCHAR(100),
    IN status_in BIT
)
BEGIN
    UPDATE Product
    SET Product_Name = name_in,
        Product_Price = price_in,
        Product_Title = title_in,
        Product_catalog = catalog_in,
        Product_Status = status_in
    WHERE Product_Id = id_in;
END //
DELIMITER ;
DELIMITER //
CREATE PROCEDURE PROC_DELETE_PRODUCT(IN id_in INT)
BEGIN
    DELETE FROM Product WHERE Product_Id = id_in;
END //
DELIMITER ;
DELIMITER //
CREATE PROCEDURE PROC_GET_PRODUCT_BY_ID(IN id_in INT)
BEGIN
    SELECT * FROM Product WHERE Product_Id = id_in;
END //
DELIMITER ;
DELIMITER //
CREATE PROCEDURE PROC_SEARCH_PRODUCT(IN name_in VARCHAR(100))
BEGIN
    SELECT * FROM Product
    WHERE Product_Name LIKE CONCAT('%', name_in, '%');
END //
DELIMITER ;
DELIMITER //
CREATE PROCEDURE PROC_COUNT_BY_CATALOG()
BEGIN
    SELECT Product_catalog, COUNT(*) AS total
    FROM Product
    GROUP BY Product_catalog;
END //
DELIMITER ;
