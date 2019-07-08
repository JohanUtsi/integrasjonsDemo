-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: forsikringer
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `avtale`
--

DROP TABLE IF EXISTS `avtale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `avtale` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bruker_id` bigint(20) NOT NULL,
  `regnummer_id` bigint(20) NOT NULL,
  `bonus_type` bigint(20) NOT NULL,
  `status` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `kunde_idx` (`bruker_id`),
  KEY `regnummer_idx` (`regnummer_id`),
  KEY `bonus_idx` (`bonus_type`),
  KEY `status_idx` (`status`),
  CONSTRAINT `bonus` FOREIGN KEY (`bonus_type`) REFERENCES `bonus` (`id`),
  CONSTRAINT `kunde` FOREIGN KEY (`bruker_id`) REFERENCES `kunde` (`id`),
  CONSTRAINT `regnummer` FOREIGN KEY (`regnummer_id`) REFERENCES `registreringsnummer` (`id`),
  CONSTRAINT `status` FOREIGN KEY (`status`) REFERENCES `status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avtale`
--

LOCK TABLES `avtale` WRITE;
/*!40000 ALTER TABLE `avtale` DISABLE KEYS */;
INSERT INTO `avtale` VALUES (16,10,5,1,1),(17,10,5,1,2),(18,11,6,1,1),(19,11,6,1,2),(20,12,7,1,1),(21,12,7,1,2),(22,13,8,1,1),(23,13,8,1,2),(24,14,9,4,1),(25,14,9,4,2),(26,15,10,4,1),(27,15,10,4,2),(28,16,11,5,1),(29,16,11,5,2);
/*!40000 ALTER TABLE `avtale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bonus`
--

DROP TABLE IF EXISTS `bonus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bonus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `navn` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bonus`
--

LOCK TABLES `bonus` WRITE;
/*!40000 ALTER TABLE `bonus` DISABLE KEYS */;
INSERT INTO `bonus` VALUES (1,'test'),(2,'basic'),(3,'premium'),(4,'platinum'),(5,'unlucky'),(6,'test'),(7,'Supermax'),(8,'Supermax');
/*!40000 ALTER TABLE `bonus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kunde`
--

DROP TABLE IF EXISTS `kunde`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `kunde` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fornavn` varchar(150) NOT NULL,
  `etternavn` varchar(150) NOT NULL,
  `fodselsnummer` bigint(12) NOT NULL,
  `epost` varchar(45) NOT NULL,
  `aktiv` tinyint(4) NOT NULL DEFAULT '1',
  `opprettet` datetime DEFAULT CURRENT_TIMESTAMP,
  `endret` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `epost_UNIQUE` (`epost`),
  UNIQUE KEY `fodselsnummer_UNIQUE` (`fodselsnummer`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kunde`
--

LOCK TABLES `kunde` WRITE;
/*!40000 ALTER TABLE `kunde` DISABLE KEYS */;
INSERT INTO `kunde` VALUES (10,'Jimmy','Jones',22223322232,'jimmy.jones@test.test',1,'2019-07-08 01:01:37',NULL),(11,'Jimmy','Jones',12223322232,'jimmy.jones2@test.test',1,'2019-07-08 21:37:30',NULL),(12,'Jimmy','Jones',12223323232,'j2immy.jones2@test.test',1,'2019-07-08 22:07:09',NULL),(13,'Jimmy','Jones',12263323232,'j2im7my.jones2@test.test',1,'2019-07-08 22:18:36',NULL),(14,'Johan','Utsi',30039022991,'test1@test.com',1,'2019-07-08 22:19:49',NULL),(15,'Johan','Utsi',30039022999,'test2@test.com',1,'2019-07-08 22:24:03',NULL),(16,'Rogert','Ertas',10018921332,'Rog.ert@hotmail.com',1,'2019-07-08 22:28:55',NULL);
/*!40000 ALTER TABLE `kunde` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registreringsnummer`
--

DROP TABLE IF EXISTS `registreringsnummer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `registreringsnummer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bruker_id` bigint(20) NOT NULL,
  `registreringsnummer` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `brukerId_idx` (`bruker_id`),
  CONSTRAINT `brukerId` FOREIGN KEY (`bruker_id`) REFERENCES `kunde` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registreringsnummer`
--

LOCK TABLES `registreringsnummer` WRITE;
/*!40000 ALTER TABLE `registreringsnummer` DISABLE KEYS */;
INSERT INTO `registreringsnummer` VALUES (5,10,'DN 32133'),(6,11,'DN 32133'),(7,12,'DN 32133'),(8,13,'DN 32133'),(9,14,'AB 12345'),(10,15,'AB 12345'),(11,16,'AB 12345');
/*!40000 ALTER TABLE `registreringsnummer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `status` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` varchar(120) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Opprettet'),(2,'Sendt'),(3,'Ikke sendt');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-08 23:35:15
