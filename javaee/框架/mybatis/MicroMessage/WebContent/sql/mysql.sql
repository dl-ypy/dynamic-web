/*建表语句，通过Navicat for MySQL中转储sql文件导出的sql语句*/

/*micro_message(查询表)：

Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-03-08 09:27:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `micro_message`
-- ----------------------------
DROP TABLE IF EXISTS `micro_message`;
CREATE TABLE `micro_message` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COMMAND` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `CONTENT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of micro_message
-- ----------------------------
INSERT INTO `micro_message` VALUES ('1', '查看', '查看内容', '精彩内容...');
INSERT INTO `micro_message` VALUES ('2', 'gfgd', 'gdfhd', 'ggh');
INSERT INTO `micro_message` VALUES ('3', 'jkg', 'fg', 'sdf');




/*command(一对多主键表)
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-03-08 09:26:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `command`
-- ----------------------------
DROP TABLE IF EXISTS `command`;
CREATE TABLE `command` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of command
-- ----------------------------
INSERT INTO `command` VALUES ('1', '名字');
INSERT INTO `command` VALUES ('2', '查看');





/*command_content(一对多子表)
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-03-08 09:27:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `command_content`
-- ----------------------------
DROP TABLE IF EXISTS `command_content`;
CREATE TABLE `command_content` (
  `content_id` int(11) NOT NULL DEFAULT '0',
  `content` varchar(255) DEFAULT NULL,
  `command_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  KEY `command_id` (`command_id`),
  CONSTRAINT `command_id` FOREIGN KEY (`command_id`) REFERENCES `command` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of command_content
-- ----------------------------
INSERT INTO `command_content` VALUES ('1', 'mj', '1');
INSERT INTO `command_content` VALUES ('2', 'kb', '1');
INSERT INTO `command_content` VALUES ('3', 'dd', '1');
INSERT INTO `command_content` VALUES ('4', 'ypy', '1');
INSERT INTO `command_content` VALUES ('5', 'dddddd', '1');
INSERT INTO `command_content` VALUES ('6', 'aaaaa', '2');
INSERT INTO `command_content` VALUES ('7', 'dwafaaw', '2');

