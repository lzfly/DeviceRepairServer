/*
SQLyog v10.2 
MySQL - 5.7.20-log : Database - devicerepair
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`devicerepair` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `devicerepair`;

/*Table structure for table `check_cycle` */

DROP TABLE IF EXISTS `check_cycle`;

CREATE TABLE `check_cycle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `check_cycle` */

/*Table structure for table `check_plan` */

DROP TABLE IF EXISTS `check_plan`;

CREATE TABLE `check_plan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `device_id` bigint(20) DEFAULT NULL,
  `device_name` varchar(64) DEFAULT NULL,
  `check_type` varchar(64) DEFAULT NULL,
  `owner_name` varchar(64) DEFAULT NULL,
  `project` varchar(128) DEFAULT NULL,
  `check_cycle` varchar(128) DEFAULT NULL,
  `check_state` varchar(64) DEFAULT NULL,
  `company` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `check_plan` */

insert  into `check_plan`(`id`,`start_date`,`end_date`,`device_id`,`device_name`,`check_type`,`owner_name`,`project`,`check_cycle`,`check_state`,`company`) values (2,'2018-01-02','2018-02-03',1,'dev1','1','lu','pr1','3','ok','lapsen');

/*Table structure for table `check_state` */

DROP TABLE IF EXISTS `check_state`;

CREATE TABLE `check_state` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `check_state` */

/*Table structure for table `check_type` */

DROP TABLE IF EXISTS `check_type`;

CREATE TABLE `check_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `check_type` */

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `company` */

/*Table structure for table `device` */

DROP TABLE IF EXISTS `device`;

CREATE TABLE `device` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `sn` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `region` varchar(256) DEFAULT NULL,
  `type` varchar(64) DEFAULT NULL,
  `factory` varchar(128) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `owner_name` varchar(64) DEFAULT NULL,
  `company` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `device` */

insert  into `device`(`id`,`sn`,`name`,`region`,`type`,`factory`,`date`,`owner_name`,`company`) values (2,'3435435435435','dev1','beijing','robot','lapsen','2018-02-09','lu','lapsen'),(3,'3435435435435','dev1','beijing','robot','lapsen','2018-02-09','lu','lapsen'),(4,'3435435435435','dev1','beijing','robot','lapsen','2018-02-09','lu','lapsen');

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `project` */

/*Table structure for table `repair_item` */

DROP TABLE IF EXISTS `repair_item`;

CREATE TABLE `repair_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `device_id` bigint(20) DEFAULT NULL,
  `device_name` varchar(128) DEFAULT NULL,
  `discription` varchar(256) DEFAULT NULL,
  `audio_path` varchar(256) DEFAULT NULL,
  `picture_path` varchar(256) DEFAULT NULL,
  `check_owner` varchar(64) DEFAULT NULL,
  `check_time` datetime DEFAULT NULL,
  `accept_owner` varchar(64) DEFAULT NULL,
  `accept_time` datetime DEFAULT NULL,
  `repair_state` varchar(64) DEFAULT NULL,
  `repair_owner` varchar(64) DEFAULT NULL,
  `repair_time` datetime DEFAULT NULL,
  `company` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `repair_item` */

insert  into `repair_item`(`id`,`device_id`,`device_name`,`discription`,`audio_path`,`picture_path`,`check_owner`,`check_time`,`accept_owner`,`accept_time`,`repair_state`,`repair_owner`,`repair_time`,`company`) values (2,1,'dev1','错了','/audio.mp3','/picture.png','lu','2018-02-24 01:30:45','lu','2018-02-24 05:30:46','fail','luoiefly','2018-02-24 06:20:35','lapsen'),(3,1,'dev1','错了','/audio.mp3','/picture.png','lu','2018-02-09 01:30:45','lu','2018-02-09 05:30:46','ok','luoie','2018-02-09 06:20:35','lapsen');

/*Table structure for table `repair_state` */

DROP TABLE IF EXISTS `repair_state`;

CREATE TABLE `repair_state` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `state` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `repair_state` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`name`) values (1,'ROLE_AUTHOR'),(2,'ROLE_USER'),(3,'ROLE_VISITER');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `email` varchar(32) NOT NULL,
  `role` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `password` varchar(128) NOT NULL,
  `last_password_reset_date` datetime DEFAULT NULL,
  `phone` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `phone` (`phone`) USING BTREE,
  KEY `fk_role` (`role`) USING BTREE,
  KEY `email` (`email`) USING BTREE,
  CONSTRAINT `FKl5alypubd40lwejc45vl35wjb` FOREIGN KEY (`role`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`email`,`role`,`create_time`,`password`,`last_password_reset_date`,`phone`) values (12,'jhq','1044038054@qq.com',2,'2017-10-16 23:37:58','$2a$10$RpWEAz9vvnjKwbUoaNyuKuyzDHDlnUMnpQFWrlIZH0z1Zr7Zn5PBC','2017-10-16 23:37:58','15700084693'),(13,'jhq','1044038054@qq.com',2,'2017-10-17 07:38:40','$2a$10$3blZnGvgjyk9QAMA3U/.kOaTMqwdNAygMwUxR/Tnnabj.MvIbcEO6','2017-10-17 07:38:40','15700084694'),(14,'luoie','luoiefly@163.com',1,'2018-02-19 13:04:49','$2a$10$jCV7w6NciZbNlXcHBcSgWOXKpULPKHxXn/tGWtIIhM/nQ5WNTPS2m','2018-02-19 13:04:49','13810501286');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
