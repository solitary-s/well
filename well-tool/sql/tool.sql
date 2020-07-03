/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.7.24 : Database - well
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`well` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `well`;

/*Table structure for table `e_emp_employee` */

DROP TABLE IF EXISTS `e_emp_employee`;

CREATE TABLE `e_emp_employee` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `NAME` varchar(60) NOT NULL COMMENT '名称',
  `AGE` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `e_emp_employee` */

/*Table structure for table `e_emp_personal` */

DROP TABLE IF EXISTS `e_emp_personal`;

CREATE TABLE `e_emp_personal` (
  `ID` bigint(20) NOT NULL COMMENT 'ID',
  `EMP_ID` bigint(20) NOT NULL COMMENT 'EMP_ID',
  `CARD_ID` varchar(100) DEFAULT NULL COMMENT '身份证号码',
  `CARD_NAME` varchar(100) DEFAULT NULL COMMENT '身份证姓名',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `e_emp_personal` */

/*Table structure for table `gen_table` */

DROP TABLE IF EXISTS `gen_table`;

CREATE TABLE `gen_table` (
  `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) DEFAULT '' COMMENT '表描述',
  `class_name` varchar(100) DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) DEFAULT NULL COMMENT '生成功能作者',
  `options` varchar(1000) DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='代码生成业务表';

/*Data for the table `gen_table` */

insert  into `gen_table`(`table_id`,`table_name`,`table_comment`,`class_name`,`tpl_category`,`package_name`,`module_name`,`business_name`,`function_name`,`function_author`,`options`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values 
(1,'e_emp_employee','员工信息','EmpEmployee','crud','com.aloneness.well.emp','emp','employee','employee','aloneness','{}','admin','2020-06-08 19:42:08','','2020-06-12 15:33:56',NULL),
(2,'e_emp_personal','个人信息','EmpPersonal','crud','com.aloneness.well.emp','emp','personal','personal','aloneness','{}','admin','2020-06-12 15:01:35','','2020-06-12 15:28:11',NULL);

/*Table structure for table `gen_table_column` */

DROP TABLE IF EXISTS `gen_table_column`;

CREATE TABLE `gen_table_column` (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) DEFAULT '' COMMENT '字典类型',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='代码生成业务表字段';

/*Data for the table `gen_table_column` */

insert  into `gen_table_column`(`column_id`,`table_id`,`column_name`,`column_comment`,`column_type`,`java_type`,`java_field`,`is_pk`,`is_increment`,`is_required`,`is_insert`,`is_edit`,`is_list`,`is_query`,`query_type`,`html_type`,`dict_type`,`sort`,`create_by`,`create_time`,`update_by`,`update_time`) values 
(1,'1','ID','ID','bigint(20)','Long','id','1','1',NULL,'1',NULL,NULL,NULL,'EQ','input','',1,'admin','2020-06-08 19:42:08','','2020-06-12 15:33:56'),
(2,'1','NAME','名称','varchar(60)','String','name','0','0','1','1','1','1','1','LIKE','input','',2,'admin','2020-06-08 19:42:08','','2020-06-12 15:33:56'),
(3,'1','AGE','年龄','int(11)','Integer','age','0','0',NULL,'1','1','1','1','EQ','input','',3,'admin','2020-06-08 19:42:08','','2020-06-12 15:33:56'),
(4,'2','ID','ID','bigint(20)','Long','id','1','0',NULL,'1',NULL,NULL,NULL,'EQ','input','',1,'admin','2020-06-12 15:01:35','','2020-06-12 15:28:11'),
(5,'2','EMP_ID','EMP_ID','bigint(20)','Long','empId','0','0','1','1','1','1','1','EQ','input','',2,'admin','2020-06-12 15:01:35','','2020-06-12 15:28:11'),
(6,'2','CARD_ID','身份证号码','varchar(100)','String','cardId','0','0',NULL,'1','1','1','1','EQ','input','',3,'admin','2020-06-12 15:01:35','','2020-06-12 15:28:11'),
(7,'2','CARD_NAME','身份证姓名','varchar(100)','String','cardName','0','0',NULL,'1','1','1','1','LIKE','input','',4,'admin','2020-06-12 15:01:35','','2020-06-12 15:28:11');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
