-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 21, 2015 at 07:45 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sisbase`
--

-- --------------------------------------------------------

--
-- Table structure for table `cn`
--

CREATE TABLE IF NOT EXISTS `cn` (
  `questions` varchar(30) NOT NULL,
  `answer` varchar(10) NOT NULL,
  `options` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cn`
--

INSERT INTO `cn` (`questions`, `answer`, `options`) VALUES
('How many bits for IPV4', '32', '32##64##128##256'),
('How many bits for IPV6', '128', '32##64##128##256'),
('which one is Larger', 'WAN', 'LAN##WAN##MAN##NONE'),
('segments related to?', 'TPL', 'TPL##NL##DLL');

-- --------------------------------------------------------

--
-- Table structure for table `course_details`
--

CREATE TABLE IF NOT EXISTS `course_details` (
  `CourseName` varchar(20) DEFAULT NULL,
  `ExamDate` datetime DEFAULT NULL,
  `MarksGainded` int(11) DEFAULT NULL,
  `TotalMarks` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_details`
--

INSERT INTO `course_details` (`CourseName`, `ExamDate`, `MarksGainded`, `TotalMarks`, `status`) VALUES
('CN', '2015-12-03 15:00:00', 0, 100, 0),
('OOPS', '2015-12-04 09:00:00', 0, 100, 0),
('ITW', '2015-12-05 14:00:00', 0, 100, 0),
('AI', '2015-12-06 08:30:00', 0, 100, 0);

-- --------------------------------------------------------

--
-- Table structure for table `course_registration`
--

CREATE TABLE IF NOT EXISTS `course_registration` (
  `iddno` varchar(10) DEFAULT NULL,
  `course` varchar(20) DEFAULT NULL,
  `marks` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_registration`
--

INSERT INTO `course_registration` (`iddno`, `course`, `marks`, `status`) VALUES
('N091130', 'CN', 4, 1),
('N091130', 'OOPS', 0, 0),
('N091130', 'ITW', 0, 0),
('N091130', 'AI', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `itw`
--

CREATE TABLE IF NOT EXISTS `itw` (
  `questions` varchar(80) NOT NULL,
  `options` varchar(80) NOT NULL,
  `answer` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itw`
--

INSERT INTO `itw` (`questions`, `options`, `answer`) VALUES
('MatLab developed by ?', 'mathworks##thoughtworks##google##microsoft', 'mathworks');

-- --------------------------------------------------------

--
-- Table structure for table `oops`
--

CREATE TABLE IF NOT EXISTS `oops` (
  `questions` varchar(80) NOT NULL,
  `options` varchar(80) NOT NULL,
  `answer` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `oops`
--

INSERT INTO `oops` (`questions`, `options`, `answer`) VALUES
('Who developed java ?', 'Ritche##Gosling##Babbeg##Charles', 'Gosling'),
('Odd man out?', 'encapsulation##interface##inheritance##abstration##polymorphism', 'interface');

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE IF NOT EXISTS `user_details` (
  `idno` varchar(10) NOT NULL DEFAULT '',
  `name` varchar(20) DEFAULT NULL,
  `batch` varchar(3) DEFAULT NULL,
  `branch` varchar(5) DEFAULT NULL,
  `class` varchar(2) DEFAULT NULL,
  `dob` varchar(10) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `cnctno` varchar(13) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`idno`, `name`, `batch`, `branch`, `class`, `dob`, `email`, `cnctno`, `password`) VALUES
('N091130', 'SUSANTH', 'E4', 'CSE', '1', '17-08-1994', 'susanth.pangi@gmail.com', '9441987094', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `oops`
--
ALTER TABLE `oops`
 ADD PRIMARY KEY (`answer`);

--
-- Indexes for table `user_details`
--
ALTER TABLE `user_details`
 ADD PRIMARY KEY (`idno`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
