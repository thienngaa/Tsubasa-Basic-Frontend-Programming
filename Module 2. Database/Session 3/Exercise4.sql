-- Tạo cơ sở dữ liệu (nếu chưa có)
CREATE DATABASE QuanLyTMĐT;
USE QuanLyTMĐT;

-- Tạo bảng DanhMuc
CREATE TABLE DanhMuc (
    MaDM INT PRIMARY KEY,
    TenDM VARCHAR(100) NOT NULL
);

-- Tạo bảng SanPham
CREATE TABLE SanPham (
    MaSP INT PRIMARY KEY,
    TenSP VARCHAR(100) NOT NULL,
    Gia DECIMAL(10,2),
    MaDM INT,
    FOREIGN KEY (MaDM) REFERENCES DanhMuc(MaDM)
);
-- Chèn 3 danh mục
INSERT INTO DanhMuc (MaDM, TenDM)
VALUES
(1, 'Điện thoại'),
(2, 'Laptop'),
(3, 'Phụ kiện');

-- Chèn 3 sản phẩm, mỗi sản phẩm thuộc 1 danh mục
INSERT INTO SanPham (MaSP, TenSP, Gia, MaDM)
VALUES
(1, 'iPhone 15', 25000000.00, 1),
(2, 'MacBook Air M2', 32000000.00, 2),
(3, 'Tai nghe Bluetooth', 800000.00, 3);
SELECT 
    SanPham.MaSP,
    SanPham.TenSP,
    SanPham.Gia,
    DanhMuc.TenDM
FROM 
    SanPham
JOIN 
    DanhMuc ON SanPham.MaDM = DanhMuc.MaDM
WHERE 
    DanhMuc.MaDM = 1;
