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
    TransactionType ENUM('DEBIT','CREDIT'),
    TransactionDate DATETIME,
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID),
    FOREIGN KEY (TransactionID) REFERENCES Transactions(TransactionID)
);
CREATE TABLE RecurringTransactions (
    RecurringID INT PRIMARY KEY AUTO_INCREMENT,
    FromAccountID INT,
    ToAccountID INT,
    Amount DECIMAL(15,2) NOT NULL,
    Frequency ENUM('DAILY','WEEKLY','MONTHLY') NOT NULL,
    NextTransactionDate DATE NOT NULL,
    FOREIGN KEY (FromAccountID) REFERENCES Accounts(AccountID),
    FOREIGN KEY (ToAccountID) REFERENCES Accounts(AccountID)
);
DELIMITER //

CREATE PROCEDURE ExecuteRecurringTransaction(IN inRecurringID INT)
BEGIN
    DECLARE vFrom INT;
    DECLARE vTo INT;
    DECLARE vAmount DECIMAL(15,2);
    DECLARE vFrequency ENUM('DAILY','WEEKLY','MONTHLY');
    DECLARE vNextDate DATE;
    DECLARE currentBalance DECIMAL(15,2);
    DECLARE vTransactionID INT;

    -- Lấy thông tin giao dịch định kỳ
    SELECT FromAccountID, ToAccountID, Amount, Frequency, NextTransactionDate
    INTO vFrom, vTo, vAmount, vFrequency, vNextDate
    FROM RecurringTransactions
    WHERE RecurringID = inRecurringID
    FOR UPDATE;

    -- Kiểm tra số dư tài khoản nguồn
    SELECT Balance INTO currentBalance
    FROM Accounts
    WHERE AccountID = vFrom
    FOR UPDATE;

    IF currentBalance < vAmount THEN
        SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'Số dư tài khoản nguồn không đủ!';
    ELSE
        -- Bắt đầu transaction
        START TRANSACTION;

        -- Trừ tiền tài khoản nguồn
        UPDATE Accounts
        SET Balance = Balance - vAmount
        WHERE AccountID = vFrom;

        -- Cộng tiền vào tài khoản đích
        UPDATE Accounts
        SET Balance = Balance + vAmount
        WHERE AccountID = vTo;

        -- Ghi giao dịch vào Transactions
        INSERT INTO Transactions (FromAccountID, ToAccountID, Amount)
        VALUES (vFrom, vTo, vAmount);

        SET vTransactionID = LAST_INSERT_ID();

        -- Ghi lịch sử giao dịch
        INSERT INTO TransactionHistory (AccountID, TransactionID, Amount, TransactionType, TransactionDate)
        VALUES (vFrom, vTransactionID, vAmount, 'DEBIT', NOW());

        INSERT INTO TransactionHistory (AccountID, TransactionID, Amount, TransactionType, TransactionDate)
        VALUES (vTo, vTransactionID, vAmount, 'CREDIT', NOW());

        -- Cập nhật NextTransactionDate theo Frequency
        IF vFrequency = 'DAILY' THEN
            SET vNextDate = DATE_ADD(vNextDate, INTERVAL 1 DAY);
        ELSEIF vFrequency = 'WEEKLY' THEN
            SET vNextDate = DATE_ADD(vNextDate, INTERVAL 1 WEEK);
        ELSEIF vFrequency = 'MONTHLY' THEN
            SET vNextDate = DATE_ADD(vNextDate, INTERVAL 1 MONTH);
        END IF;

        UPDATE RecurringTransactions
        SET NextTransactionDate = vNextDate
        WHERE RecurringID = inRecurringID;

        COMMIT;
    END IF;
END //

DELIMITER ;
INSERT INTO Accounts (AccountName, Balance) VALUES ('Alice', 1000.00), ('Bob', 500.00);

INSERT INTO RecurringTransactions (FromAccountID, ToAccountID, Amount, Frequency, NextTransactionDate)
VALUES (1, 2, 100.00, 'DAILY', '2025-11-05');
CALL ExecuteRecurringTransaction(1);
SELECT * FROM Accounts;
SELECT * FROM Transactions;
SELECT * FROM TransactionHistory;
SELECT * FROM RecurringTransactions;
