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
-- Table structure for table `JobQuota`
--

DROP TABLE IF EXISTS `JobQuota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `JobQuota` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jobId` int(11) NOT NULL,
  `month` varchar(20) NOT NULL,
  `quota` int(11) NOT NULL,
  `jpaVersion` int(11) NOT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `createdTime` datetime NOT NULL,
  `lastUpdater` varchar(20) DEFAULT NULL,
  `lastUpdatedTime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `jobId` (`jobId`),
  CONSTRAINT `jobquota_ibfk_1` FOREIGN KEY (`jobId`) REFERENCES `job` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='职位指标';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `JobQuota`
--

LOCK TABLES `JobQuota` WRITE;
/*!40000 ALTER TABLE `JobQuota` DISABLE KEYS */;
/*!40000 ALTER TABLE `JobQuota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applicationReport`
--

DROP TABLE IF EXISTS `applicationReport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applicationReport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `start` datetime NOT NULL,
  `end` datetime NOT NULL,
  `newApplied` int(11) NOT NULL,
  `newInterviewed` int(11) NOT NULL,
  `newOnboarded` int(11) NOT NULL,
  `type` varchar(20) NOT NULL,
  `jpaVersion` int(11) NOT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `createdTime` datetime NOT NULL,
  `lastUpdater` varchar(20) DEFAULT NULL,
  `lastUpdatedTime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  CONSTRAINT `applicationReport_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='求职报表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicationReport`
--

LOCK TABLES `applicationReport` WRITE;
/*!40000 ALTER TABLE `applicationReport` DISABLE KEYS */;
INSERT INTO `applicationReport` VALUES (1,2,'2019-11-04 21:11:43','2019-11-10 21:11:43',20,5,3,'WEEKLY',1,NULL,'2019-08-28 21:11:43',NULL,'2019-11-01 22:27:25'),(2,2,'2019-10-28 21:11:43','2019-11-03 21:11:43',15,7,6,'WEEKLY',1,'1','2019-08-28 21:11:43','1','2019-11-01 22:27:25');
/*!40000 ALTER TABLE `applicationReport` ENABLE KEYS */;
UNLOCK TABLES;

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
  `creator` varchar(20) DEFAULT NULL,
  `createdTime` datetime NOT NULL,
  `lastUpdater` varchar(20) DEFAULT NULL,
  `lastUpdatedTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='公司部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (8,'康兰劳务浦西店','上海市长宁区江苏路209号','刘春燕','12345678912',3,NULL,'2019-10-29 21:41:35',NULL,'2019-11-01 21:59:07'),(9,'康兰劳务张江店','上海浦东新区张江露1号','张婕','14223894872',1,NULL,'2019-11-01 19:38:57',NULL,'2019-11-01 19:38:57');
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
  `creator` varchar(20) DEFAULT NULL,
  `createdTime` datetime NOT NULL,
  `lastUpdater` varchar(20) DEFAULT NULL,
  `lastUpdatedTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='候选人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate`
--

