USE QuanLyCuaHang;
CREATE TABLE SanPham (
    MaSP INT PRIMARY KEY,
    TenSP VARCHAR(100) NOT NULL,
    Gia DECIMAL(10,2),
    SoLuongTon INT DEFAULT 0
);
ALTER TABLE SanPham
ADD COLUMN MoTa TEXT;
INSERT INTO SanPham (MaSP, TenSP, Gia, SoLuongTon, MoTa)
VALUES
(1, 'Bánh Quy', 35000.00, 20, 'Bánh quy bơ giòn tan'),
(2, 'Sữa Tươi', 55000.00, 15, 'Sữa tươi nguyên chất 1 lít'),
(3, 'Cà Phê Gói', 75000.00, 10, 'Cà phê hòa tan đậm vị');
SELECT * FROM SanPham WHERE Gia > 50000;
