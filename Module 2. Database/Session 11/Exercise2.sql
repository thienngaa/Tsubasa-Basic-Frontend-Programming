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
DELIMITER //

CREATE PROCEDURE SpendFromAccount(
    IN inAccountID INT,
    IN inExpenseAmount DECIMAL(15,2),
    IN inDescription VARCHAR(255)
)
BEGIN
    DECLARE currentBalance DECIMAL(15,2);
    DECLARE currentRemaining DECIMAL(15,2);

    -- Bắt đầu transaction
    START TRANSACTION;

    -- Lấy số dư hiện tại của tài khoản
    SELECT Balance INTO currentBalance
    FROM Accounts
    WHERE AccountID = inAccountID
    FOR UPDATE;

    -- Kiểm tra số dư
    IF currentBalance < inExpenseAmount THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'Số dư tài khoản không đủ để chi tiêu!';
    ELSE
        -- Trừ tiền từ tài khoản
        UPDATE Accounts
        SET Balance = Balance - inExpenseAmount
        WHERE AccountID = inAccountID;

        -- Thêm bản ghi chi tiêu vào Expenses
        INSERT INTO Expenses (AccountID, ExpenseAmount, Description)
        VALUES (inAccountID, inExpenseAmount, inDescription);

        -- Cập nhật RemainingAmount trong Budgets nếu có
        IF EXISTS (SELECT 1 FROM Budgets WHERE AccountID = inAccountID) THEN
            SELECT RemainingAmount INTO currentRemaining
            FROM Budgets
            WHERE AccountID = inAccountID
            FOR UPDATE;

            UPDATE Budgets
            SET RemainingAmount = RemainingAmount - inExpenseAmount
            WHERE AccountID = inAccountID;
        END IF;

        -- Commit transaction
        COMMIT;
    END IF;
END //

DELIMITER ;
INSERT INTO Accounts (AccountName, Balance)
VALUES 
('Alice', 1000.00),
('Bob', 500.00);

INSERT INTO Budgets (AccountID, BudgetAmount, RemainingAmount)
VALUES
(1, 800.00, 800.00),
(2, 400.00, 400.00);
CALL SpendFromAccount(1, 200.00, 'Mua văn phòng phẩm');
CALL SpendFromAccount(2, 900.00, 'Mua thiết bị');
SELECT * FROM Accounts;
SELECT * FROM Budgets;
SELECT * FROM Expenses;
