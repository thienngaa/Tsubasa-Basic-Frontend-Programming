CREATE DATABASE BankDB;
USE BankDB;
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
DELIMITER //

CREATE PROCEDURE TransferMoney(
    IN fromAccountID INT,
    IN toAccountID INT,
    IN transferAmount DECIMAL(15,2)
)
BEGIN
    DECLARE currentBalance DECIMAL(15,2);

    -- Bắt đầu transaction
    START TRANSACTION;

    -- Lấy số dư hiện tại của tài khoản nguồn
    SELECT Balance INTO currentBalance
    FROM Accounts
    WHERE AccountID = fromAccountID
    FOR UPDATE;

    -- Kiểm tra số dư
    IF currentBalance < transferAmount THEN
        -- Không đủ tiền, rollback và báo lỗi
        ROLLBACK;
        SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'Số dư tài khoản nguồn không đủ!';
    ELSE
        -- Trừ tiền tài khoản nguồn
        UPDATE Accounts
        SET Balance = Balance - transferAmount
        WHERE AccountID = fromAccountID;

        -- Cộng tiền vào tài khoản đích
        UPDATE Accounts
        SET Balance = Balance + transferAmount
        WHERE AccountID = toAccountID;

        -- Ghi lại giao dịch
        INSERT INTO Transactions (FromAccountID, ToAccountID, Amount)
        VALUES (fromAccountID, toAccountID, transferAmount);

        -- Commit transaction
        COMMIT;
    END IF;
END //

DELIMITER ;
INSERT INTO Accounts (AccountName, Balance)
VALUES 
('Alice', 1000.00),
('Bob', 500.00);
CALL TransferMoney(1, 2, 300.00);
CALL TransferMoney(2, 1, 1000.00);
SELECT * FROM Accounts;
SELECT * FROM Transactions;
