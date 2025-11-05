CREATE DATABASE QuanLySanPham;
USE QuanLySanPham;

-- Bảng danh mục sản phẩm
CREATE TABLE categories (
    categoryId INT PRIMARY KEY AUTO_INCREMENT,
    categoryName VARCHAR(100) NOT NULL
);

-- Bảng sản phẩm
CREATE TABLE products (
    productId INT PRIMARY KEY AUTO_INCREMENT,
    productName VARCHAR(100) NOT NULL,
    productPrice DECIMAL(15,2) NOT NULL,
    categoryId INT,
    FOREIGN KEY (categoryId) REFERENCES categories(categoryId)
);

INSERT INTO products (productId, productName, productPrice, categoryId)
VALUES
(4, 'Samsung Galaxy S23', 22000000, 1),
(5, 'Dell XPS 13', 28000000, 2),
(6, 'Bàn phím cơ Keychron', 1500000, 3);

UPDATE products
SET productPrice = 29000000
WHERE productName = 'Dell XPS 13';

DELETE FROM products
WHERE productId = 3;

SELECT *
FROM products
ORDER BY productPrice ASC;

SELECT 
    c.categoryName,
    COUNT(p.productId) AS SoLuongSanPham
FROM 
    categories c
LEFT JOIN 
    products p ON c.categoryId = p.categoryId
GROUP BY 
    c.categoryName;
