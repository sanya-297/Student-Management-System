-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: sms
-- ------------------------------------------------------
-- Server version	8.0.46

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `role` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('admin','Sanya','Sanya@123','Sanya@123'),('admin','Rahul','rahul@123','rahul@123'),('admin','Pooja','pooja@123','pooja@123'),('admin','Amit','amit@123','amit@123'),('admin','Neha','neha@123','neha@123'),('admin','Vijay','vijay@123','vijay@123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `roll_no` int NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `eng_marks` varchar(15) DEFAULT NULL,
  `maths_marks` varchar(15) DEFAULT NULL,
  `science_marks` varchar(15) DEFAULT NULL,
  `computer_marks` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`roll_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (101,'Krrish','krrish@123','abc','2345678901','96','94','97','99'),(102,'Mahi','mahi@123gmail.com','xyz','6354328456','70','80','83','78'),(103,'Monika','monika@123gmail.com','pqr','6354328866','87','56','96','89'),(104,'Rina','rina@123gmail.com','def','6354328834','87','56','96','89'),(105,'Gaurav','gaurav@123gmail.com','ghi','6354328834','87','56','96','89'),(106,'Sanjeev','sanjeev@123gmail.com','jkl','6354328834','87','90','45','78'),(107,'Vipin','vipin@123gmail.com','str','6354328834','87','90','45','78'),(109,'Saurabh','saurabh@123','defg','8765432109','90','78','90','67'),(110,'Aman','aman@123','Street 1','9876543210','85','88','90','92'),(111,'Priya','priya@123','Street 2','9876543211','92','85','88','95'),(112,'Rahul','rahul@123','Street 3','9876543212','78','90','85','80'),(113,'Sneha','sneha@123','Street 4','9876543213','90','92','94','96'),(114,'Vikram','vikram@123','Street 5','9876543214','80','75','82','85'),(115,'Anjali','anjali@123','Street 6','9876543215','88','89','91','93'),(116,'Sanjeev','Sanjeev@123','mnop','1234554321','78','98','89','79');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-24 22:16:25
