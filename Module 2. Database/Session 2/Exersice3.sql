INSERT INTO Employee (EmployeeID, FirstName, LastName, HireDate, Salary, Department)
VALUES
(1, 'John', 'Smith', '2020-01-15', 50000, 'IT'),
(2, 'Emily', 'Johnson', '2019-03-22', 60000, 'HR'),
(3, 'Michael', 'Brown', '2021-07-10', 55000, 'Finance'),
(4, 'Sarah', 'Davis', '2018-11-05', 70000, 'IT'),
(5, 'David', 'Wilson', '2022-02-01', 48000, 'Sales'),
(6, 'Sophia', 'Taylor', '2020-09-18', 53000, 'Marketing'),
(7, 'James', 'Anderson', '2017-06-25', 80000, 'Finance'),
(8, 'Olivia', 'Thomas', '2021-12-30', 45000, 'Sales'),
(9, 'Daniel', 'Martinez', '2019-08-14', 62000, 'IT'),
(10, 'Isabella', 'Garcia', '2022-05-20', 47000, 'HR');

-- Truy vấn tất cả nhân viên thuộc phòng ban cụ thể. 
SELECT * FROM Employee
WHERE department = "IT";

-- Cập nhật thông tin lương của một nhân viên.
UPDATE Employee
SET Salary = 50000
WHERE EmployeeID = 10;

SELECT * FROM Employee
WHERE EmployeeID = "10";

-- Xóa tất cả nhân viên có mức lương thấp hơn một giá trị nhất định.
DELETE FROM employee
WHERE salary < 50000;
