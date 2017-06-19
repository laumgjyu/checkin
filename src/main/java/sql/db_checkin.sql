/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : db_checkin

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-19 23:31:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id`            int(11)     NOT NULL AUTO_INCREMENT,
  `adminname`     varchar(20) NOT NULL,
  `adminpassword` LONGTEXT    NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'admin', '0bfPC68vdB69vK516zf/Ig==');

-- ----------------------------
-- Table structure for t_checkdate
-- ----------------------------
DROP TABLE IF EXISTS `t_checkdate`;
CREATE TABLE `t_checkdate` (
  `id`        INT(255) NOT NULL AUTO_INCREMENT,
  `u_id`      INT(255) NOT NULL,
  `checkDate` DATE              DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `f_user_checkDate` (`u_id`),
  CONSTRAINT `f_user_checkDate` FOREIGN KEY (`u_id`) REFERENCES `t_user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 19
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of t_checkdate
-- ----------------------------
INSERT INTO `t_checkdate` VALUES ('18', '42', NULL);

-- ----------------------------
-- Table structure for t_file
-- ----------------------------
DROP TABLE IF EXISTS `t_file`;
CREATE TABLE `t_file` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `fileName` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of t_file
-- ----------------------------
INSERT INTO `t_file` VALUES ('1', '1111', 'web/WEB-INF/upload/userFile/bookmarks_17_4_252.html');
INSERT INTO `t_file` VALUES ('2', 'bookmarks_17_4_25.html', 'web/WEB-INF/upload/userFile/bookmarks_17_4_25.html');
INSERT INTO `t_file` VALUES ('3', 'bookmarks_17_4_251.html', 'web/WEB-INF/upload/userFile/bookmarks_17_4_251.html');
INSERT INTO `t_file` VALUES ('5', 'ThunderMini_dl1.5.3.2881.exe', 'web/upload/userFile/ThunderMini_dl1.5.3.2881.exe');
INSERT INTO `t_file` VALUES ('6', 'ThunderMini_dl1.5.3.2882.exe', 'web/upload/userFile/ThunderMini_dl1.5.3.2882.exe');

-- ----------------------------
-- Table structure for t_note
-- ----------------------------
DROP TABLE IF EXISTS `t_note`;
CREATE TABLE `t_note` (
  `id`      INT(11) NOT NULL AUTO_INCREMENT,
  `u_id`    INT(11)          DEFAULT NULL,
  `theme`   VARCHAR(255)     DEFAULT NULL,
  `content` LONGTEXT,
  PRIMARY KEY (`id`),
  KEY `f_noteToUser` (`u_id`),
  CONSTRAINT `f_noteToUser` FOREIGN KEY (`u_id`) REFERENCES `t_user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of t_note
-- ----------------------------

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `notice` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES ('2', '111asdasd');
INSERT INTO `t_notice` VALUES ('3', 'asd');
INSERT INTO `t_notice` VALUES ('4', 'asd');
INSERT INTO `t_notice` VALUES ('5', 'ddsdsd');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id`       int(11)      NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 43
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('42', '123456', 'AL5riQzgwmMhXZX+5MtU0A==');

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
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 43
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of t_userdetail
-- ----------------------------
INSERT INTO `t_userdetail`
VALUES ('42', '/upload/IMG_01391.JPG', '123456', '男', '12356', '23465', '13456', '13246', '2016', '12346', '2', '42');
