-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: tutoringprogram
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sessions` (
  `SessionID` int NOT NULL AUTO_INCREMENT,
  `TutorID` int NOT NULL,
  `StudentID` int NOT NULL,
  `SubjectID` int NOT NULL,
  `dates` date NOT NULL,
  PRIMARY KEY (`SessionID`),
  KEY `TutorID` (`TutorID`),
  KEY `StudentID` (`StudentID`),
  KEY `SubjectID` (`SubjectID`),
  CONSTRAINT `sessions_ibfk_1` FOREIGN KEY (`TutorID`) REFERENCES `tutors` (`TutorID`),
  CONSTRAINT `sessions_ibfk_2` FOREIGN KEY (`StudentID`) REFERENCES `students` (`StudentID`),
  CONSTRAINT `sessions_ibfk_3` FOREIGN KEY (`SubjectID`) REFERENCES `subjects` (`SubjectID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

LOCK TABLES `sessions` WRITE;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
INSERT INTO `sessions` VALUES (1,2,2,7,'2020-01-01'),(2,2,4,19,'2020-10-21');
/*!40000 ALTER TABLE `sessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `StudentID` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `phonenumber` varchar(13) NOT NULL,
  `emailaddress` varchar(80) NOT NULL,
  PRIMARY KEY (`StudentID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (2,'Jon','Doe','444-444-4444','JonDoe@gmail.com'),(4,'Sam','Ray','222-222-2222','SamRay@gmail.com');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `SubjectID` int NOT NULL AUTO_INCREMENT,
  `subjectName` varchar(50) NOT NULL,
  PRIMARY KEY (`SubjectID`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (1,'Advanced English Grammar'),(2,'American Government'),(3,'Art History'),(4,'Biological Principles'),(5,'Calculus'),(6,'Chemistry'),(7,'Composition'),(8,'Computer Programming'),(9,'Database Management'),(10,'Design'),(11,'Drawing'),(12,'Elementary Algebra'),(13,'Engineering Physics'),(14,'Financial Accounting'),(15,'General Biology'),(16,'General Physics'),(17,'Geometry and Visualization'),(18,'History of Jazz'),(19,'Information Systems Concepts'),(20,'Information Technology'),(21,'Intermediate Algebra'),(22,'Introduction to Art'),(23,'Introduction to Business'),(24,'Introduction to Entrepreneurship'),(25,'Introduction to Geography'),(26,'Introduction to Political Science'),(27,'Microbiology'),(28,'Music in the Western World'),(29,'Organic Chemistry'),(30,'Painting'),(31,'Physical Geography'),(32,'Preparatory Mathematics'),(33,'Macroeconomics'),(34,'Microeconomics'),(35,'Programming in Python'),(36,'Second Year Music Theory'),(37,'Survey of Economics'),(38,'Survey Of Physics'),(39,'Trigonometry'),(40,'U.S. History'),(41,'Women and Politics'),(42,'World History to 1500');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutors`
--

DROP TABLE IF EXISTS `tutors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutors` (
  `TutorID` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `certDate` date NOT NULL,
  `status` varchar(50) NOT NULL,
  `phonenumber` varchar(13) NOT NULL,
  `emailaddress` varchar(80) NOT NULL,
  PRIMARY KEY (`TutorID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutors`
--

LOCK TABLES `tutors` WRITE;
/*!40000 ALTER TABLE `tutors` DISABLE KEYS */;
INSERT INTO `tutors` VALUES (2,'Jane','Doe','2020-03-05',' active',' 999-999-9999',' JaneDoe@gmail.com ');
/*!40000 ALTER TABLE `tutors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-30  1:33:32
