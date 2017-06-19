/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

DROP DATABASE IF EXISTS `tm`;
CREATE DATABASE IF NOT EXISTS `tm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tm`;

DROP TABLE IF EXISTS `appointment`;
CREATE TABLE IF NOT EXISTS `appointment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateAndTime` datetime DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `specialist_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8itpwy8dyp3u1l2f5iq319c6i` (`client_id`),
  KEY `FK497sa8kpik8jotopwqh09xnf6` (`specialist_id`),
  CONSTRAINT `FK497sa8kpik8jotopwqh09xnf6` FOREIGN KEY (`specialist_id`) REFERENCES `specialist` (`id`),
  CONSTRAINT `FK8itpwy8dyp3u1l2f5iq319c6i` FOREIGN KEY (`client_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
REPLACE INTO `appointment` (`id`, `dateAndTime`, `client_id`, `specialist_id`) VALUES
	(3, '2017-06-01 16:00:43', 1, 1),
	(11, '2017-06-09 15:00:00', 1, 1),
	(19, '2017-06-22 08:00:00', 1, 1),
	(23, '2017-06-12 11:00:00', 1, 1);
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;

DROP TABLE IF EXISTS `dailytimetable`;
CREATE TABLE IF NOT EXISTS `dailytimetable` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `breakEnds` time DEFAULT NULL,
  `breakStarts` time DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `timeForAppointment` time DEFAULT NULL,
  `workEnds` time DEFAULT NULL,
  `workStarts` time DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `dailytimetable` DISABLE KEYS */;
REPLACE INTO `dailytimetable` (`Id`, `breakEnds`, `breakStarts`, `notes`, `place`, `timeForAppointment`, `workEnds`, `workStarts`) VALUES
	(1, '14:00:00', '13:00:00', 'Note', 'Room #10', '00:30:00', '17:00:00', '08:00:00'),
	(3, '14:00:00', '13:00:00', 'Note', 'Room #10', '00:30:00', '17:00:00', '08:00:00'),
	(5, '14:00:00', '13:00:00', 'Note', 'Room #10', '00:30:00', '17:00:00', '08:00:00'),
	(7, '14:00:00', '13:00:00', 'Note', 'Room #10', '00:30:00', '17:00:00', '08:00:00'),
	(9, '14:00:00', '13:00:00', 'Note', 'Room #10', '00:30:00', '17:00:00', '08:00:00'),
	(17, NULL, NULL, 'Weekend', NULL, NULL, NULL, NULL),
	(19, NULL, NULL, 'Weekend', NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `dailytimetable` ENABLE KEYS */;

DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `organisation_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcn5bom6gx37w99jubs7phf042` (`organisation_id`),
  CONSTRAINT `FKcn5bom6gx37w99jubs7phf042` FOREIGN KEY (`organisation_id`) REFERENCES `organisation` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `department` DISABLE KEYS */;
REPLACE INTO `department` (`id`, `name`, `organisation_id`) VALUES
	(1, 'Department 1', 1),
	(3, '2', 1);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
REPLACE INTO `hibernate_sequence` (`next_val`) VALUES
	(2);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

DROP TABLE IF EXISTS `organisation`;
CREATE TABLE IF NOT EXISTS `organisation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `admin_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKitv4s5p83oeib8yeyjm8jho1q` (`admin_id`),
  CONSTRAINT `FKitv4s5p83oeib8yeyjm8jho1q` FOREIGN KEY (`admin_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `organisation` DISABLE KEYS */;
REPLACE INTO `organisation` (`id`, `address`, `name`, `admin_id`) VALUES
	(1, 'бул. Шевченка 123', 'Test Facility', 1);
/*!40000 ALTER TABLE `organisation` ENABLE KEYS */;

DROP TABLE IF EXISTS `rearrangerequest`;
CREATE TABLE IF NOT EXISTS `rearrangerequest` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `newTime` date DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `appointment_id` int(11) DEFAULT NULL,
  `initiator_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKjlvffsprw2f82n7uvcypbcbhd` (`appointment_id`),
  KEY `FKe60r7xnawlimkpjj3ood8n812` (`initiator_id`),
  CONSTRAINT `FKe60r7xnawlimkpjj3ood8n812` FOREIGN KEY (`initiator_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKjlvffsprw2f82n7uvcypbcbhd` FOREIGN KEY (`appointment_id`) REFERENCES `appointment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `rearrangerequest` DISABLE KEYS */;
/*!40000 ALTER TABLE `rearrangerequest` ENABLE KEYS */;

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
REPLACE INTO `role` (`id`, `name`) VALUES
	(1, 'ROLE_USER'),
	(3, 'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

DROP TABLE IF EXISTS `specialist`;
CREATE TABLE IF NOT EXISTS `specialist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `specialization` varchar(255) NOT NULL,
  `department_id` int(11) DEFAULT NULL,
  `timetable_Id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgwgith1q7tju4fvqo1ogk8ufi` (`department_id`),
  KEY `FKgsji8jdp9tswddpfl34p31fvy` (`timetable_Id`),
  KEY `FKtlxjm5i2505jn02jyjls8uhm` (`user_id`),
  CONSTRAINT `FKgsji8jdp9tswddpfl34p31fvy` FOREIGN KEY (`timetable_Id`) REFERENCES `timetable` (`Id`),
  CONSTRAINT `FKgwgith1q7tju4fvqo1ogk8ufi` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `FKtlxjm5i2505jn02jyjls8uhm` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `specialist` DISABLE KEYS */;
REPLACE INTO `specialist` (`id`, `specialization`, `department_id`, `timetable_Id`, `user_id`) VALUES
	(1, 'Surgeon', 1, 1, 3);
/*!40000 ALTER TABLE `specialist` ENABLE KEYS */;

DROP TABLE IF EXISTS `timetable`;
CREATE TABLE IF NOT EXISTS `timetable` (
  `Id` int(11) NOT NULL,
  `allowUnregistered` bit(1) DEFAULT NULL,
  `applyingDate` date DEFAULT NULL,
  `expiringDate` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `timetable` DISABLE KEYS */;
REPLACE INTO `timetable` (`Id`, `allowUnregistered`, `applyingDate`, `expiringDate`) VALUES
	(1, b'0', '2017-01-01', '2017-12-31');
/*!40000 ALTER TABLE `timetable` ENABLE KEYS */;

DROP TABLE IF EXISTS `timetable_dailytimetable`;
CREATE TABLE IF NOT EXISTS `timetable_dailytimetable` (
  `Timetable_Id` int(11) NOT NULL,
  `timetables_Id` int(11) NOT NULL,
  UNIQUE KEY `UK_g5x4ia8872coogwdb0onps83d` (`timetables_Id`),
  KEY `FKsy1q9hq7gln5r8g3nwachv107` (`Timetable_Id`),
  CONSTRAINT `FKb7fjossjvkbylp4ymax24jq2h` FOREIGN KEY (`timetables_Id`) REFERENCES `dailytimetable` (`Id`),
  CONSTRAINT `FKsy1q9hq7gln5r8g3nwachv107` FOREIGN KEY (`Timetable_Id`) REFERENCES `timetable` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `timetable_dailytimetable` DISABLE KEYS */;
REPLACE INTO `timetable_dailytimetable` (`Timetable_Id`, `timetables_Id`) VALUES
	(1, 1),
	(1, 3),
	(1, 5),
	(1, 7),
	(1, 9),
	(1, 17),
	(1, 19);
/*!40000 ALTER TABLE `timetable_dailytimetable` ENABLE KEYS */;

DROP TABLE IF EXISTS `unregisteredappointment`;
CREATE TABLE IF NOT EXISTS `unregisteredappointment` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `clientsFullName` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `endTime` time NOT NULL,
  `startTime` time NOT NULL,
  `specialist_id` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKlv7eohgwme3fsbkrepqokistf` (`specialist_id`),
  CONSTRAINT `FKlv7eohgwme3fsbkrepqokistf` FOREIGN KEY (`specialist_id`) REFERENCES `specialist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `unregisteredappointment` DISABLE KEYS */;
/*!40000 ALTER TABLE `unregisteredappointment` ENABLE KEYS */;

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`id`, `email`, `fullName`, `password`, `phone`) VALUES
	(1, 'metryumora@gmail.com', 'Валентин Тулуб', '$2a$10$UolQraowJD/f05.XRDzaB.mjkyIHv7bWYORdHq1xrZegYXtTlpGxm', '+380671841877'),
	(3, 'spec@gmail.com', 'Dr. John Watson', '$2a$10$Xi1Kbg44sttv7De/n8e/M.25ZhpF.XxMxZBGk/QFraJ/fYOtOodvC', '322223');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKbhgxpici80n5kpvs65q90ou14` (`role_id`),
  CONSTRAINT `FKbhgxpici80n5kpvs65q90ou14` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKhlmdr3u7pdi6gfd47cgcb4p6t` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
REPLACE INTO `user_roles` (`user_id`, `role_id`) VALUES
	(1, 1),
	(3, 1);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
