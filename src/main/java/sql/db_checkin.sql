/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : db_checkin

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-12 22:52:08
*/

DROP DATABASE IF EXISTS db_checkin;

USE db_checkin;


SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminname` varchar(20) NOT NULL,
  `adminpassword` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for t_file
-- ----------------------------
DROP TABLE IF EXISTS `t_file`;
CREATE TABLE `t_file` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `fileName` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_file
-- ----------------------------
INSERT INTO `t_file` VALUES ('1', '1111', 'web/WEB-INF/upload/userFile/bookmarks_17_4_252.html');
INSERT INTO `t_file` VALUES ('2', 'bookmarks_17_4_25.html', 'web/WEB-INF/upload/userFile/bookmarks_17_4_25.html');
INSERT INTO `t_file` VALUES ('3', 'bookmarks_17_4_251.html', 'web/WEB-INF/upload/userFile/bookmarks_17_4_251.html');
INSERT INTO `t_file` VALUES ('5', 'ThunderMini_dl1.5.3.2881.exe', 'web/upload/userFile/ThunderMini_dl1.5.3.2881.exe');
INSERT INTO `t_file` VALUES ('6', 'ThunderMini_dl1.5.3.2882.exe', 'web/upload/userFile/ThunderMini_dl1.5.3.2882.exe');

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `notice` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES ('2', '111asdasd');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('18', 'wqqw', '123');
INSERT INTO `t_user` VALUES ('19', '312', '312');
INSERT INTO `t_user` VALUES ('20', '333', '333');
INSERT INTO `t_user` VALUES ('21', '666', '66');
INSERT INTO `t_user` VALUES ('22', '66655', '6');
INSERT INTO `t_user` VALUES ('23', 'ww', 'ww');
INSERT INTO `t_user` VALUES ('24', '2223', '3');
INSERT INTO `t_user` VALUES ('25', 's', 's');
INSERT INTO `t_user` VALUES ('26', '22222221', 'e');
INSERT INTO `t_user` VALUES ('27', '2222222122', '222');
INSERT INTO `t_user` VALUES ('28', '2222222122p', 'p');
INSERT INTO `t_user` VALUES ('29', '2222222122p2', '2');
INSERT INTO `t_user` VALUES ('30', '2131', '1');
INSERT INTO `t_user` VALUES ('31', 'sad', 'sa');

-- ----------------------------
-- Table structure for t_userdetail
-- ----------------------------
DROP TABLE IF EXISTS `t_userdetail`;
CREATE TABLE `t_userdetail` (
  `d_id` int(11) NOT NULL AUTO_INCREMENT,
  `head` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `tel` int(20) DEFAULT NULL,
  `QQ` int(20) DEFAULT NULL,
  `weixin` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `grade` int(10) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `lang` varchar(255) DEFAULT NULL,
  `u_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`d_id`),
  KEY `f_detailToUser` (`u_id`),
  CONSTRAINT `f_detailToUser` FOREIGN KEY (`u_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_userdetail
-- ----------------------------
INSERT INTO `t_userdetail` VALUES ('19', null, '123', '男', '123', '123', '123', '123', '2016', '123', '123', '18');
INSERT INTO `t_userdetail` VALUES ('20', null, '123', '男', '123', '123', '123123', '123', '2016', '123', '123', '19');
INSERT INTO `t_userdetail` VALUES ('21', null, '333', '2016', '3333', '33', '33', '33', '2016', '33333', '3', '20');
INSERT INTO `t_userdetail` VALUES ('22', null, '66', '2016', '66', '66', '6', '66', '2016', '6', '6', '21');
INSERT INTO `t_userdetail` VALUES ('23', null, '66', '2016', '66', '66', '6', '66', '2016', '6', '6', '22');
INSERT INTO `t_userdetail` VALUES ('24', null, '1', '2016', '123', '123', '123', '1', '2016', '1', '1', '23');
INSERT INTO `t_userdetail` VALUES ('25', null, '3', '男', '3', '3', '313', '3', '2016', '3', '3', '24');
INSERT INTO `t_userdetail` VALUES ('26', null, 's', '男', '4', '4', '4', '4', '2016', '4', '4', '25');
INSERT INTO `t_userdetail` VALUES ('27', null, 'e', '男', '33', '3', '313', '3', '2016', '3', '3', '26');
INSERT INTO `t_userdetail` VALUES ('28', null, 'e', '男', '33', '3', '313', '3', '2016', '3', '3', '27');
INSERT INTO `t_userdetail` VALUES ('29', null, 'e', '男', '33', '3', '313', '3', '2016', '3', '3', '28');
INSERT INTO `t_userdetail` VALUES ('30', 'E:\\workPlace\\JavaWorkPlace\\javaWebWorkPlace\\CheckIn\\web\\upload/IMG_01395.JPG', 'e', '男', '33', '3', '313', '3', '2016', '3', '3', '29');
INSERT INTO `t_userdetail` VALUES ('31', 'IMG_0221.JPG', '1', '男', '1', '123', '1', '1', '2016', '1', '123', '30');
INSERT INTO `t_userdetail` VALUES ('32', '/upload/IMG_0272.JPG', '2', '男', '2', '23', '213', '2', '2016', '2', '2', '31');
