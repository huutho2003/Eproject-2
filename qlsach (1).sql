-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2022 at 02:39 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlsach`
--
CREATE DATABASE IF NOT EXISTS `qlsach` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `qlsach`;

-- --------------------------------------------------------

--
-- Table structure for table `ctpm`
--

CREATE TABLE `ctpm` (
  `MaPM` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MaSach` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `NgayTra` date DEFAULT NULL,
  `TinhTrangSach` int(11) NOT NULL,
  `TinhTrangTra` int(11) DEFAULT NULL,
  `User` varchar(10) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `GhiChu` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `ctpm`
--

INSERT INTO `ctpm` (`MaPM`, `MaSach`, `NgayTra`, `TinhTrangSach`, `TinhTrangTra`, `User`, `GhiChu`) VALUES
('PM01', 'MS02', '2020-06-03', 100, 0, 'admin', 'mất sách'),
('PM01', 'MS78', '2020-06-03', 100, 100, 'admin', 'TT sách tốt'),
('PM02', 'MS01', '2020-06-25', 100, 0, 'admin', 'Mất sách'),
('PM02', 'MS03', '2020-06-25', 100, 0, 'admin', 'Mất sách'),
('PM03', 'MS02', '2020-06-14', 100, 0, 'admin', 'mất sách'),
('PM03', 'MS13', '2020-06-14', 100, 95, 'admin', 'sách hỏng 5%'),
('PM04', 'MS02', '2020-07-05', 100, 90, 'admin', 'Hư 10%, trễ hạn'),
('PM04', 'MS117', '2020-07-05', 100, 100, 'admin', 'sách tốt, trễ hạn'),
('PM04', 'MS149', '2020-07-05', 100, 100, 'admin', 'sách tốt, trễ hạn'),
('PM05', 'MS01', '2020-07-05', 100, 50, 'admin', 'sách hỏng 50%, trễ hạn'),
('PM05', 'MS02', '2020-07-05', 90, 90, 'admin', 'TT sách tốt'),
('PM06', 'MS01', NULL, 100, NULL, NULL, NULL),
('PM06', 'MS02', NULL, 100, NULL, NULL, NULL),
('PM07', 'MS03', '2020-07-04', 50, 45, 'admin', ''),
('PM08', 'MS02', '2020-06-25', 100, 70, 'admin', 'hư 30%, trễ hạn'),
('PM08', 'MS03', '2020-07-06', 100, 0, 'admin', 'Mất sách'),
('PM08', 'MS04', '2020-07-06', 100, 0, 'admin', 'Mất sách'),
('PM09', 'MS01', NULL, 100, NULL, NULL, NULL),
('PM09', 'MS114', NULL, 95, NULL, NULL, NULL),
('PM10', 'MS10', NULL, 100, NULL, NULL, NULL),
('PM10', 'MS85', NULL, 100, NULL, NULL, NULL),
('PM11', 'MS101', NULL, 100, NULL, NULL, NULL),
('PM11', 'MS12', NULL, 100, NULL, NULL, NULL),
('PM11', 'MS13', NULL, 100, NULL, NULL, NULL),
('PM12', 'MS37', NULL, 100, NULL, NULL, NULL),
('PM12', 'MS87', NULL, 100, NULL, NULL, NULL),
('PM13', 'MS74', NULL, 100, NULL, NULL, NULL),
('PM13', 'MS77', NULL, 95, NULL, NULL, NULL),
('PM14', 'MS07', NULL, 100, NULL, NULL, NULL),
('PM14', 'MS83', NULL, 100, NULL, NULL, NULL),
('PM15', 'MS32', NULL, 100, NULL, NULL, NULL),
('PM15', 'MS49', NULL, 100, NULL, NULL, NULL),
('PM15', 'MS96', NULL, 100, NULL, NULL, NULL),
('PM16', 'MS83', NULL, 100, NULL, NULL, NULL),
('PM17', 'MS30', NULL, 100, NULL, NULL, NULL),
('PM17', 'MS34', NULL, 100, NULL, NULL, NULL),
('PM17', 'MS56', NULL, 100, NULL, NULL, NULL),
('PM18', 'MS30', NULL, 100, NULL, NULL, NULL),
('PM18', 'MS31', NULL, 100, NULL, NULL, NULL),
('PM19', 'MS63', NULL, 100, NULL, NULL, NULL),
('PM19', 'MS76', NULL, 100, NULL, NULL, NULL),
('PM19', 'MS79', NULL, 100, NULL, NULL, NULL),
('PM20', 'MS44', NULL, 100, NULL, NULL, NULL),
('PM20', 'MS48', NULL, 100, NULL, NULL, NULL),
('PM21', 'MS81', NULL, 100, NULL, NULL, NULL),
('PM22', 'MS93', NULL, 100, NULL, NULL, NULL),
('PM23', 'MS90', NULL, 100, NULL, NULL, NULL),
('PM23', 'MS92', NULL, 100, NULL, NULL, NULL),
('PM24', 'MS27', NULL, 100, NULL, NULL, NULL),
('PM24', 'MS29', NULL, 100, NULL, NULL, NULL),
('PM24', 'MS95', NULL, 100, NULL, NULL, NULL),
('PM25', 'MS43', NULL, 100, NULL, NULL, NULL),
('PM26', 'MS29', NULL, 100, NULL, NULL, NULL),
('PM26', 'MS62', NULL, 100, NULL, NULL, NULL),
('PM26', 'MS83', NULL, 100, NULL, NULL, NULL),
('PM27', 'MS56', NULL, 100, NULL, NULL, NULL),
('PM27', 'MS98', NULL, 100, NULL, NULL, NULL),
('PM28', 'MS96', NULL, 100, NULL, NULL, NULL),
('PM29', 'MS80', NULL, 100, NULL, NULL, NULL),
('PM30', 'MS71', NULL, 100, NULL, NULL, NULL),
('PM30', 'MS83', NULL, 100, NULL, NULL, NULL),
('PM30', 'MS92', NULL, 100, NULL, NULL, NULL),
('PM31', 'MS83', NULL, 100, NULL, NULL, NULL),
('PM32', 'MS91', NULL, 100, NULL, NULL, NULL),
('PM33', 'MS23', NULL, 100, NULL, NULL, NULL),
('PM33', 'MS72', NULL, 100, NULL, NULL, NULL),
('PM34', 'MS28', NULL, 100, NULL, NULL, NULL),
('PM35', 'MS26', NULL, 100, NULL, NULL, NULL),
('PM35', 'MS39', NULL, 100, NULL, NULL, NULL),
('PM35', 'MS65', NULL, 100, NULL, NULL, NULL),
('PM36', 'MS23', NULL, 100, NULL, NULL, NULL),
('PM36', 'MS34', NULL, 100, NULL, NULL, NULL),
('PM36', 'MS67', NULL, 100, NULL, NULL, NULL),
('PM37', 'MS43', NULL, 100, NULL, NULL, NULL),
('PM38', 'MS153', NULL, 100, NULL, NULL, NULL),
('PM38', 'MS20', NULL, 100, NULL, NULL, NULL),
('PM39', 'MS158', NULL, 100, NULL, NULL, NULL),
('PM39', 'MS54', NULL, 100, NULL, NULL, NULL),
('PM40', 'MS139', NULL, 100, NULL, NULL, NULL),
('PM40', 'MS67', NULL, 100, NULL, NULL, NULL),
('PM40', 'MS93', NULL, 100, NULL, NULL, NULL),
('PM41', 'MS143', NULL, 100, NULL, NULL, NULL),
('PM42', 'MS129', NULL, 100, NULL, NULL, NULL),
('PM43', 'MS164', NULL, 100, NULL, NULL, NULL),
('PM43', 'MS165', NULL, 100, NULL, NULL, NULL),
('PM43', 'MS32', NULL, 100, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `docgia`
--

CREATE TABLE `docgia` (
  `MaDG` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TenDG` varchar(20) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `SDT` varchar(20) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `DiaChi` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `GioiTinh` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MatSach` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `docgia`
--

INSERT INTO `docgia` (`MaDG`, `TenDG`, `SDT`, `DiaChi`, `GioiTinh`, `MatSach`) VALUES
('DG01', 'Đỗ Nhật Quang', '0342565857', 'Quận Thủ Đức', 'Nam', 0),
('DG02', 'Trần Quốc Phong', '0981249458', 'Quận Gò Vấp', 'Nam', 1),
('DG03', 'Lê Thị Thanh Tiến', '0983216950', 'Quận 2', 'Nữ', 1),
('DG04', 'Nguyễn Thái Hòa', '0356721980', 'Quận 9', 'Nam', 3),
('DG05', 'Phan Thanh Phú Thọ', '0914469424', 'Quận Gò Vấp', 'Nam', 2),
('DG06', 'Hồ Phương Ly', '0522004039', 'Quận Thủ Đức', 'Nữ', 0),
('DG07', 'Phan Ngọc Phương Nhi', '0682144611', 'Quận 5', 'Nữ', 0),
('DG08', 'Lê Thị Mỹ Diệu', '0347526510', 'Quận 1', 'Nữ', 0),
('DG09', 'Nguyễn Thị Mỹ Dung', '0714521035', 'Quận 10', 'Nữ', 0),
('DG10', 'Lữ Thị Ngọc Hiền', '0996215423', 'Quận 2', 'Nữ', 0),
('DG11', 'Nguyễn Phương Lan', '0888621540', 'Quận 1', 'Nữ', 0),
('DG12', 'Đỗ Thị Như Quỳnh', '0732561485', 'Huyện Cần Giờ', 'Nữ', 0),
('DG13', 'Nguyễn Thị Hà Thuyên', '0962532564', 'Quận 8', 'Nữ', 0),
('DG14', 'Lê Ngọc Tiến', '0632547125', 'Quận 1', 'Nam', 0),
('DG15', 'Nguyễn Lê Mỹ Hòa', '0856212356', 'Quận 10', 'Nữ', 0),
('DG16', 'Phan Phúc Khánh', '0571222356', 'Quận 5', 'Nam', 0),
('DG17', 'Trần Thanh Lâm', '0975263510', 'Quận 2', 'Nam', 0),
('DG18', 'Đỗ Nguyễn Vân Anh', '0974142514', 'Quận 1', 'Nữ', 0),
('DG19', 'Nguyễn Quốc Huy', '0814252012', 'Quận 9', 'Nam', 0),
('DG20', 'Nguyễn Thanh Hiển', '0345112456', 'Quận 9', 'Nam', 0),
('DG21', 'Trần Thanh Hiếu', '0845124785', 'Quận 10', 'Nam', 0),
('DG22', 'Đỗ Mẫn Nhi', '0641114507', 'Quận 2', 'Nữ', 0),
('DG23', 'Ngô Minh Thư', '0774150121', 'Quận 7', 'Nữ', 0),
('DG24', 'Ngô Khánh Hà', '0841112045', 'Quận 9', 'Nữ', 0),
('DG25', 'Trần Khôi Nguyên', '0888142012', 'Quận 5', 'Nam', 0),
('DG26', 'Tạ Hồng Đức', '0957154200', 'Quận Gò Vấp', 'Nam', 0),
('DG27', 'Ngô Thúy Hiền', '0314211212', 'Quận 12', 'Nữ', 0),
('DG28', 'Đỗ Ngọc Anh', '0314211212', 'Quận 3', 'Nữ', 0),
('DG29', 'Phan Thanh Kha', '0984145201', 'Quận 10', 'Nam', 0),
('DG30', 'Trần Xuân Lộc', '0654121450', 'Quận Tân Phú', 'Nam', 0),
('DG31', 'Hà Doãn Minh', '0714520124', 'Quận Tân Phú', 'Nam', 0),
('DG32', 'Đào Phạm Toàn', '0614017894', 'Quận Tân Phú', 'Nam', 0),
('DG33', 'Hồ Thị Trinh', '0341568547', 'Quận Tân Bình', 'Nữ', 0),
('DG34', 'Phan Hồ Anh Thư', '0341510412', 'Quận Tân Phú', 'Nữ', 0),
('DG35', 'Đỗ Ngọc Thiên', '0874114120', 'Quận 3', 'Nam', 0),
('DG36', 'Hồ Đăng Khoa', '0651425011', 'Quận 3', 'Nam', 0),
('DG37', 'Lê Chí Trung', '0874145145', 'Quận 1', 'Nam', 0),
('DG38', 'Bùi Thúy Kiều', '0645147887', 'Quận 12', 'Nữ', 0),
('DG39', 'Phan Ngọc Thư', '0741478947', 'Quận 10', 'Nữ', 0),
('DG40', 'Phan Thành Nhân', '0654178941', 'Quận 7', 'Nam', 0),
('DG41', 'Lê Khôi Thành', '0347845120', 'Quận Gò Vấp', 'Nam', 0),
('DG42', 'Mã Tiến Huy', '0999874520', 'Quận Gò Vấp', 'Nam', 0),
('DG43', 'Châu Ngọc Minh Thư', '0357125894', 'Quận Bình Thạnh', 'Nữ', 0),
('DG44', 'Nguyễn Trần Hà Đức', '0871421501', 'Quận 3', 'Nam', 0),
('DG45', 'Nguyễn Hữu Nhật Tân', '0614631549', 'Quận 1', 'Nam', 0),
('DG46', 'Phan Viết Đức', '0417521483', 'Quận 10', 'Nam', 0),
('DG47', 'Phan Vĩnh Khoa', '0971420156', 'Quận 9', 'Nam', 0),
('DG48', 'Võ Minh Khang', '0991478156', 'Quận 7', 'Nam', 0),
('DG49', 'Nguyễn Thu Huyền', '0624710586', 'Quận 5', 'Nữ', 0),
('DG50', 'Đào Thị Thu Hiền', '0714508041', 'Quận 3', 'Nữ', 0),
('DG51', 'Trần Nhật Linh', '0314540478', 'Quận 10', 'Nam', 0),
('DG52', 'Hồ Minh Huy', '0971542314', 'Quận Thủ Đức', 'Nam', 0),
('DG53', 'Bùi Xuân Hồng', '0982142357', 'Quận Tân Bình', 'Nữ', 0),
('DG54', 'Nguyễn Sơn Ca', '0315677152', 'Quận Tân Bình', 'Nữ', 0),
('DG55', 'Nguyễn Bảo Nghĩa', '0417622478', 'Quận 5', 'Nam', 0),
('DG56', 'Phan Thị Thùy Mi', '0687415245', 'Quận 8', 'Nữ', 0),
('DG57', 'Ngô Nguyễn Khôi', '0971423103', 'Quận 1', 'Nam', 0),
('DG58', 'Bùi Thành Hưng', '0571204612', 'Quận 9', 'Nam', 0),
('DG59', 'Lê Minh Thành', '09142113010', 'Quận 2', 'Nam', 0),
('DG60', 'Trương Yến Nhi', '04120703421', 'Quận 3', 'Nữ', 0),
('DG61', 'Nguyễn Hữu Hiếu', '0972163012', 'Quận 5', 'Nam', 0),
('DG62', 'Trần Tấn Công', '0782143015', 'Quận 2', 'Nam', 0),
('DG63', 'Đoàn Thúy Ngân', '0535344210', 'Quận 8', 'Nữ', 0),
('DG64', 'Võ Hoàng Tuấn', '0341258710', 'Quận Thủ Đức', 'Nam', 0),
('DG65', 'Mai Thanh Hiền', '0871534453', 'Quận Thủ Đức', 'Nữ', 0),
('DG66', 'Nguyễn Bảo Trân', '0789653100', 'Quận Tân Phú', 'Nữ', 0),
('DG67', 'Bạch Thị Ngọc', '0345410053', 'Quận Tân Bình', 'Nữ', 0),
('DG68', 'Bùi Thị Kim Thoa', '0542113033', 'Quận 9', 'Nữ', 0);

-- --------------------------------------------------------

--
-- Table structure for table `phieumuon`
--

CREATE TABLE `phieumuon` (
  `MaPM` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MaDG` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `NgayMuon` date NOT NULL,
  `NgayHenTra` date NOT NULL,
  `SoLuongMuon` int(11) NOT NULL,
  `User` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `phieumuon`
--

INSERT INTO `phieumuon` (`MaPM`, `MaDG`, `NgayMuon`, `NgayHenTra`, `SoLuongMuon`, `User`) VALUES
('PM01', 'DG01', '2020-05-03', '2020-06-03', 2, 'admin'),
('PM02', 'DG02', '2020-05-06', '2020-06-06', 3, 'admin'),
('PM03', 'DG03', '2020-05-15', '2020-06-15', 2, 'admin'),
('PM04', 'DG10', '2020-06-03', '2020-07-03', 3, 'admin'),
('PM05', 'DG26', '2020-06-04', '2020-07-04', 2, 'admin'),
('PM06', 'DG18', '2020-06-07', '2020-07-07', 2, 'admin'),
('PM07', 'DG07', '2020-06-07', '2020-07-07', 1, 'admin'),
('PM08', 'DG05', '2020-06-07', '2020-07-07', 2, 'admin'),
('PM09', 'DG20', '2020-06-08', '2020-07-08', 2, 'admin'),
('PM10', 'DG25', '2020-06-10', '2020-07-10', 2, 'admin'),
('PM11', 'DG52', '2020-06-12', '2020-07-12', 3, 'admin'),
('PM12', 'DG32', '2020-06-13', '2020-07-12', 2, 'admin'),
('PM13', 'DG06', '2020-06-13', '2020-07-13', 2, 'admin'),
('PM14', 'DG09', '2020-06-15', '2020-07-15', 2, 'admin'),
('PM15', 'DG28', '2020-06-15', '2020-07-15', 3, 'admin'),
('PM16', 'DG59', '2020-06-16', '2020-07-16', 1, 'admin'),
('PM17', 'DG55', '2020-06-16', '2020-07-16', 3, 'admin'),
('PM18', 'DG33', '2020-06-17', '2020-07-17', 2, 'admin'),
('PM19', 'DG63', '2020-06-17', '2020-07-17', 3, 'admin'),
('PM20', 'DG44', '2020-06-17', '2020-07-17', 2, 'admin'),
('PM21', 'DG37', '2020-06-18', '2020-07-18', 1, 'admin'),
('PM22', 'DG35', '2020-06-18', '2020-07-18', 1, 'admin'),
('PM23', 'DG15', '2020-06-19', '2020-07-19', 2, 'admin'),
('PM24', 'DG24', '2020-06-20', '2020-07-20', 3, 'admin'),
('PM25', 'DG42', '2020-06-20', '2020-07-20', 1, 'admin'),
('PM26', 'DG46', '2020-06-22', '2020-07-22', 3, 'admin'),
('PM27', 'DG12', '2020-06-23', '2020-07-23', 2, 'admin'),
('PM28', 'DG19', '2020-06-23', '2020-07-23', 1, 'admin'),
('PM29', 'DG30', '2020-06-24', '2020-07-24', 1, 'admin'),
('PM30', 'DG21', '2020-06-25', '2020-07-25', 3, 'admin'),
('PM31', 'DG34', '2020-06-25', '2020-07-25', 1, 'admin'),
('PM32', 'DG13', '2020-06-26', '2020-07-26', 1, 'admin'),
('PM33', 'DG08', '2020-06-26', '2020-07-26', 2, 'admin'),
('PM34', 'DG23', '2020-06-27', '2020-07-27', 1, 'admin'),
('PM35', 'DG29', '2020-06-27', '2020-07-27', 3, 'admin'),
('PM36', 'DG11', '2020-06-29', '2020-07-29', 3, 'admin'),
('PM37', 'DG58', '2020-06-30', '2020-07-30', 1, 'admin'),
('PM38', 'DG45', '2020-06-30', '2020-07-30', 2, 'admin'),
('PM39', 'DG36', '2020-07-01', '2020-08-01', 2, 'admin'),
('PM40', 'DG31', '2020-07-02', '2020-08-02', 3, 'admin'),
('PM41', 'DG51', '2020-07-04', '2020-08-04', 1, 'admin'),
('PM42', 'DG17', '2020-07-04', '2020-08-04', 1, 'admin'),
('PM43', 'DG14', '2020-07-04', '2020-08-04', 3, 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE `sach` (
  `MaSach` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TenSach` varchar(100) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TenTG` varchar(20) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `NhaXB` varchar(20) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TheLoai` varchar(20) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `GiaTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`MaSach`, `TenSach`, `TenTG`, `NhaXB`, `TheLoai`, `SoLuong`, `GiaTien`) VALUES
('MS01', 'Cơ sở dữ liệu', 'Vũ Minh Sang', 'NXB ĐHQG TP.HCM', 'Giáo trình', 10, 100000),
('MS02', 'Đại số tuyến tính', 'Đặng Lệ Thúy', 'NXB ĐHQG TP.HCM', 'Giáo trình', 10, 50000),
('MS03', 'Luật Im Lặng', 'Mario Puzo', 'ĐHQG Hà Nội', 'Văn học nước ngoài', 10, 71000),
('MS04', 'Tuổi trẻ hoang dại', 'Nguyễn Ngọc Thạch', 'NXB Văn Học', 'Kỹ năng sống', 9, 95000),
('MS05', '3 Phút Sơ Cứu', 'Ngô Đức Hùng', 'NXB Thế Giới', 'Chăm sóc sức khỏe', 10, 125000),
('MS06', 'Gửi tuổi trẻ yêu thương', 'Kim Wook', 'NXB Dân Trí', 'Kỹ năng sống', 10, 109000),
('MS07', 'Tâm lý học tích cực', 'Edward Hoffman', 'NXB Lao Động', 'Kỹ năng sống', 9, 129000),
('MS08', 'Quy tắc 5 giây', 'Mel Robbins', 'NXB Thế Giới', 'Kỹ năng sống', 10, 135000),
('MS09', 'Phương pháp tạo động lực trong công việc', 'Jon Sternfeld', 'NXB Lao Động', 'Kỹ năng sống', 10, 158000),
('MS10', 'Chạm', 'Werner Bartens', 'NXB Thanh Niên', 'Kỹ năng sống', 9, 122000),
('MS100', 'Những Nhà Kinh Tế Tiên Phong', 'Nathan Schneider', 'NXB Công Thương', 'Quản lý kinh doanh', 10, 139000),
('MS101', 'Mưu Lược Trong Kinh Doanh', 'Hoàng Văn Tuấn', 'NXB Lao Động', 'Quản lý kinh doanh', 9, 130000),
('MS102', 'Quản Lý Chuyên Nghiệp', 'Dottie Schindlinger', 'NXB Lao Động', 'Quản lý kinh doanh', 15, 119000),
('MS103', 'Content Đắt Có Bắt Được Trend', 'Ryan Wakeman', 'NXB Công Thương', 'Quản lý kinh doanh', 10, 119000),
('MS104', 'Đế Chế Alibaba', 'Trần Vĩ', 'NXB Hồng Đức', 'Quản lý kinh doanh', 10, 172000),
('MS105', 'Muôn Kiếp Nhân Sinh', 'Nguyên Phong', 'NXB Tổng Hợp TP.HCM', 'Kiến thức bách khoa', 10, 228000),
('MS106', 'Câu Đố Việt Nam', 'Mai Chi', 'NXB Hồng Đức', 'Kiến thức bách khoa', 20, 58000),
('MS107', 'Giải Mã Siêu Trí Tuệ', 'Vishen Lakhian', 'NXB Công Thương', 'Kiến thức bách khoa', 10, 159000),
('MS108', 'Khoa Học Thật Là Vui', 'Triệu Từ Húc', 'NXB Thanh Niên', 'Kiến thức bách khoa', 30, 25000),
('MS109', 'Thời Cá Voi Biết Đi', 'Dougal Dixon', 'NXB ĐH Sư Phạm', 'Kiến thức bách khoa', 10, 98000),
('MS11', 'Chủ nghĩa tối giản', 'Fields Millburn', 'NXB Lao Động Xã Hội', 'Kỹ năng sống', 10, 139000),
('MS110', 'Nông Trại Nuôi Sống Chúng Ta', 'Nancy Castaldo', 'NXB ĐH Sư Phạm', 'Kiến thức bách khoa', 10, 120000),
('MS111', '30 Giây Y Học', 'Gabrielle M Finn', 'NXB Kim Đồng', 'Kiến thức bách khoa', 10, 130000),
('MS112', '30 Giây AI Và Robot Học', 'Luis de Miranda', 'NXB Kim Đồng', 'Kiến thức bách khoa', 10, 130000),
('MS113', 'Dấu Ấn Khơi Dòng Văn Hóa Việt', 'Lê Minh Quốc', 'NXB Tổng Hợp TP.HCM', 'Kiến thức bách khoa', 5, 260000),
('MS114', 'Kể Tiếp Chuyện Bác Hồ', 'Trần Quân Ngọc', 'NXB Tổng Hợp TP.HCM', 'Kiến thức bách khoa', 14, 70000),
('MS115', 'Thế Giới Sẽ Ra Sao?', 'Nhiều Tác Giả', 'NXB Dân Trí', 'Kiến thức bách khoa', 10, 129000),
('MS116', 'Giáo Trình Xã Hội Học Đại Cương', 'Trương Thị Hiền', 'NXB Tổng Hợp TP.HCM', 'Kiến thức bách khoa', 10, 90000),
('MS117', 'Đại Việt Sử Ký Tục Biên (1676 - 1789)', 'VNC Hàn Nôm', 'NXB Hồng Đức', 'Kiến thức bách khoa', 5, 300000),
('MS118', 'Vĩ Đại Một Con Người', 'Trần Bạch Đằng', 'NXB Trẻ', 'Kiến thức bách khoa', 10, 52000),
('MS119', '99 Thử Thách Từ Vựng', 'Sarah Khan', 'NXB Lao Động', 'Kiến thức bách khoa', 10, 75000),
('MS12', 'Văn phòng không nhạt nhẽo', 'Hương Lan', 'NXB Dân Trí', 'Kỹ năng sống', 9, 80000),
('MS120', 'Về Trung Quốc', 'Henry Kissinger', 'NXB Hội Nhà Văn', 'Kiến thức bách khoa', 5, 299000),
('MS121', 'Lược Sử Kinh Tế Học', 'Niall Kishtainy', 'NXB Thế Giới', 'Kiến thức bách khoa', 10, 135000),
('MS122', 'Danh Nhân Quân Sự Việt Nam', 'Lê Minh Quốc', 'NXB Trẻ', 'Kiến thức bách khoa', 10, 125000),
('MS123', 'Tương Lai Nhân Loại', 'Michio Kaku', 'NXB Thế Giới', 'Kiến thức bách khoa', 10, 179000),
('MS124', 'Ngoại Giao Của Chính Quyền Sài Gòn', 'Trần Nam Tiến', 'NXB Dân Trí', 'Kiến thức bách khoa', 10, 159000),
('MS125', 'Thượng Kinh Ký Sự', 'Lê Hữu Trác', 'NXB Hà Nội', 'Kiến thức bách khoa', 10, 69000),
('MS126', 'Vừa A Dính', 'Tô Hoài', 'NXB Kim Đồng', 'Kiến thức bách khoa', 25, 12000),
('MS127', 'Kể Chuyện Bác Hồ', 'Khánh Linh', 'NXB Lao Động', 'Kiến thức bách khoa', 20, 50000),
('MS128', 'Vật Lý Của Tương Lai', 'Michio Kaku', 'NXB Thế Giới', 'Kiến thức bách khoa', 10, 199000),
('MS129', 'Cuộc Chiến Lỗ Đen', 'Leonard Susskind', 'NXB Trẻ', 'Kiến thức bách khoa', 9, 192000),
('MS13', 'Đời thay đổi khi ta thôi đẩy', 'Sarah Knight', 'NXB Thế Giới', 'Kỹ năng sống', 9, 92000),
('MS130', 'Khoa Học Cực Ngầu', 'Daniel Tatarsky', 'NXB Thế Giới', 'Kiến thức bách khoa', 10, 79000),
('MS131', 'Cùng Con Lớn Lên Từng Ngày', 'Nguyễn Minh Hải', 'NXB Tổng Hợp TP.HCM', 'Tâm lý giáo dục', 10, 90000),
('MS132', 'Không Hoảng Loạn Khi Con Kết Bạn', 'Michael Thompson', 'NXB Lao Động', 'Tâm lý giáo dục', 10, 99000),
('MS133', 'Hãy Nói Với Con Rằng Con Giỏi Lắm', 'Nguyệt Minh', 'NXB Lao Động', 'Tâm lý giáo dục', 15, 55000),
('MS134', 'Con Là Của Báu', 'Tadashi Tsujii', 'NXB Lao Động', 'Tâm lý giáo dục', 15, 43000),
('MS135', 'Cha Mẹ Pháp Không Đầu Hàng', 'Pamela Druckerman', 'NXB Lao Động', 'Tâm lý giáo dục', 15, 45000),
('MS136', 'Vì Chơi Là Học - Dành Cho Trẻ', 'Tadashi Tsujii', 'NXB Lao Động', 'Tâm lý giáo dục', 15, 43000),
('MS137', 'Trí Thông Minh Đa Dạng Của Trẻ', 'Yoon OK In', 'NXB Phụ Nữ', 'Tâm lý giáo dục', 10, 129000),
('MS138', '4 Món Quà Tặng Con', 'Barbara Coloroso', 'NXB Phụ Nữ', 'Tâm lý giáo dục', 10, 109000),
('MS139', 'Cùng Con Bước Qua Tiểu Học', 'Laura Numeroff', 'NXB Văn Học', 'Tâm lý giáo dục', 9, 89000),
('MS14', 'Điều vĩ đại đời thường', 'Robin Sharma', 'NXB Trẻ', 'Kỹ năng sống', 10, 73000),
('MS140', 'Trong Sách Có Gì Mà Vui Thế?', 'Mem Fox', 'NXB Phụ Nữ', 'Tâm lý giáo dục', 10, 89000),
('MS141', 'Cha Mẹ Vô Điều Kiện', 'Nguyễn Thị Thu Hiền', 'NXB Phụ Nữ', 'Tâm lý giáo dục', 10, 129000),
('MS142', 'Con Chúng Ta Không Sao Đâu', 'Cheonseok Suh', 'NXB Phụ Nữ', 'Tâm lý giáo dục', 10, 129000),
('MS143', 'Cùng Con Học Nói', 'Sally Ward', 'NXB Phụ Nữ', 'Tâm lý giáo dục', 9, 129000),
('MS144', 'Học Làm Cha Mẹ Hiệu Quả', 'Thomas Gordon', 'NXB Phụ Nữ', 'Tâm lý giáo dục', 10, 109000),
('MS145', 'Dạy Con Tập Bơi', 'Usborne', 'NXB Lao Động', 'Tâm lý giáo dục', 10, 79000),
('MS146', 'Giúp Con Phát Triển Ngôn Ngữ', 'Kato Kumiko', 'NXB Văn Học', 'Tâm lý giáo dục', 10, 69000),
('MS147', 'Bí Quyết Giúp Con Giỏi Tiếng Anh', 'Claire Selby', 'NXB Phụ Nữ', 'Tâm lý giáo dục', 10, 49000),
('MS148', 'Cha Mẹ Thời Đại Kĩ Thuật Số', 'Shin Yee Jin', 'NXB Văn Học', 'Tâm lý giáo dục', 10, 109000),
('MS149', 'Chờ Đến Mẫu Giáo Thì Đã Muộn', 'Ibuka Masaru', 'NXB Văn Học', 'Tâm lý giáo dục', 10, 69000),
('MS15', 'Đừng bao giờ đi ăn một mình', 'Keith Ferrazzi', 'NXB Trẻ', 'Kỹ năng sống', 10, 95000),
('MS150', 'Người Mẹ Tốt Hơn Là Người Thầy Tốt', 'Doãn Kiến Lợi', 'NXB Văn Học', 'Tâm lý giáo dục', 10, 139000),
('MS151', 'Nuôi Dạy Con Theo Phương Pháp Montessori', 'Quốc Tú Hoa', 'NXB Phụ Nữ', 'Tâm lý giáo dục', 10, 75000),
('MS152', 'Mẹ Dành Cả Thế Giới Cho Con', 'Lý Xuân Lợi', 'NXB Phụ Nữ', 'Tâm lý giáo dục', 10, 90000),
('MS153', 'Những Ngộ Nhận “Vì Sức Khỏe”', 'Toshio Akitsu', 'NXB Phụ Nữ', 'Chăm sóc sức khỏe', 9, 109000),
('MS154', 'Sống Mạnh Khỏe Nhờ Ăn Uống', 'Lê Duyên Hải', 'NXB Lao Động', 'Chăm sóc sức khỏe', 10, 80000),
('MS155', 'Thiền Chữa Lành Thân Và Tâm', 'Tulku Thondup', 'NXB Hà Nội', 'Chăm sóc sức khỏe', 10, 95000),
('MS156', 'Diện Chẩn Điều Khiển Liệu Pháp', 'Bùi Quốc Châu', 'NXB Đà Nẵng', 'Chăm sóc sức khỏe', 15, 38000),
('MS157', 'Định Ninh Tôi Học Mạch', 'Lê Đức Thiếp', 'NXB Dân Trí', 'Chăm sóc sức khỏe', 10, 150000),
('MS158', 'Nhịn Ăn Gián Đoạn', 'Gin Stephens', 'NXB Thế Giới', 'Chăm sóc sức khỏe', 9, 99000),
('MS159', 'Tranh Châm Cứu Giải Phẫu Thực Dụng', 'Lê Quý Ngưu', 'NXB Thế Giới', 'Chăm sóc sức khỏe', 10, 120000),
('MS16', 'Siêu trí nhớ', 'Dominic O’Brien', 'NXB Lao Động', 'Kỹ năng sống', 10, 99000),
('MS160', 'Ám Ảnh Ăn Sạch', 'Renee Mc Gregor', 'NXB Công Thương', 'Chăm sóc sức khỏe', 10, 85000),
('MS161', 'Y Học Thực Chứng', 'Nguyễn Văn Tuấn', 'NXB Tổng Hợp TP.HCM', 'Chăm sóc sức khỏe', 10, 145000),
('MS162', 'Phế Đại Trường Trong Đông Y', 'Hoàng Duy Tân', 'NXB Dân Trí', 'Chăm sóc sức khỏe', 10, 180000),
('MS163', 'Thực Hành Thiền Định', 'Matthieu Ricard', 'NXB Hà Nội', 'Chăm sóc sức khỏe', 10, 65000),
('MS164', 'Dưỡng Sinh', 'Nguyễn Mạnh Trí', 'NXB Tổng Hợp TP.HCM', 'Chăm sóc sức khỏe', 14, 55000),
('MS165', 'Sức Khỏe Gia Đình', 'Đỗ Hồng Ngọc', 'NXB Tổng Hợp TP.HCM', 'Chăm sóc sức khỏe', 14, 90000),
('MS166', 'Giải tích 1', 'Lê Hoàng Tuấn', 'NXB ĐHQG TP.HCM', 'Giáo trình', 50, 75000),
('MS167', 'Giải tích 2', 'Lê Hoàng Tuấn', 'NXB ĐHQG TP.HCM', 'Giáo trình', 50, 80000),
('MS168', 'Lý Luận Nhà Nước Và Pháp Luật', 'Lê Vũ Nam', 'NXB ĐHQG TP.HCM', 'Giáo trình', 20, 96000),
('MS169', 'Tư Tưởng Hồ Chí Minh', 'Bộ Giáo Dục', 'NXB Chính Trị QG', 'Giáo trình', 100, 22000),
('MS17', 'Mặc đẹp để thành công', 'Nishimura Yukiko', 'NXB Thế Giới', 'Kỹ năng sống', 10, 99000),
('MS170', 'Đường Lối Cách Mạng Của Đảng Cộng Sản VN', 'Bộ Giáo Dục', 'NXB Chính Trị QG', 'Giáo trình', 100, 30000),
('MS171', 'Phát Triển Ứng Dụng Web', 'Trần Khánh Lâm', 'NXB ĐHQG TP.HCM', 'Giáo trình', 50, 56000),
('MS172', 'Phân Tích Thiết Kế HTTT', 'Cao Thị Nhạn', 'NXB ĐHQG TP.HCM', 'Giáo trình', 25, 90000),
('MS173', 'Nhập Môn Mạng Máy Tính', 'Trần Thị Dung', 'NXB ĐHQG TP.HCM', 'Giáo trình', 25, 30000),
('MS174', 'Lập Trình JaVa', 'Phan Hoàng Khải', 'NXB ĐHQG TP.HCM', 'Giáo trình', 20, 99000),
('MS175', 'Hệ Điều Hành', 'Chung Quang Khánh', 'NXB ĐHQG TP.HCM', 'Giáo trình', 60, 40000),
('MS176', '600 Essential Words For The Toeic', 'Dr. Lin Lougheed', 'NXB Tổng Hợp TP.HCM', 'Ngoại ngữ', 10, 110000),
('MS177', 'Starter Toeic Third Edition', 'Anne Taylor', 'NXB Tổng Hợp TP.HCM', 'Ngoại ngữ', 15, 120000),
('MS178', 'Luyện Thi Toeic 850 Reading', 'Jo Gang - Soo', 'NXB Khoa Học Xã Hội', 'Ngoại ngữ', 10, 169000),
('MS179', 'Luyện Thi Toeic 750 Reading', 'Jo Gang - Soo', 'NXB Khoa Học Xã Hội', 'Ngoại ngữ', 10, 149000),
('MS18', 'Trở thành siêu nhân ghi nhớ', 'Oopsy', 'NXB Thế Giới', 'Kỹ năng sống', 10, 89000),
('MS180', 'Pass The Toeic Test Intermediate Course', 'Miles Craven', 'NXB Tổng Hợp TP.HCM', 'Ngoại ngữ', 10, 169000),
('MS181', 'Pass The Toeic Test - Advanced Course', 'Miles Craven', 'NXB Tổng Hợp TP.HCM', 'Ngoại ngữ', 10, 169000),
('MS182', 'Luyện Thi TOEIC Thật Là Đơn Giản (Kèm CD)', 'Yukihiro Tsukada', 'NXB Hồng Đức', 'Ngoại ngữ', 10, 150000),
('MS183', 'Very Easy Toeic - Kèm 2 CD', 'Yukihiro Tsukada', 'NXB Trẻ', 'Ngoại ngữ', 10, 134000),
('MS184', 'Toeic All In One', 'Research Institue', 'NXB Thế Giới', 'Ngoại ngữ', 10, 219000),
('MS185', 'Restart Your English - Traveling Abroad', 'Bae Jin Young', 'NXB Hồng Đức', 'Ngoại ngữ', 5, 250000),
('MS19', 'Mỗi ngày một chút thôi', 'Nguyễn Thái Duy', 'NXB Tổng Hợp TP.HCM', 'Kỹ năng sống', 10, 109000),
('MS20', 'Sức mạnh của sự tử tế', 'Linda Kaplan Thaler', 'NXB Tri Thức', 'Kỹ năng sống', 9, 68000),
('MS21', 'Đọc sách siêu tốc', 'Christian Gruning', 'NXB Lao Động', 'Kỹ năng sống', 10, 69000),
('MS22', 'Bạn chính là thông điệp', 'Roger Ailes', 'NXB Thanh Hóa', 'Kỹ năng sống', 10, 79000),
('MS23', 'Bí quyết học nhanh nhớ lâu', 'Jonathan Hancock', 'NXB Trẻ', 'Kỹ năng sống', 18, 48000),
('MS24', 'Bài học của Thầy', 'Nhóm tác giả', 'NXB Hà Nội', 'Kỹ năng sống', 20, 35000),
('MS25', 'Đạo lý sống đẹp', 'Thế Anh', 'NXB VHTT', 'Kỹ năng sống', 20, 36000),
('MS26', 'Góc nhìn của người Do Thái', 'Robert Fulghum', 'NXB Tổng Hợp TP.HCM', 'Kỹ năng sống', 9, 80000),
('MS27', 'Ca Dao Giảng Luận', 'Thuần Phong', 'NXB Tri Thức', 'Văn học Việt Nam', 4, 117000),
('MS28', 'Kính thưa liền thị', 'Nguyễn Duy', 'NXB Phụ Nữ', 'Văn học Việt Nam', 9, 79000),
('MS29', 'Số Đỏ', 'Vũ Trọng Phụng', 'NXB Văn Học', 'Văn học Việt Nam', 13, 40000),
('MS30', 'Đời Thừa', 'Nam Cao', 'NXB Văn Học', 'Văn học Việt Nam', 8, 65000),
('MS31', 'Truyện Tây Bắc', 'Tô Hoài', 'NXB Kim Đồng', 'Văn học Việt Nam', 14, 50000),
('MS32', 'Truyện Kiều', 'Nguyễn Du', 'NXB Văn học', 'Văn học Việt Nam', 13, 45000),
('MS33', 'Thi nhân Việt Nam', 'Hoài Thanh', 'NXB Văn học', 'Văn học Việt Nam', 15, 89000),
('MS34', 'Cô ấy khiêu vũ một mình', 'Tịnh Bảo', 'NXB Trẻ', 'Văn học Việt Nam', 8, 66000),
('MS35', 'Ngoại ô thương nhớ', 'Phi Tân', 'NXB Trẻ', 'Văn học Việt Nam', 10, 97000),
('MS36', 'Thành ngữ và tục ngữ Việt Nam', 'Nhóm tác giả', 'NXB Hội Nhà Văn', 'Văn học Việt Nam', 20, 60000),
('MS37', 'Những tinh cầu trôi dạt', 'Đỗ Bích Ngọc', 'NXB Dân Trí', 'Văn học Việt Nam', 14, 59000),
('MS38', 'Áo trắng biển lặng', 'Nhiều tác giả', 'NXB Trẻ', 'Văn học Việt Nam', 20, 35000),
('MS39', 'Kim, Vân, Kiều truyện', 'Trương Vĩnh Ký', 'NXB Văn Học', 'Văn học Việt Nam', 9, 95000),
('MS40', 'Người canh giữ phù dung', 'Nguyệt Chu', 'NXB Văn Học', 'Văn học Việt Nam', 10, 68000),
('MS41', 'Thơ văn Hàn Mạc Tử', 'Trần Quang Chu', 'NXB Văn Học', 'Văn học Việt Nam', 10, 200000),
('MS42', 'Sài côn cố sự', 'Bằng Giang', 'NXB Tổng Hợp TP.HCM', 'Văn học Việt Nam', 10, 120000),
('MS43', 'Trúng số độc đắc', 'Vũ Trọng Phụng', 'NXB Văn Học', 'Văn học Việt Nam', 8, 12085),
('MS44', 'Lòng dạ đàn bà', 'Nguyễn Ngọc Thạch', 'NXB Hà Nội', 'Văn học Việt Nam', 9, 89000),
('MS45', 'Những ngày thơ ấu', 'Nguyên Hồng', 'NXB Văn Học', 'Văn học Việt Nam', 20, 40000),
('MS46', 'Trong cơn say níu sợi dây đứt', 'Hoàng Công Danh', 'NXB Trẻ', 'Văn học Việt Nam', 10, 79000),
('MS47', 'Người viết tình yêu', 'Nguyễn Ngọc Hà', 'NXB Trẻ', 'Văn học Việt Nam', 10, 82000),
('MS48', 'Một thời ngang dọc', 'Hoàng Ly', 'NXB Hội Nhà Văn', 'Văn học Việt Nam', 9, 190000),
('MS49', 'Mình và họ', 'Nguyễn Bình Phương', 'NXB Trẻ', 'Văn học Việt Nam', 9, 100000),
('MS50', 'Vũ trung tùy bút', 'Phạm Đình Hổ', 'NXB Văn Hóa Dân Tộc', 'Văn học Việt Nam', 10, 75000),
('MS51', 'Mắt biếc', 'Nguyễn Nhật Ánh', 'NXB Trẻ', 'Văn học Việt Nam', 15, 110000),
('MS52', 'Cỏ dại thênh thang', 'Bùi Tiểu Quyên', 'NXB Trẻ', 'Văn học Việt Nam', 10, 43000),
('MS53', 'Những đứa con cổ tích', 'Bạch Đằng', 'NXB Trẻ', 'Văn học Việt Nam', 10, 96000),
('MS54', 'Lời chào quá khứ', 'Trung Trung Đỉnh', 'NXB Trẻ', 'Văn học Việt Nam', 9, 105000),
('MS55', 'Lớn lên sẽ khác', 'Hai Mươi', 'NXB Văn Học', 'Văn học Việt Nam', 10, 89000),
('MS56', 'Gió lạnh đầu mùa', 'Thạch Lam', 'NXB Văn Học', 'Văn học Việt Nam', 8, 50000),
('MS57', 'Luận anh hùng', 'Dịch Trung Thiên', 'NXB Văn Học', 'Văn học nước ngoài', 10, 139000),
('MS58', 'Lũ trẻ đường ray', 'Edith Nesbit', 'NXB Văn Học', 'Văn học nước ngoài', 10, 90000),
('MS59', 'Một nụ cười nào đó', 'Francoise Sagan', 'NXB Văn Hóa', 'Văn học nước ngoài', 10, 86000),
('MS60', 'Cậu nhóc gặt gió', 'William Kamkwamba', 'NXB Thanh Niên', 'Văn học nước ngoài', 10, 115000),
('MS61', 'Quo Vadis', 'Henryk Sienkiewicz', 'NXB Văn Học', 'Văn học nước ngoài', 10, 350000),
('MS62', 'Giã từ vũ khí', 'Ernest Hemingway', 'NXB Văn Học', 'Văn học nước ngoài', 9, 149000),
('MS63', 'Thần thoại Bắc Âu', 'Quỳnh Liên', 'NXB Kim Đồng', 'Văn học nước ngoài', 9, 96000),
('MS64', 'Đệ tử quy', 'Lý Dục Tú', 'NXB Dân Trí', 'Văn học nước ngoài', 10, 85000),
('MS65', 'Hoa Tuylip đen', 'Alexandre Dumas', 'NXB Văn Học', 'Văn học nước ngoài', 9, 100000),
('MS66', 'Trò chuyện với ác quỷ', 'Mitsuro Sato', 'NXB Thế Giới', 'Văn học nước ngoài', 10, 159000),
('MS67', 'Thành cát tư hãn', 'René Grousset', 'NXB Văn Học', 'Văn học nước ngoài', 8, 150000),
('MS68', 'Sau ánh hào quang', 'Leslie Odom Jr', 'NXB Thế Giới', 'Văn học nước ngoài', 10, 81000),
('MS69', 'Hai mươi năm sau', 'Alexandre Dumas', 'NXB Văn Học', 'Văn học nước ngoài', 10, 270000),
('MS70', 'Nghìn lẻ một đêm', 'Antoine Galland', 'NXB Văn Học', 'Văn học nước ngoài', 10, 235000),
('MS71', 'Tội ác dưới ánh mặt trời', 'Agatha Christie', 'NXB Trẻ', 'Văn học nước ngoài', 9, 120000),
('MS72', 'Ngôi nhà nghìn hành lang', 'Diana Wynne Jones', 'NXB Hội Nhà Văn', 'Văn học nước ngoài', 9, 108000),
('MS73', 'Một chuyện đời', 'Sato Shogo', 'NXB Hà Nội', 'Văn học nước ngoài', 10, 145000),
('MS74', 'Nhà thờ Đức Bà Paris', 'Victor Hugo', 'NXB Văn Học', 'Văn học nước ngoài', 9, 165000),
('MS75', 'Hoa hồng xa mạc', 'Luis Sepulveda', 'NXB Hội Nhà Văn', 'Văn học nước ngoài', 15, 70000),
('MS76', 'Ông già và biển cá', 'Ernest Hemingway', 'NXB Tổng Hợp TP.HCM', 'Văn học nước ngoài', 14, 80000),
('MS77', 'Tiếng gọi nơi hoang dã', 'Jack London', 'NXB Văn Học', 'Văn học nước ngoài', 9, 85000),
('MS78', 'Bắt trẻ đồng xanh', 'David Salinger', 'NXB Hội Nhà Văn', 'Văn học nước ngoài', 10, 100000),
('MS79', 'Tâm hồn cao thượng', 'Edmondo De Amicis', 'NXB Hội Nhà Văn', 'Văn học nước ngoài', 19, 60000),
('MS80', 'Ác quỷ nam kinh', 'Mo Hayder', 'NXB Hội Nhà Văn', 'Văn học nước ngoài', 14, 116000),
('MS81', 'Quy Trình Bán Hàng Chuyên Nghiệp', 'Cory Bray', 'NXB Lao Động', 'Quản lý kinh doanh', 9, 119000),
('MS82', 'Big Data Cho Nhà Quản Lý', 'Mike Malmgren', 'NXB Công Thương', 'Quản lý kinh doanh', 10, 149000),
('MS83', 'Quản Trị Rủi Ro Pháp Lý Trong Kinh Doanh', 'Đỗ Đăng Khoa', 'NXB Tổng hợp TP.HCM', 'Quản lý kinh doanh', 5, 198000),
('MS84', 'Ngân Hàng Biết Tìm Khách Hàng Ở Đâu?', 'Trịnh Minh Thảo', 'NXB Hồng Đức', 'Quản lý kinh doanh', 10, 159000),
('MS85', 'Trải Nghiệm Khách Hàng', 'Blake Morgan', 'NXB Công Thương', 'Quản lý kinh doanh', 9, 139000),
('MS86', 'Tương Lai Thuộc Về Châu Á', 'Parag Khanna', 'NXB Trẻ', 'Quản lý kinh doanh', 8, 210000),
('MS87', 'Tư Duy Amazon - Think Like Amazon', 'John Rossman', 'NXB Lao Động', 'Quản lý kinh doanh', 9, 159000),
('MS88', 'TikTok Marketing', 'Markus Rach', 'NXB Thanh Niên', 'Quản lý kinh doanh', 10, 139000),
('MS89', '10 Loại Hình Đổi Mới Sáng Tạo', ' Larry Keeley', 'NXB Công Thương', 'Quản lý kinh doanh', 10, 249000),
('MS90', 'Siêu Năng Suất', 'Chris Bailey', 'NXB Công Thương', 'Quản lý kinh doanh', 9, 139000),
('MS91', 'Nâng Tầm Dịch Vụ', 'Ron Kaufman', 'NXB Trẻ', 'Quản lý kinh doanh', 9, 150000),
('MS92', 'Học Jack Ma Khởi Nghiệp', 'Trịnh Nhất Quần', 'NXB Dân Trí', 'Quản lý kinh doanh', 8, 150000),
('MS93', 'Quản Trị Theo Phong Cách Cờ Vây', 'Bất Thức Nguyệt', 'NXB Phụ Nữ', 'Quản lý kinh doanh', 8, 83000),
('MS94', 'Quản Trị Trong Thời Khủng Hoảng', 'Peter F Drucker', 'NXB Công Thương', 'Quản lý kinh doanh', 10, 129000),
('MS95', 'Hùng Mạnh Hơn Sau Khủng Hoảng', 'Ian I Mitroff', 'NXB Công Thương', 'Quản lý kinh doanh', 9, 129000),
('MS96', 'Dẫn Dắt Sự Thay Đổi', 'John P Kotter', 'NXB Thế Giới', 'Quản lý kinh doanh', 8, 129000),
('MS97', 'Đi Ra Thế Giới Với Người Khổng Lồ', 'Phan Văn Phương', 'NXB Thế Giới', 'Quản lý kinh doanh', 10, 119000),
('MS98', 'Kiếm Tiền Thời Khủng Hoảng', 'Martin D Weiss', 'NXB Phụ Nữ', 'Quản lý kinh doanh', 9, 169000),
('MS99', 'Tư Duy Đơn Giản', 'Ken Segall', 'NXB Thế Giới', 'Quản lý kinh doanh', 10, 138000);

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `User` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `Password` varchar(20) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `PhanQuyen` int(11) NOT NULL,
  `TenND` varchar(20) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `SDT` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `CMND` varchar(20) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`User`, `Password`, `PhanQuyen`, `TenND`, `SDT`, `CMND`) VALUES
('admin', 'admin', 1, 'Admin', '0975350001', '001203012382'),
('an10diem', 'anbanvlrkem', 2, 'Le Duy An', '0987654321', '11610000417621');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ctpm`
--
ALTER TABLE `ctpm`
  ADD PRIMARY KEY (`MaPM`,`MaSach`),
  ADD KEY `User` (`User`),
  ADD KEY `MaSach` (`MaSach`);

--
-- Indexes for table `docgia`
--
ALTER TABLE `docgia`
  ADD PRIMARY KEY (`MaDG`);

--
-- Indexes for table `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD PRIMARY KEY (`MaPM`),
  ADD KEY `fk_phieumuon_MaDG` (`MaDG`),
  ADD KEY `fk_phieumuon_User` (`User`);

--
-- Indexes for table `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`MaSach`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`User`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ctpm`
--
ALTER TABLE `ctpm`
  ADD CONSTRAINT `ctpm_ibfk_1` FOREIGN KEY (`User`) REFERENCES `taikhoan` (`User`),
  ADD CONSTRAINT `ctpm_ibfk_2` FOREIGN KEY (`MaPM`) REFERENCES `phieumuon` (`MaPM`),
  ADD CONSTRAINT `ctpm_ibfk_3` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`),
  ADD CONSTRAINT `ctpm_ibfk_4` FOREIGN KEY (`MaPM`) REFERENCES `phieumuon` (`MaPM`);

--
-- Constraints for table `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD CONSTRAINT `fk_phieumuon_MaDG` FOREIGN KEY (`MaDG`) REFERENCES `docgia` (`MaDG`),
  ADD CONSTRAINT `fk_phieumuon_User` FOREIGN KEY (`User`) REFERENCES `taikhoan` (`User`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
