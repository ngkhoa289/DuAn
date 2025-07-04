-- Fix the ChiTietSanPham table creation (missing comma)
-- Run this to fix the existing table or recreate it

-- Drop and recreate the table with proper syntax
DROP TABLE IF EXISTS HoaDonChiTiet;
DROP TABLE IF EXISTS GioHangChiTiet;
DROP TABLE IF EXISTS ChiTietSanPham;

CREATE TABLE ChiTietSanPham
(
	Id INT IDENTITY(1,1) PRIMARY KEY,
	IdSP INT,
	IdKichThuoc INT,
	IdMauSac INT,
	MaCTSP VARCHAR(10),
	TenCTSP NVARCHAR(30),
	SoLuong INT,
	DonGia MONEY,
	GhiChu NVARCHAR(255),
	TrangThai INT DEFAULT 1,

	FOREIGN KEY(IdSP) REFERENCES SanPham(Id),
	FOREIGN KEY(IdKichThuoc) REFERENCES KichThuoc(Id),
	FOREIGN KEY(IdMauSac) REFERENCES MauSac(Id)
)
GO

-- Recreate dependent tables
CREATE TABLE HoaDonChiTiet
(
	Id INT IDENTITY(1,1) PRIMARY KEY,
	IdHD INT,
	IdSPCT INT,
	Ma VARCHAR(10) NULL,
	SoLuong INT,
	Gia MONEY,
	TrangThai INT DEFAULT 1,

	FOREIGN KEY(IdSPCT) REFERENCES ChiTietSanPham(Id),
	FOREIGN KEY(IdHD) REFERENCES HoaDon(Id)
)
GO

CREATE TABLE GioHangChiTiet
(
	Id INT IDENTITY(1,1) PRIMARY KEY,
	IdGioHang INT,
	IdSanPham INT,
	IdSPCT INT,
	SoLuong INT,
	FOREIGN KEY(IdGioHang) REFERENCES GioHang(Id),
	FOREIGN KEY(IdSanPham) REFERENCES SanPham(Id),
	FOREIGN KEY(IdSPCT) REFERENCES ChiTietSanPham(Id)
)
GO

-- Add some sample ChiTietSanPham data
INSERT INTO ChiTietSanPham (IdSP, IdKichThuoc, IdMauSac, MaCTSP, TenCTSP, SoLuong, DonGia, GhiChu, TrangThai)
VALUES 
(1, 1, 1, 'CTSP001', N'Nike Air Max - Đỏ - 36', 50, 1500000, N'Sản phẩm mới', 1),
(1, 2, 1, 'CTSP002', N'Nike Air Max - Đỏ - 37', 45, 1500000, N'Sản phẩm mới', 1),
(1, 3, 2, 'CTSP003', N'Nike Air Max - Xanh - 38', 30, 1500000, N'Sản phẩm mới', 1),
(2, 1, 3, 'CTSP004', N'Nike Revolution - Vàng - 36', 25, 1200000, N'Mẫu mới 2025', 1),
(2, 4, 4, 'CTSP005', N'Nike Revolution - Trắng - 39', 40, 1200000, N'Mẫu mới 2025', 1);