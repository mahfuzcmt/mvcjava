-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 03, 2016 at 12:39 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ns`
--

-- --------------------------------------------------------

--
-- Table structure for table `classroutine`
--

CREATE TABLE IF NOT EXISTS `classroutine` (
  `oid` varchar(64) NOT NULL,
  `teacherID` varchar(128) NOT NULL,
  `courseID` varchar(128) NOT NULL,
  `shift` varchar(128) DEFAULT NULL,
  `sessionYear` varchar(512) NOT NULL,
  `days` varchar(512) NOT NULL,
  `timeFrom` varchar(128) DEFAULT NULL,
  `timeTo` varchar(128) DEFAULT NULL,
  `createdBy` varchar(64) DEFAULT 'Admin',
  `createdOn` datetime DEFAULT NULL,
  `updatedBy` varchar(64) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `oid` varchar(64) NOT NULL,
  `code` varchar(512) NOT NULL,
  `name` varchar(512) NOT NULL,
  `credit` varchar(512) NOT NULL,
  `courseTeacher` varchar(512) DEFAULT NULL,
  `shift` varchar(512) DEFAULT NULL,
  `createdBy` varchar(64) DEFAULT 'Admin',
  `createdOn` datetime DEFAULT NULL,
  `updatedBy` varchar(64) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`oid`, `code`, `name`, `credit`, `courseTeacher`, `shift`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
('01', 'CSE-01', 'Object Oriented Programming-1', '3', 't01', 'eve', 'Mahfuz Ahmed', '2016-08-22 00:00:00', NULL, NULL),
('02', 'CSE-02', 'Object Oriented Programming-2', '3', '20160903-160111-dqMHbUWoM8syPg1', 'eve', 'Mahfuz Ahmed', '2016-08-22 00:00:00', NULL, NULL),
('03', 'CSE-03', 'Software Engineering', '3', 't01', 'eve', 'Mahfuz Ahmed', '2016-08-22 00:00:00', NULL, NULL),
('04', 'CSE-04', 'Database Mangement System', '3', 't01', 'eve', 'Mahfuz Ahmed', '2016-08-22 00:00:00', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `coursemapping`
--

CREATE TABLE IF NOT EXISTS `coursemapping` (
  `oid` varchar(64) NOT NULL,
  `studentID` varchar(512) NOT NULL,
  `courseID` varchar(512) NOT NULL,
  `status` varchar(512) NOT NULL,
  `examResult` varchar(512) DEFAULT NULL,
  `sessionYear` varchar(512) DEFAULT NULL,
  `shift` varchar(512) DEFAULT NULL,
  `createdBy` varchar(64) DEFAULT 'Admin',
  `createdOn` datetime DEFAULT NULL,
  `updatedBy` varchar(64) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `coursemapping`
--

INSERT INTO `coursemapping` (`oid`, `studentID`, `courseID`, `status`, `examResult`, `sessionYear`, `shift`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
('20160903-152102-3LEcOxVZMnZTNZc', '2215030081', '02', 'registered', NULL, NULL, 'eve', 'admin', '2016-09-03 15:21:02', 'admin', '2016-09-03 15:27:10'),
('20160903-152102-LKCbzP3duwDksOv', '2215030081', '03', 'registered', NULL, NULL, 'eve', 'admin', '2016-09-03 15:21:02', 'admin', '2016-09-03 15:27:27'),
('20160903-152102-RliKwHT1Hf3Pr3o', '2215030081', '04', 'registered', NULL, NULL, 'eve', 'admin', '2016-09-03 15:21:02', 'admin', '2016-09-03 15:27:17'),
('20160903-152102-Ss7h70xV6rhJvbC', '2215030081', '01', 'registered', NULL, NULL, 'eve', 'admin', '2016-09-03 15:21:02', 'admin', '2016-09-03 15:27:22');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `loginID` varchar(64) NOT NULL,
  `roleID` varchar(64) NOT NULL,
  `featureJSON` text NOT NULL,
  `password` varchar(100) NOT NULL,
  `status` varchar(2) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `phoneNo` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `imagePath` varchar(128) DEFAULT NULL,
  `dataJSON` text,
  `createdBy` varchar(64) DEFAULT 'Admin',
  `createdOn` datetime DEFAULT NULL,
  `updatedBy` varchar(64) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`loginID`, `roleID`, `featureJSON`, `password`, `status`, `name`, `phoneNo`, `email`, `imagePath`, `dataJSON`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
('admin', 'admin', '{"children":[{"id":"webMenu","url":"webMenu","text":"Web Menu","enable":false,"children":[{"id":"dashboard","url":"dashboard","text":"dashboard","enable":true,"settings":[],"children":[],"$$hashKey":"object:237"},{"id":"student","url":"student","text":"Student","enable":true,"settings":[],"children":[],"$$hashKey":"object:238"},{"id":"teacher","url":"teacher","text":"Teacher","enable":true,"settings":[],"children":[{"id":"schedule","url":"schedule","text":"Schedule","enable":false,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:268"},{"id":"mystudents","url":"mystudents","text":"My Student","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:269"}],"$$hashKey":"object:239"},{"id":"course","url":"course","text":"Course","enable":true,"settings":[],"children":[],"$$hashKey":"object:240"},{"id":"registration","url":"registration","text":"Registration","enable":true,"settings":[],"children":[],"$$hashKey":"object:241"},{"id":"settings","url":"settings","text":"Settings","enable":true,"settings":[],"children":[{"id":"userManagement","url":"userManagement","text":"User Management","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:569"},{"id":"roleManagement","url":"roleManagement","text":"Role Management","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:570"}],"$$hashKey":"object:242"}],"$$hashKey":"object:233"}]}', 'RReQzFI520Y=', 'A', 'Mahfuz Ahmed', '+8801975585960', 'mahfuzcmt@gmail.com', 'images/user/5c4afa22-e733-4bdb-9b31-58011856e8f3.jpg', NULL, 'Admin', NULL, 'admin', '2016-09-03 16:25:12'),
('tcr-brishti', 'teacher', '{"children":[{"id":"webMenu","url":"webMenu","text":"Web Menu","enable":false,"children":[{"id":"dashboard","url":"dashboard","text":"dashboard","enable":true,"settings":[],"children":[],"$$hashKey":"object:246"},{"id":"student","url":"student","text":"Student","enable":false,"settings":[],"children":[],"$$hashKey":"object:247"},{"id":"teacher","url":"teacher","text":"Teacher","enable":true,"settings":[],"children":[{"id":"schedule","url":"schedule","text":"Schedule","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:277"},{"id":"mystudents","url":"mystudents","text":"My Student","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:278"}],"$$hashKey":"object:248"},{"id":"course","url":"course","text":"Course","enable":true,"settings":[],"children":[],"$$hashKey":"object:249"},{"id":"registration","url":"registration","text":"Registration","enable":true,"settings":[],"children":[],"$$hashKey":"object:250"},{"id":"settings","url":"settings","text":"Settings","enable":true,"settings":[],"children":[{"id":"userManagement","url":"userManagement","text":"User Management","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:569"},{"id":"roleManagement","url":"roleManagement","text":"Role Management","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:570"}],"$$hashKey":"object:251"}],"$$hashKey":"object:242"}]}', '2muYJuh1vKU=', 'A', 'brishti shaha', '01987885555', 'brishti@brishti.brishti', 'images/user/e9fa02b8-ff7d-49ba-a29e-648c98ae37a9.JPG', NULL, 'admin', '2016-09-03 16:01:11', 'admin', '2016-09-03 16:24:34'),
('tcr-farah', 'teacher', '{"children":[{"id":"webMenu","url":"webMenu","text":"Web Menu","enable":false,"children":[{"id":"dashboard","url":"dashboard","text":"dashboard","enable":true,"settings":[],"children":[],"$$hashKey":"object:222"},{"id":"student","url":"student","text":"Student","enable":true,"settings":[],"children":[],"$$hashKey":"object:223"},{"id":"teacher","url":"teacher","text":"Teacher","enable":true,"settings":[],"children":[{"id":"schedule","url":"schedule","text":"Schedule","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:253"},{"id":"mystudents","url":"mystudents","text":"My Student","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:254"}],"$$hashKey":"object:224"},{"id":"course","url":"course","text":"Course","enable":false,"settings":[],"children":[],"$$hashKey":"object:225"},{"id":"registration","url":"registration","text":"Registration","enable":true,"settings":[],"children":[],"$$hashKey":"object:226"},{"id":"settings","url":"settings","text":"Settings","enable":true,"settings":[],"children":[{"id":"userManagement","url":"userManagement","text":"User Management","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:569"},{"id":"roleManagement","url":"roleManagement","text":"Role Management","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:570"}],"$$hashKey":"object:227"}],"$$hashKey":"object:218"}]}', 'RReQzFI520Y=', 'A', 'farah naz', '019785555', '', 'images/user/62e3b3f9-95a7-445f-99aa-638b4fee6e6a.png', NULL, 'tcr-tonu', '2016-09-03 15:50:03', 'admin', '2016-09-03 16:24:44'),
('tcr-test', 'teacher', '{"children":[{"id":"webMenu","url":"webMenu","text":"Web Menu","enable":false,"children":[{"id":"dashboard","url":"dashboard","text":"dashboard","enable":true,"settings":[],"children":[]},{"id":"student","url":"student","text":"Student","enable":true,"settings":[],"children":[]},{"id":"teacher","url":"teacher","text":"Teacher","enable":true,"settings":[],"children":[{"id":"schedule","url":"schedule","text":"Schedule","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}]},{"id":"mystudents","url":"mystudents","text":"My Student","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}]}]},{"id":"course","url":"course","text":"Course","enable":true,"settings":[],"children":[]},{"id":"registration","url":"registration","text":"Registration","enable":true,"settings":[],"children":[]},{"id":"settings","url":"settings","text":"Settings","enable":true,"settings":[],"children":[{"id":"userManagement","url":"userManagement","text":"User Management","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:569"},{"id":"roleManagement","url":"roleManagement","text":"Role Management","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:570"}]}]}]}', 'RReQzFI520Y=', 'A', 'test khan', '01975585960', 'male@male.male', 'images/user/9a5e77c5-0f79-4ab3-ae8f-f66ea4cc5b87.jpg', NULL, 'admin', '2016-09-03 16:33:20', 'tcr-test', '2016-09-03 16:34:02'),
('tcr-tonu', 'teacher', '{"children":[{"id":"webMenu","url":"webMenu","text":"Web Menu","enable":false,"children":[{"id":"dashboard","url":"dashboard","text":"dashboard","enable":true,"settings":[],"children":[]},{"id":"student","url":"student","text":"Student","enable":true,"settings":[],"children":[]},{"id":"teacher","url":"teacher","text":"Teacher","enable":true,"settings":[],"children":[{"id":"schedule","url":"schedule","text":"Schedule","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}]},{"id":"mystudents","url":"mystudents","text":"My Student","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}]}]},{"id":"course","url":"course","text":"Course","enable":true,"settings":[],"children":[]},{"id":"registration","url":"registration","text":"Registration","enable":true,"settings":[],"children":[]},{"id":"settings","url":"settings","text":"Settings","enable":true,"settings":[],"children":[{"id":"userManagement","url":"userManagement","text":"User Management","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:569"},{"id":"roleManagement","url":"roleManagement","text":"Role Management","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:570"}]}]}]}', 'RReQzFI520Y=', 'A', 'Tonusshree Sharma', '01798989', 'att@gmail.com', 'images/user/9c698d4d-b5c0-4bdc-a394-e26fd701376d.jpg', NULL, 'admin', '2016-09-03 15:47:32', 'admin', '2016-09-03 16:24:54'),
('test', 'admin', '{"children":[{"id":"webMenu","url":"webMenu","text":"Web Menu","enable":false,"children":[{"id":"dashboard","url":"dashboard","text":"dashboard","enable":true,"settings":[],"children":[],"$$hashKey":"object:594"},{"id":"student","url":"student","text":"Student","enable":false,"settings":[],"children":[],"$$hashKey":"object:595"},{"id":"teacher","url":"teacher","text":"Teacher","enable":false,"settings":[],"children":[{"id":"schedule","url":"schedule","text":"Schedule","enable":false,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:625"},{"id":"mystudents","url":"mystudents","text":"My Student","enable":false,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:626"}],"$$hashKey":"object:596"},{"id":"course","url":"course","text":"Course","enable":false,"settings":[],"children":[],"$$hashKey":"object:597"},{"id":"registration","url":"registration","text":"Registration","enable":true,"settings":[],"children":[],"$$hashKey":"object:598"},{"id":"settings","url":"settings","text":"Settings","enable":false,"settings":[],"children":[{"id":"userManagement","url":"userManagement","text":"User Management","enable":false,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:569"},{"id":"roleManagement","url":"roleManagement","text":"Role Management","enable":false,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:570"}],"$$hashKey":"object:599"}],"$$hashKey":"object:591"}]}', 'RReQzFI520Y=', 'A', 'test', '4534', '534', '', NULL, 'tcr-test', '2016-09-03 16:34:39', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `loginlog`
--

CREATE TABLE IF NOT EXISTS `loginlog` (
  `oid` varchar(64) NOT NULL,
  `loginID` varchar(64) NOT NULL,
  `roleID` varchar(64) DEFAULT NULL,
  `ipAddress` varchar(64) DEFAULT NULL,
  `loginTime` datetime DEFAULT NULL,
  `logoutTime` datetime DEFAULT NULL,
  `loginStatus` varchar(64) DEFAULT NULL,
  `LOGINDURATION` varchar(64) DEFAULT NULL,
  `createdBy` varchar(64) DEFAULT 'Admin',
  `createdOn` datetime DEFAULT NULL,
  `updatedBy` varchar(64) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loginlog`
