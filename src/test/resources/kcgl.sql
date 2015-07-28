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
/*!40000 ALTER TABLE `t_brand` DISABLE KEYS */;
INSERT INTO `t_brand` (`id`, `name`, `flag`, `create_time`, `create_user`) VALUES
	(1, '品牌1', 1, '2015-07-28 13:14:30', 11);
/*!40000 ALTER TABLE `t_brand` ENABLE KEYS */;


-- 导出  表 kcgl.t_cust 结构
DROP TABLE IF EXISTS `t_cust`;
CREATE TABLE IF NOT EXISTS `t_cust` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `flag` int(1) NOT NULL DEFAULT '1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='客户';

-- 正在导出表  kcgl.t_cust 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `t_cust` DISABLE KEYS */;
INSERT INTO `t_cust` (`id`, `name`, `flag`, `create_time`, `create_user`) VALUES
	(4, '格纳斯', 1, '2015-03-12 10:33:47', 11);
/*!40000 ALTER TABLE `t_cust` ENABLE KEYS */;


-- 导出  表 kcgl.t_func 结构
DROP TABLE IF EXISTS `t_func`;
CREATE TABLE IF NOT EXISTS `t_func` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `url` varchar(200) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- 正在导出表  kcgl.t_func 的数据：~11 rows (大约)
/*!40000 ALTER TABLE `t_func` DISABLE KEYS */;
INSERT INTO `t_func` (`id`, `name`, `url`, `type`) VALUES
	(1, '权限管理', 'rightManage.xhtml', 0),
	(2, '用户管理', 'userManage.xhtml', 0),
	(3, '产品出库', 'productOutManage.xhtml', 1),
	(4, '产品入库', 'productInManage.xhtml', 1),
	(5, '价格调整', 'priceManage.xhtml', 1),
	(6, '总库存日报表', 'stockManage.xhtml', 2),
	(7, '型号查询次数统计表', '', 2),
	(8, '入库日报表', '', 2),
	(9, '出货日报表', '', 2),
	(10, '价格表', '', 2),
	(11, '佣金月报表', '', 2);
/*!40000 ALTER TABLE `t_func` ENABLE KEYS */;


-- 导出  表 kcgl.t_identify 结构
DROP TABLE IF EXISTS `t_identify`;
CREATE TABLE IF NOT EXISTS `t_identify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  kcgl.t_identify 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `t_identify` DISABLE KEYS */;
INSERT INTO `t_identify` (`id`, `name`) VALUES
	(1, '标识1');
/*!40000 ALTER TABLE `t_identify` ENABLE KEYS */;


-- 导出  表 kcgl.t_manufactor 结构
DROP TABLE IF EXISTS `t_manufactor`;
CREATE TABLE IF NOT EXISTS `t_manufactor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  kcgl.t_manufactor 的数据：~1 rows (大约)
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
  `identify_id` int(11) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `query_times` int(11) NOT NULL DEFAULT '0',
  `amount` int(11) NOT NULL,
  `create_user_id` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='产品';

-- 正在导出表  kcgl.t_product 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;
INSERT INTO `t_product` (`id`, `product_no`, `product_name`, `brand_id`, `tech_id`, `thickness_id`, `identify_id`, `price`, `query_times`, `amount`, `create_user_id`, `create_time`) VALUES
	(1, 'S1', '型号1', 1, 1, 1, 1, 200, 0, 871, 0, '2015-07-28 13:45:26');
/*!40000 ALTER TABLE `t_product` ENABLE KEYS */;


-- 导出  表 kcgl.t_product_in 结构
DROP TABLE IF EXISTS `t_product_in`;
CREATE TABLE IF NOT EXISTS `t_product_in` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `amount` int(11) NOT NULL,
  `manufactor_id` int(11) NOT NULL,
  `create_user_id` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='入库单';

-- 正在导出表  kcgl.t_product_in 的数据：~11 rows (大约)
/*!40000 ALTER TABLE `t_product_in` DISABLE KEYS */;
INSERT INTO `t_product_in` (`id`, `product_id`, `price`, `amount`, `manufactor_id`, `create_user_id`, `create_time`) VALUES
	(1, 1, 100, 1, 1, 1, '2015-07-28 13:45:26'),
	(2, 1, 200, 10, 0, 0, '2015-07-28 14:49:25'),
	(3, 1, 200, 0, 0, 1, '2015-07-28 16:43:42'),
	(4, 1, 200, 0, 0, 1, '2015-07-28 16:47:03'),
	(5, 1, 200, 200, 0, 1, '2015-07-28 17:22:01'),
	(6, 1, 200, 200, 0, 1, '2015-07-28 17:22:04'),
	(7, 1, 200, 200, 0, 1, '2015-07-28 17:22:06'),
	(8, 1, 200, 200, 0, 1, '2015-07-28 17:22:12'),
	(9, 1, 200, 20, 0, 1, '2015-07-28 17:22:15'),
	(10, 1, 200, 20, 0, 1, '2015-07-28 17:22:19'),
	(11, 1, 200, 20, 0, 1, '2015-07-28 17:22:34');
/*!40000 ALTER TABLE `t_product_in` ENABLE KEYS */;


-- 导出  表 kcgl.t_product_out 结构
DROP TABLE IF EXISTS `t_product_out`;
CREATE TABLE IF NOT EXISTS `t_product_out` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `amount` int(20) NOT NULL,
  `sale_price` double NOT NULL,
  `cust_name` varchar(200) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_user` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='出库单';

-- 正在导出表  kcgl.t_product_out 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_product_out` DISABLE KEYS */;
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
  `amount` int(11) DEFAULT NULL,
  `identify_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='库存';

-- 正在导出表  kcgl.t_stock 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `t_stock` DISABLE KEYS */;
INSERT INTO `t_stock` (`id`, `product_id`, `amount`, `identify_id`) VALUES
	(1, 0, NULL, 0),
	(2, 0, NULL, 0);
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
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`id`, `username`, `password`, `realname`, `status`, `createTime`, `updateTime`) VALUES
	(1, 'admin', 'admin', '超级管理员', 0, '2015-07-24 14:23:19', '2015-07-28 09:58:29'),
	(2, 'zx', 'zx', '张三', 0, '2015-07-26 09:35:37', '2015-07-26 09:35:37'),
	(3, 'ls', 'ls', '李四', 1, '2015-07-26 09:35:50', '2015-07-28 09:59:01');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;


-- 导出  表 kcgl.t_user_right 结构
DROP TABLE IF EXISTS `t_user_right`;
CREATE TABLE IF NOT EXISTS `t_user_right` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `right_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- 正在导出表  kcgl.t_user_right 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `t_user_right` DISABLE KEYS */;
INSERT INTO `t_user_right` (`id`, `user_id`, `right_id`) VALUES
	(12, 1, 1);
/*!40000 ALTER TABLE `t_user_right` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
