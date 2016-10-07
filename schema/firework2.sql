/*
Navicat MySQL Data Transfer

Source Server         : local-guest
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : firework2

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2016-10-08 00:26:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for f_login_history
-- ----------------------------
DROP TABLE IF EXISTS `f_login_history`;
CREATE TABLE `f_login_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
  `user_id` varchar(32) NOT NULL COMMENT 'Login ID',
  `device_id` varchar(64) DEFAULT NULL COMMENT 'Device token',
  `platform` varchar(32) NOT NULL COMMENT 'Platform: 1 Portal 2 Android 3 iOS',
  `login_time` datetime NOT NULL COMMENT 'Login time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='Login History';

-- ----------------------------
-- Records of f_login_history
-- ----------------------------

-- ----------------------------
-- Table structure for f_module
-- ----------------------------
DROP TABLE IF EXISTS `f_module`;
CREATE TABLE `f_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
  `code` varchar(32) NOT NULL COMMENT 'Module Code',
  `name` varchar(64) NOT NULL COMMENT 'Module Name',
  `parent` bigint(20) DEFAULT NULL COMMENT 'Parent Module ID',
  `url` varchar(64) DEFAULT NULL COMMENT 'URL',
  `controller` varchar(128) DEFAULT NULL COMMENT 'Related AngularJS Controller',
  `template` varchar(256) DEFAULT NULL COMMENT 'Related AngularJS Temlate',
  `order_id` int(11) DEFAULT '1' COMMENT 'Sequence In current module depth',
  `valid` int(1) DEFAULT '1' COMMENT 'Valid: 1 Yes 0 No',
  `create_user` varchar(50) NOT NULL COMMENT 'Create by',
  `create_time` datetime NOT NULL COMMENT 'Create time',
  `update_user` varchar(50) DEFAULT NULL COMMENT 'Update by',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Last Update Time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='Module';

-- ----------------------------
-- Records of f_module
-- ----------------------------
INSERT INTO `f_module` VALUES ('1', 'order', 'Orders', null, '#', null, null, '1', '1', 'system', '2016-10-07 13:57:01', null, '2016-10-07 16:43:02');
INSERT INTO `f_module` VALUES ('2', 'statistics', 'Statistics', null, '#', null, null, '1', '1', 'system', '2016-10-07 13:57:01', null, '2016-10-07 16:43:03');
INSERT INTO `f_module` VALUES ('3', 'order-online', 'Online Orders', '1', '#', null, null, '1', '1', 'system', '2016-10-07 13:57:01', null, '2016-10-07 16:45:46');
INSERT INTO `f_module` VALUES ('4', 'order-offline', 'Offline Orders', '1', '#', null, null, '2', '0', 'system', '2016-10-07 13:57:01', null, '2016-10-07 16:46:51');
INSERT INTO `f_module` VALUES ('5', 'order-online-selfrun', 'Self-Run Online Orders', '3', '/order-online-selfrun', 'onlineSelfRunController', 'views/order/online-selfrun-order.html', '1', '1', 'system', '2016-10-07 13:57:01', null, '2016-10-07 18:51:34');
INSERT INTO `f_module` VALUES ('6', 'order-online-outsource', 'Outsourcing Online Orders', '3', '/order-online-outsource', 'onlineOutsourceController', 'views/order/online-outsource-order.html', '2', '1', 'system', '2016-10-07 13:57:01', null, '2016-10-07 18:51:38');
INSERT INTO `f_module` VALUES ('7', 'user-statistics', 'User', '2', '#', null, null, '1', '1', 'system', '2016-10-07 13:57:01', null, '2016-10-07 16:45:55');
INSERT INTO `f_module` VALUES ('8', 'user-statistics-new', 'New Users Statistics', '7', '/user-statistics-new', 'newUserController', 'views/statistics/new-user.html', '1', '1', 'system', '2016-10-07 13:57:01', null, '2016-10-07 18:51:27');
INSERT INTO `f_module` VALUES ('9', 'user-statistics-region', 'User Regions Statistics', '7', '/user-statistics-region', 'userRegionController', 'views/statistics/user-region.html', '2', '1', 'system', '2016-10-07 14:27:51', null, '2016-10-07 18:52:09');

-- ----------------------------
-- Table structure for f_role
-- ----------------------------
DROP TABLE IF EXISTS `f_role`;
CREATE TABLE `f_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
  `role_name` varchar(32) NOT NULL COMMENT 'Role Name',
  `valid` int(1) DEFAULT '1' COMMENT 'Valid User: 1 Yes 0 No',
  `create_user` varchar(50) NOT NULL COMMENT 'Create by',
  `create_time` datetime NOT NULL COMMENT 'Create time',
  `update_user` varchar(50) DEFAULT NULL COMMENT 'Update by',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Last Update Time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_role` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='Role';

-- ----------------------------
-- Records of f_role
-- ----------------------------
INSERT INTO `f_role` VALUES ('1', 'GUEST', '1', 'system', '2016-10-07 14:33:36', null, '2016-10-07 14:33:38');
INSERT INTO `f_role` VALUES ('2', 'USER', '1', 'system', '2016-10-07 14:34:10', null, '2016-10-07 14:34:13');
INSERT INTO `f_role` VALUES ('3', 'ADMIN', '1', 'system', '2016-10-07 14:35:01', null, '2016-10-07 14:35:03');

-- ----------------------------
-- Table structure for f_role_module
-- ----------------------------
DROP TABLE IF EXISTS `f_role_module`;
CREATE TABLE `f_role_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
  `role_name` varchar(32) NOT NULL COMMENT 'Role Name',
  `module_code` varchar(32) NOT NULL COMMENT 'Module Code',
  `valid` int(1) DEFAULT '1' COMMENT 'Valid User: 1 Yes 0 No',
  `create_user` varchar(50) NOT NULL COMMENT 'Create by',
  `create_time` datetime NOT NULL COMMENT 'Create time',
  `update_user` varchar(50) DEFAULT NULL COMMENT 'Update by',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Last Update Time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_role_module` (`role_name`,`module_code`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='Role Module Mapping';

-- ----------------------------
-- Records of f_role_module
-- ----------------------------
INSERT INTO `f_role_module` VALUES ('1', 'GUEST', 'order', '1', 'system', '2016-10-07 14:37:29', null, '2016-10-07 16:45:01');
INSERT INTO `f_role_module` VALUES ('2', 'GUEST', 'statistics', '1', 'system', '2016-10-07 14:37:29', null, '2016-10-07 16:45:02');
INSERT INTO `f_role_module` VALUES ('3', 'GUEST', 'order-online', '1', 'system', '2016-10-07 14:37:29', null, '2016-10-07 16:45:02');
INSERT INTO `f_role_module` VALUES ('4', 'GUEST', 'order-offline', '1', 'system', '2016-10-07 14:37:29', null, '2016-10-07 16:45:03');
INSERT INTO `f_role_module` VALUES ('5', 'GUEST', 'order-online-selfrun', '1', 'system', '2016-10-07 14:37:29', null, '2016-10-07 16:45:04');
INSERT INTO `f_role_module` VALUES ('6', 'GUEST', 'order-online-outsource', '1', 'system', '2016-10-07 14:37:29', null, '2016-10-07 16:45:05');
INSERT INTO `f_role_module` VALUES ('7', 'GUEST', 'user-statistics', '1', 'system', '2016-10-07 14:37:29', null, '2016-10-07 16:45:06');
INSERT INTO `f_role_module` VALUES ('8', 'GUEST', 'user-statistics-new', '1', 'system', '2016-10-07 14:37:29', null, '2016-10-07 16:45:07');
INSERT INTO `f_role_module` VALUES ('9', 'GUEST', 'user-statistics-region', '1', 'system', '2016-10-07 14:37:29', null, '2016-10-07 16:45:10');

-- ----------------------------
-- Table structure for f_user
-- ----------------------------
DROP TABLE IF EXISTS `f_user`;
CREATE TABLE `f_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
  `user_id` varchar(32) NOT NULL COMMENT 'Login ID',
  `user_pwd` varchar(64) NOT NULL COMMENT 'Password',
  `user_name` varchar(64) DEFAULT NULL COMMENT 'Password',
  `gender` int(1) DEFAULT NULL COMMENT 'Gender：1 Male 2 Female',
  `id_number` varchar(32) DEFAULT NULL COMMENT 'Identification Number',
  `mobile` varchar(32) DEFAULT NULL COMMENT 'Mobile Number',
  `email` varchar(64) DEFAULT NULL COMMENT 'Email',
  `zip` varchar(32) DEFAULT NULL COMMENT 'Zip Code',
  `address` varchar(256) DEFAULT NULL COMMENT 'Address',
  `valid` int(1) DEFAULT '1' COMMENT 'Valid User: 1 Yes 0 No',
  `create_user` varchar(50) NOT NULL COMMENT 'Create by',
  `create_time` datetime NOT NULL COMMENT 'Create time',
  `update_user` varchar(50) DEFAULT NULL COMMENT 'Update by',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Last Update Time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_userid` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='User';

-- ----------------------------
-- Records of f_user
-- ----------------------------
INSERT INTO `f_user` VALUES ('1', 'demo', 'fe01ce2a7fbac8fafaed7c982a04e229', 'demo', '1', '310000198511050000', '13111111111', 'demo@gmail.com', '210000', 'Nanjing, Jiangsu Province, China', '1', 'system', '2016-10-05 20:49:23', null, '2016-10-05 20:49:23');

-- ----------------------------
-- Table structure for f_user_role
-- ----------------------------
DROP TABLE IF EXISTS `f_user_role`;
CREATE TABLE `f_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
  `user_id` varchar(32) NOT NULL COMMENT 'Login ID',
  `role_name` varchar(32) NOT NULL COMMENT 'Role Name',
  `valid` int(1) DEFAULT '1' COMMENT 'Valid User: 1 Yes 0 No',
  `create_user` varchar(50) NOT NULL COMMENT 'Create by',
  `create_time` datetime NOT NULL COMMENT 'Create time',
  `update_user` varchar(50) DEFAULT NULL COMMENT 'Update by',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Last Update Time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_user_role` (`user_id`,`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='User Role Mapping';

-- ----------------------------
-- Records of f_user_role
-- ----------------------------
INSERT INTO `f_user_role` VALUES ('1', 'demo', 'GUEST', '1', 'system', '2016-10-07 14:47:16', null, '2016-10-07 14:47:19');
