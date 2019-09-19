-- MySQL dump 10.13  Distrib 5.6.24, for osx10.8 (x86_64)
--
-- Host: localhost    Database: hrms_db
-- ------------------------------------------------------
-- Server version 5.6.24-enterprise-commercial-advanced

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='候选人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate`
--

LOCK TABLES `candidate` WRITE;
/*!40000 ALTER TABLE `candidate` DISABLE KEYS */;
INSERT INTO `candidate` VALUES (1,'刘力','MALE','12334564543','321283193009845','上海','浦东新区张江川北公路1号',2,'admin','2019-08-22 22:44:27','admin','2019-08-22 22:44:27'),(2,'张勇','MALE','123456722342','321283193009845','上海','浦东新区张江川北公路1号',1,'admin','2019-08-24 23:09:44','admin','2019-08-24 23:09:44');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='公司部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'财务','001','赵飞','15685638704',3,'admin','2019-08-19 22:17:41','admin','2019-08-19 22:17:41'),(2,'销售','002','刘春燕','14565638701',0,'admin','2019-08-19 22:17:41','admin','2019-08-19 22:17:41'),(3,'后勤','003','刘勇','16265732724',0,'admin','2019-08-19 22:17:42','admin','2019-08-19 22:17:42'),(5,'研发','004','张力','0273697573',1,'admin','2019-08-20 22:39:59','admin','2019-08-20 22:39:59');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业职位表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
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
  `jpaVersion` int(11) NOT NULL,
  `createdBy` varchar(20) NOT NULL,
  `createdTime` datetime NOT NULL,
  `lastUpdatedBy` varchar(20) NOT NULL,
  `lastUpdatedTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='后台用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','81dd6e3a5c7dd1c701201ef5a2e59f6100e3ac0baa10eb5b14600bc18b29cdeaa7ac97ef816a471d','administrator',0,'admin','2019-08-19 22:16:32','admin','2019-08-19 22:16:32');
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

-- Dump completed on 2019-08-27 22:20:22
