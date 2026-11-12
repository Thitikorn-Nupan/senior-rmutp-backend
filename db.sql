/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `ecomerce_backend_modify` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ecomerce_backend_modify`;

CREATE TABLE IF NOT EXISTS `addresses` (
  `aid` int NOT NULL AUTO_INCREMENT,
  `province` varchar(60) DEFAULT NULL,
  `district` varchar(60) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zipcode` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `addresses` (`aid`, `province`, `district`, `street`, `zipcode`) VALUES
	(65, 'Bangkok', 'Bang Rak', '661/8-9 Soi Sathupradit 55 Sathupradit Road Bangpongpang', '10500'),
	(66, 'Bangkok', 'Bang Rak', '661/8-9 Soi Sathupradit 55 Sathupradit Road Bangpongpang', '10500'),
	(67, 'Bangkok', 'Bang Rak', '661/8-9 Soi Sathupradit 55 Sathupradit Road Bangpongpang', '10500'),
	(68, 'Bangkok', 'Bang Rak', 'Admin', '10500'),
	(69, 'Nonthaburi', 'Bang Bua Thong', '123 AB. Village', '10165'),
	(70, 'Nonthaburi', 'Bang Bua Thong', '123 AB. Village', '10165'),
	(71, 'Nonthaburi', 'Bang Bua Thong', '123 AB. Village', '10165'),
	(72, 'Nonthaburi', 'Bang Bua Thong', '123 AB. Village', '10165'),
	(73, 'Nonthaburi', 'Bang Bua Thong', '123 AB. Village', '10165'),
	(74, 'Nonthaburi', 'Bang Bua Thong', '123 AB. Village', '10165'),
	(75, 'Bangkok', 'Bang Khun Thian', '1/186 หมู่บ้านพฤกษาวิลล์ ซอย สะแกงาม 14 อำเภอ บางขุนเทียน ตำบล แสมดำ', '10150'),
	(76, 'Bangkok', 'Bang Khun Thian', '1/186 หมู่บ้านพฤกษาวิลล์ ซอย สะแกงาม 14 อำเภอ บางขุนเทียน ตำบล แสมดำ', '10150'),
	(77, 'Nonthaburi', 'Bang Bua Thong', '123 AB. Village', '10165'),
	(78, 'Nonthaburi', 'Bang Bua Thong', '123 AB. Village', '10165'),
	(79, 'Nonthaburi', 'Bang Bua Thong', '123 AB. Village', '10165'),
	(80, 'Nonthaburi', 'Bang Bua Thong', '123 AB. Village', '10165'),
	(81, 'Nonthaburi', 'Bang Bua Thong', '123 AB. Village', '10165'),
	(82, 'Nonthaburi', 'Bang Bua Thong', '123 AB. Village', '10165'),
	(83, 'Nonthaburi', 'Bang Bua Thong', '123 AB. Village', '10165'),
	(84, 'Nonthaburi', 'Bang Bua Thong', '123 AB. Village', '10165'),
	(85, 'Nonthaburi', 'Bang Rak Pattana', '123 AB. Village', '10165'),
	(86, 'Nonthaburi', 'Bang Rak Pattana', '123 AB. Village', '10165'),
	(87, 'Nonthaburi', 'Bang Bua Thong', '123 AB. Village', '10165'),
	(88, 'Nonthaburi', 'Bang Bua Thong', '123 AB. Village', '10165'),
	(89, 'Bangkok', 'Bang Khun Thian', '123 AB village', '10150'),
	(90, 'Bangkok', 'Bang Khun Thian', '123 AB village', '10150'),
	(91, 'Nonthaburi', 'Bang Rak Pattana', '12345 AB. Village', '16525'),
	(92, 'Nonthaburi', 'Bang Rak Pattana', '12345 AB. Village', '16525'),
	(103, 'Bangkok', 'Bang Rak', '661/8-9 Soi Sathupradit 55 Sathupradit Road Bangpongpang', '10500'),
	(104, 'Bangkok', 'Bang Rak', '661/8-9 Soi Sathupradit 55 Sathupradit Road Bangpongpang', '10500'),
	(109, 'Bangkok', 'Bang Rak', '661/8-9 Soi Sathupradit 55 Sathupradit Road Bangpongpang', '10152'),
	(110, 'Bangkok', 'Bang Rak', '661/8-9 Soi Sathupradit 55 Sathupradit Road Bangpongpang', '10152'),
	(111, 'Bangkok', 'Bang Rak', '661/8-9 Soi Sathupradit 55 Sathupradit Road Bangpongpang', '10152'),
	(112, 'Bangkok', 'Bang Rak', '661/8-9 Soi Sathupradit 55 Sathupradit Road Bangpongpang', '10152'),
	(113, 'Bangkok', 'Dusit', 'West Coast Leather Factory, 124 Phang-Nga Rd., A. Muang', '12345'),
	(114, 'Bangkok', 'Dusit', 'West Coast Leather Factory, 124 Phang-Nga Rd., A. Muang', '12345'),
	(115, 'Bangkok', 'Dusit', 'West Coast Leather Factory, 124 Phang-Nga Rd., A. Muang', '12345'),
	(116, 'Bangkok', 'Dusit', 'West Coast Leather Factory, 124 Phang-Nga Rd., A. Muang', '12345'),
	(117, 'Bangkok', 'Bang Khun Thian', '661/8-9 Soi Sathupradit 55 Sathupradit Road Bangpongpang', '10150'),
	(118, 'Bangkok', 'Bang Khun Thian', '661/8-9 Soi Sathupradit 55 Sathupradit Road Bangpongpang', '10150'),
	(119, 'Bangkok', 'Bang Khun Thian', '1/186 หมู่บ้านพฤกษาวิลล์ ซอย สะแกงาม 14 อำเภอ บางขุนเทียน ตำบล แสมดำ', '10150'),
	(120, 'Bangkok', 'Bang Khun Thian', '1/186 หมู่บ้านพฤกษาวิลล์ ซอย สะแกงาม 14 อำเภอ บางขุนเทียน ตำบล แสมดำ', '10150'),
	(121, 'Bangkok', 'Bang Khen', 'West Coast Leather Factory, 124 Phang-Nga Rd., A. Muang', '10325'),
	(122, 'Bangkok', 'Bang Khen', 'West Coast Leather Factory, 124 Phang-Nga Rd., A. Muang', '10330'),
	(123, 'Bangkok', 'Dusit', 'West Coast Leather Factory, 124 Phang-Nga Rd., A. Muang', '12345'),
	(124, 'Bangkok', 'Dusit', 'West Coast Leather Factory, 124 Phang-Nga Rd., A. Muang', '12345'),
	(125, 'Bangkok', 'Bang Khen', '123 AB. Village', '12352'),
	(126, 'Bangkok', 'Bang Khen', '123 AB. Village', '12352'),
	(127, 'Bangkok', 'Dusit', '1/186 หมู่บ้านพฤกษาวิลล์ ซอย สะแกงาม 14 อำเภอ บางขุนเทียน ตำบล แสมดำ', '10150'),
	(128, 'Bangkok', 'Dusit', '1/186 หมู่บ้านพฤกษาวิลล์ ซอย สะแกงาม 14 อำเภอ บางขุนเทียน ตำบล แสมดำ', '10150'),
	(133, 'Bangkok', 'Dusit', '661/8-9 Soi Sathupradit 55 Sathupradit Road Bangpongpang', '11121'),
	(134, 'Bangkok', 'Dusit', '661/8-9 Soi Sathupradit 55 Sathupradit Road Bangpongpang', '11121'),
	(135, 'Bangkok', 'Dusit', '661/8-9 Soi Sathupradit 55 Sathupradit Road Bangpongpang', '11121'),
	(136, 'Bangkok', 'Dusit', '661/8-9 Soi Sathupradit 55 Sathupradit Road Bangpongpang', '10150'),
	(137, 'Bangkok', 'Dusit', '661/8-9 Soi Sathupradit 55 Sathupradit Road Bangpongpang', '10150'),
	(138, 'Bangkok', 'Dusit', '1/186 หมู่บ้านพฤกษาวิลล์ ซอย สะแกงาม 14 อำเภอ บางขุนเทียน ตำบล แสมดำ', '10215'),
	(139, 'Bangkok', 'Dusit', '1/186 หมู่บ้านพฤกษาวิลล์ ซอย สะแกงาม 14 อำเภอ บางขุนเทียน ตำบล แสมดำ', '10215'),
	(140, 'Bangkok', 'Dusit', '1/186 หมู่บ้านพฤกษาวิลล์ ซอย สะแกงาม 14 อำเภอ บางขุนเทียน ตำบล แสมดำ', '10150'),
	(141, 'Bangkok', 'Dusit', '1/186 หมู่บ้านพฤกษาวิลล์ ซอย สะแกงาม 14 อำเภอ บางขุนเทียน ตำบล แสมดำ', '10150'),
	(142, 'Bangkok', 'Bang Khen', '123 AB. Village', '15236'),
	(143, 'Bangkok', 'Bang Khen', '123 AB. Village', '15236'),
	(144, 'Samut Sakhon', 'Lak Ha', '51/101-102 Phrabaramee Road', '10322'),
	(145, 'Samut Sakhon', 'Lak Ha', '51/101-102 Phrabaramee Road', '10322'),
	(146, 'Bangkok', 'Nong Khaem', '1584 Sukhumvit Rd', '16565'),
	(147, 'Bangkok', 'Nong Khaem', '1584 Sukhumvit Rd', '16565'),
	(148, 'Bangkok', 'Bang Khun Thian', '33/1429 Soi Chokchai 4, Ladprao Rd., Ladprao', '10150'),
	(149, 'Bangkok', 'Bang Khun Thian', '33/1429 Soi Chokchai 4, Ladprao Rd., Ladprao', '10150'),
	(150, 'Bangkok', 'Bang Khun Thian', '33/1429 Soi Chokchai 4, Ladprao Rd., Ladprao', '10150'),
	(151, 'Bangkok', 'Bang Khun Thian', '33/1429 Soi Chokchai 4, Ladprao Rd., Ladprao', '10150');

