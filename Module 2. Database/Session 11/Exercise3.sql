CREATE DATABASE FinanceDB;
USE FinanceDB;
CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY AUTO_INCREMENT,
    AccountName VARCHAR(100) NOT NULL,
    Balance DECIMAL(15,2) NOT NULL DEFAULT 0
);
CREATE TABLE Transactions (
    TransactionID INT PRIMARY KEY AUTO_INCREMENT,
    FromAccountID INT,
    ToAccountID INT,
    Amount DECIMAL(15,2) NOT NULL,
    TransactionDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (FromAccountID) REFERENCES Accounts(AccountID),
    FOREIGN KEY (ToAccountID) REFERENCES Accounts(AccountID)
);
CREATE TABLE Budgets (
    BudgetID INT PRIMARY KEY AUTO_INCREMENT,
    AccountID INT,
    BudgetAmount DECIMAL(15,2) NOT NULL,
    RemainingAmount DECIMAL(15,2) NOT NULL,
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);
CREATE TABLE Expenses (
    ExpenseID INT PRIMARY KEY AUTO_INCREMENT,
    AccountID INT,
    ExpenseAmount DECIMAL(15,2) NOT NULL,
    ExpenseDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    Description VARCHAR(255),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);
CREATE TABLE TransactionHistory (
    HistoryID INT PRIMARY KEY AUTO_INCREMENT,
    AccountID INT,
    TransactionID INT,
    Amount DECIMAL(15,2),
    TransactionType ENUM('DEBIT','CREDIT'), -- DEBIT từ tài khoản, CREDIT vào tài khoản
    TransactionDate DATETIME,
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID),
    FOREIGN KEY (TransactionID) REFERENCES Transactions(TransactionID)
);
DELIMITER //

CREATE PROCEDURE RecordTransactionHistory(IN inTransactionID INT)
BEGIN
    DECLARE vFrom INT;
    DECLARE vTo INT;
    DECLARE vAmount DECIMAL(15,2);
    DECLARE vDate DATETIME;

    -- Lấy thông tin giao dịch
    SELECT FromAccountID, ToAccountID, Amount, TransactionDate
    INTO vFrom, vTo, vAmount, vDate
    FROM Transactions
    WHERE TransactionID = inTransactionID;

    -- Ghi DEBIT cho tài khoản gửi
    INSERT INTO TransactionHistory (AccountID, TransactionID, Amount, TransactionType, TransactionDate)
    VALUES (vFrom, inTransactionID, vAmount, 'DEBIT', vDate);

    -- Ghi CREDIT cho tài khoản nhận
    INSERT INTO TransactionHistory (AccountID, TransactionID, Amount, TransactionType, TransactionDate)
    VALUES (vTo, inTransactionID, vAmount, 'CREDIT', vDate);
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE GetTotalTransactionsForAccount(
    IN inAccountID INT,
    IN inStartDate DATETIME,
    IN inEndDate DATETIME
)
BEGIN
    SELECT AccountID,
           SUM(CASE WHEN TransactionType='DEBIT' THEN Amount ELSE 0 END) AS TotalDebited,
           SUM(CASE WHEN TransactionType='CREDIT' THEN Amount ELSE 0 END) AS TotalCredited
    FROM TransactionHistory
    WHERE AccountID = inAccountID
      AND TransactionDate BETWEEN inStartDate AND inEndDate
    GROUP BY AccountID;
END //

DELIMITER ;
INSERT INTO Accounts (AccountName, Balance) VALUES ('Alice', 1000.00), ('Bob', 500.00);

INSERT INTO Transactions (FromAccountID, ToAccountID, Amount)
VALUES (1, 2, 200.00);

-- Ghi lại lịch sử giao dịch
CALL RecordTransactionHistory(1);
SELECT * FROM TransactionHistory;
CALL GetTotalTransactionsForAccount(1, '2025-01-01', '2025-12-31');