LOCK TABLES `candidate` WRITE;
/*!40000 ALTER TABLE `candidate` DISABLE KEYS */;
INSERT INTO `candidate` VALUES (3,'刘云飞','MALE','15128903892','321283193009845','汉','大专','党员','浦东新区张江路1号','浦东新区张江路1号','中国银行','3445-6598-0998-4083','张飞','13128903891','朋友',9,NULL,'2019-09-21 21:35:14','admin','2019-11-10 18:08:34'),(18,'王彭','MALE','15388936672','412702200210145511','汉','高中','群众','河南省周口市项城市王明口镇后彭庄村','上海市浦东新区唐镇','光大银行','6214920605028842','王付强','17634773219','父亲',2,NULL,'2019-10-28 21:12:12','admin','2019-11-10 18:08:15'),(19,'王飞飞','MALE','13598506150','410823198303277000','汉','初中','群众','南省焦作市武陟县圪垱店乡邢庄村青年东街22号','上海市浦东新区曹路镇朱盛村78号','光大银行','6226630604693514','王玲','15939187526','配偶',1,NULL,'2019-10-28 21:12:12',NULL,'2019-10-28 21:12:12');
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
  `creator` varchar(20) DEFAULT NULL,
  `createdTime` datetime NOT NULL,
  `lastUpdater` varchar(20) DEFAULT NULL,
  `lastUpdatedTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='企业职位表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,'盒马生鲜','上海','浦东新区','张江路2000号','骑手','FULL_TIME','8000-9000',90,1,1,1000,'',8,NULL,'2019-08-28 21:11:43',NULL,'2019-11-01 22:27:25'),(2,'盒马生鲜','上海','长宁','长宁区江苏路108号','仓库管理员','FULL_TIME','6000-6500',10,1,0,0,'',1,NULL,'2019-11-03 14:26:56',NULL,'2019-11-03 14:26:56'),(3,'海底捞','上海','浦东新区','高科西路108号','服务员','FULL_TIME','6000-9000',30,1,1,1000,'',1,'admin','2019-11-16 21:20:49','admin','2019-11-16 21:20:49');
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
  `interviewDate` datetime DEFAULT NULL,
  `onboardDate` datetime DEFAULT NULL,
  `resignDate` datetime DEFAULT NULL,
  `jpaVersion` int(11) NOT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `createdTime` datetime NOT NULL,
  `lastUpdater` varchar(20) DEFAULT NULL,
  `lastUpdatedTime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `jobId` (`jobId`),
  KEY `candidateId` (`candidateId`),
  CONSTRAINT `jobapplication_ibfk_1` FOREIGN KEY (`jobId`) REFERENCES `job` (`id`),
  CONSTRAINT `jobapplication_ibfk_2` FOREIGN KEY (`candidateId`) REFERENCES `candidate` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='求职信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobApplication`
--

LOCK TABLES `jobApplication` WRITE;
/*!40000 ALTER TABLE `jobApplication` DISABLE KEYS */;
INSERT INTO `jobApplication` VALUES (1,1,3,'张群2','15790476239','RESIGNED','2019-10-16 21:28:29','2019-10-20 21:28:29','2019-10-28 21:28:29','2019-11-13 23:22:55',6,NULL,'2019-10-14 22:49:32','admin','2019-11-13 23:22:55'),(4,1,19,'王力宏','134578932556','ON_BOARDED_ONE_MONTH','2019-10-15 21:28:29','2019-10-16 21:28:29','2019-10-20 21:28:29',NULL,4,NULL,'2019-11-01 19:43:11','admin','2019-11-16 21:21:08'),(9,1,19,'刘四','123563546346','ON_BOARDED','2019-10-13 21:28:29','2019-10-15 21:28:29','2019-10-20 21:28:29',NULL,2,NULL,'2019-11-01 22:27:15','admin','2019-11-16 21:21:25'),(10,2,19,'张亮','19803887745','WAITING_INTERVIEW','2019-10-29 21:28:29','2019-11-22 21:28:29',NULL,NULL,1,NULL,'2019-11-03 14:27:41',NULL,'2019-11-03 14:27:41'),(13,3,18,'','','WAITING_INTERVIEW','2019-11-15 00:00:00',NULL,NULL,NULL,2,'admin','2019-11-17 22:05:45','admin','2019-11-17 22:20:05');
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
  `creator` varchar(20) DEFAULT NULL,
  `createdTime` datetime NOT NULL,
  `lastUpdater` varchar(20) DEFAULT NULL,
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
  `creator` varchar(20) DEFAULT NULL,
  `createdTime` datetime NOT NULL,
  `lastUpdater` varchar(20) DEFAULT NULL,
  `lastUpdatedTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='后台用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','86888061b399e74e30eeead8c7aab922','administrator',1,0,NULL,'2019-08-19 22:16:32',NULL,'2019-08-19 22:16:32'),(2,'gary','010787e658be76708b40aa336e482293','gary',0,12,NULL,'2019-08-19 22:16:32',NULL,'2019-09-12 21:06:47'),(3,'james','ccafb510f7510f31d1831233f39b29c9','james',0,1,NULL,'2019-11-03 16:35:51',NULL,'2019-11-03 16:35:51');
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

-- Dump completed on 2019-11-17 23:23:18
