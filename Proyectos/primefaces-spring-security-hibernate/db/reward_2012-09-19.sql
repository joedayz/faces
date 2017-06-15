# ************************************************************
# Sequel Pro SQL dump
# Version 3408
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.5.20)
# Database: reward
# Generation Time: 2012-09-19 09:26:19 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table app_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `app_user`;

CREATE TABLE `app_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_expired` bit(1) NOT NULL,
  `account_locked` bit(1) NOT NULL,
  `address` varchar(150) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `postal_code` varchar(15) DEFAULT NULL,
  `province` varchar(100) DEFAULT NULL,
  `credentials_expired` bit(1) NOT NULL,
  `email` varchar(255) NOT NULL,
  `account_enabled` bit(1) DEFAULT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `password_hint` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;

INSERT INTO `app_user` (`id`, `account_expired`, `account_locked`, `address`, `city`, `country`, `postal_code`, `province`, `credentials_expired`, `email`, `account_enabled`, `first_name`, `last_name`, `password`, `password_hint`, `phone_number`, `username`, `version`, `website`)
VALUES
	(1,b'0',b'0','','Denver','US','80210','CO',b'0','susan.inga@joedayz.pe',b'1','Susan','Inga','a564de63c2d0da68cf47586ee05984d7','admin','','admin',2,'');

/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(64) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;

INSERT INTO `role` (`id`, `description`, `name`)
VALUES
	(1,'Administrator role (can edit Users)','ROLE_ADMIN'),
	(2,'Default role for all Users','ROLE_USER');

/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_account
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_account`;

CREATE TABLE `t_account` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NUMBER` varchar(9) DEFAULT NULL,
  `NAME` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NUMBER` (`NUMBER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `t_account` WRITE;
/*!40000 ALTER TABLE `t_account` DISABLE KEYS */;

INSERT INTO `t_account` (`ID`, `NUMBER`, `NAME`)
VALUES
	(1,'123456789','Keith and Keri Donald'),
	(2,'123456002','Cornelia J. Andrese'),
	(3,'123456003','Coral Villareal Betancourt'),
	(4,'123456004','Chad I. Cobbs'),
	(5,'123456005','Michael C. Feller'),
	(6,'123456006','Michael J. Grover'),
	(7,'123456007','John C. Howard'),
	(8,'123456008','Ida Ketterer'),
	(9,'123456009','Laina Ochoa Lucero'),
	(10,'123456010','Wesley M. Mayo'),
	(11,'123456011','Leslie F. Mcclary'),
	(12,'123456012','John D. Mudra'),
	(13,'123456013','Pietronella J. Nielsen'),
	(14,'123456014','John S. Oleary'),
	(15,'123456015','Glenda D. Smith'),
	(16,'123456016','Willemina O. Thygesen'),
	(17,'123456017','Antje Vogt'),
	(18,'123456018','Julia Weber'),
	(19,'123456019','Mark T. Williams'),
	(20,'123456020','Christine J. Wilson');

/*!40000 ALTER TABLE `t_account` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_account_beneficiary
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_account_beneficiary`;

CREATE TABLE `t_account_beneficiary` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ACCOUNT_ID` bigint(20) DEFAULT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `ALLOCATION_PERCENTAGE` double NOT NULL,
  `SAVINGS` double NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ACCOUNT_ID` (`ACCOUNT_ID`,`NAME`),
  CONSTRAINT `FK_t_account_beneficiary` FOREIGN KEY (`ACCOUNT_ID`) REFERENCES `t_account` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `t_account_beneficiary` WRITE;
/*!40000 ALTER TABLE `t_account_beneficiary` DISABLE KEYS */;

