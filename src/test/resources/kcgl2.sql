-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.25 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  8.2.0.4675
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
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

-- 数据导出被取消选择。


-- 导出  表 kcgl.t_brand 结构
DROP TABLE IF EXISTS `t_brand`;
CREATE TABLE IF NOT EXISTS `t_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `flag` int(1) NOT NULL DEFAULT '1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品牌';

-- 数据导出被取消选择。


-- 导出  表 kcgl.t_cust 结构
DROP TABLE IF EXISTS `t_cust`;
CREATE TABLE IF NOT EXISTS `t_cust` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `flag` int(1) NOT NULL DEFAULT '1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户';

-- 数据导出被取消选择。


-- 导出  表 kcgl.t_func 结构
DROP TABLE IF EXISTS `t_func`;
CREATE TABLE IF NOT EXISTS `t_func` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `url` varchar(200) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 kcgl.t_identify 结构
DROP TABLE IF EXISTS `t_identify`;
CREATE TABLE IF NOT EXISTS `t_identify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 kcgl.t_manufactor 结构
DROP TABLE IF EXISTS `t_manufactor`;
CREATE TABLE IF NOT EXISTS `t_manufactor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品';

-- 数据导出被取消选择。


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='入库单';

-- 数据导出被取消选择。


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出库单';

-- 数据导出被取消选择。


-- 导出  表 kcgl.t_right 结构
DROP TABLE IF EXISTS `t_right`;
CREATE TABLE IF NOT EXISTS `t_right` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT '0',
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 kcgl.t_right_func 结构
DROP TABLE IF EXISTS `t_right_func`;
CREATE TABLE IF NOT EXISTS `t_right_func` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `right_id` int(11) NOT NULL,
  `func_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 kcgl.t_stock 结构
DROP TABLE IF EXISTS `t_stock`;
CREATE TABLE IF NOT EXISTS `t_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `identify_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存';

-- 数据导出被取消选择。


-- 导出  表 kcgl.t_tech 结构
DROP TABLE IF EXISTS `t_tech`;
CREATE TABLE IF NOT EXISTS `t_tech` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `flag` int(1) NOT NULL DEFAULT '1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工艺';

-- 数据导出被取消选择。


-- 导出  表 kcgl.t_thickness 结构
DROP TABLE IF EXISTS `t_thickness`;
CREATE TABLE IF NOT EXISTS `t_thickness` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `flag` int(1) NOT NULL DEFAULT '1',
  `create_user` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='厚度';

-- 数据导出被取消选择。


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 kcgl.t_user_right 结构
DROP TABLE IF EXISTS `t_user_right`;
CREATE TABLE IF NOT EXISTS `t_user_right` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `right_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
