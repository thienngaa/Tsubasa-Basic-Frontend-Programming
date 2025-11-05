-- Chọn CSDL để làm việc
USE QuanLyTMĐT;

-- Bảng KhachHang
CREATE TABLE KhachHang (
    MaKH INT PRIMARY KEY,
    TenKH VARCHAR(100) NOT NULL,
    Email VARCHAR(100)
);

-- Bảng DonHang
CREATE TABLE DonHang (
    MaDH INT PRIMARY KEY,
    MaKH INT NOT NULL,
    NgayDat DATE NOT NULL,
    FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH)
);

-- Bảng ChiTietDonHang
CREATE TABLE ChiTietDonHang (
    MaDH INT NOT NULL,
    MaSP INT NOT NULL,
    SoLuong INT NOT NULL,
    PRIMARY KEY (MaDH, MaSP),
    FOREIGN KEY (MaDH) REFERENCES DonHang(MaDH),
    FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
);
INSERT INTO KhachHang (MaKH, TenKH, Email)
VALUES
(1, 'Nguyen Van A', 'vana@gmail.com'),
(2, 'Tran Thi B', 'thib@gmail.com');
INSERT INTO DonHang (MaDH, MaKH, NgayDat)
VALUES
(1, 1, '2025-11-01'),
(2, 2, '2025-11-03');
INSERT INTO SanPham (MaSP, TenSP, Gia, MaDM)
VALUES
(4, 'Chuột Không Dây', 250000.00, 3),
(5, 'Bàn Phím Cơ', 850000.00, 3);
INSERT INTO ChiTietDonHang (MaDH, MaSP, SoLuong)
VALUES
(1, 4, 2),
(2, 5, 1);
SELECT 
    DonHang.MaDH,
    KhachHang.TenKH,
    SanPham.TenSP,
    ChiTietDonHang.SoLuong,
    DonHang.NgayDat
FROM 
    ChiTietDonHang
JOIN DonHang ON ChiTietDonHang.MaDH = DonHang.MaDH
JOIN KhachHang ON DonHang.MaKH = KhachHang.MaKH
JOIN SanPham ON ChiTietDonHang.MaSP = SanPham.MaSP;
