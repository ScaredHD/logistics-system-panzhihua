/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : lms2

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2022-07-09 09:11:42
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
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '郫县京东', '1415151419', '王经理');
INSERT INTO `company` VALUES ('2', '江安京东', '1414124145', '张先生');
INSERT INTO `company` VALUES ('4', '洲济企业有限公司', '15680801111', '李经理');
INSERT INTO `company` VALUES ('5', '华为', '15555555', '浮点数');
INSERT INTO `company` VALUES ('6', 'test2', 'test2', 'test2');
INSERT INTO `company` VALUES ('10', 'test3', 'test3', 'test3');

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
  CONSTRAINT `order_id` FOREIGN KEY (`d_order_id`) REFERENCES `orders` (`order_id`) ON UPDATE CASCADE,
  CONSTRAINT `vehicle_id` FOREIGN KEY (`d_vehicle_id`) REFERENCES `vehicle` (`vehicle_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of delivery
-- ----------------------------
INSERT INTO `delivery` VALUES ('1', '1', '2', '1', '2022-07-08 16:27:24', 'Sichuan', '1', null);
INSERT INTO `delivery` VALUES ('2', '1', '2', '1', '2022-07-08 16:28:05', 'Sichuan', '0', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of driver
-- ----------------------------
INSERT INTO `driver` VALUES ('1', '张师傅', '男', '2432423423432', '川A-12345', '343242342323434', '12', '四川省成都市双流区', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '张经理', '男', '0001', '4241231323', '北京市南二环');
INSERT INTO `employee` VALUES ('2', '李经理', '男', '0002', '42423423432323', '南京市南二环');
INSERT INTO `employee` VALUES ('3', 'test', '男性', 'test', 'test', 'test');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) NOT NULL,
  `goods_desc` varchar(255) DEFAULT NULL,
  `goods_price` int(11) NOT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('2', '电动牙刷', '牙刷描述', '10');
INSERT INTO `goods` VALUES ('3', 'ipad', 'Apple Ipad', '3999');
INSERT INTO `goods` VALUES ('5', '西瓜', '', '11');
INSERT INTO `goods` VALUES ('9', 'iphone', 'Apple', '3999');
INSERT INTO `goods` VALUES ('10', 'iphone2', 'Apple2描述信息', '9000');

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
  CONSTRAINT `record_goods_id` FOREIGN KEY (`ir_goods_id`) REFERENCES `goods` (`goods_id`) ON UPDATE CASCADE,
  CONSTRAINT `record_warehouse_id` FOREIGN KEY (`ir_warehouse_id`) REFERENCES `warehouse` (`warehouse_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of inventory_record
-- ----------------------------
INSERT INTO `inventory_record` VALUES ('1', '1', '2', '2022-07-07 14:38:25', '100', '0', '无');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `o_goods_id` int(11) NOT NULL,
  `o_company_id` int(11) NOT NULL,
  `order_created_at` datetime NOT NULL,
  `order_desc` varchar(255) DEFAULT NULL,
  `order_num` int(11) NOT NULL,
  `order_status` char(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`),
  KEY `company_id` (`o_company_id`),
  KEY `o_goods_id` (`o_goods_id`) USING BTREE,
  CONSTRAINT `company_id` FOREIGN KEY (`o_company_id`) REFERENCES `company` (`company_id`) ON UPDATE CASCADE,
  CONSTRAINT `o_goods_id` FOREIGN KEY (`o_goods_id`) REFERENCES `goods` (`goods_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '3', '1', '2022-07-08 10:02:01', '无', '100', '1');
INSERT INTO `orders` VALUES ('6', '2', '2', '2022-07-08 13:50:47', 'w', '50', '0');
INSERT INTO `orders` VALUES ('7', '5', '2', '2022-07-08 13:51:21', '无', '50', '0');
INSERT INTO `orders` VALUES ('8', '3', '1', '2022-07-08 13:56:05', '我', '100', '0');
INSERT INTO `orders` VALUES ('9', '10', '2', '2022-07-08 13:56:58', '额温枪二', '50', '0');
INSERT INTO `orders` VALUES ('10', '10', '2', '2022-07-08 13:57:04', '额温枪二', '50', '0');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `activation_code` varchar(255) NOT NULL,
  `state` char(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'demo_test', '70B8F44768B0A70D', '010101', '0');
INSERT INTO `user` VALUES ('2', 'demo2@qq.com', '6C298700D0102AB9', '020202', '0');
INSERT INTO `user` VALUES ('3', 'demo@qq.com', '70B8F44768B0A70D', '030303', '0');

-- ----------------------------
-- Table structure for `vehicle`
-- ----------------------------
DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
  `vehicle_id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_license_number` varchar(255) NOT NULL,
  `vehicle_type` varchar(255) NOT NULL,
  `vehicle_status` char(1) NOT NULL,
  PRIMARY KEY (`vehicle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of vehicle
-- ----------------------------
INSERT INTO `vehicle` VALUES ('1', '京A-00001', '货车', '0');
INSERT INTO `vehicle` VALUES ('2', '京A-00002', '小型汽车', '1');
INSERT INTO `vehicle` VALUES ('3', '京A-00003', '卡车', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES ('1', 'test1', '1');
INSERT INTO `warehouse` VALUES ('3', 'test1', '1');
INSERT INTO `warehouse` VALUES ('4', 'test2', '2');
INSERT INTO `warehouse` VALUES ('5', 'testtest', '3');
