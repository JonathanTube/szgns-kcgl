-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.21-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 kcgl 的数据库结构
DROP DATABASE IF EXISTS `kcgl`;
CREATE DATABASE IF NOT EXISTS `kcgl` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `kcgl`;


-- 导出  表 kcgl.t_bill 结构
DROP TABLE IF EXISTS `t_bill`;
CREATE TABLE IF NOT EXISTS `t_bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seq` varchar(13) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出货单号';

-- 正在导出表  kcgl.t_bill 的数据：~0 rows (大约)
DELETE FROM `t_bill`;
/*!40000 ALTER TABLE `t_bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_bill` ENABLE KEYS */;


-- 导出  表 kcgl.t_brand 结构
DROP TABLE IF EXISTS `t_brand`;
CREATE TABLE IF NOT EXISTS `t_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `flag` int(1) NOT NULL DEFAULT '1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='品牌';

-- 正在导出表  kcgl.t_brand 的数据：~1 rows (大约)
DELETE FROM `t_brand`;
/*!40000 ALTER TABLE `t_brand` DISABLE KEYS */;
INSERT INTO `t_brand` (`id`, `name`, `flag`, `create_time`, `create_user`) VALUES
	(1, '品牌1', 1, '2015-07-28 13:14:30', 11);
/*!40000 ALTER TABLE `t_brand` ENABLE KEYS */;


-- 导出  表 kcgl.t_cust 结构
DROP TABLE IF EXISTS `t_cust`;
CREATE TABLE IF NOT EXISTS `t_cust` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='客户';

-- 正在导出表  kcgl.t_cust 的数据：~1 rows (大约)
DELETE FROM `t_cust`;
/*!40000 ALTER TABLE `t_cust` DISABLE KEYS */;
INSERT INTO `t_cust` (`id`, `name`) VALUES
	(1, '客户01');
/*!40000 ALTER TABLE `t_cust` ENABLE KEYS */;


-- 导出  表 kcgl.t_func 结构
DROP TABLE IF EXISTS `t_func`;
CREATE TABLE IF NOT EXISTS `t_func` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `url` varchar(200) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- 正在导出表  kcgl.t_func 的数据：~12 rows (大约)
DELETE FROM `t_func`;
/*!40000 ALTER TABLE `t_func` DISABLE KEYS */;
INSERT INTO `t_func` (`id`, `name`, `url`, `type`) VALUES
	(1, '权限管理', 'rightManage.xhtml', 0),
	(2, '用户管理', 'userManage.xhtml', 0),
	(3, '产品入库', 'productInManage.xhtml', 1),
	(4, '产品出库', 'productOutManage.xhtml', 1),
	(5, '价格调整', 'priceManage.xhtml', 1),
	(6, '总库存日报表', 'reportStock.xhtml', 2),
	(7, '型号查询次数统计表', 'reportQueryTimes.xhtml', 2),
	(8, '入库日报表', 'reportProductIn.xhtml', 2),
	(9, '出货日报表', 'reportProductOut.xhtml', 2),
	(10, '价格表', 'reportPrice.xhtml', 2),
	(11, '佣金月报表', '', 2),
	(12, '库存查询', '#', 2);
/*!40000 ALTER TABLE `t_func` ENABLE KEYS */;


-- 导出  表 kcgl.t_identify 结构
DROP TABLE IF EXISTS `t_identify`;
CREATE TABLE IF NOT EXISTS `t_identify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  kcgl.t_identify 的数据：~1 rows (大约)
DELETE FROM `t_identify`;
/*!40000 ALTER TABLE `t_identify` DISABLE KEYS */;
INSERT INTO `t_identify` (`id`, `name`) VALUES
	(1, '客户标1');
/*!40000 ALTER TABLE `t_identify` ENABLE KEYS */;


