-- MySQL dump 10.13  Distrib 5.6.24, for osx10.8 (x86_64)
--
-- Host: localhost    Database: hrms_db
-- ------------------------------------------------------
-- Server version	5.6.24-enterprise-commercial-advanced

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `candidate`
--

DROP TABLE IF EXISTS `candidate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `idNumber` varchar(30) NOT NULL,
  `ethnicity` varchar(30) NOT NULL,
  `degree` varchar(50) NOT NULL,
  `politicalStatus` varchar(50) NOT NULL,
  `bornAddress` varchar(200) NOT NULL,
  `currentAddress` varchar(200) NOT NULL,
  `bank` varchar(100) NOT NULL,
  `bankAccount` varchar(50) NOT NULL,
  `emergencyContactName` varchar(20) NOT NULL,
  `emergencyContactPhone` varchar(20) NOT NULL,
  `emergencyContactRelationship` varchar(30) NOT NULL,
  `jpaVersion` int(11) NOT NULL,
  `createdBy` varchar(20) NOT NULL,
  `createdTime` datetime NOT NULL,
  `lastUpdatedBy` varchar(20) NOT NULL,
  `lastUpdatedTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='候选人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate`
--

LOCK TABLES `candidate` WRITE;
/*!40000 ALTER TABLE `candidate` DISABLE KEYS */;
INSERT INTO `candidate` VALUES (3,'刘云飞','MALE','15128903890','321283193009844','汉族','大专','党员','浦东新区张江路1号','浦东新区张江路1号','中国银行','3445-6598-0998-4083','张飞','13128903891','朋友',2,'admin','2019-09-21 21:35:14','admin','2019-09-22 11:31:12'),(10,'张飞','MALE','12345678901','321283199903027214','汉族','本科','党员','浦东新区张江高科1号','浦东新区张江高科2号','中国银行','3445-6598-0998-4083','张飞','13128903891','朋友',1,'admin','2019-09-23 22:02:34','admin','2019-09-23 22:02:34'),(11,'刘丽','FEMALE','15672348901','521283199903027290','汉族','本科','党员','浦东新区张江高科1号','浦东新区张江高科2号','中国银行','3445-6598-0998-4083','张飞','13128903891','朋友',1,'admin','2019-09-23 22:02:34','admin','2019-09-23 22:02:34'),(12,'赵云','MALE','10112345678','721283199903027x78','汉族','本科','党员','浦东新区张江高科1号','浦东新区张江高科2号','中国银行','3445-6598-0998-4083','张飞','13128903891','朋友',1,'admin','2019-09-23 22:02:34','admin','2019-09-23 22:02:34'),(13,'李强','MALE','16789011234','412283199903027215','汉族','本科','党员','浦东新区张江高科1号','浦东新区张江高科2号','中国银行','3445-6598-0998-4083','张飞','13128903891','朋友',1,'admin','2019-09-23 22:02:34','admin','2019-09-23 22:02:34'),(14,'陈冰','FEMALE','14125678901','621283199903027267','汉族','本科','党员','浦东新区张江高科1号','浦东新区张江高科2号','中国银行','3445-6598-0998-4083','张飞','13128903891','朋友',1,'admin','2019-09-23 22:02:34','admin','2019-09-23 22:02:34');
/*!40000 ALTER TABLE `candidate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `number` varchar(20) NOT NULL,
  `manager` varchar(20) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `jpaVersion` int(11) NOT NULL,
  `createdBy` varchar(20) NOT NULL,
  `createdTime` datetime NOT NULL,
  `lastUpdatedBy` varchar(20) NOT NULL,
  `lastUpdatedTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='公司部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'财务','001','赵飞','15685638704',12,'admin','2019-08-19 22:17:41','admin','2019-09-07 10:50:50'),(2,'销售','002','刘春燕','14565638701',0,'admin','2019-08-19 22:17:41','admin','2019-08-19 22:17:41'),(3,'后勤','003','刘勇','16265732724',0,'admin','2019-08-19 22:17:42','admin','2019-08-19 22:17:42'),(5,'研发','004','张力','0273697573',1,'admin','2019-08-20 22:39:59','admin','2019-08-20 22:39:59'),(7,'客服','006','张什么','0273697573',1,'admin','2019-09-07 10:16:57','admin','2019-09-07 10:16:57');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(50) NOT NULL,
  `city` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` varchar(20) NOT NULL,
  `salaryRange` varchar(50) NOT NULL,
  `quota` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  `referralBonus` tinyint(1) NOT NULL DEFAULT '1',
  `referralBonusAmount` int(11) NOT NULL,
  `note` varchar(20) NOT NULL,
  `jpaVersion` int(11) NOT NULL,
  `createdBy` varchar(20) NOT NULL,
  `createdTime` datetime NOT NULL,
  `lastUpdatedBy` varchar(20) NOT NULL,
  `lastUpdatedTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='企业职位表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,'盒马生鲜','上海','骑手','0','7000-9000',50,1,1,1000,'10月底有效！！！',1,'admin','2019-08-28 21:11:43','james','2019-08-28 21:11:43');
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobApplication`
--

DROP TABLE IF EXISTS `jobApplication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobApplication` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jobId` int(11) NOT NULL,
  `candidateId` int(11) NOT NULL,
  `referee` varchar(20) DEFAULT NULL,
  `refereePhone` varchar(20) DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  `onBoardedTime` datetime DEFAULT NULL,
  `resignedTime` datetime DEFAULT NULL,
  `jpaVersion` int(11) NOT NULL,
  `createdBy` varchar(20) NOT NULL,
  `createdTime` datetime NOT NULL,
  `lastUpdatedBy` varchar(20) NOT NULL,
  `lastUpdatedTime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `jobId` (`jobId`),
  KEY `candidateId` (`candidateId`),
  CONSTRAINT `jobapplication_ibfk_1` FOREIGN KEY (`jobId`) REFERENCES `job` (`id`),
  CONSTRAINT `jobapplication_ibfk_2` FOREIGN KEY (`candidateId`) REFERENCES `candidate` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='求职信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobApplication`
--

LOCK TABLES `jobApplication` WRITE;
/*!40000 ALTER TABLE `jobApplication` DISABLE KEYS */;
INSERT INTO `jobApplication` VALUES (1,1,3,'张群','15790476239','WAITING_INTERVIEW',NULL,NULL,1,'gary','2019-10-14 22:49:32','gary','2019-10-14 22:49:32');
/*!40000 ALTER TABLE `jobApplication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `password` varchar(120) NOT NULL,
  `name` varchar(20) NOT NULL,
  `authority` int(1) DEFAULT NULL,
  `jpaVersion` int(11) NOT NULL,
  `createdBy` varchar(20) NOT NULL,
  `createdTime` datetime NOT NULL,
  `lastUpdatedBy` varchar(20) NOT NULL,
  `lastUpdatedTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='后台用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','86888061b399e74e30eeead8c7aab922','administrator',1,0,'admin','2019-08-19 22:16:32','admin','2019-08-19 22:16:32'),(2,'gary','010787e658be76708b40aa336e482293','gary',0,12,'admin','2019-08-19 22:16:32','admin','2019-09-12 21:06:47');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-14 23:28:09
