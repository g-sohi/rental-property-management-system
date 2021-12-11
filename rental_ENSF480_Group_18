CREATE DATABASE  IF NOT EXISTS `rpms` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rpms`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: rpms
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `property` (
  `Property_ID` int NOT NULL AUTO_INCREMENT,
  `Address` varchar(100) NOT NULL,
  `quadrant` varchar(100) NOT NULL,
  `Type` varchar(100) NOT NULL,
  `NoOfBedrooms` int NOT NULL,
  `NoOfBathrooms` int NOT NULL,
  `Furnished` varchar(100) NOT NULL,
  `Fees` double NOT NULL,
  `FeesPaid` varchar(100) NOT NULL,
  `Status` varchar(100) NOT NULL,
  `Landlord_ID` int NOT NULL,
  `StartDate` varchar(100) NOT NULL,
  `EndDate` varchar(100) NOT NULL,
  `RentDate` varchar(100) DEFAULT NULL,
  `FeePeriod` int DEFAULT NULL,
  PRIMARY KEY (`Property_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES (1,'295, Royal Oak ,Calgary, T1K 1L6','NE','Detached',4,2,'yes',3000,'yes','Active',4,'2021-10-05 12:00:00','2022-11-31 12:01:01','Null',3),(2,'39, Santa Close,Calgary, T1G 1U7','NE','TownHouse',1,1,'No',500,'yes','Rented',2,'2021-12-10 16:08:57','2022-06-10 16:08:57','2021-12-10',6),(3,'122, Carlos Drive ,Calgary, T3J 1R6','SE','Semi-Detached',6,5,'No',2313,'yes','Canceled',2,'2021-12-09 10:01:01','2023-03-01 10:01:01',NULL,15),(4,'233, Steel avenue, Calgary, T3J 1O6','NW','Semi-Detached',3,2,'Yes',390,'yes','Rented',2,'2021-11-07 01:00:00','2022-04-06 01:01:01','2021-12-07',6),(5,'230, Stuart avenue, Calgary, T3T 1S6','NE','Detached',2,3,'Yes',400,'yes','Active',4,'2021-12-10 18:59:41','2022-06-10 18:59:41',NULL,6),(6,'361, Charles Drive,Calgary, T3J 2Y4','NE','Detached',1,1,'Yes',0,'No','Suspended',4,'null','null',NULL,NULL),(7,'241, Green Road,Calgary, T3J 2S4','NE','Detached',1,1,'Yes',0,'No','Suspended',2,'null','null',NULL,NULL),(8,'125, Ridge Road,Calgary, T3J 2D5','NE','Detached',1,1,'Yes',0,'No','Suspended',2,'null','null',NULL,NULL),(9,'30, Auburn Close,Calgary, T3Y 1D7','NE','TownHouse',2,2,'No',200.5,'yes','Rented',4,'2021-09-07 02:00:00','2022-06-10 19:06:16','2021-11-05',6),(10,'355, Centre Street, Calgary, T1C-2R5','SW','TownHouse',5,4,'Yes',199.56,'yes','Active',2,'2021-12-10 19:12:10','2022-01-10 19:12:10',NULL,1);
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `UserName` varchar(100) NOT NULL,
  `FName` varchar(100) NOT NULL,
  `LName` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `ID` int NOT NULL AUTO_INCREMENT,
  `UserType` varchar(100) NOT NULL,
  `LastLogin` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Sam','Samuel','SS','ensf480',1,'Renter','2021-12-10'),('David','Smith','David','ensf480',2,'Landlord','2021-12-10'),('Robin','Robin','Sio','ensf480',3,'Manager','2021-12-10'),('Roy','Roth','Smith','ensf480',4,'Landlord','2021-12-10'),('singh','SS','Singh','ensf480',5,'Renter',NULL);
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

-- Dump completed on 2021-12-10 20:24:58