-- 导出  表 kcgl.t_in_type 结构
DROP TABLE IF EXISTS `t_in_type`;
CREATE TABLE IF NOT EXISTS `t_in_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  kcgl.t_in_type 的数据：~3 rows (大约)
DELETE FROM `t_in_type`;
/*!40000 ALTER TABLE `t_in_type` DISABLE KEYS */;
INSERT INTO `t_in_type` (`id`, `name`) VALUES
	(1, '生产入库'),
	(2, '采购入库'),
	(3, '退货入库');
/*!40000 ALTER TABLE `t_in_type` ENABLE KEYS */;


-- 导出  表 kcgl.t_manufactor 结构
DROP TABLE IF EXISTS `t_manufactor`;
CREATE TABLE IF NOT EXISTS `t_manufactor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  kcgl.t_manufactor 的数据：~1 rows (大约)
DELETE FROM `t_manufactor`;
/*!40000 ALTER TABLE `t_manufactor` DISABLE KEYS */;
INSERT INTO `t_manufactor` (`id`, `name`) VALUES
	(1, '厂家1');
/*!40000 ALTER TABLE `t_manufactor` ENABLE KEYS */;


-- 导出  表 kcgl.t_product 结构
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE IF NOT EXISTS `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_no` varchar(100) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `brand_id` int(11) NOT NULL,
  `tech_id` int(11) NOT NULL,
  `thickness_id` int(11) NOT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `query_times` int(11) NOT NULL DEFAULT '0',
  `create_user_id` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='产品';

-- 正在导出表  kcgl.t_product 的数据：~7 rows (大约)
DELETE FROM `t_product`;
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;
INSERT INTO `t_product` (`id`, `product_no`, `product_name`, `brand_id`, `tech_id`, `thickness_id`, `price`, `query_times`, `create_user_id`, `create_time`) VALUES
	(4, 'S1', 'XH1', 1, 1, 1, 101, 0, 1, '2015-07-29 13:15:55'),
	(5, 'S2', 'XH2', 1, 1, 1, 200, 0, 1, '2015-07-29 13:20:29'),
	(6, 'S3', 'S3', 1, 1, 1, 300, 0, 1, '2015-07-29 14:02:12'),
	(7, 'S4', 'XH4', 1, 1, 1, 400, 0, 1, '2015-07-29 14:10:34'),
	(8, 'S5', 'XH5', 1, 1, 1, 500, 0, 1, '2015-07-29 14:14:13'),
	(9, 'S6', 'XH6', 1, 1, 1, 600, 0, 1, '2015-07-29 14:16:17'),
	(12, 'S7', 'XH7', 1, 1, 1, 700, 0, 1, '2015-07-29 14:17:38');
/*!40000 ALTER TABLE `t_product` ENABLE KEYS */;


-- 导出  表 kcgl.t_product_in 结构
DROP TABLE IF EXISTS `t_product_in`;
CREATE TABLE IF NOT EXISTS `t_product_in` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `amount` int(11) NOT NULL,
  `in_type_id` int(11) DEFAULT NULL COMMENT '入库类型',
  `manufactor_id` int(11) NOT NULL,
  `identify_type` int(11) NOT NULL COMMENT '0-中性标，1-客户标',
  `identify_id` int(11) DEFAULT NULL,
  `create_user_id` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='入库单';

