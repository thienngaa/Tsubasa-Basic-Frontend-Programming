SELECT *
FROM products
WHERE productPrice BETWEEN 1000000 AND 25000000;

SELECT *
FROM products
WHERE productName LIKE '%Pro%';

SELECT 
    c.categoryName,
    AVG(p.productPrice) AS GiaTrungBinh
FROM 
    products p
JOIN 
    categories c ON p.categoryId = c.categoryId
GROUP BY 
    c.categoryName;

SELECT *
FROM products
WHERE productPrice > (
    SELECT AVG(productPrice)
    FROM products
);
SELECT 
    c.categoryName,
    p.productName,
    p.productPrice
FROM 
    products p
JOIN 
    categories c ON p.categoryId = c.categoryId
WHERE 
    p.productPrice = (
        SELECT MIN(p2.productPrice)
        FROM products p2
        WHERE p2.categoryId = p.categoryId
    );