--

INSERT INTO `loginlog` (`oid`, `loginID`, `roleID`, `ipAddress`, `loginTime`, `logoutTime`, `loginStatus`, `LOGINDURATION`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
('0fe08b12-585f-4e7a-a8a0-4fe6e9fc15f3', 'admin', NULL, NULL, '2016-09-03 16:12:43', NULL, NULL, NULL, 'Admin', NULL, NULL, NULL),
('36eaf0c4-78fa-43f6-918c-91d4936d3a0c', 'admin', NULL, NULL, '2016-09-03 16:39:20', NULL, NULL, NULL, 'Admin', NULL, NULL, NULL),
('3bc1e038-b267-45d4-9721-d1970a31cfe2', 'tcr-test', NULL, NULL, '2016-09-03 16:33:48', NULL, NULL, NULL, 'Admin', NULL, NULL, NULL),
('ac1abb9d-e692-49c5-91d4-abfa886ae89f', 'admin', NULL, NULL, '2016-09-03 16:31:41', NULL, NULL, NULL, 'Admin', NULL, NULL, NULL),
('bd7e90f6-5caf-4805-80ff-7ebae269afb8', 'admin', NULL, NULL, '2016-09-03 16:26:23', NULL, NULL, NULL, 'Admin', NULL, NULL, NULL),
('dc98f0f4-0a40-4d1a-be56-caa75054e47a', 'admin', NULL, NULL, '2016-09-03 16:13:04', NULL, NULL, NULL, 'Admin', NULL, NULL, NULL),
('e2ac86d4-675a-452f-ac4b-73f9b169ea74', 'test', NULL, NULL, '2016-09-03 16:36:25', '2016-09-03 16:36:28', NULL, '3', 'Admin', NULL, NULL, NULL),
('ea31b0bb-4506-4096-bd12-16e8f7c3d0cf', 'tcr-test', NULL, NULL, '2016-09-03 16:36:33', NULL, NULL, NULL, 'Admin', NULL, NULL, NULL),
('ea7a083a-d4ac-43f9-a344-2d5d5ff427e7', 'admin', NULL, NULL, '2016-09-03 16:32:41', NULL, NULL, NULL, 'Admin', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `metaproperty`
--

CREATE TABLE IF NOT EXISTS `metaproperty` (
  `OID` varchar(64) NOT NULL,
  `valueJSON` text,
  `description` varchar(64) DEFAULT NULL,
  `createdBy` varchar(64) DEFAULT 'Admin',
  `createdOn` datetime DEFAULT NULL,
  `updatedBy` varchar(64) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `metaproperty`
--

INSERT INTO `metaproperty` (`OID`, `valueJSON`, `description`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
('MenuJSON', '{\n  "{\n  "children": [\n    {\n      "id": "webMenu",\n      "url": "webMenu",\n      "text": "Web Menu",\n      "enable": false,\n      "children": [\n        {\n          "id": "dashboard",\n          "url": "dashboard",\n          "text": "dashboard",\n          "enable": true,\n          "settings": [],\n          "children": []\n        },\n        {\n          "id": "student",\n          "url": "student",\n          "text": "Student",\n          "enable": true,\n          "settings": [],\n          "children": []\n        },\n        {\n          "id": "teacher",\n          "url": "teacher",\n          "text": "Teacher",\n          "enable": true,\n          "settings": [],\n          "children": [{\n              "id": "schedule",\n              "url": "schedule",\n              "text": "Schedule",\n              "enable": true,\n              "isSubmenu": true,\n              "children": [],\n              "settings": [\n                {\n                  "id": "itemperpage",\n                  "enable": true,\n                  "value": "15",\n                  "children": []\n                },\n                {\n                  "id": "defaultview",\n                  "enable": true,\n                  "value": "card",\n                  "children": []\n                }\n              ]},\n            {\n              "id": "mystudents",\n              "url": "mystudents",\n              "text": "My Student",\n              "enable": true,\n              "isSubmenu": true,\n              "children": [],\n              "settings": [\n                {\n                  "id": "itemperpage",\n                  "enable": true,\n                  "value": "15",\n                  "children": []\n                },\n                {\n                  "id": "defaultview",\n                  "enable": true,\n                  "value": "card",\n                  "children": []\n                }\n              ]}]\n        },\n        {\n          "id": "course",\n          "url": "course",\n          "text": "Course",\n          "enable": true,\n          "settings": [],\n          "children": []\n        },\n        {\n          "id": "registration",\n          "url": "registration",\n          "text": "Registration",\n          "enable": true,\n          "settings": [],\n          "children": []\n        },\n        {\n          "id": "settings",\n          "url": "settings",\n          "text": "Settings",\n          "enable": true,\n          "settings": [],\n          "children": [\n            {\n              "id": "userManagement",\n              "url": "userManagement",\n              "text": "User Management",\n              "enable": true,\n              "isSubmenu": true,\n              "children": [],\n              "settings": [\n                {\n                  "id": "itemperpage",\n                  "enable": true,\n                  "value": "15",\n                  "children": []\n                },\n                {\n                  "id": "defaultview",\n                  "enable": true,\n                  "value": "card",\n                  "children": []\n                }\n              ],\n              "$$hashKey": "object:569"\n            },\n            {\n              "id": "roleManagement",\n              "url": "roleManagement",\n              "text": "Role Management",\n              "enable": true,\n              "isSubmenu": true,\n              "children": [],\n              "settings": [\n                {\n                  "id": "itemperpage",\n                  "enable": true,\n                  "value": "15",\n                  "children": []\n                },\n                {\n                  "id": "defaultview",\n                  "enable": true,\n                  "value": "card",\n                  "children": []\n                }\n              ],\n              "$$hashKey": "object:570"\n            }\n          ]\n        }\n      ]\n    }\n  ]\n}', 'Menu JSON Template', 'Admin', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE IF NOT EXISTS `registration` (
  `oid` varchar(64) NOT NULL,
  `sid` varchar(128) NOT NULL,
  `courseID` varchar(128) NOT NULL,
  `shift` varchar(128) DEFAULT NULL,
  `status` varchar(128) DEFAULT NULL,
  `sessionYear` varchar(128) DEFAULT NULL,
  `batch` varchar(128) NOT NULL,
  `mobileNo` varchar(128) NOT NULL,
  `email` varchar(128) DEFAULT NULL,
  `createdBy` varchar(64) DEFAULT 'Admin',
  `createdOn` datetime DEFAULT NULL,
  `updatedBy` varchar(64) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`oid`, `sid`, `courseID`, `shift`, `status`, `sessionYear`, `batch`, `mobileNo`, `email`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
('20160903-152343-YbE992TZHe1j8dz', '2215030081', '04', 'eve', 'registered', NULL, '2nd', '01975585960', NULL, 'admin', '2016-09-03 15:23:43', NULL, NULL),
('20160903-152453-3NdwYoSXYWFF6aJ', '2215030081', '02', 'eve', 'registered', 'summer-2016', '2nd', '01975585960', NULL, 'admin', '2016-09-03 15:24:53', NULL, NULL),
('20160903-152626-U0VsObtcjWYAlU8', '2215030081', '03', 'eve', 'registered', NULL, '2nd', '01975585960', NULL, 'admin', '2016-09-03 15:26:26', NULL, NULL),
('20160903-152630-IAN0t1YLsaBHQeo', '2215030081', '01', 'eve', 'registered', NULL, '2nd', '01975585960', NULL, 'admin', '2016-09-03 15:26:30', NULL, NULL),
('20160903-152710-AYxvSjaHNTYUWzG', '2215030081', '02', 'eve', 'registered', NULL, '2nd', '01975585960', NULL, 'admin', '2016-09-03 15:27:10', NULL, NULL),
('20160903-152717-ZYUcWS2ogavLM0B', '2215030081', '04', 'eve', 'registered', NULL, '2nd', '01975585960', NULL, 'admin', '2016-09-03 15:27:17', NULL, NULL),
('20160903-152722-vO8Q7Z8nZwiN7tQ', '2215030081', '01', 'eve', 'registered', 'summer-2016', '2nd', '01975585960', NULL, 'admin', '2016-09-03 15:27:22', NULL, NULL),
('20160903-152727-mraDdokSf8fujv7', '2215030081', '03', 'eve', 'registered', 'spring-2016', '2nd', '01975585960', NULL, 'admin', '2016-09-03 15:27:27', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `roleID` varchar(64) NOT NULL,
  `roleDescription` varchar(128) DEFAULT NULL,
  `featureJSON` text NOT NULL,
  `createdBy` varchar(64) DEFAULT 'Admin',
  `createdOn` datetime DEFAULT NULL,
  `updatedBy` varchar(64) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`roleID`, `roleDescription`, `featureJSON`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
('admin', 'Super Admin', '{"children":[{"id":"webMenu","url":"webMenu","text":"Web Menu","enable":false,"children":[{"id":"dashboard","url":"dashboard","text":"dashboard","enable":true,"settings":[],"children":[],"$$hashKey":"object:594"},{"id":"student","url":"student","text":"Student","enable":true,"settings":[],"children":[],"$$hashKey":"object:595"},{"id":"teacher","url":"teacher","text":"Teacher","enable":true,"settings":[],"children":[{"id":"schedule","url":"schedule","text":"Schedule","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:625"},{"id":"mystudents","url":"mystudents","text":"My Student","enable":false,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:626"}],"$$hashKey":"object:596"},{"id":"course","url":"course","text":"Course","enable":true,"settings":[],"children":[],"$$hashKey":"object:597"},{"id":"registration","url":"registration","text":"Registration","enable":true,"settings":[],"children":[],"$$hashKey":"object:598"},{"id":"settings","url":"settings","text":"Settings","enable":true,"settings":[],"children":[{"id":"userManagement","url":"userManagement","text":"User Management","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:569"},{"id":"roleManagement","url":"roleManagement","text":"Role Management","enable":true,"isSubmenu":true,"children":[],"settings":[{"id":"itemperpage","enable":true,"value":"15","children":[]},{"id":"defaultview","enable":true,"value":"card","children":[]}],"$$hashKey":"object:570"}],"$$hashKey":"object:599"}],"$$hashKey":"object:591"}]}', 'Admin', NULL, 'admin', '2016-09-03 16:12:37'),
('teacher', 'Course Teacher', '{\n  "children": [\n    {\n      "id": "webMenu",\n      "url": "webMenu",\n      "text": "Web Menu",\n      "enable": false,\n      "children": [\n        {\n          "id": "dashboard",\n          "url": "dashboard",\n          "text": "dashboard",\n          "enable": true,\n          "settings": [],\n          "children": []\n        },\n        {\n          "id": "student",\n          "url": "student",\n          "text": "Student",\n          "enable": true,\n          "settings": [],\n          "children": []\n        },\n        {\n          "id": "teacher",\n          "url": "teacher",\n          "text": "Teacher",\n          "enable": true,\n          "settings": [],\n          "children": [{\n              "id": "schedule",\n              "url": "schedule",\n              "text": "Schedule",\n              "enable": true,\n              "isSubmenu": true,\n              "children": [],\n              "settings": [\n                {\n                  "id": "itemperpage",\n                  "enable": true,\n                  "value": "15",\n                  "children": []\n                },\n                {\n                  "id": "defaultview",\n                  "enable": true,\n                  "value": "card",\n                  "children": []\n                }\n              ]},\n            {\n              "id": "mystudents",\n              "url": "mystudents",\n              "text": "My Student",\n              "enable": true,\n              "isSubmenu": true,\n              "children": [],\n              "settings": [\n                {\n                  "id": "itemperpage",\n                  "enable": true,\n                  "value": "15",\n                  "children": []\n                },\n                {\n                  "id": "defaultview",\n                  "enable": true,\n                  "value": "card",\n                  "children": []\n                }\n              ]}]\n        },\n        {\n          "id": "course",\n          "url": "course",\n          "text": "Course",\n          "enable": true,\n          "settings": [],\n          "children": []\n        },\n        {\n          "id": "registration",\n          "url": "registration",\n          "text": "Registration",\n          "enable": true,\n          "settings": [],\n          "children": []\n        },\n        {\n          "id": "settings",\n          "url": "settings",\n          "text": "Settings",\n          "enable": true,\n          "settings": [],\n          "children": [\n            {\n              "id": "userManagement",\n              "url": "userManagement",\n              "text": "User Management",\n              "enable": true,\n              "isSubmenu": true,\n              "children": [],\n              "settings": [\n                {\n                  "id": "itemperpage",\n                  "enable": true,\n                  "value": "15",\n                  "children": []\n                },\n                {\n                  "id": "defaultview",\n                  "enable": true,\n                  "value": "card",\n                  "children": []\n                }\n              ],\n              "$$hashKey": "object:569"\n            },\n            {\n              "id": "roleManagement",\n              "url": "roleManagement",\n              "text": "Role Management",\n              "enable": true,\n              "isSubmenu": true,\n              "children": [],\n              "settings": [\n                {\n                  "id": "itemperpage",\n                  "enable": true,\n                  "value": "15",\n                  "children": []\n                },\n                {\n                  "id": "defaultview",\n                  "enable": true,\n                  "value": "card",\n                  "children": []\n                }\n              ],\n              "$$hashKey": "object:570"\n            }\n          ]\n        }\n      ]\n    }\n  ]\n}', 'Admin', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `schema_version`
--

CREATE TABLE IF NOT EXISTS `schema_version` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `schema_version`
--

INSERT INTO `schema_version` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES
(1, '00', 'init', 'SQL', 'R00__init.sql', 0, 'root', '2016-09-03 09:17:16', 2, 1),
(2, '010.00', 'createMetaObject.MySql', 'SQL', '00-common/R010_00__createMetaObject.MySql.sql', -1116664044, 'root', '2016-09-03 09:17:17', 216, 1),
(3, '010.01', 'createSecurityObject.MySql', 'SQL', '00-common/R010_01__createSecurityObject.MySql.sql', -931346897, 'root', '2016-09-03 09:17:17', 724, 1),
(4, '011.00', 'createStudentObject.MySql', 'SQL', '01-student/R011_00__createStudentObject.MySql.sql', -993761054, 'root', '2016-09-03 09:17:18', 208, 1),
(5, '012.02', 'createCourseObject.MySql', 'SQL', '02-course/R012_02__createCourseObject.MySql.sql', -1690456610, 'root', '2016-09-03 09:17:18', 434, 1),
(6, '013.00', 'createTeacherObject.MySql', 'SQL', '03-teacher/R013_00__createTeacherObject.MySql.sql', 298348354, 'root', '2016-09-03 09:17:18', 200, 1),
(7, '014.00', 'createRegistrationObject.MySql', 'SQL', '04-registration/R014_00__createRegistrationObject.MySql.sql', 2136693497, 'root', '2016-09-03 09:17:19', 407, 1),
(8, '015.000', 'createClassRoutineObject.MySql', 'SQL', '05-classroutine/R015_000__createClassRoutineObject.MySql.sql', -1372539383, 'root', '2016-09-03 09:17:19', 363, 1),
(9, '20.00', 'createIndex.MySQL', 'SQL', 'R20_00__createIndex.MySQL.sql', 0, 'root', '2016-09-03 09:17:19', 0, 1),
(10, '40.00', 'createTrigger', 'SQL', 'R40_00__createTrigger.sql', 0, 'root', '2016-09-03 09:17:19', 0, 1),
(11, '50.00', 'createView', 'SQL', 'R50_00__createView.sql', 0, 'root', '2016-09-03 09:17:19', 0, 1),
(12, '061.00', 'insertMetaData.MySql', 'SQL', 'R061_00__insertMetaData.MySql.sql', 1113653428, 'root', '2016-09-03 09:17:19', 111, 1),
(13, '061.01', 'insertCourseData.MySql', 'SQL', 'R061_01__insertCourseData.MySql.sql', 1875238183, 'root', '2016-09-03 09:17:19', 67, 1);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `oid` varchar(64) NOT NULL,
  `batch` varchar(128) DEFAULT NULL,
  `name` varchar(128) NOT NULL,
  `gender` varchar(128) DEFAULT NULL,
  `mobileNo` varchar(128) NOT NULL,
  `email` varchar(128) DEFAULT NULL,
  `image` varchar(128) DEFAULT NULL,
  `program` varchar(128) NOT NULL,
  `shift` varchar(128) NOT NULL,
  `createdBy` varchar(64) DEFAULT 'Admin',
  `createdOn` datetime DEFAULT NULL,
  `updatedBy` varchar(64) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`oid`, `batch`, `name`, `gender`, `mobileNo`, `email`, `image`, `program`, `shift`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
('2215030081', '2nd', 'mahfuz', 'male', '01975585960', NULL, NULL, 'cse', 'eve', 'admin', '2016-09-03 15:21:02', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE IF NOT EXISTS `teacher` (
  `oid` varchar(64) NOT NULL,
  `loginID` varchar(128) NOT NULL,
  `name` varchar(128) NOT NULL,
  `gender` varchar(128) DEFAULT NULL,
  `mobileNo` varchar(128) NOT NULL,
  `email` varchar(128) DEFAULT NULL,
  `image` varchar(128) DEFAULT NULL,
  `designation` varchar(128) NOT NULL,
  `createdBy` varchar(64) DEFAULT 'Admin',
  `createdOn` datetime DEFAULT NULL,
  `updatedBy` varchar(64) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`oid`, `loginID`, `name`, `gender`, `mobileNo`, `email`, `image`, `designation`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
('20160903-154732-4JUYK1IbrDMkouK', 'tcr-tonu', 'Tonusshree Sharma', NULL, '01798989', 'att@gmail.com', NULL, 'lecturer', 'admin', '2016-09-03 15:47:32', NULL, NULL),
('20160903-155003-jcYbd8A5SfWOEO6', 'tcr-farah', 'farah naz', NULL, '019785555', NULL, NULL, 'lecturer', 'tcr-tonu', '2016-09-03 15:50:03', NULL, NULL),
('20160903-160111-dqMHbUWoM8syPg1', 'tcr-brishti', 'brishti shaha', NULL, '01987885555', 'brishti@brishti.brishti', NULL, 'lecturer', 'admin', '2016-09-03 16:01:11', NULL, NULL),
('20160903-163320-uadVaTWxIXmgrof', 'tcr-test', 'test khan', 'male', '01975585960', 'male@male.male', NULL, 'lecturer', 'admin', '2016-09-03 16:33:20', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `classroutine`
--
ALTER TABLE `classroutine`
 ADD PRIMARY KEY (`oid`), ADD KEY `fk_teacherID_ClassRoutine` (`teacherID`), ADD KEY `fk_courseID_ClassRoutine` (`courseID`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
 ADD PRIMARY KEY (`oid`);

--
-- Indexes for table `coursemapping`
--
ALTER TABLE `coursemapping`
 ADD PRIMARY KEY (`oid`), ADD KEY `fk_studentID_CourseMapping` (`studentID`), ADD KEY `fk_courseID_CourseMapping` (`courseID`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
 ADD PRIMARY KEY (`loginID`), ADD KEY `f_roleID_Login` (`roleID`);

--
-- Indexes for table `loginlog`
--
ALTER TABLE `loginlog`
 ADD PRIMARY KEY (`oid`), ADD KEY `fk_loginlog_loginID` (`loginID`);

--
-- Indexes for table `metaproperty`
--
ALTER TABLE `metaproperty`
 ADD PRIMARY KEY (`OID`);

--
-- Indexes for table `registration`
--
ALTER TABLE `registration`
 ADD PRIMARY KEY (`oid`), ADD KEY `f_sid_Registration` (`sid`), ADD KEY `f_courseID_Registration` (`courseID`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
 ADD PRIMARY KEY (`roleID`);

--
-- Indexes for table `schema_version`
--
ALTER TABLE `schema_version`
 ADD PRIMARY KEY (`installed_rank`), ADD KEY `schema_version_s_idx` (`success`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
 ADD PRIMARY KEY (`oid`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
 ADD PRIMARY KEY (`oid`), ADD KEY `fk_Teacher_loginID` (`loginID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `classroutine`
--
ALTER TABLE `classroutine`
ADD CONSTRAINT `fk_courseID_ClassRoutine` FOREIGN KEY (`courseID`) REFERENCES `course` (`oid`),
ADD CONSTRAINT `fk_teacherID_ClassRoutine` FOREIGN KEY (`teacherID`) REFERENCES `teacher` (`oid`);

--
-- Constraints for table `coursemapping`
--
ALTER TABLE `coursemapping`
ADD CONSTRAINT `fk_courseID_CourseMapping` FOREIGN KEY (`courseID`) REFERENCES `course` (`oid`),
ADD CONSTRAINT `fk_studentID_CourseMapping` FOREIGN KEY (`studentID`) REFERENCES `student` (`oid`);

--
-- Constraints for table `login`
--
ALTER TABLE `login`
ADD CONSTRAINT `f_roleID_Login` FOREIGN KEY (`roleID`) REFERENCES `role` (`roleID`);

--
-- Constraints for table `loginlog`
--
ALTER TABLE `loginlog`
ADD CONSTRAINT `fk_loginlog_loginID` FOREIGN KEY (`loginID`) REFERENCES `login` (`loginID`);

--
-- Constraints for table `registration`
--
ALTER TABLE `registration`
ADD CONSTRAINT `f_courseID_Registration` FOREIGN KEY (`courseID`) REFERENCES `course` (`oid`),
ADD CONSTRAINT `f_sid_Registration` FOREIGN KEY (`sid`) REFERENCES `student` (`oid`);

--
-- Constraints for table `teacher`
--
ALTER TABLE `teacher`
ADD CONSTRAINT `fk_Teacher_loginID` FOREIGN KEY (`loginID`) REFERENCES `login` (`loginID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
