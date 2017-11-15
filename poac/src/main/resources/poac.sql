/*
 Navicat MySQL Data Transfer

 Source Server         : training
 Source Server Version : 50626
 Source Host           : localhost
 Source Database       : poac

 Target Server Version : 50626
 File Encoding         : utf-8

 Date: 11/15/2017 17:16:20 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `cctcraw`
-- ----------------------------
DROP TABLE IF EXISTS `cctcraw`;
CREATE TABLE `cctcraw` (
  `metadataid` int(2) NOT NULL AUTO_INCREMENT,
  `t1no` varchar(20) DEFAULT NULL,
  `recvbegtime` varchar(20) DEFAULT NULL,
  `filebegtime` varchar(20) DEFAULT NULL,
  `filegeneratedtime` varchar(20) DEFAULT NULL,
  `mb` varchar(5) DEFAULT NULL,
  `seq` int(10) DEFAULT NULL,
  `ext` varchar(10) DEFAULT NULL,
  `st` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`metadataid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `cctcraw`
-- ----------------------------
BEGIN;
INSERT INTO `cctcraw` VALUES ('1', null, null, null, null, null, '0', null, null), ('2', null, null, null, null, null, '0', null, null), ('3', null, null, null, null, null, '0', null, null), ('4', null, null, null, null, null, '0', null, null), ('5', null, null, null, null, null, '0', null, null), ('6', 'TL1A1', '20151323234334', '20151323234334', '20151323234334', 'm', '1', 'raw', 'TS'), ('7', 'TL1A1', '20151323234334', '20151323234334', '20151323234334', 'm', '2', 'raw', 'TS'), ('8', 'TL1A1', '20151323234334', '20151323234334', '20151323234334', 'm', '2', 'raw', 'TS'), ('9', 'TL1A1', '20151323234334', '20151323234334', '20151323234334', 'm', '3', 'raw', 'TS'), ('10', 'TL1A1', '20151323234334', '20151323234334', '20151323234334', 'm', '43', 'raw', 'TS');
COMMIT;

-- ----------------------------
--  Table structure for `plan`
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestart` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `timestop` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `plan`
-- ----------------------------
BEGIN;
INSERT INTO `plan` VALUES ('1', 'plandata1', '20140702101010', '20170702101010'), ('2', 'plandata2', '20150702101010', '20160702101010');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
