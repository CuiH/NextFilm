-- MySQL dump 10.13  Distrib 5.7.11, for Win64 (x86_64)
--
-- Host: localhost    Database: nextfilm
-- ------------------------------------------------------
-- Server version	5.7.11

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
-- Table structure for table `actor`
--

DROP TABLE IF EXISTS `actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `image_url` varchar(200) DEFAULT NULL,
  `brief` varchar(80) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor`
--

LOCK TABLES `actor` WRITE;
/*!40000 ALTER TABLE `actor` DISABLE KEYS */;
INSERT INTO `actor` VALUES (2,'汤姆·赫兰德','https://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=907665c6768da9775a228e79d138937c/b3b7d0a20cf431ad1109e5cc4e36acaf2fdd9868.jpg','英国男演员。','1996-06-01'),(3,'小罗伯特·唐尼','https://gss3.bdstatic.com/7Po3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike272%2C5%2C5%2C272%2C90/sign=ce42877564061d95694b3f6a1a9d61b4/4e4a20a4462309f7f711535f780e0cf3d7cad605.jpg','美国电影演员、制片人。','1965-04-04'),(4,'乔·沃茨','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2690380547,1558424725&fm=11&gp=0.jpg','美国电影导演、制片人和编剧。','1981-06-28'),(5,'马特·里夫斯','https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=ac6e88bb798da9775a228e79d138937c/96dda144ad3459825449ae1a06f431adcaef8473.jpg','电影导演、编剧、制片。','1996-04-27'),(6,'安迪·瑟金斯','https://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike180%2C5%2C5%2C180%2C60/sign=c9c576c9a064034f1bc0ca54ceaa1254/9f2f070828381f306b1a35bda2014c086e06f0a7.jpg','英国演员、导演。','1964-04-20'),(7,'伍迪·哈里森','https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike180%2C5%2C5%2C180%2C60/sign=d19cb4a3e250352aa56c2d5a322a9097/37d12f2eb9389b50a4ad5b468e35e5dde7116e50.jpg','美国演员。','1961-07-23'),(8,'奥利奥尔·保罗','http://img5.mtime.cn/ph/2017/08/25/104102.28770688_290X440X4.jpg','西班牙导演。','1975-01-01'),(9,'马里奥·卡萨斯','https://gss3.bdstatic.com/7Po3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike180%2C5%2C5%2C180%2C60/sign=653ac8687a8b4710da22f59ea2a7a898/d833c895d143ad4b0e8876898a025aafa50f06d0.jpg','西班牙演员。','1986-06-12'),(10,'佩雷·布拉索','https://img3.doubanio.com/img/celebrity/medium/1490064259.25.jpg','西班牙演员','1978-06-22');
/*!40000 ALTER TABLE `actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cinema`
--

DROP TABLE IF EXISTS `cinema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cinema` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `city_code` varchar(10) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `brief` varchar(80) DEFAULT NULL,
  `image_url` varchar(200) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinema`
--

LOCK TABLES `cinema` WRITE;
/*!40000 ALTER TABLE `cinema` DISABLE KEYS */;
INSERT INTO `cinema` VALUES (1,'广州飞扬影城-正佳IMAX店','100000','天河路228号正佳广场七楼（体育中心站 D出口）','020-85590911','位于天和商业区，正佳广场7层。','https://img.alicdn.com/bao/uploaded/TB1hPU1FFXXXXcvaXXXSutbFXXX','公司集体活动：包场看电影、会议、电影兑换券、贵宾充值卡 品牌宣传活动：映前广告、现场活动、灯箱广告、 电话：020-85596002'),(2,'五一影城广州四季天地店','100000','广州市海珠区赤岗北路118号四季天地3楼','020-34329288 ','营业时间：9:30-02:00（次日）','https://img.alicdn.com/bao/uploaded/T1cZuAFo4dXXb1upjX','影院外部：KFC、渔乐现场、菌香园、炉火鱼香时尚烤鱼主题餐厅、叁点叁时尚餐厅、大碗厨、星巴克、刘氏小龙虾、麻田'),(3,'广州UA IMAX花城汇电影城','100000','广州市天河区珠江新城花城广场花城汇负一层1130铺（花城广场入口靠近黄埔大道）','020-34329288','营业时间：9:30-02:00（次日）','https://img.alicdn.com/bao/uploaded/T1fPmCFblXXXb1upjX','影院外部：KFC、渔乐现场、菌香园、炉火鱼香时尚烤鱼主题餐厅、叁点叁时尚餐厅、大碗厨、星巴克、刘氏小龙虾、麻田');
/*!40000 ALTER TABLE `cinema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `alias` varchar(80) DEFAULT NULL,
  `brief` varchar(80) DEFAULT NULL,
  `language` varchar(40) DEFAULT NULL,
  `length` varchar(40) DEFAULT NULL,
  `on_date` date DEFAULT NULL,
  `image_url` varchar(200) DEFAULT NULL,
  `category` varchar(40) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film`
--

LOCK TABLES `film` WRITE;
/*!40000 ALTER TABLE `film` DISABLE KEYS */;
INSERT INTO `film` VALUES (2,'蜘蛛侠：英雄归来 ','','在初次接触了复仇者联盟之后，彼得回到和梅姨（玛丽莎·托梅饰演）的家中，托尼·史塔克（小罗伯特·唐尼饰演）对他开始了培训……','英语','133','2017-09-08','https://img.alicdn.com/bao/uploaded/i4/TB1dTfubYsTMeJjSsziXXcdwXXa_.jpg_300x300.jpg','动作','3D'),(3,'猩球崛起3：终极之战','','故事发生在第二部《猩球崛起：黎明之战》的后两年。猿族和人类的战争已经持续了两年之久。','英语','140','2017-09-15','https://img.alicdn.com/bao/uploaded/i4/TB1SjYYSpXXXXaBapXXXXXXXXXX_.jpg_300x300.jpg','冒险','3D'),(4,'看不见的客人','','艾德里安（马里奥•卡萨斯饰）经营着一间科技公司，事业蒸蒸日上，家中有美丽贤惠的妻子和活泼可爱的女儿……','西班牙语','106','2017-09-15','https://img.alicdn.com/bao/uploaded/i2/TB15rj6XqigSKJjSsppXXabnpXa_.jpg_300x300.jpg','悬疑','2D');
/*!40000 ALTER TABLE `film` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film_actor_map`
--

DROP TABLE IF EXISTS `film_actor_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film_actor_map` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `film_id` bigint(20) DEFAULT NULL,
  `actor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_film_actor_1` (`actor_id`),
  KEY `FK_film_actor_2` (`film_id`),
  CONSTRAINT `FK_film_actor_1` FOREIGN KEY (`actor_id`) REFERENCES `actor` (`id`),
  CONSTRAINT `FK_film_actor_2` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film_actor_map`
--

LOCK TABLES `film_actor_map` WRITE;
/*!40000 ALTER TABLE `film_actor_map` DISABLE KEYS */;
INSERT INTO `film_actor_map` VALUES (2,2,3),(3,2,2),(4,3,6),(5,3,7),(6,4,9),(7,4,10);
/*!40000 ALTER TABLE `film_actor_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film_cinema_map`
--

DROP TABLE IF EXISTS `film_cinema_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film_cinema_map` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `film_id` bigint(20) DEFAULT NULL,
  `cinema_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_film_cinema_1` (`film_id`),
  KEY `FK_film_cinema_2` (`cinema_id`),
  CONSTRAINT `FK_film_cinema_1` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`),
  CONSTRAINT `FK_film_cinema_2` FOREIGN KEY (`cinema_id`) REFERENCES `cinema` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film_cinema_map`
--

LOCK TABLES `film_cinema_map` WRITE;
/*!40000 ALTER TABLE `film_cinema_map` DISABLE KEYS */;
INSERT INTO `film_cinema_map` VALUES (1,2,2),(2,3,2),(3,4,2);
/*!40000 ALTER TABLE `film_cinema_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film_director_map`
--

DROP TABLE IF EXISTS `film_director_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film_director_map` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `film_id` bigint(20) DEFAULT NULL,
  `director_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_film_director_1` (`film_id`),
  KEY `FK_film_director_2` (`director_id`),
  CONSTRAINT `FK_film_director_1` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`),
  CONSTRAINT `FK_film_director_2` FOREIGN KEY (`director_id`) REFERENCES `actor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film_director_map`
--

LOCK TABLES `film_director_map` WRITE;
/*!40000 ALTER TABLE `film_director_map` DISABLE KEYS */;
INSERT INTO `film_director_map` VALUES (2,2,4),(3,3,5),(4,4,8);
/*!40000 ALTER TABLE `film_director_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hall`
--

DROP TABLE IF EXISTS `hall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hall` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cinema_id` bigint(20) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `row_num` smallint(6) DEFAULT NULL,
  `column_num` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_hall_cinema` (`cinema_id`),
  CONSTRAINT `FK_hall_cinema` FOREIGN KEY (`cinema_id`) REFERENCES `cinema` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hall`
--

LOCK TABLES `hall` WRITE;
/*!40000 ALTER TABLE `hall` DISABLE KEYS */;
INSERT INTO `hall` VALUES (1,2,'1号厅','IMAX',18,25),(2,2,'2号厅','巨幕',22,32),(3,2,'3号厅','普通',14,18),(4,2,'4号厅','普通',15,20),(5,2,'5号厅','普通',11,18);
/*!40000 ALTER TABLE `hall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `purchase_id` bigint(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `row_pos` smallint(6) DEFAULT NULL,
  `column_pos` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_order_purdchase` (`purchase_id`),
  CONSTRAINT `FK_order_purdchase` FOREIGN KEY (`purchase_id`) REFERENCES `purchase_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order`
--

DROP TABLE IF EXISTS `purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `film_id` bigint(20) DEFAULT NULL,
  `film_image_url` varchar(200) DEFAULT NULL,
  `film_name` varchar(50) DEFAULT NULL,
  `cinema_id` bigint(20) DEFAULT NULL,
  `cinema_name` varchar(50) DEFAULT NULL,
  `hall_name` varchar(30) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `seat_num` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_purchase_order_user` (`user_id`),
  CONSTRAINT `FK_purchase_order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order`
--

LOCK TABLES `purchase_order` WRITE;
/*!40000 ALTER TABLE `purchase_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `showing_id` bigint(20) DEFAULT NULL,
  `row_pos` smallint(6) DEFAULT NULL,
  `column_pos` smallint(6) DEFAULT NULL,
  `status` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_seat_showing` (`showing_id`),
  CONSTRAINT `FK_seat_showing` FOREIGN KEY (`showing_id`) REFERENCES `showing` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=451 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,4,1,1,'1'),(2,4,1,2,'1'),(3,4,1,3,'1'),(4,4,1,4,'1'),(5,4,1,5,'1'),(6,4,1,6,'1'),(7,4,1,7,'1'),(8,4,1,8,'1'),(9,4,1,9,'1'),(10,4,1,10,'1'),(11,4,1,11,'1'),(12,4,1,12,'1'),(13,4,1,13,'1'),(14,4,1,14,'1'),(15,4,1,15,'1'),(16,4,1,16,'1'),(17,4,1,17,'1'),(18,4,1,18,'1'),(19,4,1,19,'1'),(20,4,1,20,'1'),(21,4,1,21,'1'),(22,4,1,22,'1'),(23,4,1,23,'1'),(24,4,1,24,'1'),(25,4,1,25,'1'),(26,4,2,1,'1'),(27,4,2,2,'1'),(28,4,2,3,'1'),(29,4,2,4,'1'),(30,4,2,5,'1'),(31,4,2,6,'1'),(32,4,2,7,'1'),(33,4,2,8,'1'),(34,4,2,9,'1'),(35,4,2,10,'1'),(36,4,2,11,'1'),(37,4,2,12,'1'),(38,4,2,13,'1'),(39,4,2,14,'1'),(40,4,2,15,'1'),(41,4,2,16,'1'),(42,4,2,17,'1'),(43,4,2,18,'1'),(44,4,2,19,'1'),(45,4,2,20,'1'),(46,4,2,21,'1'),(47,4,2,22,'1'),(48,4,2,23,'1'),(49,4,2,24,'1'),(50,4,2,25,'1'),(51,4,3,1,'1'),(52,4,3,2,'1'),(53,4,3,3,'1'),(54,4,3,4,'1'),(55,4,3,5,'1'),(56,4,3,6,'1'),(57,4,3,7,'1'),(58,4,3,8,'1'),(59,4,3,9,'1'),(60,4,3,10,'1'),(61,4,3,11,'1'),(62,4,3,12,'1'),(63,4,3,13,'1'),(64,4,3,14,'1'),(65,4,3,15,'1'),(66,4,3,16,'1'),(67,4,3,17,'1'),(68,4,3,18,'1'),(69,4,3,19,'1'),(70,4,3,20,'1'),(71,4,3,21,'1'),(72,4,3,22,'1'),(73,4,3,23,'1'),(74,4,3,24,'1'),(75,4,3,25,'1'),(76,4,4,1,'1'),(77,4,4,2,'1'),(78,4,4,3,'1'),(79,4,4,4,'1'),(80,4,4,5,'1'),(81,4,4,6,'1'),(82,4,4,7,'1'),(83,4,4,8,'1'),(84,4,4,9,'1'),(85,4,4,10,'1'),(86,4,4,11,'1'),(87,4,4,12,'1'),(88,4,4,13,'1'),(89,4,4,14,'1'),(90,4,4,15,'1'),(91,4,4,16,'1'),(92,4,4,17,'1'),(93,4,4,18,'1'),(94,4,4,19,'1'),(95,4,4,20,'1'),(96,4,4,21,'1'),(97,4,4,22,'1'),(98,4,4,23,'1'),(99,4,4,24,'1'),(100,4,4,25,'1'),(101,4,5,1,'1'),(102,4,5,2,'1'),(103,4,5,3,'1'),(104,4,5,4,'1'),(105,4,5,5,'1'),(106,4,5,6,'1'),(107,4,5,7,'1'),(108,4,5,8,'1'),(109,4,5,9,'1'),(110,4,5,10,'1'),(111,4,5,11,'1'),(112,4,5,12,'1'),(113,4,5,13,'1'),(114,4,5,14,'1'),(115,4,5,15,'1'),(116,4,5,16,'1'),(117,4,5,17,'1'),(118,4,5,18,'1'),(119,4,5,19,'1'),(120,4,5,20,'1'),(121,4,5,21,'1'),(122,4,5,22,'1'),(123,4,5,23,'1'),(124,4,5,24,'1'),(125,4,5,25,'1'),(126,4,6,1,'1'),(127,4,6,2,'1'),(128,4,6,3,'1'),(129,4,6,4,'1'),(130,4,6,5,'1'),(131,4,6,6,'1'),(132,4,6,7,'1'),(133,4,6,8,'1'),(134,4,6,9,'1'),(135,4,6,10,'1'),(136,4,6,11,'1'),(137,4,6,12,'1'),(138,4,6,13,'1'),(139,4,6,14,'1'),(140,4,6,15,'1'),(141,4,6,16,'1'),(142,4,6,17,'1'),(143,4,6,18,'1'),(144,4,6,19,'1'),(145,4,6,20,'1'),(146,4,6,21,'1'),(147,4,6,22,'1'),(148,4,6,23,'1'),(149,4,6,24,'1'),(150,4,6,25,'1'),(151,4,7,1,'1'),(152,4,7,2,'1'),(153,4,7,3,'1'),(154,4,7,4,'1'),(155,4,7,5,'1'),(156,4,7,6,'1'),(157,4,7,7,'1'),(158,4,7,8,'1'),(159,4,7,9,'1'),(160,4,7,10,'1'),(161,4,7,11,'1'),(162,4,7,12,'1'),(163,4,7,13,'1'),(164,4,7,14,'1'),(165,4,7,15,'1'),(166,4,7,16,'1'),(167,4,7,17,'1'),(168,4,7,18,'1'),(169,4,7,19,'1'),(170,4,7,20,'1'),(171,4,7,21,'1'),(172,4,7,22,'1'),(173,4,7,23,'1'),(174,4,7,24,'1'),(175,4,7,25,'1'),(176,4,8,1,'1'),(177,4,8,2,'1'),(178,4,8,3,'1'),(179,4,8,4,'1'),(180,4,8,5,'1'),(181,4,8,6,'1'),(182,4,8,7,'1'),(183,4,8,8,'1'),(184,4,8,9,'1'),(185,4,8,10,'1'),(186,4,8,11,'1'),(187,4,8,12,'1'),(188,4,8,13,'1'),(189,4,8,14,'1'),(190,4,8,15,'1'),(191,4,8,16,'1'),(192,4,8,17,'1'),(193,4,8,18,'1'),(194,4,8,19,'1'),(195,4,8,20,'1'),(196,4,8,21,'1'),(197,4,8,22,'1'),(198,4,8,23,'1'),(199,4,8,24,'1'),(200,4,8,25,'1'),(201,4,9,1,'1'),(202,4,9,2,'1'),(203,4,9,3,'1'),(204,4,9,4,'1'),(205,4,9,5,'1'),(206,4,9,6,'1'),(207,4,9,7,'1'),(208,4,9,8,'1'),(209,4,9,9,'1'),(210,4,9,10,'1'),(211,4,9,11,'1'),(212,4,9,12,'1'),(213,4,9,13,'1'),(214,4,9,14,'1'),(215,4,9,15,'1'),(216,4,9,16,'1'),(217,4,9,17,'1'),(218,4,9,18,'1'),(219,4,9,19,'1'),(220,4,9,20,'1'),(221,4,9,21,'1'),(222,4,9,22,'1'),(223,4,9,23,'1'),(224,4,9,24,'1'),(225,4,9,25,'1'),(226,4,10,1,'1'),(227,4,10,2,'1'),(228,4,10,3,'1'),(229,4,10,4,'1'),(230,4,10,5,'1'),(231,4,10,6,'1'),(232,4,10,7,'1'),(233,4,10,8,'1'),(234,4,10,9,'1'),(235,4,10,10,'1'),(236,4,10,11,'1'),(237,4,10,12,'1'),(238,4,10,13,'1'),(239,4,10,14,'1'),(240,4,10,15,'1'),(241,4,10,16,'1'),(242,4,10,17,'1'),(243,4,10,18,'1'),(244,4,10,19,'1'),(245,4,10,20,'1'),(246,4,10,21,'1'),(247,4,10,22,'1'),(248,4,10,23,'1'),(249,4,10,24,'1'),(250,4,10,25,'1'),(251,4,11,1,'1'),(252,4,11,2,'1'),(253,4,11,3,'1'),(254,4,11,4,'1'),(255,4,11,5,'1'),(256,4,11,6,'1'),(257,4,11,7,'1'),(258,4,11,8,'1'),(259,4,11,9,'1'),(260,4,11,10,'1'),(261,4,11,11,'1'),(262,4,11,12,'1'),(263,4,11,13,'1'),(264,4,11,14,'1'),(265,4,11,15,'1'),(266,4,11,16,'1'),(267,4,11,17,'1'),(268,4,11,18,'1'),(269,4,11,19,'1'),(270,4,11,20,'1'),(271,4,11,21,'1'),(272,4,11,22,'1'),(273,4,11,23,'1'),(274,4,11,24,'1'),(275,4,11,25,'1'),(276,4,12,1,'1'),(277,4,12,2,'1'),(278,4,12,3,'1'),(279,4,12,4,'1'),(280,4,12,5,'1'),(281,4,12,6,'1'),(282,4,12,7,'1'),(283,4,12,8,'1'),(284,4,12,9,'1'),(285,4,12,10,'1'),(286,4,12,11,'1'),(287,4,12,12,'1'),(288,4,12,13,'1'),(289,4,12,14,'1'),(290,4,12,15,'1'),(291,4,12,16,'1'),(292,4,12,17,'1'),(293,4,12,18,'1'),(294,4,12,19,'1'),(295,4,12,20,'1'),(296,4,12,21,'1'),(297,4,12,22,'1'),(298,4,12,23,'1'),(299,4,12,24,'1'),(300,4,12,25,'1'),(301,4,13,1,'1'),(302,4,13,2,'1'),(303,4,13,3,'1'),(304,4,13,4,'1'),(305,4,13,5,'1'),(306,4,13,6,'1'),(307,4,13,7,'1'),(308,4,13,8,'1'),(309,4,13,9,'1'),(310,4,13,10,'1'),(311,4,13,11,'1'),(312,4,13,12,'1'),(313,4,13,13,'1'),(314,4,13,14,'1'),(315,4,13,15,'1'),(316,4,13,16,'1'),(317,4,13,17,'1'),(318,4,13,18,'1'),(319,4,13,19,'1'),(320,4,13,20,'1'),(321,4,13,21,'1'),(322,4,13,22,'1'),(323,4,13,23,'1'),(324,4,13,24,'1'),(325,4,13,25,'1'),(326,4,14,1,'1'),(327,4,14,2,'1'),(328,4,14,3,'1'),(329,4,14,4,'1'),(330,4,14,5,'1'),(331,4,14,6,'1'),(332,4,14,7,'1'),(333,4,14,8,'1'),(334,4,14,9,'1'),(335,4,14,10,'1'),(336,4,14,11,'1'),(337,4,14,12,'1'),(338,4,14,13,'1'),(339,4,14,14,'1'),(340,4,14,15,'1'),(341,4,14,16,'1'),(342,4,14,17,'1'),(343,4,14,18,'1'),(344,4,14,19,'1'),(345,4,14,20,'1'),(346,4,14,21,'1'),(347,4,14,22,'1'),(348,4,14,23,'1'),(349,4,14,24,'1'),(350,4,14,25,'1'),(351,4,15,1,'1'),(352,4,15,2,'1'),(353,4,15,3,'1'),(354,4,15,4,'1'),(355,4,15,5,'1'),(356,4,15,6,'1'),(357,4,15,7,'1'),(358,4,15,8,'1'),(359,4,15,9,'1'),(360,4,15,10,'1'),(361,4,15,11,'1'),(362,4,15,12,'1'),(363,4,15,13,'1'),(364,4,15,14,'1'),(365,4,15,15,'1'),(366,4,15,16,'1'),(367,4,15,17,'1'),(368,4,15,18,'1'),(369,4,15,19,'1'),(370,4,15,20,'1'),(371,4,15,21,'1'),(372,4,15,22,'1'),(373,4,15,23,'1'),(374,4,15,24,'1'),(375,4,15,25,'1'),(376,4,16,1,'1'),(377,4,16,2,'1'),(378,4,16,3,'1'),(379,4,16,4,'1'),(380,4,16,5,'1'),(381,4,16,6,'1'),(382,4,16,7,'1'),(383,4,16,8,'1'),(384,4,16,9,'1'),(385,4,16,10,'1'),(386,4,16,11,'1'),(387,4,16,12,'1'),(388,4,16,13,'1'),(389,4,16,14,'1'),(390,4,16,15,'1'),(391,4,16,16,'1'),(392,4,16,17,'1'),(393,4,16,18,'1'),(394,4,16,19,'1'),(395,4,16,20,'1'),(396,4,16,21,'1'),(397,4,16,22,'1'),(398,4,16,23,'1'),(399,4,16,24,'1'),(400,4,16,25,'1'),(401,4,17,1,'1'),(402,4,17,2,'1'),(403,4,17,3,'1'),(404,4,17,4,'1'),(405,4,17,5,'1'),(406,4,17,6,'1'),(407,4,17,7,'1'),(408,4,17,8,'1'),(409,4,17,9,'1'),(410,4,17,10,'1'),(411,4,17,11,'1'),(412,4,17,12,'1'),(413,4,17,13,'1'),(414,4,17,14,'1'),(415,4,17,15,'1'),(416,4,17,16,'1'),(417,4,17,17,'1'),(418,4,17,18,'1'),(419,4,17,19,'1'),(420,4,17,20,'1'),(421,4,17,21,'1'),(422,4,17,22,'1'),(423,4,17,23,'1'),(424,4,17,24,'1'),(425,4,17,25,'1'),(426,4,18,1,'1'),(427,4,18,2,'1'),(428,4,18,3,'1'),(429,4,18,4,'1'),(430,4,18,5,'1'),(431,4,18,6,'1'),(432,4,18,7,'1'),(433,4,18,8,'1'),(434,4,18,9,'1'),(435,4,18,10,'1'),(436,4,18,11,'1'),(437,4,18,12,'1'),(438,4,18,13,'1'),(439,4,18,14,'1'),(440,4,18,15,'1'),(441,4,18,16,'1'),(442,4,18,17,'1'),(443,4,18,18,'1'),(444,4,18,19,'1'),(445,4,18,20,'1'),(446,4,18,21,'1'),(447,4,18,22,'1'),(448,4,18,23,'1'),(449,4,18,24,'1'),(450,4,18,25,'1');
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showing`
--

DROP TABLE IF EXISTS `showing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `showing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hall_id` bigint(20) DEFAULT NULL,
  `film_cinema_map_id` bigint(20) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `price_manual` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_showing_fcm` (`film_cinema_map_id`),
  KEY `FK_showing_hall_idx` (`hall_id`),
  CONSTRAINT `FK_showing_fcm` FOREIGN KEY (`film_cinema_map_id`) REFERENCES `film_cinema_map` (`id`),
  CONSTRAINT `FK_showing_hall` FOREIGN KEY (`hall_id`) REFERENCES `hall` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showing`
--

LOCK TABLES `showing` WRITE;
/*!40000 ALTER TABLE `showing` DISABLE KEYS */;
INSERT INTO `showing` VALUES (4,1,1,'2017-09-19 12:01:00','2017-09-19 14:22:00',50);
/*!40000 ALTER TABLE `showing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `phone_num` varchar(11) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ch','1',NULL,'2017-09-19 23:59:14',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_detail`
--

DROP TABLE IF EXISTS `user_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_detail` (
  `id` bigint(20) NOT NULL,
  `city_code` varchar(10) DEFAULT NULL,
  `first_name` varchar(16) DEFAULT NULL,
  `last_name` varchar(16) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_detail`
--

LOCK TABLES `user_detail` WRITE;
/*!40000 ALTER TABLE `user_detail` DISABLE KEYS */;
INSERT INTO `user_detail` VALUES (1,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_profile`
--

DROP TABLE IF EXISTS `user_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_profile`
--

LOCK TABLES `user_profile` WRITE;
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_profile_map`
--

DROP TABLE IF EXISTS `user_profile_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_profile_map` (
  `user_id` bigint(20) NOT NULL,
  `user_profile_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`user_profile_id`),
  KEY `FK_user_profile_2` (`user_profile_id`),
  CONSTRAINT `FK_user_profile_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_user_profile_2` FOREIGN KEY (`user_profile_id`) REFERENCES `user_profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_profile_map`
--

LOCK TABLES `user_profile_map` WRITE;
/*!40000 ALTER TABLE `user_profile_map` DISABLE KEYS */;
INSERT INTO `user_profile_map` VALUES (1,1),(1,2);
/*!40000 ALTER TABLE `user_profile_map` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-21 15:19:18