INSERT INTO `t_account_beneficiary` (`ID`, `ACCOUNT_ID`, `NAME`, `ALLOCATION_PERCENTAGE`, `SAVINGS`)
VALUES
	(1,1,'Annabelle',0.5,0),
	(2,1,'Corgan',0.5,0),
	(3,3,'Antolin',0.25,0),
	(4,3,'Argus',0.25,0),
	(5,3,'Gian',0.25,0),
	(6,3,'Argeo',0.25,0),
	(7,8,'Kai',0.33,0),
	(8,8,'Kasper',0.33,0),
	(9,8,'Ernst',0.34,0),
	(10,12,'Brian',0.75,0),
	(11,12,'Shelby',0.25,0),
	(12,15,'Charles',0.5,0),
	(13,15,'Thomas',0.25,0),
	(14,15,'Neil',0.25,0),
	(15,17,'Daniel',1,0);

/*!40000 ALTER TABLE `t_account_beneficiary` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_account_credit_card
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_account_credit_card`;

CREATE TABLE `t_account_credit_card` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ACCOUNT_ID` bigint(20) DEFAULT NULL,
  `NUMBER` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ACCOUNT_ID` (`ACCOUNT_ID`,`NUMBER`),
  CONSTRAINT `FK_t_account_credit_card` FOREIGN KEY (`ACCOUNT_ID`) REFERENCES `t_account` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `t_account_credit_card` WRITE;
/*!40000 ALTER TABLE `t_account_credit_card` DISABLE KEYS */;

INSERT INTO `t_account_credit_card` (`ID`, `ACCOUNT_ID`, `NUMBER`)
VALUES
	(1,1,'1234123412341234'),
	(2,2,'1234123412340002'),
	(3,3,'1234123412340003'),
	(4,4,'1234123412340004'),
	(5,5,'1234123412340005'),
	(6,6,'1234123412340006'),
	(7,7,'1234123412340007'),
	(8,8,'1234123412340008'),
	(9,9,'1234123412340009'),
	(10,10,'1234123412340010'),
	(11,11,'1234123412340011'),
	(12,12,'1234123412340012'),
	(13,13,'1234123412340013'),
	(14,14,'1234123412340014'),
	(15,15,'1234123412340015'),
	(16,16,'1234123412340016'),
	(17,17,'1234123412340017'),
	(18,18,'1234123412340018'),
	(19,19,'1234123412340019'),
	(20,20,'1234123412340020');

/*!40000 ALTER TABLE `t_account_credit_card` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_restaurant
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_restaurant`;

CREATE TABLE `t_restaurant` (
  `ID` bigint(20) NOT NULL,
  `MERCHANT_NUMBER` varchar(10) NOT NULL,
  `NAME` varchar(80) NOT NULL,
  `BENEFIT_PERCENTAGE` double NOT NULL,
  `BENEFIT_AVAILABILITY_POLICY` varchar(1) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `MERCHANT_NUMBER` (`MERCHANT_NUMBER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `t_restaurant` WRITE;
/*!40000 ALTER TABLE `t_restaurant` DISABLE KEYS */;

INSERT INTO `t_restaurant` (`ID`, `MERCHANT_NUMBER`, `NAME`, `BENEFIT_PERCENTAGE`, `BENEFIT_AVAILABILITY_POLICY`)
VALUES
	(0,'1234567890','AppleBees',0.08,'A');

/*!40000 ALTER TABLE `t_restaurant` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_reward
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_reward`;

CREATE TABLE `t_reward` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CONFIRMATION_NUMBER` varchar(25) NOT NULL,
  `REWARD_AMOUNT` double NOT NULL,
  `REWARD_DATE` date NOT NULL,
  `ACCOUNT_NUMBER` varchar(9) NOT NULL,
  `DINING_AMOUNT` double NOT NULL,
  `DINING_MERCHANT_NUMBER` varchar(10) NOT NULL,
  `DINING_DATE` date NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CONFIRMATION_NUMBER` (`CONFIRMATION_NUMBER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK143BF46A9B523CC9` (`role_id`),
  KEY `FK143BF46A407D00A9` (`user_id`),
  CONSTRAINT `FK143BF46A407D00A9` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `FK143BF46A9B523CC9` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;

INSERT INTO `user_role` (`user_id`, `role_id`)
VALUES
	(1,1);

/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
