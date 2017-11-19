-- phpMyAdmin SQL Dump
-- version 3.3.7deb5build0.10.10.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 25, 2011 at 06:41 PM
-- Server version: 5.1.49
-- PHP Version: 5.3.3-1ubuntu9.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `stego_base`
--

-- --------------------------------------------------------

--
-- Table structure for table `Stegolica_progress`
--

CREATE TABLE IF NOT EXISTS `Stegolica_progress` (
  `team` varchar(100) NOT NULL,
  `no` int(10) NOT NULL,
  `uptime` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Stegolica_progress`
--


-- --------------------------------------------------------

--
-- Table structure for table `Stegolica_questions`
--

CREATE TABLE IF NOT EXISTS `Stegolica_questions` (
  `ques` varchar(150) NOT NULL,
  `ans` varchar(150) NOT NULL,
  `no` int(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Stegolica_questions`
--

INSERT INTO `Stegolica_questions` (`ques`, `ans`, `no`) VALUES
('images/gghgyui.png', '61438', 2),
('images/sgsgssg.png', 'god knows everything', 1),
('images/fgturetu.png', 'run and hide', 3),
('images/sdgdyui.png', '9244477778', 4),
('images/fgbhxgj.png', 'take rest', 5),
('images/hjkgjj.png', 'information is highly relevant', 6),
('images/ifgdhhg.png', 'education', 7),
('images/jstwretri.png', 'target', 8),
('images/ldfhdhg.png', 'airport', 9),
('images/odfugy.png', 'e', 10);