-- 正在导出表  kcgl.t_product_in 的数据：~13 rows (大约)
DELETE FROM `t_product_in`;
/*!40000 ALTER TABLE `t_product_in` DISABLE KEYS */;
INSERT INTO `t_product_in` (`id`, `product_id`, `price`, `amount`, `in_type_id`, `manufactor_id`, `identify_type`, `identify_id`, `create_user_id`, `create_time`) VALUES
	(12, 4, 100, 100, 0, 1, 1, 1, 1, '2015-07-29 13:15:55'),
	(13, 5, 200, 200, 0, 1, 0, 1, 1, '2015-07-29 13:20:29'),
	(14, 6, 300, 300, 0, 1, 1, 1, 1, '2015-07-29 14:02:12'),
	(20, 7, 400, 1, 1, 1, 0, NULL, 1, '2015-07-29 16:26:37'),
	(21, 7, 400, 1, 1, 1, 0, NULL, 1, '2015-07-29 16:26:50'),
	(22, 4, 100, 1, 1, 1, 0, NULL, 1, '2015-07-29 16:31:18'),
	(23, 4, 100, 1, 1, 1, 0, NULL, 1, '2015-07-29 16:32:37'),
	(24, 4, 100, 1, 1, 1, 0, NULL, 1, '2015-07-29 16:35:16'),
	(25, 4, 100, 1, 1, 1, 0, NULL, 1, '2015-07-29 16:38:43'),
	(26, 4, 100, 1, 1, 1, 0, NULL, 1, '2015-07-29 16:38:51'),
	(27, 4, 100, 1, 1, 1, 0, NULL, 1, '2015-07-29 16:39:42'),
	(28, 4, 101, 1, 1, 1, 0, NULL, 1, '2015-07-29 16:40:51'),
	(29, 5, 200, 11, 1, 1, 0, NULL, 1, '2015-07-29 16:42:23');
/*!40000 ALTER TABLE `t_product_in` ENABLE KEYS */;


-- 导出  表 kcgl.t_product_out 结构
DROP TABLE IF EXISTS `t_product_out`;
CREATE TABLE IF NOT EXISTS `t_product_out` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `amount` int(20) NOT NULL,
  `cust_id` int(11) NOT NULL,
  `price` double NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='出库单';

-- 正在导出表  kcgl.t_product_out 的数据：~2 rows (大约)
DELETE FROM `t_product_out`;
/*!40000 ALTER TABLE `t_product_out` DISABLE KEYS */;
INSERT INTO `t_product_out` (`id`, `product_id`, `amount`, `cust_id`, `price`, `create_time`, `create_user_id`) VALUES
	(1, 4, 1, 1, 111, '2015-07-30 00:23:59', 1),
	(2, 4, 2, 1, 121, '2015-07-30 00:24:03', 1);
/*!40000 ALTER TABLE `t_product_out` ENABLE KEYS */;


-- 导出  表 kcgl.t_right 结构
DROP TABLE IF EXISTS `t_right`;
CREATE TABLE IF NOT EXISTS `t_right` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT '0',
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  kcgl.t_right 的数据：~4 rows (大约)
DELETE FROM `t_right`;
/*!40000 ALTER TABLE `t_right` DISABLE KEYS */;
INSERT INTO `t_right` (`id`, `name`, `description`) VALUES
	(1, '超级管理员', '所有权限；包括增减用户及用户权限设置。'),
	(2, '财务', '出厂价录入、各类报表下载。'),
	(3, '仓库', '产品入库及出库。'),
	(4, '业务', '库存查询');
/*!40000 ALTER TABLE `t_right` ENABLE KEYS */;


