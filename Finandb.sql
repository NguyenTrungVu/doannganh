-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: localhost    Database: Financedb
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `belong`
--

DROP TABLE IF EXISTS `belong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `belong` (
  `id` int NOT NULL,
  `user_id` int NOT NULL,
  `group_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_belong_user_idx` (`user_id`),
  KEY `fx_belong_gr_idx` (`group_id`),
  CONSTRAINT `fx_belong_gr` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `fx_belong_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `belong`
--

LOCK TABLES `belong` WRITE;
/*!40000 ALTER TABLE `belong` DISABLE KEYS */;
/*!40000 ALTER TABLE `belong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Income'),(2,'Expense');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupexpense`
--

DROP TABLE IF EXISTS `groupexpense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `groupexpense` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `group_id` int NOT NULL,
  `purpose` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` decimal(10,0) DEFAULT '0',
  `created_date` datetime DEFAULT NULL,
  `type` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_type_idx` (`type`),
  KEY `fk_grex_user_idx` (`user_id`),
  KEY `fk_grex_gr_idx` (`group_id`),
  CONSTRAINT `fk_grex_gr` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `fk_grex_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_type` FOREIGN KEY (`type`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupexpense`
--

LOCK TABLES `groupexpense` WRITE;
/*!40000 ALTER TABLE `groupexpense` DISABLE KEYS */;
/*!40000 ALTER TABLE `groupexpense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupexpensetemp`
--

DROP TABLE IF EXISTS `groupexpensetemp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `groupexpensetemp` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `group_id` int NOT NULL,
  `purpose` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` decimal(10,0) DEFAULT '0',
  `created_date` datetime DEFAULT NULL,
  `type` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_type_gex_idx` (`type`),
  CONSTRAINT `fk_type_gex` FOREIGN KEY (`type`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupexpensetemp`
--

LOCK TABLES `groupexpensetemp` WRITE;
/*!40000 ALTER TABLE `groupexpensetemp` DISABLE KEYS */;
/*!40000 ALTER TABLE `groupexpensetemp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `groups` (
  `id` int NOT NULL AUTO_INCREMENT,
  `groupname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `purpose` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_userid_idx` (`userid`),
  CONSTRAINT `fk_userid_idx` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inexpense`
--

DROP TABLE IF EXISTS `inexpense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inexpense` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `purpose` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` decimal(10,0) DEFAULT '0',
  `created_date` datetime DEFAULT NULL,
  `type` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cate_id_idx` (`type`),
  KEY `fk_user_id_idx` (`user_id`),
  CONSTRAINT `fk_cate_id` FOREIGN KEY (`type`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inexpense`
--

LOCK TABLES `inexpense` WRITE;
/*!40000 ALTER TABLE `inexpense` DISABLE KEYS */;
INSERT INTO `inexpense` VALUES (1,3,'mua banh trang',10000,'2022-10-29 09:04:42',2),(2,3,'Mua card dien thoai',20000,'2022-10-29 09:16:26',2),(3,3,'Salary thang 9',50000000,'2022-09-29 09:52:32',1),(4,3,'Sandal',1500000,'2022-11-02 21:14:15',2),(5,3,'Mua xe',30000000,'2022-11-09 10:42:36',2),(6,3,'Salary',50000000,'2022-11-10 08:07:54',1),(7,3,'IPhone 14 pro max',30000000,'2022-11-10 08:08:19',2),(8,3,'Hoc phi',15000000,'2022-11-10 08:24:38',2),(9,3,'Mua vang',20000000,'2022-11-10 08:34:08',2),(10,3,'Bonus thang 11',3000000,'2022-11-10 16:56:14',1),(11,3,'Mua giay ',2000000,'2022-11-10 19:41:09',2),(12,3,'Tien lixi',1000000,'2022-11-10 19:44:58',1),(13,3,'Salary thang 10',50000000,'2022-10-10 08:07:54',1),(15,3,'Mua Banh',10000,'2022-11-12 10:39:18',2),(16,3,'Mua may tinh',51000000,'2022-11-12 10:41:40',2);
/*!40000 ALTER TABLE `inexpense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `group_id` int NOT NULL,
  `content` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_message_user_idx` (`user_id`),
  KEY `fk_message_group_idx` (`group_id`),
  CONSTRAINT `fk_message_group` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `fk_message_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rule`
--

DROP TABLE IF EXISTS `rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rule` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `content` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_userid_idx_idx` (`user_id`),
  CONSTRAINT `fk_user_idx` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=474 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule`
--

LOCK TABLES `rule` WRITE;
/*!40000 ALTER TABLE `rule` DISABLE KEYS */;
INSERT INTO `rule` VALUES (471,3,'So tien hien tai cua ban con duoi ₫5,000,000 '),(472,3,'So tien hien tai cua ban con duoi ₫5,000,000 '),(473,3,'So tien hien tai cua ban con duoi ₫5,000,000 ');
/*!40000 ALTER TABLE `rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `active` bit(1) DEFAULT b'1',
  `avatar` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_role` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `regdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'vumin','vumin@gmail.com','12324','$sadfwecddf3sf',_binary '',NULL,'ROLE_ADMIN','2022-10-04 10:27:11'),(2,'vu','vu@gmail.com','342524','$2a$10$pmt6LRjFe0I6NUAuszB00OIwhFYLSCBmbaJJemFL.0fsJIctzkdIC',NULL,'https://res.cloudinary.com/dcrqeomcc/image/upload/v1664855718/qxjy18up5kotoajjet3w.heic','MEMBER','2022-10-04 10:55:05'),(3,'huy','huy@gmail.com','13123','$2a$10$FI7HUWzlOg66ws/GlHgIxOZEy/Mb/yYItb9f6R0tfxnpvUOiunSau',_binary '','https://res.cloudinary.com/dcrqeomcc/image/upload/v1664855869/o4xnbmb9lnuzoqlegda2.heic','MEMBER','2022-10-04 10:57:07'),(4,'vumin1','vumin1@gmail.com','423424','$2a$10$6yOGZQxGsOnEDPEkQA0CwOozO3vfe5ndHtQS0qvsw.GgImvC2XJcK',_binary '','https://res.cloudinary.com/dcrqeomcc/image/upload/v1664869461/txgfh4awpjmfkerq73jf.jpg','ADMIN','2022-10-04 14:44:10'),(5,'khang','khang@gmail.com','342342','$2a$10$mzzUFPNINTRsoaOY0mJf1.PWKaLUajDxSomKcrrHFKMznZ4bKuP1e',_binary '','https://res.cloudinary.com/dcrqeomcc/image/upload/v1664978769/nmm6sm5pmvbvthuerodt.jpg','MEMBER','2022-10-05 21:06:00'),(6,'vu','vumin@gmail.com','1231231','$2a$10$5mhF0FdPaSFdNSKvPUiwGOYGxr9LFCl/UTeZUa5NtNb69ZL/sYVpa',_binary '','https://res.cloudinary.com/dcrqeomcc/image/upload/v1664978944/ljume7yr7hgb1srvwwbw.jpg','MEMBER','2022-10-05 21:08:56'),(7,'huynh','huynh@gmail.com','1231231','$2a$10$RpVmdT/a/T7iMGD3vvIqeecp.lSmCh.tAs2Kq5TXuxNQAjsLPQsDG',_binary '','https://res.cloudinary.com/dcrqeomcc/image/upload/v1665018126/jck0lv361cyim9i8nw7b.jpg','MEMBER','2022-10-06 08:02:03'),(8,'de','de@gmail.com','23424234','$2a$10$fEXcMlzeE7rlhRWkNrFz1u/ujDdYEP9Qyre031bW2vc5E696Iymj6',_binary '','https://res.cloudinary.com/dcrqeomcc/image/upload/v1665022186/kwi7eyhzsl4hpgtorsta.jpg','MEMBER','2022-10-06 09:09:44'),(16,'thang','thang@gmail.com','43242342','$2a$10$KRApP5/EkTh4kl2PX8VkPe/5KxsSaI/Gc2l/.JdGh8eB2TkFYIi4m',_binary '','https://res.cloudinary.com/dcrqeomcc/image/upload/v1667309214/to5vxasrto6xblytdxpw.png','MEMBER','2022-11-01 20:26:51'),(17,'rak','rak@gmail.com','1231231','$2a$10$qmCq6ocr0Dq2MEqN/NASFegF97ZqoNGpFw4SrJhgHQAGrZ2.fTr3y',_binary '','https://res.cloudinary.com/dcrqeomcc/image/upload/v1668216718/mlc3lozgqustoejlxwjb.jpg','MEMBER','2022-11-12 08:31:56');
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

-- Dump completed on 2022-11-16 19:33:26
