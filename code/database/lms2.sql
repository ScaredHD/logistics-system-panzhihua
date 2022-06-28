/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : lms2

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2022-06-28 10:54:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `commodity`
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `commodity_id` int(11) NOT NULL,
  `commodity_name` varchar(255) NOT NULL,
  `commodity_desc` varchar(255) DEFAULT NULL,
  `commodity_price` int(11) NOT NULL,
  PRIMARY KEY (`commodity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of commodity
-- ----------------------------

-- ----------------------------
-- Table structure for `company`
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) NOT NULL,
  `company_tel` varchar(255) NOT NULL,
  `company_contacts` varchar(255) NOT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of company
-- ----------------------------

-- ----------------------------
-- Table structure for `delivery`
-- ----------------------------
DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery` (
  `deliver_id` int(11) NOT NULL AUTO_INCREMENT,
  `driver_id` int(11) NOT NULL,
  `vehicle_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `deliver_time` datetime NOT NULL,
  `deliver_address` varchar(255) NOT NULL,
  `deliver_status` int(11) NOT NULL,
  `deliver_notice` varchar(255) NOT NULL,
  PRIMARY KEY (`deliver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of delivery
-- ----------------------------

-- ----------------------------
-- Table structure for `driver`
-- ----------------------------
DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver` (
  `driver_id` int(11) NOT NULL AUTO_INCREMENT,
  `driver_name` varchar(255) NOT NULL,
  `driver_gender` varchar(255) NOT NULL,
  `driver_tel` varchar(255) NOT NULL,
  `driver_license` varchar(255) NOT NULL,
  `driver_id_card` varchar(255) NOT NULL,
  `driver_license_score` int(11) NOT NULL,
  `driver_address` varchar(255) NOT NULL,
  PRIMARY KEY (`driver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of driver
-- ----------------------------

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(255) NOT NULL,
  `employee_gender` varchar(255) NOT NULL,
  `employee_id_card` varchar(255) NOT NULL,
  `employee_tel` varchar(255) NOT NULL,
  `employee_address` varchar(255) NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of employee
-- ----------------------------

-- ----------------------------
-- Table structure for `inventory`
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `inventory_id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse_id` int(11) NOT NULL,
  `commodity_id` int(11) NOT NULL,
  `inventory_count` int(11) NOT NULL,
  PRIMARY KEY (`inventory_id`),
  KEY `in_warehouse_id` (`warehouse_id`) USING BTREE,
  KEY `in_commodity_id` (`commodity_id`) USING BTREE,
  CONSTRAINT `commodity_id` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`commodity_id`) ON UPDATE CASCADE,
  CONSTRAINT `warehouse_id` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`warehouse_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of inventory
-- ----------------------------

-- ----------------------------
-- Table structure for `inventory_record`
-- ----------------------------
DROP TABLE IF EXISTS `inventory_record`;
CREATE TABLE `inventory_record` (
  `inventory_record_id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse_id` int(11) NOT NULL,
  `commodity_id` int(11) NOT NULL,
  `record_created_at` datetime NOT NULL,
  `record_count` int(11) NOT NULL,
  `record_type` int(11) NOT NULL,
  `record_comments` varchar(255) DEFAULT '',
  PRIMARY KEY (`inventory_record_id`),
  KEY `warehouse_id` (`warehouse_id`) USING BTREE,
  KEY `record_commodity_id` (`commodity_id`),
  CONSTRAINT `record_commodity_id` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`commodity_id`) ON UPDATE CASCADE,
  CONSTRAINT `record_warehouse_id` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`warehouse_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of inventory_record
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `inventory_id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `order_created_at` datetime NOT NULL,
  `order_desc` varchar(255) DEFAULT NULL,
  `order_num` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `inventory_id` (`inventory_id`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `company_id` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON UPDATE CASCADE,
  CONSTRAINT `inventory_id` FOREIGN KEY (`inventory_id`) REFERENCES `inventory` (`inventory_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `vehicle`
-- ----------------------------
DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
  `vehicle_id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_license_number` varchar(255) NOT NULL,
  `vehicle_type` varchar(255) NOT NULL,
  PRIMARY KEY (`vehicle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of vehicle
-- ----------------------------

-- ----------------------------
-- Table structure for `warehouse`
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `warehouse_id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse_name` varchar(255) NOT NULL,
  `warehouse_manager_id` int(11) NOT NULL,
  PRIMARY KEY (`warehouse_id`),
  KEY `warehouse_manager_id` (`warehouse_manager_id`),
  CONSTRAINT `warehouse_manager_id` FOREIGN KEY (`warehouse_manager_id`) REFERENCES `employee` (`employee_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
