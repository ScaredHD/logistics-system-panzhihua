/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2022-07-09 17:25:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `company`
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) NOT NULL,
  `company_tel` varchar(255) NOT NULL,
  `company_contacts` varchar(255) NOT NULL,
  `company_isvisible` char(1) NOT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '郫县京东', '1415151419', '合作伙伴', '');
INSERT INTO `company` VALUES ('2', '江安京东', '1414124145', '合作伙伴', '');

-- ----------------------------
-- Table structure for `delivery`
-- ----------------------------
DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery` (
  `deliver_id` int(11) NOT NULL AUTO_INCREMENT,
  `d_driver_id` int(11) NOT NULL,
  `d_vehicle_id` int(11) NOT NULL,
  `d_order_id` int(11) NOT NULL,
  `deliver_time` datetime NOT NULL,
  `deliver_address` varchar(255) NOT NULL,
  `deliver_status` char(1) NOT NULL,
  `deliver_notice` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`deliver_id`),
  KEY `driver_id` (`d_driver_id`),
  KEY `vehicle_id` (`d_vehicle_id`),
  KEY `order_id` (`d_order_id`),
  CONSTRAINT `driver_id` FOREIGN KEY (`d_driver_id`) REFERENCES `driver` (`driver_id`) ON UPDATE CASCADE,
  CONSTRAINT `order_id` FOREIGN KEY (`d_order_id`) REFERENCES `order` (`order_id`) ON UPDATE CASCADE,
  CONSTRAINT `vehicle_id` FOREIGN KEY (`d_vehicle_id`) REFERENCES `vehicle` (`vehicle_id`) ON UPDATE CASCADE
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
  `driver_status` char(1) NOT NULL DEFAULT '',
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
  `employee_isvisible` char(1) NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of employee
-- ----------------------------

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) NOT NULL,
  `goods_desc` varchar(255) DEFAULT NULL,
  `goods_price` int(11) NOT NULL,
  `goods_isvisible` char(1) NOT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for `inventory`
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `inventory_id` int(11) NOT NULL AUTO_INCREMENT,
  `i_warehouse_id` int(11) NOT NULL,
  `i_goods_id` int(11) NOT NULL,
  `inventory_count` int(11) NOT NULL,
  PRIMARY KEY (`inventory_id`),
  KEY `in_warehouse_id` (`i_warehouse_id`) USING BTREE,
  KEY `in_goods_id` (`i_goods_id`) USING BTREE,
  CONSTRAINT `goods_id` FOREIGN KEY (`i_goods_id`) REFERENCES `goods` (`goods_id`) ON UPDATE CASCADE,
  CONSTRAINT `warehouse_id` FOREIGN KEY (`i_warehouse_id`) REFERENCES `warehouse` (`warehouse_id`) ON UPDATE CASCADE
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
  `ir_warehouse_id` int(11) NOT NULL,
  `ir_goods_id` int(11) NOT NULL,
  `record_created_at` datetime NOT NULL,
  `record_count` int(11) NOT NULL,
  `record_type` char(1) NOT NULL,
  `record_comments` varchar(255) DEFAULT '',
  PRIMARY KEY (`inventory_record_id`),
  KEY `warehouse_id` (`ir_warehouse_id`) USING BTREE,
  KEY `record_goods_id` (`ir_goods_id`),
  CONSTRAINT `record_goods_id` FOREIGN KEY (`ir_goods_id`) REFERENCES `inventory` (`i_goods_id`) ON UPDATE CASCADE,
  CONSTRAINT `record_warehouse_id` FOREIGN KEY (`ir_warehouse_id`) REFERENCES `inventory` (`i_warehouse_id`) ON UPDATE CASCADE
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
  `o_inventory_id` int(11) NOT NULL,
  `o_company_id` int(11) NOT NULL,
  `order_created_at` datetime NOT NULL,
  `order_desc` varchar(255) DEFAULT NULL,
  `order_num` int(11) NOT NULL,
  `order_status` char(1) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `inventory_id` (`o_inventory_id`),
  KEY `company_id` (`o_company_id`),
  CONSTRAINT `company_id` FOREIGN KEY (`o_company_id`) REFERENCES `company` (`company_id`) ON UPDATE CASCADE,
  CONSTRAINT `inventory_id` FOREIGN KEY (`o_inventory_id`) REFERENCES `inventory` (`inventory_id`) ON UPDATE CASCADE
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
  `user_email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `activation_code` varchar(255) NOT NULL,
  `state` char(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1123352498@qq.com', '123456', '010101', '0');
INSERT INTO `user` VALUES ('2', null, null, '020202', '0');
INSERT INTO `user` VALUES ('3', null, null, '030303', '0');

-- ----------------------------
-- Table structure for `vehicle`
-- ----------------------------
DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
  `vehicle_id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_license_number` varchar(255) NOT NULL,
  `vehicle_type` varchar(255) NOT NULL,
  `vehicle_status` char(1) NOT NULL,
  `vehicle_isvisible` char(1) NOT NULL,
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
