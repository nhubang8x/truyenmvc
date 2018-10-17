-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 17, 2018 lúc 06:12 AM
-- Phiên bản máy phục vụ: 10.1.33-MariaDB
-- Phiên bản PHP: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `truyendb`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `card`
--

CREATE TABLE `card` (
  `cdID` bigint(20) NOT NULL COMMENT 'ID Thẻ',
  `cdNumber` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Số Thẻ',
  `cdSerial` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Mã Thẻ',
  `gold` int(11) NOT NULL COMMENT 'Giá trị thẻ',
  `createData` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'Ngày Tạo Thẻ',
  `cdStatus` int(11) DEFAULT '1' COMMENT 'Trạng Thái Thẻ'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Table Thẻ';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `cID` int(11) NOT NULL,
  `cName` varchar(150) CHARACTER SET utf8 NOT NULL COMMENT 'Tên Thể Loại',
  `cMetatitle` varchar(150) COLLATE utf8_unicode_ci NOT NULL COMMENT 'MetaTitle Thể Loại',
  `createDate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'Ngày Tạo',
  `createBy` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Tên Người Tạo',
  `modifiedDate` datetime DEFAULT NULL COMMENT 'Ngày Sửa',
  `modifiedBy` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Người sửa',
  `cStatus` int(11) DEFAULT '1' COMMENT 'Trạng Thái Thể Loại'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Table Thể Loại';

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`cID`, `cName`, `cMetatitle`, `createDate`, `createBy`, `modifiedDate`, `modifiedBy`, `cStatus`) VALUES
(1, 'Đô Thị', 'do-thi', '2018-09-13 09:22:08', 'administrator', NULL, NULL, 1),
(2, 'Tiên Hiệp', 'tien-hiep', '2018-09-13 09:25:14', 'administrator', NULL, NULL, 1),
(3, 'Huyền Ảo', 'huyen-ao', '2018-09-13 09:25:14', 'administrator', NULL, NULL, 1),
(4, 'Kiếm Hiệp', 'kiem-hiep', '2018-09-13 09:25:14', 'administrator', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chapter`
--

CREATE TABLE `chapter` (
  `chID` bigint(20) NOT NULL COMMENT 'ID Chapter',
  `chNumber` int(11) NOT NULL COMMENT 'Chương Thứ',
  `chSerial` float NOT NULL COMMENT 'Số thứ tự chương',
  `chName` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT 'Tên Chương',
  `chView` int(11) DEFAULT '0' COMMENT 'Số View Chương',
  `sID` bigint(20) DEFAULT NULL COMMENT 'ID Truyện',
  `content` text COLLATE utf8_unicode_ci NOT NULL COMMENT 'Nội dung chương',
  `createDate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'Ngày Đăng',
  `uID` bigint(20) DEFAULT NULL COMMENT 'ID Người Đăng',
  `wordNumber` int(11) DEFAULT NULL COMMENT 'Số chữ của chương',
  `price` int(11) DEFAULT '0' COMMENT 'Giá Chương Trả Phí',
  `dealine` datetime DEFAULT NULL COMMENT 'Ngày Hết Hạn Trả Phí',
  `chStatus` int(11) DEFAULT '1' COMMENT 'Trạng Thái Chương'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Table Chapter Truyện';

--
-- Đang đổ dữ liệu cho bảng `chapter`
--

INSERT INTO `chapter` (`chID`, `chNumber`, `chSerial`, `chName`, `chView`, `sID`, `content`, `createDate`, `uID`, `wordNumber`, `price`, `dealine`, `chStatus`) VALUES
(1, 1, 1, 'c1', 0, 1, 'c1', '2018-09-10 22:52:08', 1, 2, 0, NULL, 1),
(2, 1, 1, 'c2', 0, 2, 'c2', '2018-09-10 22:52:09', 1, 2, 0, NULL, 1),
(3, 2, 2, 'c3', 0, 2, 'c2', '2018-09-11 09:44:09', 2, 2, 0, NULL, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `comment`
--

CREATE TABLE `comment` (
  `comID` bigint(20) NOT NULL COMMENT 'ID bình luận',
  `uID` bigint(20) DEFAULT NULL COMMENT 'ID User',
  `sID` bigint(20) DEFAULT NULL COMMENT 'ID Story',
  `content` text COLLATE utf8_unicode_ci NOT NULL COMMENT 'Nội dung comment',
  `createDate` datetime DEFAULT NULL COMMENT 'Ngày Bình Luận',
  `comStatus` int(11) DEFAULT '1' COMMENT 'Trạng Thái Bình Luận'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Table Bình Luận';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `information`
--

CREATE TABLE `information` (
  `infoID` int(11) NOT NULL COMMENT 'ID Infomation',
  `introduce` text COLLATE utf8_unicode_ci COMMENT 'Thông tin giới Thiệu Web',
  `email` varchar(150) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Email WebSite',
  `phone` varchar(13) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Điện Thoại Liên Hệ',
  `skype` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Địa Chỉ Skype',
  `epass` varchar(250) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Mật khẩu Email',
  `logo` varchar(150) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Logo Website',
  `favicon` varchar(150) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Favicon WebSite'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Table Thông Tin Web';

--
-- Đang đổ dữ liệu cho bảng `information`
--

INSERT INTO `information` (`infoID`, `introduce`, `email`, `phone`, `skype`, `epass`, `logo`, `favicon`) VALUES
(1, 'TruyenOnline là website đọc truyện convert online cập nhật liên tục và nhanh nhất các truyện tiên hiệp, kiếm hiệp, huyền ảo được các thành viên liên tục đóng góp rất nhiều truyện hay và nổi bật.', 'apt.truyenonline@gmail.com', NULL, 'truyenonline', '8101a00c8bcb65062f4d4d3ca01bf854', 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/truyenmvc/logo.png', 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/truyenmvc/favicon.ico');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `rID` int(11) NOT NULL COMMENT 'ID Phân QUyền ',
  `rName` varchar(150) CHARACTER SET utf8 NOT NULL COMMENT 'Tên Phân Quyền'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Table Phân Quyền Người Dùng';

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`rID`, `rName`) VALUES
(1, 'administrator'),
(2, 'smod'),
(3, 'converter'),
(4, 'user');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `story`
--

CREATE TABLE `story` (
  `sID` bigint(20) NOT NULL COMMENT 'ID Truyện',
  `vnName` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT 'Tên truyện Tiếng Việt',
  `sMetaTitle` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Tên truyện MetaTitle',
  `cnName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Tên truyện tiếng trung',
  `cnLink` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Link truyện tiếng Trung',
  `sImages` varchar(150) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Hình ảnh truyện',
  `sAuthor` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT 'Tác giả truyện',
  `sInfo` text COLLATE utf8_unicode_ci NOT NULL COMMENT 'Thông tin truyện',
  `sView` int(11) DEFAULT '0' COMMENT 'Số lượt xem',
  `sRating` float DEFAULT '0' COMMENT 'Điểm đánh giá',
  `sConverter` bigint(20) NOT NULL COMMENT 'Người Đăng',
  `createDate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'Ngày Tạo',
  `modifiedBy` datetime DEFAULT NULL COMMENT 'Ngày Sửa',
  `sPrice` int(11) DEFAULT '0' COMMENT 'Giá truyện',
  `sTimeDeal` int(11) DEFAULT NULL COMMENT 'Thời gian trả phí',
  `sDealStatus` int(11) DEFAULT '0' COMMENT 'Trạng Thái Trả Phí',
  `sUpdate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'Ngày Cập Nhật',
  `sStatus` int(11) DEFAULT '1' COMMENT 'Trạng Thái Truyện'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Table Truyện';

--
-- Đang đổ dữ liệu cho bảng `story`
--

INSERT INTO `story` (`sID`, `vnName`, `sMetaTitle`, `cnName`, `cnLink`, `sImages`, `sAuthor`, `sInfo`, `sView`, `sRating`, `sConverter`, `createDate`, `modifiedBy`, `sPrice`, `sTimeDeal`, `sDealStatus`, `sUpdate`, `sStatus`) VALUES
(1, 'Tu Chân Nói Chuyện Phiếm Quần', 'tu-chan-noi-chuyen-phiem-quan', '修真聊天群', 'http://www.qidian.com/Book/3602691.aspx', 'https://res.cloudinary.com/thang1988/image/upload/v1539535310/truyenmvc/tu-chan-noi-chuyen-phiem-quan.jpg', 'Thánh kỵ sĩ truyền thuyết', 'Một ngày, Tống Thư Hàng ngoài ý muốn gia nhập một cái tiên hiệp chuunibyou thâm niên người bệnh giao lưu quần, bên trong quần bạn nhóm đều lấy \'Đạo hữu\' tương xứng, quần danh thiếp đều là các loại Phủ chủ, Động chủ, Chân nhân, Thiên Sư. Liền chủ nhóm lạc đường chó cảnh đều xưng là Đại yêu khuyển rời nhà trốn đi. Cả ngày nói chuyện là luyện đan, xông bí cảnh, luyện công kinh nghiệm cái gì.\r\n\r\nĐột nhiên có một ngày, lặn xuống nước hồi lâu hắn đột nhiên phát hiện... Trong đám mỗi một cái quần viên, vậy mà toàn bộ là Tu chân giả, có thể di sơn đảo hải, trường sinh ngàn năm cái chủng loại kia!', 0, 0, 1, '2018-09-01 22:48:35', NULL, 0, NULL, 0, '2018-09-10 22:48:35', 1),
(2, 'Nhất Niệm Vĩnh Hằng', 'nhat-niem-vinh-hang', '一念永恒', 'http://www.qidian.com/Book/1003354631.aspx', 'https://res.cloudinary.com/thang1988/image/upload/v1539535551/truyenmvc/nhat-niem-vinh-hang.jpg', 'Nhĩ Căn', 'Nhất niệm thành thương hải , nhất niệm hóa tang điền . nhất niệm trảm thiên ma , nhất niệm tru vạn tiên . duy ngã niệm …… vĩnh hằng', 0, 0, 1, '2018-09-10 22:49:46', NULL, 0, NULL, 0, '2018-09-10 22:49:46', 2),
(3, 'Dị Thế Giới Mỹ Thực Gia', 'di-the-gioi-my-thuc-gia', '异世界的美食家', 'https://www.lread.net/read/51823/', 'https://res.cloudinary.com/thang1988/image/upload/v1539535665/truyenmvc/di-the-gioi-my-thuc-gia.jpg', 'Lý Hồng Thiên', 'Ở Vũ Giả nhấc tay có thể Liệt Sơn xuyên, súy chân có thể đoạn trường hà Huyền Huyễn trên thế giới, tồn tại như vậy một nhà nhà hàng nhỏ . \r\n\r\nNhà hàng nhỏ không lớn, nhưng là vô số cường giả đỉnh cao xua như xua vịt chi địa . \r\n\r\nỞ đàng kia ngươi có thể thưởng thức được dùng trứng Phượng Hoàng cùng Long Huyết mét xào thành cơm xào trứng . \r\n\r\nỞ đàng kia ngươi có thể Hát đáo Sinh Mệnh Chi Tuyền xứng Chu Quả chế riêng Liệt Tửu . \r\n\r\nỞ đàng kia ngươi có thể ăn được Cửu Giai Thánh Thú nhục thân hợp với Hắc hồ tiêu thịt quay . \r\n\r\nCái gì ngươi nghĩ đem đầu bếp bắt về nhà ? Không có khả năng, bởi vì nhà hàng cửa nằm một con giữ cửa Thập Giai Thần Thú, Địa Ngục Khuyển . \r\n\r\nOh, người đầu bếp còn có một cái có thể một tay bóp chết Cửu Phẩm Chí Tôn cục sắt trợ thủ cùng một đám bị chinh phục dạ dày điên cuồng nữ nhân . ', 0, 0, 1, '2018-09-10 22:49:46', NULL, 0, NULL, 0, '2018-09-10 22:49:47', 1),
(4, 'Mục Thần Ký', 'muc-than-ky', '牧神记', 'https://book.qidian.com/info/1009704712', 'https://res.cloudinary.com/thang1988/image/upload/v1539535810/truyenmvc/muc-than-ky.jpg', 'Trạch Trư', 'Đại khư tổ huấn nói, trời tối, đừng đi ra ngoài.\r\n\r\nĐại khư tàn lão thôn già yếu tàn tật bọn họ từ bờ sông nhặt được một đứa bé, lấy tên Tần Mục, ngậm đắng nuốt cay đem hắn nuôi lớn. Một ngày này màn đêm buông xuống, bóng tối bao trùm đại khư, Tần Mục đi ra cửa chính. . .\r\n\r\nLàm gió xuân bên trong nhộn nhạo nhân vật phản diện đi!\r\n\r\nNgười mù nói với hắn.\r\n\r\nTần Mục nhân vật phản diện chi lộ, ngay tại quật khởi!', 0, 0, 1, '2018-09-13 09:29:52', NULL, 0, NULL, 0, '2018-09-13 09:29:52', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `uID` bigint(20) NOT NULL,
  `uName` varchar(30) CHARACTER SET utf8 NOT NULL,
  `uPass` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `uDname` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `uEmail` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `gold` double DEFAULT '0',
  `uAvatar` varchar(255) COLLATE utf8_unicode_ci DEFAULT 'avatar.jpg',
  `modifiedDate` datetime DEFAULT NULL,
  `createDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `uStatus` int(11) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Table Người dùng';

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`uID`, `uName`, `uPass`, `uDname`, `uEmail`, `gold`, `uAvatar`, `modifiedDate`, `createDate`, `uStatus`) VALUES
(1, 'administrator', '$2a$10$N0eqNiuikWCy9ETQ1rdau.XEELcyEO7kukkfoiNISk/9F7gw6eB0W', NULL, 'administrator@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-08-15 18:26:31', 1),
(2, 'nhubang8x', '$2a$10$F6AV3A2HvcfHGk4fUje35.caAKEDAJs0CAi4/APoGEWRR.JPkt2ve', NULL, 'tieupham304@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', '2018-10-16 10:11:53', '2018-08-15 18:30:13', 1),
(3, 'hieu13', '$2a$10$JlnArVWUSRMccWGTGM5Xv.5DzWNEQRgSJWbhkQLTovNtv6oKEBhX.', NULL, 'hieu13@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-09-23 19:22:24', 1),
(5, 'tieupham304', '$2a$10$F6AV3A2HvcfHGk4fUje35.caAKEDAJs0CAi4/APoGEWRR.JPkt2ve', 'tieupham304', 'tieupham1988@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 08:34:46', 1),
(6, 'tieupham1988', '$2a$10$dtGgOrabNjGVN1joaH6M7Ourdu/sC11DTlH8uw6Yea7eHjKbiq9Y6', 'tieupham1988', 'tieupham30488@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 08:35:49', 1),
(8, 'nttvirgos', '$2a$10$FyPDfA1IV8251Ztuj8dzCek8yMBaectgCNbjI7xBaFQ9ZyUFgSoYi', 'nttvirgos', 'nttvirgos@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 08:37:17', 1),
(9, 'ngocanh58', '$2a$10$ixQ06gs9YAqo.sq7rPTc6ujyLIhZ.mt.H7HrCgxCPadYtAXyLPjQ.', 'ngocanh58', 'ngocnha58@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 18:02:17', 1),
(10, 'hieu131', '$2a$10$Ctl/GBtacG7Xbk8Dn9zG8uGFqNk6BFdRz/QfOYtozwlZ6Mo55kWLG', 'hieu131', 'hieu131@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 18:10:48', 1),
(11, 'nhubang99x', '$2a$10$ETb09C4yyeAP7NaeMWcJ5e1d1LlqubudZHT7Yacuzn5NyLU6UlGKO', 'nhubang99x', 'nhubang9x@yahoo.com.vn', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 21:10:36', 1),
(13, 'aahaah', '$2a$10$JPpZHSBIMQT1k4aneplE2uaDVcRJfFz.kfkbFpPF5ldUADJ6UK9HS', 'aahaah', 'aahaah@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 22:07:11', 1),
(14, 'aahaah2', '$2a$10$njIa/OvEICKvCV06yVkrY.9H9BGUYyoAP0doZwvi/KsO.gzqBu8a6', 'aahaah2', 'aahaah2@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 22:10:34', 1),
(15, 'aahaah22', '$2a$10$N.AxvloIYKjkdYDCU.NBzeEjilHxqSv1uPyxJ.NA403NPetkL54mW', 'aahaah22', 'aahaah22@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 22:12:08', 1),
(16, 'aahaah221', '$2a$10$6tFyOuGD8LnAK/bkNST5m.S8uQNCh1ZCLMBnbZqI341i/8cIIhvdu', 'aahaah221', 'aahaah122@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 22:14:20', 1),
(17, 'aahaah2212', '$2a$10$HMjuC6/AgR2XR.jUG/DN0OglJV9LctXT3w/XAZN3IK2AJYJktH8Ey', 'aahaah2212', 'aahaah2212@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 22:16:23', 1),
(18, 'aahaah22122', '$2a$10$PNdQaj/23pQdxLbDlTezFOltMyS2HpBUKI9oo83s6gl/mTk1HGEVm', 'aahaah22122', 'aahaah22122@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 22:18:16', 1),
(19, 'hhhhhh', '$2a$10$TSQUJ3hg1XvuiPSbJQw2VeYSvwuik3e/.IybwcM.R0j/sRsyIfw76', 'hhhhhh', 'hhhhhh@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 22:52:22', 1),
(20, 'as22', '$2a$10$5NYlytPaKXNgyJk.ekH2JOl7jKguHH8rFzhK6gSBMkCLbo1bCKbHy', 'as22', 'as22@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 23:04:28', 1),
(21, 'asdasda35', '$2a$10$9RHeI5.xRP8vBYll/kLgsuWNa3emRqRn2w1BppGe7KwC60AIQtVHi', 'asdasda35', 'asdasda35@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 23:07:23', 1),
(22, '12311', '$2a$10$gUorG4gvQHwOyZyXCMNcnuLJ14at3g4Grsf3mGElkrQobBofQljtC', '12311', '12311@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 23:10:54', 1),
(23, 'nhubang8x11', '$2a$10$ODzw6XeVg8HzdedHtJJwde/CFDSnMU3kvy1lPt137xMz477bemMWm', 'nhubang8x11', 'nhubang8x11@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 23:21:48', 1),
(24, 't43t3t43', '$2a$10$Mv6m.7W98X89bsDu9i11ke4t9AQI7CdLi9uH/5UN9c9iC2TThIKXi', 't43t3t43', 't43t3t43@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 23:35:07', 1),
(25, '324234', '$2a$10$QfHy9FRvQINh/OI/1X4ZcuAcjFiHfISwpfHAzxj1yLpK8l4LKrnja', '324234', '324234@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 23:43:36', 1),
(26, '32r23r', '$2a$10$2O65AuKFxE7oO/io0nTkTeICZkFKNK0MywaR8orpgvI//euBKThCS', '32r23r', '32r23r@gmail.com', 0, 'https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png', NULL, '2018-10-15 23:45:15', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `_chdeal`
--

CREATE TABLE `_chdeal` (
  `chDealID` bigint(20) NOT NULL COMMENT 'ID chDeal',
  `uID` bigint(20) NOT NULL COMMENT 'ID người trả phí',
  `chID` bigint(20) NOT NULL COMMENT 'ID Chapter Trả',
  `price` float DEFAULT NULL COMMENT 'Price Trả Phí',
  `createDate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'Ngày Trả Phí',
  `locationIP` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Địa chỉ máy sử dụng'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Table Thanh Toán Phí';

--
-- Đang đổ dữ liệu cho bảng `_chdeal`
--

INSERT INTO `_chdeal` (`chDealID`, `uID`, `chID`, `price`, `createDate`, `locationIP`) VALUES
(1, 2, 1, 50, '2018-09-22 23:06:16', '1.1.1.1'),
(2, 2, 2, 150, '2018-09-22 23:06:16', '1.1.1.1'),
(3, 2, 3, 100, '2018-09-22 23:06:16', '1.1.1.1'),
(4, 2, 1, 100, '2018-09-22 23:06:16', '1.1.1.1'),
(5, 2, 1, 500, '2018-09-22 23:06:16', '1.1.1.1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `_scategory`
--

CREATE TABLE `_scategory` (
  `sID` bigint(20) NOT NULL COMMENT 'ID của Truyện',
  `cID` int(11) NOT NULL COMMENT 'ID Của Category'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Table Thể Loại Truyện';

--
-- Đang đổ dữ liệu cho bảng `_scategory`
--

INSERT INTO `_scategory` (`sID`, `cID`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 2),
(2, 3),
(3, 1),
(3, 3),
(3, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `_sconverter`
--

CREATE TABLE `_sconverter` (
  `uID` bigint(20) NOT NULL COMMENT 'ID Người Đăng',
  `sID` bigint(20) NOT NULL COMMENT 'ID Truyện',
  `createDate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'Ngày Tạo',
  `status` int(11) DEFAULT '1' COMMENT 'Trạng Thái Converter'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Table Converter của truyện';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `_seditor`
--

CREATE TABLE `_seditor` (
  `uID` bigint(20) NOT NULL COMMENT 'ID Người Duyệt',
  `sID` bigint(20) NOT NULL COMMENT 'ID Truyện',
  `createDate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'Ngày Tạo',
  `status` int(11) DEFAULT '1' COMMENT 'Trạng Thái Editor'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `_srating`
--

CREATE TABLE `_srating` (
  `uID` bigint(20) NOT NULL COMMENT 'ID User',
  `sID` bigint(20) NOT NULL COMMENT 'ID Truyện',
  `locationID` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Địa chỉ IP',
  `rating` float NOT NULL COMMENT 'Đánh Giá',
  `createDate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'Ngày Đánh Giá'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Table Đánh Giá Truyện';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `_ucard`
--

CREATE TABLE `_ucard` (
  `cdID` bigint(20) NOT NULL COMMENT 'ID Thẻ',
  `uID` bigint(20) NOT NULL COMMENT 'ID User',
  `creaateDate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'Ngày Sử Dụng'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Table Thẻ User';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `_ufavorites`
--

CREATE TABLE `_ufavorites` (
  `ufID` bigint(20) NOT NULL COMMENT 'ID User Favorites',
  `uID` bigint(20) DEFAULT NULL COMMENT 'ID User',
  `chID` bigint(20) DEFAULT NULL COMMENT 'ID Chapter',
  `locationIP` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Địa chỉ máy đọc',
  `ufStatus` int(11) DEFAULT '1' COMMENT 'Trạng Thái Hiển Thị',
  `dateView` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời Gian Đọc'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Table Yêu Thích';

--
-- Đang đổ dữ liệu cho bảng `_ufavorites`
--

INSERT INTO `_ufavorites` (`ufID`, `uID`, `chID`, `locationIP`, `ufStatus`, `dateView`) VALUES
(1, 1, 2, '', 1, '2018-09-04 09:36:05'),
(2, 1, 3, NULL, 1, '2018-09-11 09:36:05'),
(3, 1, 3, NULL, 1, '2018-09-12 09:36:05'),
(4, 1, 2, NULL, 1, '2018-09-14 09:36:05'),
(5, 1, 3, NULL, 1, '2018-09-14 09:36:05'),
(6, 1, 1, NULL, 1, '2018-09-14 09:36:05'),
(7, 1, 2, NULL, 1, '2018-09-14 09:36:05'),
(8, 1, 3, NULL, 1, '2018-09-14 09:36:05'),
(9, 2, 1, NULL, 1, '2018-09-18 09:36:05'),
(10, 2, 3, NULL, 1, '2018-09-18 09:36:05');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `_urole`
--

CREATE TABLE `_urole` (
  `uID` bigint(20) NOT NULL COMMENT 'ID User',
  `rID` int(11) NOT NULL COMMENT 'ID của Role',
  `createDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Ngày Tạo',
  `createBy` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Người Tạo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Table Quyền Của User';

--
-- Đang đổ dữ liệu cho bảng `_urole`
--

INSERT INTO `_urole` (`uID`, `rID`, `createDate`, `createBy`) VALUES
(1, 1, '2018-08-15 18:31:47', NULL),
(1, 4, '2018-08-15 18:31:47', NULL),
(2, 3, '2018-08-15 18:31:47', NULL),
(2, 4, '2018-08-15 18:31:47', NULL),
(11, 4, '2018-10-15 21:10:36', NULL),
(13, 4, '2018-10-15 22:07:11', NULL),
(14, 4, '2018-10-15 22:10:34', NULL),
(15, 4, '2018-10-15 22:12:08', NULL),
(16, 4, '2018-10-15 22:14:20', NULL),
(17, 4, '2018-10-15 22:16:23', NULL),
(18, 4, '2018-10-15 22:18:16', NULL),
(19, 4, '2018-10-15 22:52:24', NULL),
(20, 4, '2018-10-15 23:04:28', NULL),
(21, 4, '2018-10-15 23:07:23', NULL),
(22, 4, '2018-10-15 23:10:54', NULL),
(23, 4, '2018-10-15 23:21:48', NULL),
(24, 4, '2018-10-15 23:35:07', NULL),
(25, 4, '2018-10-15 23:43:36', NULL),
(26, 4, '2018-10-15 23:45:15', NULL);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `card`
--
ALTER TABLE `card`
  ADD PRIMARY KEY (`cdID`),
  ADD UNIQUE KEY `card_cdNumber_uindex` (`cdNumber`),
  ADD UNIQUE KEY `UKren5un6y6q4dhw0wcdud33bd9` (`cdNumber`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`cID`),
  ADD UNIQUE KEY `cateogry_cName_uindex` (`cName`),
  ADD UNIQUE KEY `cateogry_cMetatitle_uindex` (`cMetatitle`);

--
-- Chỉ mục cho bảng `chapter`
--
ALTER TABLE `chapter`
  ADD PRIMARY KEY (`chID`),
  ADD KEY `chapter_story_sID_fk` (`sID`),
  ADD KEY `chapter_user_uID_fk` (`uID`);

--
-- Chỉ mục cho bảng `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`comID`),
  ADD KEY `comment_user_uID_fk` (`uID`),
  ADD KEY `comment_story_sID_fk` (`sID`);

--
-- Chỉ mục cho bảng `information`
--
ALTER TABLE `information`
  ADD PRIMARY KEY (`infoID`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`rID`);

--
-- Chỉ mục cho bảng `story`
--
ALTER TABLE `story`
  ADD PRIMARY KEY (`sID`),
  ADD KEY `story_user_uID_fk` (`sConverter`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uID`),
  ADD UNIQUE KEY `user_uName_uindex` (`uName`),
  ADD UNIQUE KEY `user_uEmail_uindex` (`uEmail`),
  ADD UNIQUE KEY `UKq0357f7kx1k6ntp6bvus0x694` (`uEmail`),
  ADD UNIQUE KEY `UKstx4oc1652ecsjfu7ln8e9bmi` (`uName`),
  ADD UNIQUE KEY `user_uDname_uindex` (`uDname`),
  ADD UNIQUE KEY `UK6jmiamq45k36v745fac2gwwnu` (`uDname`);

--
-- Chỉ mục cho bảng `_chdeal`
--
ALTER TABLE `_chdeal`
  ADD PRIMARY KEY (`chDealID`),
  ADD KEY `chdeal_user_uID_fk` (`uID`),
  ADD KEY `chdeal_chapter_chID_fk` (`chID`);

--
-- Chỉ mục cho bảng `_scategory`
--
ALTER TABLE `_scategory`
  ADD PRIMARY KEY (`sID`,`cID`),
  ADD KEY `_scategory_cateogry_cID_fk` (`cID`);

--
-- Chỉ mục cho bảng `_sconverter`
--
ALTER TABLE `_sconverter`
  ADD PRIMARY KEY (`uID`,`sID`),
  ADD KEY `_sconverter_story_sID_fk` (`sID`);

--
-- Chỉ mục cho bảng `_seditor`
--
ALTER TABLE `_seditor`
  ADD PRIMARY KEY (`uID`,`sID`),
  ADD KEY `_seditor_story_sID_fk` (`sID`);

--
-- Chỉ mục cho bảng `_srating`
--
ALTER TABLE `_srating`
  ADD PRIMARY KEY (`uID`,`sID`),
  ADD KEY `_srating_story_sID_fk` (`sID`);

--
-- Chỉ mục cho bảng `_ucard`
--
ALTER TABLE `_ucard`
  ADD PRIMARY KEY (`cdID`,`uID`),
  ADD KEY `_ucard_user_uID_fk` (`uID`);

--
-- Chỉ mục cho bảng `_ufavorites`
--
ALTER TABLE `_ufavorites`
  ADD PRIMARY KEY (`ufID`),
  ADD KEY `ufavorites_user_uID_fk` (`uID`),
  ADD KEY `ufavorites_chapter_chID_fk` (`chID`);

--
-- Chỉ mục cho bảng `_urole`
--
ALTER TABLE `_urole`
  ADD PRIMARY KEY (`uID`,`rID`),
  ADD KEY `_urole_role_rID_fk` (`rID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `card`
--
ALTER TABLE `card`
  MODIFY `cdID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID Thẻ';

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `cID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `chapter`
--
ALTER TABLE `chapter`
  MODIFY `chID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID Chapter', AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `information`
--
ALTER TABLE `information`
  MODIFY `infoID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID Infomation', AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `role`
--
ALTER TABLE `role`
  MODIFY `rID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID Phân QUyền ', AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `story`
--
ALTER TABLE `story`
  MODIFY `sID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID Truyện', AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `uID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT cho bảng `_chdeal`
--
ALTER TABLE `_chdeal`
  MODIFY `chDealID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID chDeal', AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `_ufavorites`
--
ALTER TABLE `_ufavorites`
  MODIFY `ufID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID User Favorites', AUTO_INCREMENT=11;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chapter`
--
ALTER TABLE `chapter`
  ADD CONSTRAINT `FKoiqsft4egp7cxq41euj56hglu` FOREIGN KEY (`uID`) REFERENCES `user` (`uID`),
  ADD CONSTRAINT `chapter_story_sID_fk` FOREIGN KEY (`sID`) REFERENCES `story` (`sID`),
  ADD CONSTRAINT `chapter_user_uID_fk` FOREIGN KEY (`uID`) REFERENCES `user` (`uID`);

--
-- Các ràng buộc cho bảng `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FK7k38tac8pkcf20qqy1g3g1q5w` FOREIGN KEY (`uID`) REFERENCES `user` (`uID`),
  ADD CONSTRAINT `comment_story_sID_fk` FOREIGN KEY (`sID`) REFERENCES `story` (`sID`),
  ADD CONSTRAINT `comment_user_uID_fk` FOREIGN KEY (`uID`) REFERENCES `user` (`uID`);

--
-- Các ràng buộc cho bảng `story`
--
ALTER TABLE `story`
  ADD CONSTRAINT `FK6ya89n0d9vlpvws2c6aq5bu6t` FOREIGN KEY (`sConverter`) REFERENCES `user` (`uID`),
  ADD CONSTRAINT `story_user_uID_fk` FOREIGN KEY (`sConverter`) REFERENCES `user` (`uID`);

--
-- Các ràng buộc cho bảng `_chdeal`
--
ALTER TABLE `_chdeal`
  ADD CONSTRAINT `chdeal_chapter_chID_fk` FOREIGN KEY (`chID`) REFERENCES `chapter` (`chID`),
  ADD CONSTRAINT `chdeal_user_uID_fk` FOREIGN KEY (`uID`) REFERENCES `user` (`uID`);

--
-- Các ràng buộc cho bảng `_scategory`
--
ALTER TABLE `_scategory`
  ADD CONSTRAINT `_scategory_cateogry_cID_fk` FOREIGN KEY (`cID`) REFERENCES `category` (`cID`),
  ADD CONSTRAINT `_scategory_story_sID_fk` FOREIGN KEY (`sID`) REFERENCES `story` (`sID`);

--
-- Các ràng buộc cho bảng `_sconverter`
--
ALTER TABLE `_sconverter`
  ADD CONSTRAINT `FK9gs8t382n2th1jwnsjrdkmioh` FOREIGN KEY (`uID`) REFERENCES `user` (`uID`),
  ADD CONSTRAINT `_sconverter_story_sID_fk` FOREIGN KEY (`sID`) REFERENCES `story` (`sID`),
  ADD CONSTRAINT `_sconverter_user_uID_fk` FOREIGN KEY (`uID`) REFERENCES `user` (`uID`);

--
-- Các ràng buộc cho bảng `_seditor`
--
ALTER TABLE `_seditor`
  ADD CONSTRAINT `FK3tvnpnb5jp9fjr6hppsg5xrwl` FOREIGN KEY (`uID`) REFERENCES `user` (`uID`),
  ADD CONSTRAINT `_seditor_story_sID_fk` FOREIGN KEY (`sID`) REFERENCES `story` (`sID`),
  ADD CONSTRAINT `_seditor_user_uID_fk` FOREIGN KEY (`uID`) REFERENCES `user` (`uID`);

--
-- Các ràng buộc cho bảng `_srating`
--
ALTER TABLE `_srating`
  ADD CONSTRAINT `FKl6uc4pj2bg6o8wmos0ihxuu4n` FOREIGN KEY (`uID`) REFERENCES `user` (`uID`),
  ADD CONSTRAINT `_srating_story_sID_fk` FOREIGN KEY (`sID`) REFERENCES `story` (`sID`),
  ADD CONSTRAINT `_srating_user_uID_fk` FOREIGN KEY (`uID`) REFERENCES `user` (`uID`);

--
-- Các ràng buộc cho bảng `_ucard`
--
ALTER TABLE `_ucard`
  ADD CONSTRAINT `FKplfl8kdsv6jcbr5ba40oafkiq` FOREIGN KEY (`uID`) REFERENCES `user` (`uID`),
  ADD CONSTRAINT `_ucard_card_cdID_fk` FOREIGN KEY (`cdID`) REFERENCES `card` (`cdID`),
  ADD CONSTRAINT `_ucard_user_uID_fk` FOREIGN KEY (`uID`) REFERENCES `user` (`uID`);

--
-- Các ràng buộc cho bảng `_ufavorites`
--
ALTER TABLE `_ufavorites`
  ADD CONSTRAINT `FKsa4pkhu41dl3hk88g1ibv82nh` FOREIGN KEY (`uID`) REFERENCES `user` (`uID`),
  ADD CONSTRAINT `ufavorites_chapter_chID_fk` FOREIGN KEY (`chID`) REFERENCES `chapter` (`chID`),
  ADD CONSTRAINT `ufavorites_user_uID_fk` FOREIGN KEY (`uID`) REFERENCES `user` (`uID`);

--
-- Các ràng buộc cho bảng `_urole`
--
ALTER TABLE `_urole`
  ADD CONSTRAINT `FK6lxlgyqxdujskwtghdho3l5cn` FOREIGN KEY (`uID`) REFERENCES `user` (`uID`),
  ADD CONSTRAINT `_urole_role_rID_fk` FOREIGN KEY (`rID`) REFERENCES `role` (`rID`),
  ADD CONSTRAINT `_urole_user_uID_fk` FOREIGN KEY (`uID`) REFERENCES `user` (`uID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
