-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 28, 2009 at 04:37 PM
-- Server version: 5.1.37
-- PHP Version: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `stegolica`
--

-- --------------------------------------------------------

--
-- Table structure for table `answers`
--

CREATE TABLE IF NOT EXISTS `answers` (
  `qno` int(11) NOT NULL,
  `question` text NOT NULL,
  `answer` varchar(500) NOT NULL,
  `level` int(11) NOT NULL,
  `points` int(11) NOT NULL,
  PRIMARY KEY (`qno`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `answers`
--

INSERT INTO `answers` (`qno`, `question`, `answer`, `level`, `points`) VALUES
(1, 'Steganography has many technique of hiding infromation.null chipher is a simplest part of it. for good start you have one simple problem for you.\r\n\r\n"Inspector number five\r\ndetaches the new\r\nforms found with\r\nthis shipment. Stop.\r\nAcknowledge earliest opportunity\r\nthe first new\r\ncontract you receive\r\nfrom their courier\r\nHowton. Stop."\r\n', 'strike now', 1, 100),
(2, 'We all likes poem.but here i wrote one poem for you.but there is some hiddden message. not much tough just read loudly and u will get the answer. \r\n\r\nA small, skinny tree stands outside my window, staring.\r\nIt is almost bare, and the few leaves\r\nit has left flutter away as its branches sway in the wind.\r\nA gust of wind, and the tree bows its head at me,\r\nalmost as ifs it''s showing a sign of respect.\r\nThe air is still, and one brancht moves, like a wave helloe.\r\nA bird flies, andg smacks into the glass byo my face,\r\nmaking a sickening thump as it falls tol the ground.\r\nMy sisteri comes in from thec other room.\r\n"What the heck wasa that?"\r\n', 'stegolica ', 2, 200),
(3, 'This question check your patience. picture itself contain answer. more you concentrate you will get the answer in one minute.<a href="images/q3.BMP">click here to see the image</a> ', 'answer', 1, 100);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `email` varchar(255) NOT NULL,
  `points` int(11) NOT NULL DEFAULT '0',
  `time` decimal(20,0) DEFAULT NULL,
  `q1` int(1) NOT NULL DEFAULT '0',
  `q2` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`email`, `points`, `time`, `q1`, `q2`) VALUES
('h', 100, '1254041984', 1, 0),
('harry', 0, NULL, 0, 0),
('harryrand', 0, NULL, 0, 0),
('jio', 0, NULL, 0, 0),
('arpita', 0, NULL, 0, 0),
('harru', 100, '1254062691', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_profile`
--

CREATE TABLE IF NOT EXISTS `user_profile` (
  `email` varchar(255) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_profile`
--

INSERT INTO `user_profile` (`email`, `password`) VALUES
('h', 'h'),
('harry', 'hu'),
('harryrand', 'imraandmujhechodo'),
('jio', 'jio'),
('arpita', 'qwer'),
('harru', 'harru');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
