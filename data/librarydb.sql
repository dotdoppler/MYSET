/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50708
Source Host           : 127.0.0.1:3306
Source Database       : librarydb

Target Server Type    : MYSQL
Target Server Version : 50708
File Encoding         : 65001

Date: 2016-04-13 21:49:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `press` varchar(255) DEFAULT NULL,
  `dateOfPublication` date DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `cover` varchar(255) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '苏菲的世界', '乔斯坦·贾德 作家出版社', ' 作家出版社', '2007-10-01', '小说', 'SofiesVerden.jpg', '5', '1');
INSERT INTO `book` VALUES ('2', '没有色彩的多崎作和他的巡礼之年', '村上春树', '南海出版公司', '2013-10-01', '小说', 'dqz.jpg', '5', '1');

-- ----------------------------
-- Table structure for book_user
-- ----------------------------
DROP TABLE IF EXISTS `book_user`;
CREATE TABLE `book_user` (
  `book_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `recordDate` datetime DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_user
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `registTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'summer@me.com', 'summer', '123', null);
INSERT INTO `user` VALUES ('2', 'hello@gg.com', 'masako', '123', null);
INSERT INTO `user` VALUES ('6', 'dd@qq.com', 'masami', '333', null);
INSERT INTO `user` VALUES ('8', 'admin@qq.com', 'admin', '11', null);
INSERT INTO `user` VALUES ('9', 'hh@qq.com', '111', '11', '2016-03-29 09:30:04');
INSERT INTO `user` VALUES ('10', 'masami@nagasawa.net', 'é·æ¾¤ã¾ãã¿', '123', '2016-03-30 18:58:29');
INSERT INTO `user` VALUES ('11', 'masami@64.net', 'é¿æ³½éç¾', '123', '2016-03-30 19:11:18');
INSERT INTO `user` VALUES ('12', 'a1dmin@qq.com', 'é¿æ³½éç¾', '123', '2016-03-31 16:47:57');
INSERT INTO `user` VALUES ('13', '1@qqc.com', 'é¿æ³½éç¾', '111', '2016-03-31 16:49:32');
INSERT INTO `user` VALUES ('14', 'admin@55.COM', 'é¿æ³½éç¾é·æ¾¤ã¾ãã¿', '11', '2016-03-31 16:53:43');
INSERT INTO `user` VALUES ('15', 'admin@55.COM', 'é¿æ³½éç¾é·æ¾¤ã¾ãã¿', '11', '2016-03-31 16:54:29');
INSERT INTO `user` VALUES ('16', 'admin@qqq.com', 'é·æ¾¤ã¾ãã¿', '11', '2016-03-31 16:54:55');
INSERT INTO `user` VALUES ('17', 'admin@qq.com3', 'é¿æ³½éç¾', '11', '2016-03-31 17:07:37');
INSERT INTO `user` VALUES ('18', 'admin@qqqq.com', '长泽雅美', '11', '2016-03-31 17:13:41');
INSERT INTO `user` VALUES ('19', 'admin@ff.com', '長澤まさみ', '11', '2016-03-31 17:16:51');
INSERT INTO `user` VALUES ('20', 'admin@qq.com4', 'è¿æ ·çå', '11', '2016-03-31 19:17:07');
INSERT INTO `user` VALUES ('21', '4414@hh.com', 'dada', '11', '2016-03-31 19:36:00');
INSERT INTO `user` VALUES ('22', 'admin@qq.com6', 'é¿æ³½éç¾', '11', '2016-03-31 19:37:42');
INSERT INTO `user` VALUES ('23', '1masami@nagasawa.net', 'masako', '111', '2016-03-31 22:22:32');
INSERT INTO `user` VALUES ('24', 'admin@qq.com61', 'adada', '22', '2016-04-01 20:23:30');
