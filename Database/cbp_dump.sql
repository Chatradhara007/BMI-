-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: cbp
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `bmi_logs`
--

DROP TABLE IF EXISTS `bmi_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bmi_logs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `bmi_value` double NOT NULL,
  `category` varchar(20) NOT NULL,
  `date_logged` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bmi_logs`
--

LOCK TABLES `bmi_logs` WRITE;
/*!40000 ALTER TABLE `bmi_logs` DISABLE KEYS */;
INSERT INTO `bmi_logs` VALUES (14,9,22.839506172839506,'Normal','2025-11-09 10:03:40'),(17,9,22.839506172839506,'Normal','2025-11-14 09:13:58'),(18,1,22.99,'Normal','2025-01-10 04:45:23'),(19,1,23.12,'Normal','2025-02-15 08:52:11'),(20,2,21.09,'Normal','2025-01-08 03:41:45'),(21,2,21.5,'Normal','2025-02-14 11:13:22'),(22,3,25.88,'Overweight','2025-01-12 07:25:09'),(23,3,26.1,'Overweight','2025-02-16 09:50:42'),(24,4,19.97,'Normal','2025-01-07 03:02:19'),(25,4,20.25,'Normal','2025-02-13 08:14:51'),(26,5,27.78,'Overweight','2025-01-09 05:48:22'),(27,5,28.01,'Overweight','2025-02-17 07:07:29'),(28,6,19.82,'Normal','2025-01-06 04:35:11'),(29,6,20.12,'Normal','2025-02-12 09:09:55'),(30,7,24.81,'Normal','2025-01-15 03:44:57'),(31,7,25.1,'Normal','2025-02-18 10:42:33'),(32,33,28.68,'Overweight','2025-01-14 07:49:47'),(33,33,29.02,'Overweight','2025-02-20 06:20:27'),(34,10,20.03,'Normal','2025-01-05 06:52:41'),(35,10,20.34,'Normal','2025-02-10 11:59:16'),(36,69,26.8,'Overweight','2025-01-16 09:13:59'),(37,69,27.15,'Overweight','2025-02-19 08:25:24'),(38,12,20.71,'Normal','2025-01-11 05:41:08'),(39,12,21.03,'Normal','2025-02-18 10:19:13'),(40,13,24.91,'Normal','2025-01-13 04:47:44'),(41,13,25.14,'Normal','2025-02-17 08:38:33'),(42,14,19.38,'Normal','2025-01-04 03:43:25'),(43,14,19.6,'Normal','2025-02-11 07:57:49'),(44,15,26.74,'Overweight','2025-01-18 10:01:51'),(45,15,27.01,'Overweight','2025-02-21 07:15:30'),(46,16,21.99,'Normal','2025-01-09 05:14:37'),(47,16,22.25,'Normal','2025-02-13 11:07:44'),(48,17,25.34,'Normal','2025-01-19 05:40:55'),(49,17,25.66,'Normal','2025-02-22 09:11:32'),(50,18,23.23,'Normal','2025-01-17 04:58:14'),(51,18,23.5,'Normal','2025-02-20 10:26:27'),(52,19,26.87,'Overweight','2025-01-08 04:21:20'),(53,19,27.12,'Overweight','2025-02-11 07:01:40'),(54,20,20.55,'Normal','2025-01-06 03:13:29'),(55,20,20.78,'Normal','2025-02-13 06:28:45'),(56,21,23.39,'Normal','2025-01-14 06:17:55'),(57,21,23.7,'Normal','2025-02-19 08:03:18'),(58,22,19.92,'Normal','2025-01-10 05:09:47'),(59,22,20.12,'Normal','2025-02-14 09:59:01'),(60,23,25.5,'Overweight','2025-01-11 07:02:10'),(61,23,25.8,'Overweight','2025-02-15 11:11:48'),(62,24,20.19,'Normal','2025-01-12 05:29:17'),(63,24,20.4,'Normal','2025-02-18 09:23:33'),(64,25,27.16,'Overweight','2025-01-13 04:15:56'),(65,25,27.43,'Overweight','2025-02-17 06:52:11'),(66,26,19.08,'Normal','2025-01-07 03:03:48'),(67,26,19.39,'Normal','2025-02-12 08:01:04'),(68,27,27.17,'Overweight','2025-01-16 06:14:12'),(69,27,27.45,'Overweight','2025-02-21 09:54:51'),(70,28,21.67,'Normal','2025-01-15 04:29:29'),(71,28,21.92,'Normal','2025-02-20 08:46:47'),(72,29,25.3,'Overweight','2025-01-18 07:01:21'),(73,29,25.6,'Overweight','2025-02-22 10:44:09'),(74,30,21.07,'Normal','2025-01-17 04:44:34'),(75,30,21.34,'Normal','2025-02-19 07:14:57'),(76,70,23.836734693877553,'Normal','2025-11-14 11:43:18'),(77,70,23.148148148148145,'Normal','2025-11-14 11:44:22'),(78,14,23.456790123456788,'Normal','2025-11-15 06:29:26');
/*!40000 ALTER TABLE `bmi_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diet_plans`
--

DROP TABLE IF EXISTS `diet_plans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diet_plans` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bmi_category` varchar(20) NOT NULL,
  `recommended_foods` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `bmi_category` (`bmi_category`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diet_plans`
--

LOCK TABLES `diet_plans` WRITE;
/*!40000 ALTER TABLE `diet_plans` DISABLE KEYS */;
INSERT INTO `diet_plans` VALUES (1,'Underweight','High-calorie foods: nuts, peanut butter, whole grains, dairy.'),(2,'Normal','Balanced diet: fruits, vegetables, proteins, whole grains.'),(3,'Overweight','Low-calorie diet: vegetables, lean proteins, avoid sugar.'),(4,'Obese','Consult dietitian: focus on portion control, exercise.');
/*!40000 ALTER TABLE `diet_plans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `age` int NOT NULL,
  `gender` varchar(10) NOT NULL,
  `height` double NOT NULL,
  `weight` double NOT NULL,
  `activity_level` varchar(10) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'user1@gmail.com','Rahul Verma',21,'Male',1.72,68,'Moderate','pass12'),(2,'user2@gmail.com','Sneha Sharma',22,'Female',1.6,54,'Light','pass123'),(3,'user3@gmail.com','Arjun Reddy',23,'Male',1.78,82,'High','pass1234'),(4,'user4@gmail.com','Priya Nair',20,'Female',1.55,48,'Moderate','pass1235'),(5,'user5@gmail.com','Siddharth Rao',25,'Male',1.8,90,'Sedentary','pass1236'),(6,'user6@gmail.com','Nisha Gupta',19,'Female',1.62,52,'Light','pass1232'),(7,'user7@gmail.com','Karan Malhotra',24,'Male',1.75,76,'Moderate','pass1233'),(9,'chatradhara007@gmail.com','Chatradhara Reddy',18,'Male',1.8,74,'Moderate','22022007'),(10,'user10@gmail.com','Megha Jain',22,'Female',1.58,50,'Light','pass1232'),(11,'knight@gmail.com','chatra',18,'Male',1.8,75,'Moderate','22022007'),(12,'user12@gmail.com','Swathi Krishna',23,'Female',1.63,55,'Sedentary','pass12365'),(13,'user13@gmail.com','Rakesh Kumar',30,'Male',1.7,72,'Moderate','pass12369'),(14,'user14@gmail.com','Pooja Kaur',21,'Female',1.8,76,'moderate','pass12382'),(15,'user15@gmail.com','Vinay Kulkarni',22,'Male',1.74,81,'High','pass123254'),(16,'user16@gmail.com','Deepika Rathi',24,'Female',1.61,57,'Moderate','pass123420'),(17,'user17@gmail.com','Abhinav Jain',25,'Male',1.72,75,'Moderate','pass1236969'),(18,'user18@gmail.com','Geetha Mani',29,'Female',1.66,64,'Moderate','pass12369'),(19,'user19@gmail.com','Suresh Das',26,'Male',1.85,92,'High','pass12369420'),(20,'user20@gmail.com','Lakshmi Prasad',28,'Female',1.68,58,'Sedentary','pass1'),(21,'user21@gmail.com','Gaurav Mehta',23,'Male',1.73,70,'Moderate','pass12'),(22,'user22@gmail.com','Ritika Roy',24,'Female',1.6,51,'Light','pass'),(23,'user23@gmail.com','Vikram Shetty',27,'Male',1.76,79,'Moderate','pa'),(24,'user24@gmail.com','Harini Iyer',28,'Female',1.62,53,'Sedentary','pas'),(25,'user25@gmail.com','Manoj Patil',30,'Male',1.8,88,'High','hello'),(26,'user26@gmail.com','Sravani Rao',22,'Female',1.57,47,'Light','world'),(27,'user27@gmail.com','Yashwant Reddy',21,'Male',1.83,91,'High','king'),(28,'user28@gmail.com','Nagma Shaikh',26,'Female',1.65,59,'Moderate','broad'),(29,'user29@gmail.com','Bharat Kumar',23,'Male',1.71,74,'Moderate','cha'),(30,'user30@gmail.com','Radhika Menon',25,'Female',1.63,56,'Moderate','pash'),(33,'user9@gmail.com','Rohit Singh',28,'Male',1.82,95,'High','pass1231'),(69,'user11@gmail.com','Harsha Vardhan',27,'Male',1.77,84,'Moderate','pass12344'),(70,'satvik@gmail.com','satvik',18,'Male',1.8,75,'high','22022007');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-16  9:01:50
