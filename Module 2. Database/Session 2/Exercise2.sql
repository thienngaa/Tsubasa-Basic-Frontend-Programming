CREATE TABLE Product (
	ProductID	INT PRIMARY KEY,
    ProductName	NVARCHAR(255) NOT NULL, 
    Category	NVARCHAR(255) NOT NULL, 
    Price		DECIMAL(10,2) NOT NULL, 
    StockQuantity	INT NOT NULL
);

INSERT INTO Product (ProductID, ProductName, Category, Price, StockQuantity)
VALUES
	(0001, N'MacBook Pro 14', N'Máy tính', 45000.00, 10),
    (0002, N'Samsung Galaxy S24', N'Điện thoại', 25000.00, 20),
    (0003, N'Loa JBL Charge 5', N'Âm thanh', 3500.00, 40);

SELECT * FROM Product;
