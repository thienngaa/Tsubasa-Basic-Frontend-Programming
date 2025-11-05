CREATE TABLE KhachHang (
    MaKH INT PRIMARY KEY,
    TenKH VARCHAR(50) NOT NULL,
    NgaySinh DATE,
    DiaChi VARCHAR(100)
);
INSERT INTO KhachHang (MaKH, TenKH, NgaySinh, DiaChi)
VALUES
(1, 'Nguyen Van A', '1990-05-10', 'Ha Noi'),
(2, 'Tran Thi B', '1992-08-15', 'Da Nang'),
(3, 'Le Van C', '1988-12-01', 'Ho Chi Minh');
SELECT * FROM KhachHang;
