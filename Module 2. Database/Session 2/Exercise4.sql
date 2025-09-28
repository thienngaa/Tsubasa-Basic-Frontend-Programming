CREATE TABLE Customers (
    CustomerID 		INT PRIMARY KEY,
    CustomerName 	VARCHAR(255) NOT NULL,
    Email 			VARCHAR(255) UNIQUE
);

CREATE TABLE Orders (
	OrderID		INT PRIMARY KEY, 
    OrderDate	DATE NOT NULL, 
    CustomerID 	INT NOT NULL REFERENCES Customers(CustomerID), 
    TotalAmount	DECIMAL(10,2) NOT NULL CHECK (totalAmount >= 0)
);
