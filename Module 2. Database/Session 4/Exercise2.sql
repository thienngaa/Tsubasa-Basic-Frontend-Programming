CREATE TABLE Students (
    StudentID INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Age INT,
    Major VARCHAR(100)
);
INSERT INTO Students (StudentID, Name, Age, Major)
VALUES
(1, 'Alice', 20, 'Computer Science'),
(2, 'Bob', 22, 'Mathematics'),
(3, 'Charlie', 21, 'Physics');
UPDATE Students
SET Age = 23
WHERE StudentID = 2;
SELECT * FROM Students;
