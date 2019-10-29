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
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `address` varchar(200) NOT NULL,
  `manager` varchar(20) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `jpaVersion` int(11) NOT NULL,
  `createdBy` varchar(20) NOT NULL,
  `createdTime` datetime NOT NULL,
  `lastUpdatedBy` varchar(20) NOT NULL,
  `lastUpdatedTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='公司部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (8,'康兰劳务','浦东新区川北公路1号','张杰','12345678911',1,'admin','2019-10-29 21:41:35','admin','2019-10-29 21:41:35');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='候选人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate`
--

LOCK TABLES `candidate` WRITE;
/*!40000 ALTER TABLE `candidate` DISABLE KEYS */;
INSERT INTO `candidate` VALUES (3,'刘云飞','MALE','15128903893','321283193009844','汉','大专','党员','浦东新区张江路1号','浦东新区张江路1号','中国银行','3445-6598-0998-4083','张飞','13128903891','朋友',7,'gary','2019-09-21 21:35:14','admin','2019-10-25 00:51:25'),(10,'张飞','MALE','12345678908','321283199903027214','汉','本科','党员','浦东新区张江高科1号','浦东新区张江高科2号','中国银行','3445-6598-0998-4083','张飞','13128903891','朋友',10,'admin','2019-09-23 22:02:34','admin','2019-10-17 21:45:48'),(18,'王彭','MALE','15388936671','412702200210145511','汉','高中','群众','河南省周口市项城市王明口镇后彭庄村','上海市浦东新区唐镇','光大银行','6214920605028842','王付强','17634773219','父亲',1,'admin','2019-10-28 21:12:12','admin','2019-10-28 21:12:12'),(19,'王飞飞','MALE','13598506150','410823198303277000','汉','初中','群众','南省焦作市武陟县圪垱店乡邢庄村青年东街22号','上海市浦东新区曹路镇朱盛村78号','光大银行','6226630604693514','王玲','15939187526','配偶',1,'admin','2019-10-28 21:12:12','admin','2019-10-28 21:12:12');
/*!40000 ALTER TABLE `candidate` ENABLE KEYS */;
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
  `district` varchar(40) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
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
INSERT INTO `job` VALUES (1,'盒马生鲜','上海','浦东新区','张江路2000号','骑手','1','8000-9000',50,1,1,1000,'',5,'gary','2019-08-28 21:11:43','admin','2019-10-17 21:45:59');
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
  `applicationDate` datetime DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='求职信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobApplication`
--

LOCK TABLES `jobApplication` WRITE;
/*!40000 ALTER TABLE `jobApplication` DISABLE KEYS */;
INSERT INTO `jobApplication` VALUES (1,1,3,'张群2','15790476239','NEW','2019-10-22 00:00:00',NULL,NULL,3,'gary','2019-10-14 22:49:32','admin','2019-10-23 17:58:48'),(2,1,3,'刘四','0273697573','NEW','2019-10-22 00:00:00',NULL,NULL,1,'admin','2019-10-22 20:31:14','admin','2019-10-22 20:31:14');
/*!40000 ALTER TABLE `jobApplication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referralBonus`
--

DROP TABLE IF EXISTS `referralBonus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referralBonus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `applicationId` int(11) NOT NULL,
  `status` varchar(20) NOT NULL,
  `approvedDate` datetime DEFAULT NULL,
  `transferredDate` datetime DEFAULT NULL,
  `jpaVersion` int(11) NOT NULL,
  `createdBy` varchar(20) NOT NULL,
  `createdTime` datetime NOT NULL,
  `lastUpdatedBy` varchar(20) NOT NULL,
  `lastUpdatedTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='推荐奖金';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referralBonus`
--

LOCK TABLES `referralBonus` WRITE;
/*!40000 ALTER TABLE `referralBonus` DISABLE KEYS */;
/*!40000 ALTER TABLE `referralBonus` ENABLE KEYS */;
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

-- Dump completed on 2019-10-29 21:49:15
