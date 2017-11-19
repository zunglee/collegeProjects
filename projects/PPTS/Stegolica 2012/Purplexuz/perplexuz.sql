-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 25, 2012 at 10:39 AM
-- Server version: 5.5.24-log
-- PHP Version: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `perplexuz`
--

-- --------------------------------------------------------

--
-- Table structure for table `auth_user`
--

CREATE TABLE IF NOT EXISTS `auth_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(75) NOT NULL,
  `password` varchar(128) NOT NULL,
  `is_staff` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `is_superuser` tinyint(1) NOT NULL,
  `is_validate` tinyint(1) NOT NULL,
  `last_login` datetime NOT NULL,
  `date_joined` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `auth_user`
--

INSERT INTO `auth_user` (`id`, `username`, `first_name`, `last_name`, `email`, `password`, `is_staff`, `is_active`, `is_superuser`, `is_validate`, `last_login`, `date_joined`) VALUES
(1, 'droot', '', '', 'effervescence@iiita.ac.in', 'sha1$d3062$1f6c0257f9b631fd6f977e67b248111dc3337c15', 1, 1, 1, 0, '2012-09-20 22:07:18', '2012-09-20 20:49:47'),
(2, 'qe', '', '', 'anshumang001@gmail.com', 'sha1$08bc7$fd363b85480d24843c3c90f269ff8809824a04b1', 0, 1, 0, 1, '2012-09-20 20:51:35', '2012-09-20 20:51:35'),
(3, 'explorepulkit', '', '', 'explorepulkit@gmail.com', 'sha1$5656f$12c1474433621791743a39ea44dc60c9abebe31a', 0, 1, 0, 1, '2012-09-20 21:14:04', '2012-09-20 21:14:04'),
(4, 'gaurav728', '', '', 'gkb2004bhardwaj@gmail.com', 'sha1$4518d$6bfa05649a7a0d4bce5f762e16d375af94ccef96', 0, 1, 0, 1, '2012-09-20 21:24:20', '2012-09-20 21:24:20'),
(5, 'Hemant', '', '', 'mishra.hemant56@gmail.com', 'sha1$e6394$795f5e103a47431660d70d4cf564762ca3fab9b0', 0, 1, 0, 1, '2012-09-20 21:27:15', '2012-09-20 21:27:15'),
(6, 'cb135', '', '', 'cb140491@gmail.com', 'sha1$88e81$7496794ba445f0e1f97880e2590e31676fa97d98', 0, 1, 0, 0, '2012-09-20 21:44:44', '2012-09-20 21:44:44'),
(7, 'thrace', '', '', 'abinash29199207@gmail.com', 'sha1$1772c$bb48278600381d692e2b628ffaa2d8a81ba95dd5', 0, 1, 0, 1, '2012-09-20 21:47:56', '2012-09-20 21:47:56'),
(8, 'Aman', '', '', 'amanhussain29@gmail.com', 'sha1$93fd4$c98ca4adc05101a7e2be1eb9e62e331e36c4773e', 0, 1, 0, 1, '2012-09-20 21:56:16', '2012-09-20 21:56:16'),
(9, 'gagangupt16', 'Gagan', 'Gupta', 'gagangupt16@gmail.com', 'b1b3773a05c0ed0176787a4f1574ff0075f7521e', 0, 0, 0, 1, '0000-00-00 00:00:00', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `question_info`
--

CREATE TABLE IF NOT EXISTS `question_info` (
  `qid` int(11) NOT NULL,
  `question` varchar(50) NOT NULL,
  `ans` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question_info`
--

INSERT INTO `question_info` (`qid`, `question`, `ans`) VALUES
(1, 'q1', '8a8bb7cd343aa2ad99b7d762030857a2'),
(2, 'q2', 'a2');

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE IF NOT EXISTS `user_info` (
  `user_id` varchar(50) NOT NULL,
  `score` int(11) NOT NULL DEFAULT '0',
  `time` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`user_id`, `score`, `time`) VALUES
('gagangupt16@gmail.com', 1, '2012-09-25 16:07:38');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
