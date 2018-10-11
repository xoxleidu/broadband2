/*
Navicat MySQL Data Transfer

Source Server         : 服务器
Source Server Version : 50559
Source Host           : 192.168.88.254:3306
Source Database       : 1

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-10-10 08:45:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `community`
-- ----------------------------
DROP TABLE IF EXISTS `community`;
CREATE TABLE `community` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `community_name` varchar(20) NOT NULL COMMENT '小区名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='区域表(小区)';

-- ----------------------------
-- Records of community
-- ----------------------------
INSERT INTO `community` VALUES ('1', '中国牛逼');
INSERT INTO `community` VALUES ('3', '30');
INSERT INTO `community` VALUES ('4', 'hhhhhhhhh');
INSERT INTO `community` VALUES ('5', 'hhhhhhhhhffhhhhh');
INSERT INTO `community` VALUES ('6', 'hhhhhhhhhff');
INSERT INTO `community` VALUES ('7', 'hhhhhhhhhffggggg');
INSERT INTO `community` VALUES ('8', 'hhhhhhhhhffggggggggg');

-- ----------------------------
-- Table structure for `customer_message`
-- ----------------------------
DROP TABLE IF EXISTS `customer_message`;
CREATE TABLE `customer_message` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `customer_name` varchar(16) NOT NULL COMMENT '客户名称',
  `sex` tinyint(1) unsigned NOT NULL COMMENT '客户性别(0.男,1.女)',
  `idcard` varchar(18) NOT NULL COMMENT '证件号码',
  `tel` varchar(13) DEFAULT NULL COMMENT '家庭电话',
  `mobile` varchar(13) NOT NULL COMMENT '手机号码',
  `address` varchar(50) NOT NULL COMMENT '证件地址',
  `contacts` varchar(10) NOT NULL COMMENT '联系人',
  `contact_mobile` varchar(12) NOT NULL COMMENT '联系人电话',
  `type` tinyint(1) NOT NULL COMMENT '客户类型(0=客户，1=企业)',
  `creation_time` int(10) unsigned NOT NULL COMMENT '创建时间',
  `status` tinyint(1) unsigned NOT NULL COMMENT '状态(0.正常/激活,1.删除/未激活)',
  `sys_user_id` int(20) unsigned DEFAULT NULL COMMENT '操作者',
  PRIMARY KEY (`id`),
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='用户表(宋德和国文龙)';

-- ----------------------------
-- Records of customer_message
-- ----------------------------
INSERT INTO `customer_message` VALUES ('1', '000', '0', '130724199910343161', '加拿大', '18610588369', '老家的', '20', '18610588369', '0', '20180914', '1', '0');
INSERT INTO `customer_message` VALUES ('2', 's1021885', '0', '1356262656561326', '加拿大1', '1596568661', '陈家屯', '陈某某', '15811654235', '0', '20180903', '1', '0');
INSERT INTO `customer_message` VALUES ('3', 's10218854', '0', '13565626265', '加拿大2', '1593265654123', '陈家营', '陈某某', '15811326542', '0', '20180902', '1', '0');
INSERT INTO `customer_message` VALUES ('4', 'string', '0', 'string', 'string', '15932334125', 'string', 'string', 'string', '0', '20180925', '0', '0');
INSERT INTO `customer_message` VALUES ('5', 'string', '0', 'string', 'string', '15923265421', 'string', 'string', 'string', '0', '20180925', '0', '0');
INSERT INTO `customer_message` VALUES ('6', 'string', '0', 'string', 'string', '15932336245', 'string', 'string', 'string', '0', '20180925', '0', '0');
INSERT INTO `customer_message` VALUES ('7', 'string', '0', 'string', 'string', '15932362154', 'string', 'string', 'string', '0', '1537841942', '0', '0');
INSERT INTO `customer_message` VALUES ('8', 'string', '0', 'string', 'string', '15932336245', 'string', 'string', 'string', '0', '1537867318', '0', null);
INSERT INTO `customer_message` VALUES ('9', 'string', '5', '130724199110043211', 'string', '15932336245', 'string', 'string', 'string', '0', '1537923622', '0', null);
INSERT INTO `customer_message` VALUES ('10', 'string', '0', '130724199410042611', 'string', '15932336265', 'string', 'string', 'string', '0', '1537924294', '1', null);
INSERT INTO `customer_message` VALUES ('11', 'string', '0', '130724199610043211', 'string', '15811471092', 'string', 'string', '15811471092', '0', '1538277821', '0', null);
INSERT INTO `customer_message` VALUES ('12', '送的不不', '1', '370921200002100613', '18610588369', '18610588369', '嘎嘎嘎嘎嘎过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过', '送的不不不不不不v', '18610589369', '0', '1538965933', '1', null);
INSERT INTO `customer_message` VALUES ('13', '送的不不', '1', '370921200002100613', '18610588369', '18610588369', '嘎嘎嘎嘎嘎过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过', '送的不不不不不不v', '18610589369', '0', '1538967173', '0', null);
INSERT INTO `customer_message` VALUES ('14', 'string', '0', '130724199110043421', 'string', '15932336258', '15932336258', 'string', 'string', '0', '1538975913', '0', null);
INSERT INTO `customer_message` VALUES ('15', 'string', '0', '13072419911004342x', 'string', '15932336258', '15932336258', 'string', 'string', '0', '1538975989', '0', null);
INSERT INTO `customer_message` VALUES ('16', 'string', '0', '130724199110043421', 'string', '15932332228', '15932332228', 'string', '15932336213', '0', '1538976274', '0', null);

-- ----------------------------
-- Table structure for `equipment`
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '设备表id',
  `name` varchar(10) DEFAULT NULL COMMENT '设备名称',
  `model_id` int(11) unsigned NOT NULL COMMENT '型号表id',
  `equipment_id` varchar(10) DEFAULT NULL COMMENT '设备ID',
  `price` decimal(10,2) unsigned DEFAULT NULL COMMENT '设备价格',
  `add_time` int(10) unsigned DEFAULT '0' COMMENT '入库时间',
  `out_time` int(10) unsigned DEFAULT '0' COMMENT '出库时间',
  `status` char(1) DEFAULT '0' COMMENT '设备状态；0可用，1待出库，2已出库',
  PRIMARY KEY (`id`),
  UNIQUE KEY `equ_id` (`id`) USING BTREE COMMENT '设备主键索引',
  KEY `name` (`name`),
  KEY `model` (`model_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='设备管理表。包括设备名称、型号id、设备ID，价格、入库时间、出库时间、状态；\r\n\r\n  ';

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('1', 'string', '0', 'string', '0.00', '1539046819', '1539047157', '3');
INSERT INTO `equipment` VALUES ('2', 'nnn', '1', '1', '20.00', '1539046849', '0', '1');
INSERT INTO `equipment` VALUES ('3', 'nnn', '1', '1', '20.00', '1539046849', '0', '1');
INSERT INTO `equipment` VALUES ('4', 'string', '0', 'string', '0.00', '1539046854', '0', '4');
INSERT INTO `equipment` VALUES ('5', 'nnn', '1', '1', '20.00', '1539064270', '0', '1');
INSERT INTO `equipment` VALUES ('6', 'nnn', '8', '1', '20.00', '1539064295', '0', '1');

-- ----------------------------
-- Table structure for `equipment_model`
-- ----------------------------
DROP TABLE IF EXISTS `equipment_model`;
CREATE TABLE `equipment_model` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '设备型号id',
  `model` varchar(10) DEFAULT NULL COMMENT '设备型号',
  `status` char(1) DEFAULT '0' COMMENT '设备型号状态 “0”可用   “1”不可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `model` (`model`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='设备型号管理表';

-- ----------------------------
-- Records of equipment_model
-- ----------------------------
INSERT INTO `equipment_model` VALUES ('0', 'string', '2');
INSERT INTO `equipment_model` VALUES ('14', '8', '2');

-- ----------------------------
-- Table structure for `expenses`
-- ----------------------------
DROP TABLE IF EXISTS `expenses`;
CREATE TABLE `expenses` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '资费id',
  `name` varchar(20) DEFAULT NULL COMMENT '资费名称',
  `type` char(1) DEFAULT NULL COMMENT '资费类型',
  `ip_id` int(11) unsigned DEFAULT NULL COMMENT 'IP类型id',
  `bandwidth_id` int(11) unsigned DEFAULT NULL COMMENT '带宽限制id',
  `price` decimal(10,2) unsigned DEFAULT NULL COMMENT '资费价格',
  `cycle` smallint(11) unsigned DEFAULT NULL COMMENT '资费周期',
  `cycle_type` char(1) DEFAULT NULL COMMENT '资费周期单位',
  `status` char(1) DEFAULT '0' COMMENT '资费状态 “0” 可用  ，“1“不可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `资费表id` (`id`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='资费类型表   --王向晨';

-- ----------------------------
-- Records of expenses
-- ----------------------------
INSERT INTO `expenses` VALUES ('1', 'dddddddddddddd', '1', '0', '0', '0.00', '0', '1', '0');
INSERT INTO `expenses` VALUES ('2', 'aaaa', '2', '20', '1', '20.00', '10000', '1', '0');
INSERT INTO `expenses` VALUES ('3', 'aaaa', '1', '20', '1', '20.00', '10', '4', '0');

-- ----------------------------
-- Table structure for `gift`
-- ----------------------------
DROP TABLE IF EXISTS `gift`;
CREATE TABLE `gift` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '赠品ID',
  `name` varchar(10) NOT NULL COMMENT '赠品名称',
  `amount` int(10) unsigned DEFAULT NULL COMMENT '总使用量',
  `output` int(10) unsigned DEFAULT '0' COMMENT '总出库量',
  `stock` int(10) unsigned DEFAULT NULL COMMENT '库存量',
  `status` char(1) DEFAULT '0' COMMENT '赠品状态；0可用 ，1不可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`) USING BTREE COMMENT '赠品名称索引'
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='赠品管理表，包括id，名称，历史数量，历史出货量，库存量';

-- ----------------------------
-- Records of gift
-- ----------------------------
INSERT INTO `gift` VALUES ('1', 'fff', '0', '0', '0', '1');
INSERT INTO `gift` VALUES ('2', 'aa', '40', '32', '8', '0');
INSERT INTO `gift` VALUES ('4', 'zhangsan2', '80', '0', '80', '0');
INSERT INTO `gift` VALUES ('5', 'ffffaaaa', '80', '0', '80', '0');

-- ----------------------------
-- Table structure for `ip_segment`
-- ----------------------------
DROP TABLE IF EXISTS `ip_segment`;
CREATE TABLE `ip_segment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ip号段的索引',
  `ip_name` char(20) NOT NULL,
  `start_ip` char(20) NOT NULL COMMENT 'ip号段的起始地址',
  `end_ip` char(20) NOT NULL COMMENT 'ip号段的结束地址',
  `status` bit(1) NOT NULL DEFAULT b'0' COMMENT '号段状态,1表示停用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='小区ip段的速度管理表,编辑ip的上传速度与下载速度';

-- ----------------------------
-- Records of ip_segment
-- ----------------------------
INSERT INTO `ip_segment` VALUES ('1', '安次区ip段', '192.168.0.1', '192.168.0.100', '');
INSERT INTO `ip_segment` VALUES ('2', '安次区ip段', '192.168.0.1', '192168.0.100', '');
INSERT INTO `ip_segment` VALUES ('3', '安次区ip段', '192.168.0.1', '192。168.0.100', '');
INSERT INTO `ip_segment` VALUES ('4', '安次区ip段', '192.168.0.1', '192。168.0.100', '');
INSERT INTO `ip_segment` VALUES ('5', '安次区ip段', '192.168.0.1', '192168.0.100', '');
INSERT INTO `ip_segment` VALUES ('6', '安次区ip段', '192.168.0.1', '192.168.0.100', '');
INSERT INTO `ip_segment` VALUES ('7', '安次区ip段', '192.168.0.1', '192.168.0.100', '');
INSERT INTO `ip_segment` VALUES ('8', '安次区ip段', '192.168.0.1', '192.168.0.100', '');
INSERT INTO `ip_segment` VALUES ('9', '安次区ip段', '192.168.0.1', '192.168.0.100', '');

-- ----------------------------
-- Table structure for `ip_speed`
-- ----------------------------
DROP TABLE IF EXISTS `ip_speed`;
CREATE TABLE `ip_speed` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ip_id` int(11) NOT NULL,
  `max_upload_speed` int(11) NOT NULL COMMENT '上行速度',
  `max_download_speed` int(11) NOT NULL COMMENT '下行速度',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ip_speed
-- ----------------------------
INSERT INTO `ip_speed` VALUES ('1', '1', '1024', '10240');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `customer_id` int(10) unsigned NOT NULL COMMENT '客户表ID(外键)',
  `order_number` varchar(26) NOT NULL COMMENT '订单号',
  `create_time` int(10) unsigned NOT NULL COMMENT '订单时间',
  `expiry_time` int(10) unsigned DEFAULT NULL COMMENT '到期时间',
  `money` decimal(10,2) unsigned NOT NULL COMMENT '订单金额',
  `remarks` varchar(50) DEFAULT NULL COMMENT '备注',
  `type` int(1) unsigned NOT NULL DEFAULT '0' COMMENT '状态(0.在线/激活,1.退费/未激活,2.过期)',
  `install_date` int(11) unsigned NOT NULL COMMENT '安装时间',
  `install_address` varchar(50) NOT NULL COMMENT '安装地址',
  `telephone` varchar(13) DEFAULT NULL COMMENT '电话号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='订单表(宋德和国文龙)';

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('5', '1', '1234567897', '0', '0', '20.00', 'string', '0', '0', 'string', null);
INSERT INTO `orders` VALUES ('6', '1', 'as123456789', '1538098181', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('7', '1', 'as123456790', '1538098197', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('8', '1', 'G0RfFl4R7vQ2atG2GYZAas', '1538098197', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('9', '1', 'pfkaeB7VcvFfaNejf9ya', '1538098197', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('10', '1', 'NpmJmMn3gpe4Jvvq20hv', '1538098197', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('11', '1', 'ERwIIiwTFRPR5jluZi4u', '1538098197', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('12', '1', '0EbZzpoA5ZKFpWWFQoYL', '1538098197', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('13', '2', 'w2BD7UOuAPleqpI23wA3', '1538098197', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('14', '1', 'D999GX7PxicRdf5wxg49', '1538098197', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('15', '1', 'mo2k8pP0p3FG23kJG2ig', '1538098198', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('16', '1', 'Tot9tdEd88SSi5tj9y9j', '1538098198', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('17', '1', 'g2fXbMjBjTwbdPeacwUo', '1538098198', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('18', '1', 'w0T6vTo2T0gT6n6uc46D', '1538098198', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('19', '1', '5p9GEu0zs5QGKGr8znnY', '1538098198', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('20', '1', 'bpd64HOIJpsDzDHgFpPm', '1538098198', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('21', '1', 'ya7my5l5q5tFn6zzFagr', '1538098198', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('22', '1', 'DzSC9WJuGCfuCkD9GkWS', '1538098199', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('23', '1', 'ZR7r6gReL447tJrQ61KJ', '1538098199', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('24', '1', 'suNtJupTonD6qMPzpCPD', '1538098199', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('25', '1', '3LZqgsqcqWbsebTq2sEl', '1538098199', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('26', '1', 'vvuJjeIceoPyhhc9weSh', '1538098199', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('27', '1', 'O4dPO22VSq6IPlQTucgP', '1538098199', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('28', '1', 'kIXVxImmVmH3LKif2u2t', '1538098199', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('29', '1', '8m5zB8yMshbDt5ej7LBv', '1538098200', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('30', '1', 'Qk6QSBaf5fp5izpcASwV', '1538098200', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('31', '1', 'Sn0YrRGODDblSarnr7rf', '1538098200', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('32', '1', '8BgDOdhjN2E7BhjzVBPO', '1538098200', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('33', '1', '0wlFvo3qp80s3nisn8EB', '1538098200', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('34', '1', '0ikK1iGZktTmc3Glt4tD', '1538098200', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('35', '1', 'CZwJtWYBE5WBLMaYZ5UW', '1538098200', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('36', '1', 'E51kqneYlQYO1pGBiiwE', '1538098201', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('37', '1', 'i1QGow2Q2pFAc52bxt1V', '1538098201', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('38', '1', 'Kkmb0303KAbzULPbytz6', '1538098201', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('39', '1', 'V5uvgGFtqWsCGhvuLZa3', '1538098201', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('40', '1', 'cOkWX8qWkmqAeBWBmmIW', '1538098201', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('41', '1', 'awPnU7VJjVagOH8KVeHn', '1538098201', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('42', '1', '33ChhEqnL0CkiBCUPEHI', '1538098201', null, '200.00', null, '1', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('43', '1', '5x5s0Xfm4yi7s2yXTrfT', '1538099847', null, '200.00', null, '0', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('44', '1', 'CtfCTdr9s8rXA2VHCpAo', '1538099911', null, '200.00', null, '0', '1975827827', 'aaa', null);
INSERT INTO `orders` VALUES ('45', '1', 'MnXX1s8o8XpiQ8X3cET7', '20180', '20190929', '20.00', null, '0', '19750527', '19750527', null);
INSERT INTO `orders` VALUES ('46', '1', 'FxzQCQ4jV4nGbCAvWu4E', '20180', '20190929', '20.00', null, '0', '19750527', '19750527', null);
INSERT INTO `orders` VALUES ('47', '1', 'p45UUxENQ4EKPWu3UyLy', '20180', '20190929', '20.00', null, '0', '19750527', '19750527', null);
INSERT INTO `orders` VALUES ('48', '1', 'DSTfODSyWDxDCjSobOOL', '20180929', '20190929', '20.00', null, '0', '19750527', '19750527', null);
INSERT INTO `orders` VALUES ('49', '1', 'BjnOVOO3YfZhSxxSOnYP', '1538203758', '19700101', '20.00', null, '0', '19750527', '19750527', null);
INSERT INTO `orders` VALUES ('50', '1', 'vMcdPpalov4OaaKJucxu', '1538203824', '19700101', '20.00', null, '0', '19750527', '19750527', null);
INSERT INTO `orders` VALUES ('51', '1', 'kzY4EJgEIPTJjLJXKzEO', '1538204007', '19700101', '20.00', null, '0', '19750527', '19750527', null);
INSERT INTO `orders` VALUES ('52', '1', 'eWabKb2638wbqQZ4w755', '1538213433', null, '20.00', null, '0', '19750827', 'aaaa', null);
INSERT INTO `orders` VALUES ('53', '1', 'eWabKb2638wbqQZ4w755', '1538213433', null, '20.00', null, '0', '19750827', 'aaaa', null);
INSERT INTO `orders` VALUES ('54', '1', 'eWabKb2638wbqQZ4w755', '1538213433', null, '20.00', null, '0', '19750827', 'aaaa', null);
INSERT INTO `orders` VALUES ('55', '1', 'XzGWGQzGcG47zKsoGZXm', '1538213593', null, '20.00', null, '0', '19750827', 'aaaa', null);
INSERT INTO `orders` VALUES ('56', '1', 'XzGWGQzGcG47zKsoGZXm', '1538213593', null, '20.00', null, '0', '19750827', 'aaaa', null);
INSERT INTO `orders` VALUES ('57', '1', 'XzGWGQzGcG47zKsoGZXm', '1538213593', null, '20.00', null, '0', '19750827', 'aaaa', null);
INSERT INTO `orders` VALUES ('58', '1', 'kqJvKVewLX5voLemVKm8', '1538214185', null, '20.00', null, '0', '19750827', 'aaaa', null);
INSERT INTO `orders` VALUES ('59', '1', 'A97kKAvuaLUbrewWbdKz', '1538214279', null, '20.00', null, '0', '19750827', 'aaaa', null);
INSERT INTO `orders` VALUES ('60', '2', 'ubOrvia0thbw22JRAmtb', '1538269886', '19700817', '20.00', null, '0', '19758827', 'zzzz', null);
INSERT INTO `orders` VALUES ('61', '2', 'FPCoyVara0ivgeoAi8V7', '1538269919', '19700817', '20.00', null, '0', '19758827', 'zzzz', null);
INSERT INTO `orders` VALUES ('62', '2', '6vS9ijRuk5ElHMAYKHjj', '1538270012', '19700817', '20.00', null, '0', '19758827', 'zzzz', null);
INSERT INTO `orders` VALUES ('63', '2', 'BUvQwsmXU07iUsyi24Ud', '1538270111', '19700817', '20.00', null, '0', '19758827', 'zzzz', null);
INSERT INTO `orders` VALUES ('64', '2', 'N1diNs2BeTEnEjw1fNkr', '1538270140', '19700817', '20.00', null, '0', '19758827', 'zzzz', null);
INSERT INTO `orders` VALUES ('65', '2', 'va0yZAXMz9rncXnSrL3B', '1538270994', '19700823', '20.00', null, '0', '19758827', 'zzzz', null);
INSERT INTO `orders` VALUES ('66', '2', '3yk0orH0Hfp0tr3SR2N1', '1538271380', '19700823', '20.00', null, '0', '19758827', 'zzzz', null);
INSERT INTO `orders` VALUES ('67', '2', 'm3qsoUREtCF9EY05Aot5', '1538271530', '19700823', '20.00', null, '0', '19758827', 'zzzz', null);
INSERT INTO `orders` VALUES ('68', '2', 'k6Uve9lkH9wkym59RJlr', '1538271426', '19700823', '20.00', null, '0', '19758827', 'zzzz', null);
INSERT INTO `orders` VALUES ('69', '2', 'uC84CiRs8djlPqznPnCx', '1538271573', '19691217', '20.00', null, '0', '19758827', 'zzzz', null);
INSERT INTO `orders` VALUES ('70', '2', 'CceHAbY3DDTQAJvmvP8w', '1538271625', '19700823', '20.00', null, '0', '19758827', 'zzzz', null);
INSERT INTO `orders` VALUES ('71', '2', 'W0bnwVADFRFqNqVWar2w', '1538271630', '19700823', '20.00', null, '0', '19758827', 'zzzz', null);
INSERT INTO `orders` VALUES ('72', '2', 'OKFYsvDKsFHSxvdsJkf0', '1538271645', '19700823', '20.00', null, '0', '19758827', 'zzzz', null);
INSERT INTO `orders` VALUES ('73', '2', 'NPvbarng7PauvDSSJky1', '1538271692', '19700823', '20.00', null, '0', '19758827', 'zzzz', null);
INSERT INTO `orders` VALUES ('74', '2', 'elbEPPWdFPNPFJ1L7R2f', '1538272173', '1569772800', '20.00', null, '0', '19758827', 'zzzz', null);
INSERT INTO `orders` VALUES ('75', '2', 'RisH8YlbJURxRY8R8JXH', '1538272241', '1569772800', '20.00', null, '0', '19758827', 'zzzz', null);
INSERT INTO `orders` VALUES ('76', '1', 'JsJAKoYIyolKhJBJAJO0', '1538292818', '1569772800', '20.00', null, '0', '1975827', 'zzz', null);

-- ----------------------------
-- Table structure for `order_product`
-- ----------------------------
DROP TABLE IF EXISTS `order_product`;
CREATE TABLE `order_product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `orders_number` varchar(26) NOT NULL COMMENT '订单编号',
  `type` tinyint(1) unsigned NOT NULL COMMENT '产品类型 1:套餐2资费3设备4赠品',
  `product_id` int(10) unsigned NOT NULL COMMENT 'ID(外键)',
  `discountmoney` decimal(10,2) unsigned DEFAULT NULL COMMENT '金额',
  `discount` int(1) unsigned DEFAULT NULL COMMENT '折扣',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=335 DEFAULT CHARSET=utf8 COMMENT='订单中间表';

-- ----------------------------
-- Records of order_product
-- ----------------------------
INSERT INTO `order_product` VALUES ('76', 'mo2k8pP0p3FG23kJG2ig', '1', '1', '7.00', '7');
INSERT INTO `order_product` VALUES ('77', 'mo2k8pP0p3FG23kJG2ig', '2', '1', '8.00', null);
INSERT INTO `order_product` VALUES ('78', 'mo2k8pP0p3FG23kJG2ig', '4', '2', '8.00', null);
INSERT INTO `order_product` VALUES ('79', 'mo2k8pP0p3FG23kJG2ig', '3', '1', '8.00', null);
INSERT INTO `order_product` VALUES ('80', 'mo2k8pP0p3FG23kJG2ig', '3', '2', '8.00', null);
INSERT INTO `order_product` VALUES ('81', 'mo2k8pP0p3FG23kJG2ig', '3', '1', '8.00', null);
INSERT INTO `order_product` VALUES ('82', 'mo2k8pP0p3FG23kJG2ig', '4', '1', '8.00', null);
INSERT INTO `order_product` VALUES ('83', 'g2fXbMjBjTwbdPeacwUo', '1', '1', '2.00', null);
INSERT INTO `order_product` VALUES ('84', '1', '2', '1', '1.00', null);
INSERT INTO `order_product` VALUES ('233', '1', '1', '1', '1.00', null);
INSERT INTO `order_product` VALUES ('234', 'w2BD7UOuAPleqpI23wA3', '1', '1', '280.00', '7');
INSERT INTO `order_product` VALUES ('235', 'w2BD7UOuAPleqpI23wA3', '2', '1', '290.00', null);
INSERT INTO `order_product` VALUES ('236', ' w2BD7UOuAPleqpI23wA3', '3', '1', '300.00', null);
INSERT INTO `order_product` VALUES ('237', 'BjnOVOO3YfZhSxxSOnYP', '2', '1', '2.00', null);
INSERT INTO `order_product` VALUES ('238', 'vMcdPpalov4OaaKJucxu', '2', '1', '2.00', null);
INSERT INTO `order_product` VALUES ('239', 'kzY4EJgEIPTJjLJXKzEO', '2', '1', '2.00', null);
INSERT INTO `order_product` VALUES ('246', 'kqJvKVewLX5voLemVKm8', '1', '1', '20.20', null);
INSERT INTO `order_product` VALUES ('247', 'kqJvKVewLX5voLemVKm8', '2', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('248', 'kqJvKVewLX5voLemVKm8', '4', '1', '20.20', null);
INSERT INTO `order_product` VALUES ('249', 'A97kKAvuaLUbrewWbdKz', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('250', 'A97kKAvuaLUbrewWbdKz', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('251', 'A97kKAvuaLUbrewWbdKz', '5', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('252', '3CWgwhOZiVWEI3ytOiO6', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('253', 'R9VrYdo7N9xRho9kKMM9', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('254', 'Jmm5XiKUKIKzz5dAAFuL', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('255', 'YgrvruAR3uNvNxBBpoog', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('256', 'x85QzZdZ8xuyGtQhnkbQ', '1', '2', '20.00', null);
INSERT INTO `order_product` VALUES ('257', 'VZqbzTq8Jq6KEITFSi8g', '1', '2', '20.00', null);
INSERT INTO `order_product` VALUES ('258', 'ubOrvia0thbw22JRAmtb', '1', '2', '20.00', null);
INSERT INTO `order_product` VALUES ('259', 'ubOrvia0thbw22JRAmtb', '2', '15', '20.00', null);
INSERT INTO `order_product` VALUES ('260', 'ubOrvia0thbw22JRAmtb', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('261', 'ubOrvia0thbw22JRAmtb', '4', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('262', 'FPCoyVara0ivgeoAi8V7', '1', '2', '20.00', null);
INSERT INTO `order_product` VALUES ('263', 'FPCoyVara0ivgeoAi8V7', '2', '15', '20.00', null);
INSERT INTO `order_product` VALUES ('264', 'FPCoyVara0ivgeoAi8V7', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('265', 'FPCoyVara0ivgeoAi8V7', '4', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('266', '6vS9ijRuk5ElHMAYKHjj', '1', '2', '20.00', null);
INSERT INTO `order_product` VALUES ('267', '6vS9ijRuk5ElHMAYKHjj', '2', '15', '20.00', null);
INSERT INTO `order_product` VALUES ('268', '6vS9ijRuk5ElHMAYKHjj', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('269', '6vS9ijRuk5ElHMAYKHjj', '4', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('270', 'BUvQwsmXU07iUsyi24Ud', '1', '2', '20.00', null);
INSERT INTO `order_product` VALUES ('271', 'BUvQwsmXU07iUsyi24Ud', '2', '15', '20.00', null);
INSERT INTO `order_product` VALUES ('272', 'BUvQwsmXU07iUsyi24Ud', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('273', 'BUvQwsmXU07iUsyi24Ud', '4', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('274', 'N1diNs2BeTEnEjw1fNkr', '1', '2', '20.00', null);
INSERT INTO `order_product` VALUES ('275', 'N1diNs2BeTEnEjw1fNkr', '2', '15', '20.00', null);
INSERT INTO `order_product` VALUES ('276', 'N1diNs2BeTEnEjw1fNkr', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('277', 'N1diNs2BeTEnEjw1fNkr', '4', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('278', 'wxH43lu2wnNn8H77ibFb', '1', '2', '20.00', null);
INSERT INTO `order_product` VALUES ('279', 'q1s2olUJsq1apOBiHUQ2', '1', '2', '20.00', null);
INSERT INTO `order_product` VALUES ('280', 'q1s2olUJsq1apOBiHUQ2', '2', '15', '20.00', null);
INSERT INTO `order_product` VALUES ('281', 'q1s2olUJsq1apOBiHUQ2', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('282', 'q1s2olUJsq1apOBiHUQ2', '4', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('283', 'xqWOPL002Oq0JayE4ixR', '1', '2', '20.00', null);
INSERT INTO `order_product` VALUES ('284', 'va0yZAXMz9rncXnSrL3B', '1', '2', '20.00', null);
INSERT INTO `order_product` VALUES ('285', 'va0yZAXMz9rncXnSrL3B', '2', '15', '20.00', null);
INSERT INTO `order_product` VALUES ('286', 'va0yZAXMz9rncXnSrL3B', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('287', 'va0yZAXMz9rncXnSrL3B', '4', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('288', 'NgbqTe3wEZZ02qdh0lZ8', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('289', 'FtSbcpGagRiI7OF8cTaD', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('290', '3yk0orH0Hfp0tr3SR2N1', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('291', '3yk0orH0Hfp0tr3SR2N1', '2', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('292', '3yk0orH0Hfp0tr3SR2N1', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('293', '3yk0orH0Hfp0tr3SR2N1', '4', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('294', 'k6Uve9lkH9wkym59RJlr', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('295', 'k6Uve9lkH9wkym59RJlr', '2', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('296', 'm3qsoUREtCF9EY05Aot5', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('297', 'k6Uve9lkH9wkym59RJlr', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('298', 'k6Uve9lkH9wkym59RJlr', '4', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('299', 'm3qsoUREtCF9EY05Aot5', '2', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('300', 'm3qsoUREtCF9EY05Aot5', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('301', 'm3qsoUREtCF9EY05Aot5', '4', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('302', 'uC84CiRs8djlPqznPnCx', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('303', 'uC84CiRs8djlPqznPnCx', '2', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('304', 'uC84CiRs8djlPqznPnCx', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('305', 'uC84CiRs8djlPqznPnCx', '4', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('306', 'CceHAbY3DDTQAJvmvP8w', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('307', 'CceHAbY3DDTQAJvmvP8w', '2', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('308', 'CceHAbY3DDTQAJvmvP8w', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('309', 'CceHAbY3DDTQAJvmvP8w', '4', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('310', 'W0bnwVADFRFqNqVWar2w', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('311', 'W0bnwVADFRFqNqVWar2w', '2', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('312', 'W0bnwVADFRFqNqVWar2w', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('313', 'W0bnwVADFRFqNqVWar2w', '4', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('314', 'OKFYsvDKsFHSxvdsJkf0', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('315', 'OKFYsvDKsFHSxvdsJkf0', '2', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('316', 'OKFYsvDKsFHSxvdsJkf0', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('317', 'OKFYsvDKsFHSxvdsJkf0', '4', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('318', 'NPvbarng7PauvDSSJky1', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('319', 'NPvbarng7PauvDSSJky1', '2', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('320', 'NPvbarng7PauvDSSJky1', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('321', 'NPvbarng7PauvDSSJky1', '4', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('322', 'YxxEqorLrKKGokKxRB2Q', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('323', 'elbEPPWdFPNPFJ1L7R2f', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('324', 'elbEPPWdFPNPFJ1L7R2f', '2', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('325', 'elbEPPWdFPNPFJ1L7R2f', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('326', 'elbEPPWdFPNPFJ1L7R2f', '4', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('327', 'RisH8YlbJURxRY8R8JXH', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('328', 'RisH8YlbJURxRY8R8JXH', '2', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('329', 'RisH8YlbJURxRY8R8JXH', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('330', 'RisH8YlbJURxRY8R8JXH', '4', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('331', 'JsJAKoYIyolKhJBJAJO0', '1', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('332', 'JsJAKoYIyolKhJBJAJO0', '2', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('333', 'JsJAKoYIyolKhJBJAJO0', '3', '1', '20.00', null);
INSERT INTO `order_product` VALUES ('334', 'JsJAKoYIyolKhJBJAJO0', '4', '1', '20.00', null);

-- ----------------------------
-- Table structure for `phone_number_stock`
-- ----------------------------
DROP TABLE IF EXISTS `phone_number_stock`;
CREATE TABLE `phone_number_stock` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '号码库id',
  `phone_number` varchar(10) DEFAULT NULL COMMENT '电话号码',
  `status` char(1) DEFAULT NULL COMMENT '状态.  0可用；1不可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone_number` (`phone_number`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='固话号码库';

-- ----------------------------
-- Records of phone_number_stock
-- ----------------------------
INSERT INTO `phone_number_stock` VALUES ('1', '2635468', '2');
INSERT INTO `phone_number_stock` VALUES ('10', '26354689', '0');
INSERT INTO `phone_number_stock` VALUES ('12', '26354687', '0');
INSERT INTO `phone_number_stock` VALUES ('13', '1234567', '0');
INSERT INTO `phone_number_stock` VALUES ('15', '1234564', '0');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `name` varchar(30) DEFAULT NULL COMMENT '产品名称',
  `price` decimal(10,2) unsigned DEFAULT NULL COMMENT '产品价格',
  `status` char(1) CHARACTER SET utf8mb4 DEFAULT '0' COMMENT '产品状态（“0”可用，“1”不可用）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE COMMENT 'id'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='产品包管理表  --王向晨';

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'lll', '20.00', '0');
INSERT INTO `product` VALUES ('3', 'fff', '420.00', '0');

-- ----------------------------
-- Table structure for `product_equipment_model`
-- ----------------------------
DROP TABLE IF EXISTS `product_equipment_model`;
CREATE TABLE `product_equipment_model` (
  `product_id` int(11) unsigned NOT NULL COMMENT '套餐id',
  `equipment_model_id` int(11) unsigned DEFAULT NULL COMMENT '设备型号id',
  `equipment_num` int(11) unsigned DEFAULT NULL COMMENT '设备数量',
  KEY `product_id` (`product_id`) USING BTREE,
  KEY `product_equipment_model_ibfk_2` (`equipment_model_id`),
  CONSTRAINT `product_equipment_model_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `product_equipment_model_ibfk_2` FOREIGN KEY (`equipment_model_id`) REFERENCES `equipment` (`model_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品和设备中间表，解决一个产品多个设备问题。   --王向晨';

-- ----------------------------
-- Records of product_equipment_model
-- ----------------------------
INSERT INTO `product_equipment_model` VALUES ('3', '8', '20');

-- ----------------------------
-- Table structure for `product_expenses`
-- ----------------------------
DROP TABLE IF EXISTS `product_expenses`;
CREATE TABLE `product_expenses` (
  `product_id` int(11) unsigned NOT NULL COMMENT '套餐id',
  `expenses_id` int(11) unsigned NOT NULL COMMENT '资费id',
  KEY `product_id` (`product_id`),
  KEY `expenses_id` (`expenses_id`) USING BTREE,
  CONSTRAINT `product_expenses_ibfk_1` FOREIGN KEY (`expenses_id`) REFERENCES `expenses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `product_expenses_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='套餐（product）和资费关联表';

-- ----------------------------
-- Records of product_expenses
-- ----------------------------
INSERT INTO `product_expenses` VALUES ('3', '1');

-- ----------------------------
-- Table structure for `product_gift`
-- ----------------------------
DROP TABLE IF EXISTS `product_gift`;
CREATE TABLE `product_gift` (
  `product_id` int(11) unsigned NOT NULL COMMENT '套餐id',
  `gift_id` int(10) unsigned DEFAULT NULL COMMENT '赠品id',
  `gift_num` int(11) unsigned DEFAULT NULL COMMENT '赠品数量',
  KEY `product_gift` (`product_id`),
  KEY `gift_id` (`gift_id`),
  CONSTRAINT `product_gift_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `product_gift_ibfk_3` FOREIGN KEY (`gift_id`) REFERENCES `gift` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品和礼品中间表，一对多情况。   --王向晨';

-- ----------------------------
-- Records of product_gift
-- ----------------------------
INSERT INTO `product_gift` VALUES ('3', '1', '10');

-- ----------------------------
-- Table structure for `sys_dept`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `parent_id` int(4) NOT NULL COMMENT '上级部门ID',
  `dept_name` varchar(20) NOT NULL COMMENT '部门名称',
  `order_num` int(5) DEFAULT NULL COMMENT '排序',
  `create_time` int(10) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表(陈方硕)\r\n';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `username` varchar(20) NOT NULL COMMENT '操作用户',
  `operation` varchar(50) NOT NULL COMMENT '操作内容',
  `method` varchar(50) NOT NULL COMMENT '操作方法',
  `requestIP` varchar(64) NOT NULL COMMENT '操作者IP',
  `create_time` int(11) NOT NULL COMMENT '创建时间',
  `exceptionCode` varchar(255) DEFAULT NULL,
  `exceptionDetail` varchar(255) DEFAULT NULL,
  `type` tinyint(1) DEFAULT NULL COMMENT '类型 0:controller 1:service',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志(陈方硕)\r\n';

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '菜单/按钮ID',
  `parent_id` int(5) NOT NULL COMMENT '上级菜单ID',
  `menu_name` varchar(20) NOT NULL COMMENT '菜单/按钮名称',
  `URL` varchar(100) DEFAULT NULL COMMENT '菜单URL',
  `power` varchar(20) DEFAULT NULL COMMENT '权限标识',
  `type` int(1) NOT NULL COMMENT '类型 0菜单 1按钮',
  `order_num` int(20) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='权限(陈方硕)\r\n';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '1', '1', null, '1', '1', '1');
INSERT INTO `sys_permission` VALUES ('2', '1', '1', null, '2', '1', '1');
INSERT INTO `sys_permission` VALUES ('3', '1', '1', null, '3', '1', '1');
INSERT INTO `sys_permission` VALUES ('4', '1', '1', null, '4', '1', '1');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(20) NOT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `create_time` int(10) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色(陈方硕)\r\n';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '小宋1号', '我也不知道描述什么', '2018920');
INSERT INTO `sys_role` VALUES ('2', '小宋2号', '不清楚', '2018920');
INSERT INTO `sys_role` VALUES ('3', '小宋3号', '不知道呀', '2018920');
INSERT INTO `sys_role` VALUES ('4', '小宋4号', '真心的不知道呀', '2018920');

-- ----------------------------
-- Table structure for `sys_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` int(20) NOT NULL COMMENT '角色ID',
  `permission_id` int(20) NOT NULL COMMENT '菜单/按钮ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '2');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` char(48) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '密码',
  `dept_id` int(4) DEFAULT NULL COMMENT '部门ID',
  `emall` varchar(48) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(12) NOT NULL COMMENT '联系电话',
  `community_id` int(10) DEFAULT NULL COMMENT '小区ID',
  `description` varchar(128) CHARACTER SET utf32 DEFAULT NULL COMMENT '描述',
  `last_login_time` int(10) DEFAULT NULL COMMENT '最近访问时间',
  `crate_time` int(10) NOT NULL COMMENT '创建时间',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态 0锁定 1有效',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_username` (`username`) USING BTREE COMMENT '用户名唯一约束'
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='用户(陈方硕)\r\n';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'zhangsan', '23333', null, 'string', '13112341234', null, 'string', null, '-1641754136', '1');
INSERT INTO `sys_user` VALUES ('4', 'zhangsan1', '23333', null, 'string', '13112341234', null, 'string', null, '-1641754136', '1');
INSERT INTO `sys_user` VALUES ('5', 'zhangsan2', '23333', null, 'string', '13112341234', null, 'string', null, '-708139265', '1');
INSERT INTO `sys_user` VALUES ('7', 'zhangsan3', '23333', null, 'string', '13112341234', null, 'string', null, '-708139265', '1');
INSERT INTO `sys_user` VALUES ('8', 'zhangba', '23333', null, 'string', '13112341234', null, 'string', null, '-707559797', '1');
INSERT INTO `sys_user` VALUES ('9', 'zhangba1', '23333', null, 'string', '13112341234', null, 'string', null, '-707559797', '1');
INSERT INTO `sys_user` VALUES ('10', 'zhangba2', '23333', null, 'string', '13112341234', null, 'string', null, '-707559797', '1');
INSERT INTO `sys_user` VALUES ('11', 'zhangba3', '23333', null, 'string', '13112341234', null, 'string', null, '-707559797', '0');
INSERT INTO `sys_user` VALUES ('12', 'zhangba4', '23333', null, 'string', '13112341234', null, 'string', null, '-707559797', '0');
INSERT INTO `sys_user` VALUES ('13', 'zhangba5', '23333', null, 'string', '13112341234', null, 'string', null, '-707559797', '0');
INSERT INTO `sys_user` VALUES ('14', 'zhangba6', '23333', null, 'string', '13112341234', null, 'string', null, '-707559797', '0');
INSERT INTO `sys_user` VALUES ('17', 'zhangsasn', '23333', null, 'string', '13112341234', null, 'string', null, '1381882239', '1');
INSERT INTO `sys_user` VALUES ('19', 'zhangsasnn', '23333', null, 'string', '13112341234', null, 'string', null, '1358508032', '1');

-- ----------------------------
-- Table structure for `sys_user_community`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_community`;
CREATE TABLE `sys_user_community` (
  `community_id` int(10) NOT NULL,
  `sys_user_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`community_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_community
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(20) NOT NULL COMMENT '用户ID',
  `role_id` int(20) NOT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('1', '2');
INSERT INTO `sys_user_role` VALUES ('1', '3');

-- ----------------------------
-- Table structure for `work_order`
-- ----------------------------
DROP TABLE IF EXISTS `work_order`;
CREATE TABLE `work_order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `the_repair_order_id` char(20) NOT NULL COMMENT '工单编号',
  `appointment_date` int(10) NOT NULL COMMENT '预约时间',
  `customer_name` varchar(10) NOT NULL COMMENT '客户姓名',
  `mobile` char(11) NOT NULL COMMENT '联系电话',
  `type` tinyint(1) NOT NULL COMMENT '类型（1 维修，2 安装）',
  `maintenance_type` tinyint(1) DEFAULT NULL COMMENT '维修类型（1 宽带，2 电视，3 固话）',
  `Install_state` tinyint(1) NOT NULL DEFAULT '1' COMMENT '完成状态（1 未完成，2 完成，3 确认完成）',
  `user_id` int(10) DEFAULT NULL COMMENT '安装维修人员及其联系电话',
  `maintenance_reason` varchar(50) DEFAULT NULL COMMENT '维修原因',
  `order_number` int(1) DEFAULT NULL COMMENT '订单编号 （ 关联安装地址，产品名称，产品信息 ）',
  `note` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='工单管理（霍飞）';

-- ----------------------------
-- Records of work_order
-- ----------------------------
INSERT INTO `work_order` VALUES ('1', '233', '0', '张三', '18733688888', '1', '1', '1', '0', '网断了', '2', '无');
INSERT INTO `work_order` VALUES ('2', '233', '19750827', 'aaa', '13121780556', '1', '1', '1', '1', 'aaa', '3', 'dd');