-- 导出  表 kcgl.t_right_func 结构
DROP TABLE IF EXISTS `t_right_func`;
CREATE TABLE IF NOT EXISTS `t_right_func` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `right_id` int(11) NOT NULL,
  `func_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8;

-- 正在导出表  kcgl.t_right_func 的数据：~11 rows (大约)
DELETE FROM `t_right_func`;
/*!40000 ALTER TABLE `t_right_func` DISABLE KEYS */;
INSERT INTO `t_right_func` (`id`, `right_id`, `func_id`) VALUES
	(88, 1, 2),
	(89, 1, 3),
	(90, 1, 4),
	(91, 1, 5),
	(92, 1, 6),
	(93, 1, 7),
	(94, 1, 8),
	(95, 1, 9),
	(96, 1, 10),
	(97, 1, 11),
	(98, 1, 1);
/*!40000 ALTER TABLE `t_right_func` ENABLE KEYS */;


-- 导出  表 kcgl.t_stock 结构
DROP TABLE IF EXISTS `t_stock`;
CREATE TABLE IF NOT EXISTS `t_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `identify_type` int(11) NOT NULL COMMENT '0-中性标，1-客户标',
  `identify_id` int(11) DEFAULT NULL,
  `manufactor_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- 正在导出表  kcgl.t_stock 的数据：~6 rows (大约)
DELETE FROM `t_stock`;
/*!40000 ALTER TABLE `t_stock` DISABLE KEYS */;
INSERT INTO `t_stock` (`id`, `product_id`, `identify_type`, `identify_id`, `manufactor_id`, `amount`) VALUES
	(3, 4, 1, 1, 0, 99),
	(4, 5, 0, 1, 0, 200),
	(5, 6, 1, 1, 1, 300),
	(12, 7, 0, NULL, 1, 1),
	(13, 4, 0, NULL, 1, 3),
	(14, 5, 0, NULL, 1, 11);
/*!40000 ALTER TABLE `t_stock` ENABLE KEYS */;


-- 导出  表 kcgl.t_tech 结构
DROP TABLE IF EXISTS `t_tech`;
CREATE TABLE IF NOT EXISTS `t_tech` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `flag` int(1) NOT NULL DEFAULT '1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='工艺';

-- 正在导出表  kcgl.t_tech 的数据：~1 rows (大约)
DELETE FROM `t_tech`;
/*!40000 ALTER TABLE `t_tech` DISABLE KEYS */;
INSERT INTO `t_tech` (`id`, `name`, `flag`, `create_time`, `create_user`) VALUES
	(1, '工艺1', 1, '2015-07-28 13:15:37', 11);
/*!40000 ALTER TABLE `t_tech` ENABLE KEYS */;


-- 导出  表 kcgl.t_thickness 结构
DROP TABLE IF EXISTS `t_thickness`;
CREATE TABLE IF NOT EXISTS `t_thickness` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `flag` int(1) NOT NULL DEFAULT '1',
  `create_user` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='厚度';

-- 正在导出表  kcgl.t_thickness 的数据：~1 rows (大约)
DELETE FROM `t_thickness`;
/*!40000 ALTER TABLE `t_thickness` DISABLE KEYS */;
INSERT INTO `t_thickness` (`id`, `name`, `create_time`, `flag`, `create_user`) VALUES
	(1, '厚度1', '2015-07-28 13:16:42', 1, 11);
/*!40000 ALTER TABLE `t_thickness` ENABLE KEYS */;


-- 导出  表 kcgl.t_user 结构
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `realname` varchar(10) NOT NULL,
  `status` int(1) NOT NULL COMMENT '0-true,1-false',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`username`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  kcgl.t_user 的数据：~3 rows (大约)
DELETE FROM `t_user`;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`id`, `username`, `password`, `realname`, `status`, `createTime`, `updateTime`) VALUES
	(1, 'admin', 'admin', '超级管理员', 0, '2015-07-24 14:23:19', '2015-07-28 09:58:29'),
	(2, 'zx', 'zx', '张三', 0, '2015-07-26 09:35:37', '2015-07-26 09:35:37'),
	(3, 'ls', 'ls', '李四', 1, '2015-07-26 09:35:50', '2015-07-28 09:59:01');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;


-- 导出  表 kcgl.t_user_cust 结构
DROP TABLE IF EXISTS `t_user_cust`;
CREATE TABLE IF NOT EXISTS `t_user_cust` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `cust_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  kcgl.t_user_cust 的数据：~0 rows (大约)
DELETE FROM `t_user_cust`;
/*!40000 ALTER TABLE `t_user_cust` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_cust` ENABLE KEYS */;


-- 导出  表 kcgl.t_user_right 结构
DROP TABLE IF EXISTS `t_user_right`;
CREATE TABLE IF NOT EXISTS `t_user_right` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `right_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- 正在导出表  kcgl.t_user_right 的数据：~1 rows (大约)
DELETE FROM `t_user_right`;
/*!40000 ALTER TABLE `t_user_right` DISABLE KEYS */;
INSERT INTO `t_user_right` (`id`, `user_id`, `right_id`) VALUES
	(12, 1, 1);
/*!40000 ALTER TABLE `t_user_right` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
