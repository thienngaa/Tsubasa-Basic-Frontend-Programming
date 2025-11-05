SELECT 
    departmentID,
    SUM(salary) AS TongLuong,
    AVG(salary) AS LuongTrungBinh
FROM 
    EmployeeSalaries
GROUP BY 
    departmentID;
