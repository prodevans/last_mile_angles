CREATE DATABASE  IF NOT EXISTS `lastmileangles` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `lastmileangles`;


DROP TABLE IF EXISTS `order_details`;
CREATE TABLE `order_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(75) DEFAULT NULL,
  `area` varchar(75) DEFAULT NULL,
  `pincode` varchar(25) DEFAULT NULL,
  `mobile_no` varchar(10) DEFAULT NULL,
  `email_id` varchar(100) DEFAULT NULL,
  `opted` varchar(75) DEFAULT NULL,
  `duration_of_contract` varchar(25) DEFAULT NULL,
  `type_of_contract` varchar(50) DEFAULT NULL,
  `appliance_make` varchar(75) DEFAULT NULL,
  `serial_no` varchar(100) DEFAULT NULL,
  `invoice_no` varchar(100) DEFAULT NULL,
  `invoice_date` varchar(20) DEFAULT NULL,
  `payment_processed` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


