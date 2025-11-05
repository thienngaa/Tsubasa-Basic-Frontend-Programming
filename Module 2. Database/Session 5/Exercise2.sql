SELECT 
    ProductID,
    COUNT(SaleID) AS SoLuongDonHang
FROM 
    Sales
GROUP BY 
    ProductID;
