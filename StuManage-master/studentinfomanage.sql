/*
Navicat MySQL Data Transfer

Source Server         : mySQL
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : studentinfomanage

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-07-03 13:36:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseId` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `courseName` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `position` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `score` float(11,0) NOT NULL,
  `teacher` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('C0001', 'java', '鍔卞織402', '3', '璁告櫞濯�');
INSERT INTO `course` VALUES ('C0002', 'javaee', '鍔卞織410', '3', '浣曠敯涓�');
INSERT INTO `course` VALUES ('C0003', 'php', '鍔卞織403', '3', '涓ユ牸');

-- ----------------------------
-- Table structure for manage
-- ----------------------------
DROP TABLE IF EXISTS `manage`;
CREATE TABLE `manage` (
  `manageId` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `managePassword` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `manageName` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `manageAuthority` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`manageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of manage
-- ----------------------------
INSERT INTO `manage` VALUES ('1', '1', '1', '绠＄悊鍛�');
INSERT INTO `manage` VALUES ('2', '2', '2', '鏁欏笀');
INSERT INTO `manage` VALUES ('3', '3', '3', '鏁欏笀');
INSERT INTO `manage` VALUES ('5', '5', '5', '鏁欏笀');
INSERT INTO `manage` VALUES ('6', '666', '6', '鏁欏笀');
INSERT INTO `manage` VALUES ('7', '7', '7', '鏁欏笀');

-- ----------------------------
-- Table structure for selectcourse
-- ----------------------------
DROP TABLE IF EXISTS `selectcourse`;
CREATE TABLE `selectcourse` (
  `studentId` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `courseId` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `selectDate` date NOT NULL,
  PRIMARY KEY (`studentId`,`courseId`),
  KEY `courseId` (`courseId`),
  CONSTRAINT `courseId` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE,
  CONSTRAINT `studentId` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of selectcourse
-- ----------------------------
INSERT INTO `selectcourse` VALUES ('1', 'C0001', '2017-07-02');
INSERT INTO `selectcourse` VALUES ('1', 'C0002', '2017-07-02');
INSERT INTO `selectcourse` VALUES ('1408190203', 'C0001', '2017-07-03');
INSERT INTO `selectcourse` VALUES ('1408190203', 'C0002', '2017-07-03');
INSERT INTO `selectcourse` VALUES ('1408190203', 'C0003', '2017-07-03');
INSERT INTO `selectcourse` VALUES ('3', 'C0001', '2017-07-02');
INSERT INTO `selectcourse` VALUES ('3', 'C0002', '2017-07-02');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentId` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `studentName` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `phoneId` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1 ', '濂�', '2017-04-22', '17859901732', '123');
INSERT INTO `student` VALUES ('1408190203', '鐜嬩紒鑸�', '鐢�', '1996-10-04', '17859901691', '123');
INSERT INTO `student` VALUES ('1408190204', '闄堝槈鍔�', '鐢�', '1996-05-05', '17859901478', '123');
INSERT INTO `student` VALUES ('1408190205', '閭撴�濊繙', '鐢�', '1996-05-09', '17859901732', '123');
INSERT INTO `student` VALUES ('1408190206', '姊佽緣鑽�', '鐢�', '1996-05-23', '17859901612', '123456');
INSERT INTO `student` VALUES ('1408190241', '鍚撮敠鍏�', '鐢�', '1995-01-18', '17859901732', '123');
INSERT INTO `student` VALUES ('1408190248', '寰愭箻宄�', '濂�', '1997-02-18', '15159692682', '123');
INSERT INTO `student` VALUES ('2', '2', '鐢�', '2017-07-11', '12345678901', '123');
INSERT INTO `student` VALUES ('3', '1 ', '濂�', '1996-01-01', '17859901732', '123');
INSERT INTO `student` VALUES ('6', '6', '鐢�', '1994-07-13', '12345678901', '1123');