CREATE TABLE IF NOT EXISTS `customers` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(90) NOT NULL,
  `lastname` varchar(90) NOT NULL,
  `email` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `customers` (`cid`, `firstname`, `lastname`, `email`) VALUES
	(10, 'Alex', 'Ryder', 'alex@outlook.co.th'),
	(11, 'Admin', 'Admin', 'admin@outlook.co.th'),
	(12, 'Thitikorn', 'Nupan', 'thitikorn-n@rmutp.ac.th'),
	(13, 'Dom', 'Slider', 'dom@hotmail.com'),
	(14, 'Test', 'Test', 'test@hotmail.com'),
	(15, 'Nobody', 'Nobody', 'nobody@hotmail.com');

CREATE TABLE IF NOT EXISTS `districts` (
  `did` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `pid` int DEFAULT NULL,
  PRIMARY KEY (`did`),
  KEY `fk_provinces_pid` (`pid`),
  CONSTRAINT `fk_provinces_pid` FOREIGN KEY (`pid`) REFERENCES `provinces` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `districts` (`did`, `name`, `pid`) VALUES
	(1, 'Dusit', 1),
	(2, 'Bang Rak', 1),
	(3, 'Bang Khen', 1),
	(4, 'Bang Kapi', 1),
	(5, 'Pathum Wan', 1),
	(6, 'Bang Khun Thian', 1),
	(7, 'Nong Khaem', 1),
	(8, 'Din Daeng', 1),
	(9, 'Bang Bua Thong', 2),
	(10, 'Bang Rak Pattana', 2),
	(11, 'Bang Kruai', 2),
	(12, 'Bang Khu Rat', 2),
	(13, 'Sai Ma', 2),
	(14, 'Phimon Rat', 2),
	(15, 'Plai Bang', 2),
	(16, 'Sala Klang', 2),
	(17, 'Lak Ha', 3),
	(18, 'Khae Rai', 3),
	(19, 'Don Kai Di', 3),
	(20, 'Bang Pla', 3),
	(21, 'Kaset Phatthana', 3),
	(22, 'Tha Chin', 3),
	(23, 'Ban Phaeo', 3),
	(24, 'Na Di', 3),
	(25, 'Makham Yong', 4),
	(26, 'Ban Khot', 4),
	(27, 'Saen Suk', 4),
	(28, 'Ban Suan', 4),
	(29, 'Nong Ri', 4),
	(30, 'Na Pa', 4),
	(31, 'Don Hua Lo', 4),
	(32, 'Bang Sai', 4);

CREATE TABLE IF NOT EXISTS `orders` (
  `oid` int NOT NULL AUTO_INCREMENT,
  `order_tracking_number` varchar(255) DEFAULT NULL,
  `total_price` decimal(9,2) DEFAULT NULL,
  `total_quantity` int DEFAULT NULL,
  `billing_address_aid` int DEFAULT NULL,
  `shipping_address_aid` int DEFAULT NULL,
  `customer_cid` int DEFAULT NULL,
  `date_created` datetime(6) DEFAULT NULL,
  `status_purchase` tinyint(1) DEFAULT '1',
  `qr_purchase_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  UNIQUE KEY `uk_billing_address_aid` (`billing_address_aid`),
  UNIQUE KEY `uk_shipping_address_aid` (`shipping_address_aid`),
  KEY `k_customer_cid` (`customer_cid`),
  CONSTRAINT `fk_billing_address_aid` FOREIGN KEY (`billing_address_aid`) REFERENCES `addresses` (`aid`),
  CONSTRAINT `fk_customer_cid` FOREIGN KEY (`customer_cid`) REFERENCES `customers` (`cid`),
  CONSTRAINT `fk_shipping_address_aid` FOREIGN KEY (`shipping_address_aid`) REFERENCES `addresses` (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `orders` (`oid`, `order_tracking_number`, `total_price`, `total_quantity`, `billing_address_aid`, `shipping_address_aid`, `customer_cid`, `date_created`, `status_purchase`, `qr_purchase_url`) VALUES
	(33, 'f81deeef-e69b-40ad-99dc-c150ba193b43', 2189.97, 3, 65, 66, 10, '2024-10-08 11:24:09.693000', 1, 'assets/images/qr_purchases/61UQksXF-1001-1006.JPEG'),
	(34, '85dbabea-2b87-4891-b9aa-558139bb7d3e', 1829.97, 3, 67, 68, 10, '2024-10-08 11:25:28.352000', 1, NULL),
	(35, '85bf3201-f83e-4082-b197-f98ba317bf5b', 6999.90, 10, 69, 70, 11, '2024-10-08 11:28:57.181000', 1, 'Y0X3rn89'),
	(36, '93ae868a-6dab-4931-b08c-00052b4509d1', 2359.96, 4, 71, 72, 11, '2024-10-08 11:38:13.161000', 1, 'E6pmBG2L'),
	(37, '7d1eda7c-a573-4999-9b66-66eac67c94c9', 2649.95, 5, 73, 74, 10, '2024-10-08 14:09:22.379000', 1, NULL),
	(38, '4e157a98-fb7b-4bd6-a2b5-53b48c77d30b', 7799.90, 10, 75, 76, 12, '2024-10-08 14:10:22.687000', 1, 'cgbWDYVQ'),
	(39, '94459513-b3fd-47cf-afcb-75c271f240b3', 649.99, 1, 77, 78, 11, '2024-10-08 14:16:51.023000', 1, 'ywCR8YOP'),
	(40, '9f8c70af-7781-4f95-bf2a-458e28494e5d', 5449.87, 13, 79, 80, 10, '2024-10-09 12:53:18.824000', 1, 'KBJawSGM'),
	(41, '98a9f317-8a9b-4370-971a-92b7ec16eabe', 3639.95, 5, 81, 82, 11, '2024-10-09 12:58:54.908000', 1, '44iRa4F8'),
	(42, '7e57d643-f92f-4b2f-8d8a-ecb618504b1c', 719.99, 1, 83, 84, 11, '2024-10-09 13:00:04.445000', 1, 'UpZJUiIo'),
	(43, 'c0bd4fa7-1394-4ee1-a096-bab53ddb8064', 649.99, 1, 85, 86, 11, '2024-10-14 16:34:56.150000', 1, 'assets/images/qr_purchases/B9Vh1O16-1001-1011.JPEG'),
	(44, 'e935459d-73aa-483a-801a-2bdba4101e55', 649.99, 1, 87, 88, 11, '2024-10-14 16:39:01.854000', 1, 'assets/images/qr_purchases/61UQksXF-1001-1006.JPEG'),
	(45, '930f505f-db53-41e9-8531-1dfa83251652', 2299.97, 3, 89, 90, 13, '2025-07-05 16:11:36.085000', 1, 'assets/images/qr_purchases/61UQksXF-1001-1006.JPEG'),
	(46, '7c1c8277-1617-45a1-9101-009b9e51edd3', 649.99, 1, 91, 92, 13, '2025-07-05 16:14:32.885000', 1, NULL),
	(51, '86dbabea-2b12-4823-b9aa-558139bb7d3e', 3899.94, 6, 104, 103, 13, '2025-06-07 07:00:00.000000', 1, NULL),
	(54, '86dbabea-2b12-4123-b9aa-551139bb7d1e', 3099.95, 5, 110, 109, 11, '2025-07-07 14:08:36.375000', 1, 'assets/images/qr_purchases/qwj15zs2-1008.JPEG'),
	(55, '86cbabea-2b13-4113-b9aa-551139bb7d1e', 3099.95, 5, 112, 111, 11, '2025-07-07 14:10:23.161000', 1, 'assets/images/qr_purchases/Kw2CWn7x-1008.JPEG'),
	(56, '89cbabea-9b13-4913-b9aa-551139bb7d1e', 12169.83, 17, 114, 113, 15, '2025-07-07 15:43:22.994000', 1, 'assets/images/qr_purchases/dyc222md-1008.JPEG'),
	(57, '930f105f-db53-41e9-8511-1dfa83251152', 12169.83, 17, 116, 115, 15, '2025-07-07 15:49:04.449000', 0, 'assets/images/qr_purchases/5SvPoW2O-IMG_1605.JPEG'),
	(58, '910f105f-db53-41e9-8511-1dfa13251152', 649.99, 1, 118, 117, 11, '2025-07-07 16:14:15.552000', 1, 'assets/images/qr_purchases/UpczYk9F-IMG_1605.JPEG'),
	(59, '900f100f-db53-41e9-8511-1dfa83251152', 549.99, 1, 120, 119, 10, '2025-07-07 16:14:15.552000', 1, ''),
	(60, '930f105f-db53-41e9-1511-1dfa83253152', 2099.96, 4, 122, 121, 10, '2025-07-07 18:51:24.262000', 1, ''),
	(61, '700f100f-db13-41e9-8511-1dfa83251152', 4549.93, 7, 124, 123, 10, '2025-07-07 18:54:42.765000', 1, ''),
	(62, '0a9064fe-22e0-4388-a958-e233d94dcd7a', 5999.94, 6, 126, 125, 13, '2025-07-07 19:09:08.466000', 1, ''),
	(63, '6229c163-6c6b-4dab-bfe2-1130a6e0d603', 4749.92, 8, 128, 127, 12, '2025-07-07 19:27:08.114000', 0, 'assets/images/qr_purchases/pemMAaGZ-IMG_1605.JPEG'),
	(65, 'b785b6a4-90bc-42b8-a336-d6757d21a4a3', 999.98, 2, 139, 138, 11, '2025-07-11 14:44:20.290000', 1, 'assets/images/qr_purchases/KWIQVg3e-IMG_1605.JPEG'),
	(66, '151a0a8d-bcf0-4174-990a-995f78de9140', 4549.93, 7, 141, 140, 11, '2025-07-11 14:46:34.982000', 1, ''),
	(67, '2d98eac1-2e6d-4f7c-9ad5-bb06ba3d323f', 999.99, 1, 143, 142, 10, '2025-07-11 14:58:26.898000', 1, ''),
	(68, '7ff36965-15e1-45c2-9d6a-4d9ce57fca58', 3752.50, 5, 145, 144, 10, '2025-07-14 16:00:49.148000', 1, ''),
	(69, 'ce4dabea-f931-4430-addc-d2d9eb5b7cf9', 10694.46, 13, 147, 146, 11, '2025-07-14 16:03:10.346000', 1, 'assets/images/qr_purchases/uNUytan5-1004.JPEG'),
	(70, '7e27d10b-28ce-4063-8089-a812b15121ff', 3018.98, 4, 149, 148, 11, '2025-10-06 17:49:15.854000', 1, 'assets/images/qr_purchases/cBxQaMlW-1008.JPEG'),
	(71, 'c31f7ba6-389a-4b09-8750-afe2acc03f20', 2510.99, 3, 151, 150, 11, '2025-10-06 17:51:18.124000', 1, '');

CREATE TABLE IF NOT EXISTS `order_items` (
  `oi_id` int NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price` decimal(9,2) DEFAULT NULL,
  `order_oid` int DEFAULT NULL,
  `product_pid` int DEFAULT NULL,
  PRIMARY KEY (`oi_id`),
  KEY `k_order_oid` (`order_oid`),
  KEY `fk_product_pid` (`product_pid`),
  CONSTRAINT `fk_order_oid` FOREIGN KEY (`order_oid`) REFERENCES `orders` (`oid`),
  CONSTRAINT `fk_product_pid` FOREIGN KEY (`product_pid`) REFERENCES `products` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `order_items` (`oi_id`, `image_url`, `quantity`, `price`, `order_oid`, `product_pid`) VALUES
	(50, 'assets/images/products/female/1010.jpg', 1, 699.99, 33, 11),
	(51, 'assets/images/products/female/1011.jpg', 1, 649.99, 33, 12),
	(52, 'assets/images/products/male/1003.jpg', 1, 839.99, 33, 4),
	(53, 'assets/images/products/both/1015.jpg', 1, 779.99, 34, 16),
	(54, 'assets/images/products/both/1017.jpg', 1, 649.99, 34, 18),
	(55, 'assets/images/products/both/1016.jpg', 1, 399.99, 34, 17),
	(56, 'assets/images/products/female/1010.jpg', 10, 699.99, 35, 11),
	(57, 'assets/images/products/both/1016.jpg', 2, 399.99, 36, 17),
	(58, 'assets/images/products/both/1015.jpg', 2, 779.99, 36, 16),
	(59, 'assets/images/products/both/1016.jpg', 2, 399.99, 37, 17),
	(60, 'assets/images/products/both/1017.jpg', 2, 649.99, 37, 18),
	(61, 'assets/images/products/male/1005.jpg', 1, 549.99, 37, 6),
	(62, 'assets/images/products/both/1015.jpg', 10, 779.99, 38, 16),
	(63, 'assets/images/products/both/1013.jpg', 1, 649.99, 39, 14),
	(64, 'assets/images/products/male/1001.jpg', 1, 649.99, 40, 2),
	(65, 'assets/images/products/male/1004.jpg', 12, 399.99, 40, 5),
	(66, 'assets/images/products/both/1013.jpg', 2, 649.99, 41, 14),
	(67, 'assets/images/products/both/1015.jpg', 3, 779.99, 41, 16),
	(68, 'assets/images/products/both/1012.jpg', 1, 719.99, 42, 13),
	(69, 'assets/images/products/both/1013.jpg', 1, 649.99, 43, 14),
	(70, 'assets/images/products/both/1013.jpg', 1, 649.99, 44, 14),
	(71, 'assets/images/products/female/1008.jpg', 1, 999.99, 45, 9),
	(72, 'assets/images/products/female/1007.jpg', 2, 649.99, 45, 8),
	(73, 'assets/images/products/female/1007.jpg', 1, 649.99, 46, 8),
	(81, 'assets/images/products/female/1007.jpg', 2, 649.99, 51, 8),
	(82, 'assets/images/products/male/1001.jpg', 4, 649.99, 51, 2),
	(89, 'assets/images/products/both/1013.jpg', 2, 649.99, 54, 14),
	(90, 'assets/images/products/male/1001.jpg', 2, 649.99, 54, 2),
	(91, 'assets/images/products/both/1014.jpg', 1, 499.99, 54, 15),
	(92, 'assets/images/products/male/1001.jpg', 2, 649.99, 55, 2),
	(93, 'assets/images/products/both/1014.jpg', 1, 499.99, 55, 15),
	(94, 'assets/images/products/both/1013.jpg', 2, 649.99, 55, 14),
	(95, 'assets/images/products/both/1012.jpg', 16, 719.99, 56, 13),
	(96, 'assets/images/products/male/1001.jpg', 1, 649.99, 56, 2),
	(97, 'assets/images/products/both/1012.jpg', 16, 719.99, 57, 13),
	(98, 'assets/images/products/male/1001.jpg', 1, 649.99, 57, 2),
	(99, 'assets/images/products/male/1001.jpg', 1, 649.99, 58, 2),
	(100, 'assets/images/products/male/1002.jpg', 1, 549.99, 59, 3),
	(101, 'assets/images/products/both/1016.jpg', 2, 399.99, 60, 17),
	(102, 'assets/images/products/both/1017.jpg', 2, 649.99, 60, 18),
	(103, 'assets/images/products/both/1017.jpg', 7, 649.99, 61, 18),
	(104, 'assets/images/products/female/1008.jpg', 6, 999.99, 62, 9),
	(105, 'assets/images/products/male/1001.jpg', 4, 649.99, 63, 2),
	(106, 'assets/images/products/both/1014.jpg', 3, 499.99, 63, 15),
	(107, 'assets/images/products/both/1013.jpg', 1, 649.99, 63, 14),
	(110, 'assets/images/products/both/1014.jpg', 2, 499.99, 65, 15),
	(111, 'assets/images/products/both/1013.jpg', 7, 649.99, 66, 14),
	(112, 'assets/images/products/female/1008.jpg', 1, 999.99, 67, 9),
	(113, 'assets/images/products/female/49nsKF7S-TYOAKD-1105.png', 5, 750.50, 68, 22),
	(114, 'assets/images/products/male/uWJ2Xdmh-AWSAX-1001.png', 5, 650.50, 69, 23),
	(115, 'assets/images/products/male/g1MmTegS-WOSASD-1003.png', 4, 860.50, 69, 25),
	(116, 'assets/images/products/male/35BXQxgr-WOASD-1002.png', 4, 999.99, 69, 24),
	(117, 'assets/images/products/both/iGgMRFwJ-IUOLKAD-1006.png', 1, 999.01, 70, 21),
	(118, 'assets/images/products/both/1013.jpg', 2, 649.99, 70, 14),
	(119, 'assets/images/products/both/EN2VXdFW-Screenshot 2025-10-06 174538.png', 1, 719.99, 70, 13),
	(120, 'assets/images/products/male/uWJ2Xdmh-AWSAX-1001.png', 1, 650.50, 71, 23),
	(121, 'assets/images/products/male/g1MmTegS-WOSASD-1003.png', 1, 860.50, 71, 25),
	(122, 'assets/images/products/male/35BXQxgr-WOASD-1002.png', 1, 999.99, 71, 24);

CREATE TABLE IF NOT EXISTS `products` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `sku` varchar(90) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  `price` decimal(13,2) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `unit_in_stock` int DEFAULT NULL,
  `pc_id` int NOT NULL,
  PRIMARY KEY (`pid`),
  KEY `fk_categories_pc_id` (`pc_id`),
  CONSTRAINT `fk_categories_pc_id` FOREIGN KEY (`pc_id`) REFERENCES `product_categories` (`pc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `products` (`pid`, `sku`, `name`, `description`, `price`, `image_url`, `unit_in_stock`, `pc_id`) VALUES
	(1, 'PERFUME-M001', 'Eternity Moment', 'Eternity Moment Perfume by Ttknp shop is a floral fragrance for women that was developed in 2004 by the expert noses of Harry Fremont and Jacques Cavallier. This scent was designed to bring a youthful take on the popular Eternity perfume and has become a signature fragrance staple for women of all ages.', 549.99, 'assets/images/products/male/1000.jpg', 88, 1),
	(2, 'PERFUME-M002', 'Euphoria', 'Ttknp\'s Euphoria perfume is a captivating perfume that combines fruity and floral notes with a warm and sensual base offered as an eau de parfum spray. We also have it available in body lotion. Its amber floral fragrance family and alluring scent make it suitable for both women and men who appreciate a sophisticated and seductive aroma. With its long-lasting fragrance and widespread compliments, Euphoria has become a beloved signature scent for many.', 649.99, 'assets/images/products/male/1001.jpg', 68, 1),
	(3, 'PERFUME-M003', 'Eternity Reflections Cologne', 'Ttknp\'s Eternity Reflections cologne is a truly unique fragrance designed for relaxation and sophistication. Launched in 2023, this fragrance will appeal to your love for the outdoors as it places you in the mood for light breezes, summer skies and green forests as you breathe in its luscious blend of notes.', 549.99, 'assets/images/products/male/1002.jpg', 98, 1),
	(4, 'PERFUME-M004', 'Eternity Summer Daze Cologne', 'This romantic and fruity fragrance has a rich scent that delivers a decadent and enchanting aroma. The base notes of jasmine capture fragility, while the top notes of juicy berries add an indulgent aura.', 839.99, 'assets/images/products/male/1003.jpg', 95, 1),
	(5, 'PERFUME-M005', 'Sheer Beauty', 'Sheer Beauty Perfume by Ttknp shop, Indulge in the chic femininity and grace of Sheer Beauty, a luminous women’s fragrance. This intoxicating perfume combines fruity, floral and musky accords for a sensational result that’s sure to leave you feeling irresistible after every spritz.', 399.99, 'assets/images/products/male/1004.jpg', 100, 1),
	(6, 'PERFUME-M006', 'Reveal', 'Reveal Calvin Klein Perfume by Ttknp shop, Reveal Calvin Klein is a sensual woody fragrance that evokes scenes of sea voyages and adventures in romance. The top notes are made up of sea salt for a passionate ocean kiss, followed by the rich spices of pink, black, and white pepper.', 549.99, 'assets/images/products/male/1005.jpg', 100, 1),
	(7, 'PERFUME-F001', 'Armaf Hunter Intense', 'Armaf Hunter Intense Cologne by Ttknp shop is a cologne that combines accords of woods and florals. It was launched by Armaf in 2016. The refreshing top notes create a surprising burst of citrus with notes of bergamot, mandarin, grapefruit and lemon.', 719.99, 'assets/images/products/female/1006.jpg', 100, 2),
	(8, 'PERFUME-F002', 'Club De Nuit Imperiale', 'Armaf Club De Nuit Imperiale perfume is a citrusy aromatic fragrance for women, released by Armaf in 2022. It’s a refreshing scent that reflects a sophisticated woman who is both carefree and sensual. This perfume melds citrusy notes with spices, gourmand accords and musk that projects sophistication, elegance and feminine intrigue.', 649.99, 'assets/images/products/female/1007.jpg', 100, 2),
	(9, 'PERFUME-F003', 'Armaf Tres Jour', 'Armaf Tres Jour Perfume by Ttknp shop, White floral, citrus, green, tuberose and animalic are the main accords for Armaf Tres Jour, and they combine to give this perfume for women its distinctive scent. The tuberose note in itself adds complexity and contradiction to this design from Armaf', 999.99, 'assets/images/products/female/1008.jpg', 100, 2),
	(10, 'PERFUME-F004', 'Truth', 'Truth Perfume by Ttknp shop is a sparkling combination of green and floral accords. Introduced in 2000, this fragrance was designed with two families of scents: lush and sensual.', 839.99, 'assets/images/products/female/1009.jpg', 98, 2),
	(11, 'PERFUME-F005', 'Armaf Niche Sapphire', 'Armaf Niche Sapphire Perfume by Ttknp shop, An unusual aquatic ambery fragrance, Armaf Niche Sapphire is a great daytime scent in warmer months.', 699.99, 'assets/images/products/female/flBPF7Mp-UISAJKS-1009.png', 100, 2),
	(12, 'PERFUME-F006', 'Secret Obsession', 'Secret Obsession Perfume by Ttknp shop, Secret Obsession is that rare scent that works equally well as a daily wear fragrance or as a special date night scent. Top notes of exotic plum, nutmeg, and mace turn heads without overpowering.', 649.99, 'assets/images/products/female/YrmUHDjO-LSPAO-1004.png', 99, 2),
	(13, 'PERFUME-U001', 'Tommy Bahama Set Sail St. Barts', 'Tommy Bahama Set Sail St. Barts Perfume by Ttknp shop is a lively combination of citrus and alcohol accords. Introduced in 2007, this fragrance is fresh and crisp, like a sea breeze', 719.99, 'assets/images/products/both/EN2VXdFW-Screenshot 2025-10-06 174538.png', 64, 3),
	(14, 'PERFUME-U002', 'Invitation', 'By Invitation Perfume by Michael Buble, By Ttknp shop is a women’s floral fruity fragrance with sweet, woody, vanilla, and powdery main accords. Created by perfumer Karine Dubreuil in 2016, this perfume leads with top notes of red fruits and bergamot', 649.99, 'assets/images/products/both/1013.jpg', 18, 3),
	(15, 'PERFUME-U003', 'Wild Musk', 'Wild Musk by Coty, a timeless fragrance for women released in 1972, unleashes sweet seductiveness with irresistible charm. Floral notes intertwine with sweet, earthy and woody accords to create a scent that is as unforgettable as the woman who wears it.', 499.99, 'assets/images/products/both/1014.jpg', 100, 3),
	(16, 'PERFUME-U004', 'Laila', 'Laila Perfume by Ttknp shop, Laila perfume is a fresh blend of fruity and floral scents launched in 1995. Inspired by Norway\'s refreshing natural beauty, this fragrance features a unique blend of herbs and watermelon essence, coupled with beautiful lavender and lily of the valley', 779.99, 'assets/images/products/both/1015.jpg', 82, 3),
	(17, 'PERFUME-U005', 'Il Bacio', 'Il Bacio Perfume by Ttknp shop, Il Bacio is a fruity and fresh fragrance for women released in 1993. The aromatic opening is composed of fresh white florals including jasmine, rose, honeysuckle, freesia and lily-of-the-valley. The heart contains sweet melon, passionfruit, plum and peach.', 399.99, 'assets/images/products/both/1016.jpg', 86, 3),
	(18, 'PERFUME-U006', 'Blue Grass', 'Blue Grass Perfume by Ttknp shop, Luxurious and flowery without being cloying, Blue Grass by Elizabeth Arden is an enduring vintage fragrance that has titillated noses for generations. ', 649.99, 'assets/images/products/both/1017.jpg', 73, 3),
	(19, 'PERFUME-U007', 'Amazing Moment', 'Amazing Moment Perfume by Ttknp shop is a floral fragrance for women that was developed in 2004 by the expert noses of Harry Fremont and Jacques Cavallier. This scent was designed to bring a youthful take on the popular Eternity perfume and has become a signature fragrance staple for women of all ages.', 699.99, 'assets/images/products/both/R9CvU8y9-1018.jpg', 100, 3),
	(20, 'PERFUME-U008', 'Tonka Cola Mancera', 'Tonka Cola by Mancera is a Oriental Spicy fragrance for women and men. This is a new fragrance. Tonka Cola was launched in 2022. The nose behind this fragrance is Pierre Montale. Top notes are Cinnamon, Cherry, Sicilian Lemon and Nutmeg; middle notes are Coca-Cola, Indonesian Patchouli Leaf and Orange Blossom; base notes are Tonka Bean, Vanilla, Benzoin and Labdanum.', 659.90, 'assets/images/products/both/XQ6UytBZ-1019.jpg', 100, 3),
	(21, 'PERFUME-U009', 'Cedrat Boise Mancera', 'Cedrat Boise by Mancera is a Citrus Aromatic fragrance for women and men. Cedrat Boise was launched in 2011. The nose behind this fragrance is Pierre Montale. Top notes are Sicilian Lemon, Bergamot, Black Currant and Spicy Notes; middle notes are Fruity Notes, Patchouli Leaf and Water Jasmine; base notes are Cedar, Leather, Sandalwood, Vanilla, White Musk and Moss.', 999.01, 'assets/images/products/both/iGgMRFwJ-IUOLKAD-1006.png', 99, 3),
	(22, 'PERFUME-F007', 'Ouds From Swiss Arabian', 'Unfortunately, I don\'t have samples of all of them, but you won\'t miss many: Shaghaf Oud, which is similar to Lancome\'s Oud Bouquet; Shaghaf Oud Abyad, similar to Amouage\'s Interlude Man; and Shaghaf Oud Aswad, which colleague Eddie described as Chanel\'s Egoiste with oud and baked apples.', 750.50, 'assets/images/products/female/49nsKF7S-TYOAKD-1105.png', 95, 2),
	(23, 'PERFUME-M007', 'Ouds From Swiss Arabian Extra', 'Shaghaf means \'all-consuming passion\' in Arabic, and each fragrance in the collection is designed to evoke strong emotions and reflect passionate feelings.', 650.50, 'assets/images/products/male/uWJ2Xdmh-AWSAX-1001.png', 99, 1),
	(24, 'PERFUME-M008', 'Alien Extraintense Mugler', 'Alien Extraintense by Mugler is a Oriental Floral fragrance for women. This is a new fragrance. Alien Extraintense was launched in 2025. The nose behind this fragrance is Dominique Ropion. Top note is Petitgrain; middle notes are Tuberose and Jasmine; base notes are Vanilla, Cashmeran and Amberwood.', 999.99, 'assets/images/products/male/35BXQxgr-WOASD-1002.png', 99, 1),
	(25, 'PERFUME-M009', 'Yum Yum Armaf', 'Yum Yum by Armaf is a Floral Fruity fragrance for women. This is a new fragrance. Yum Yum was launched in 2024. Top notes are Wild Berries, Cherry, Orange and Bergamot; middle notes are Vanilla, White Flowers and Rose; base notes are Powdery Notes, Musk and Amber.', 860.50, 'assets/images/products/male/g1MmTegS-WOSASD-1003.png', 64, 1),
	(27, 'PERFUME-F008', 'Rare Beauty', 'Warm and decadent with a touch of spice, this gourmand fragrance evolves with every passing moment, lingering for up to 12 hours. Caramel and pistachio give way to rich vanilla and spicy ginger, then dries down to earthy sandalwood. Pair with Rare Fragrance Layering Balms to customize your scent.', 750.50, 'assets/images/products/female/CKVDupiU-Screenshot 2025-10-06 173139.png', 95, 2);

CREATE TABLE IF NOT EXISTS `product_categories` (
  `pc_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `product_categories` (`pc_id`, `category_name`) VALUES
	(1, 'Male'),
	(2, 'Female'),
	(3, 'Unisex');

CREATE TABLE IF NOT EXISTS `provinces` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `provinces` (`pid`, `name`) VALUES
	(1, 'Bangkok'),
	(2, 'Nonthaburi'),
	(3, 'Samut Sakhon'),
	(4, 'Chonburi');

CREATE TABLE IF NOT EXISTS `users` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT 'ROLE_USER',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `password` (`password`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `users` (`uid`, `username`, `password`, `roles`) VALUES
	(1, 'thitikorn-n@rmutp.ac.th', '$2a$10$.jgIVzGinz9QZ115VyajQuICRnHGhO.yvOe9/HFM552XXvZyjxIfy', 'ROLE_USER'),
	(3, 'stone-cold@outlook.co.th', '$2a$10$ovQtyUvV03M5SyARvOQ.k.lWf018NcgITvByPsfVeYONBKrwJWQr.', 'ROLE_USER'),
	(4, 'admin@outlook.co.th', '$2a$12$Wbqu4yLAe3ct68Sny4M.Eum2GGe2Y8XrBKLwaypRm8HlD5J3sdbYS', 'ROLE_ADMIN'),
	(5, 'alex@outlook.co.th', '$2a$10$Q4W7.PxD9Mvvt1aCj8EPke5ySHHE7uMuvJMpw7x8AcNnKKYKh.SFy', 'ROLE_USER'),
	(6, 'dom@hotmail.com', '$2a$10$LFfHSIjJ4lzrBNLmfd1AXOv36kjkwoHxqzx3L3blilid3jcUSg5VG', 'ROLE_USER'),
	(7, 'nobody@hotmail.com', '$2a$10$9.BkOKVv8h1XUj/utxkmce4dVMZ5BPn.V90QtrN/H3irv4HZgDliu', 'ROLE_USER');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
