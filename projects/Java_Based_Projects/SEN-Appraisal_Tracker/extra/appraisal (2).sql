-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 19, 2013 at 05:52 PM
-- Server version: 5.1.53
-- PHP Version: 5.3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `appraisal`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE IF NOT EXISTS `accounts` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `priviledge` varchar(25) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`username`, `password`, `priviledge`) VALUES
('kunal', 'k', 'manager'),
('kbiiit', 'kb', 'employee'),
('f', 'fu', 'employee'),
('bansal', 'bansal', 'employee'),
('shubham', 'shubham', 'employee'),
('das', 'dsad', 'asd'),
('anoop2', 'anoop', 'employee'),
('he boy', 'hello', 'Employee'),
('a', 'a', 'employee'),
('an', 'an', 'employee'),
('hel', 'hel', 'hel'),
('hello', 'hel', 'hel'),
('kbi', 'kunalb', 'employee');

-- --------------------------------------------------------

--
-- Table structure for table `profile`
--

CREATE TABLE IF NOT EXISTS `profile` (
  `username` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `priviledge` varchar(30) NOT NULL,
  `e_mail` varchar(30) NOT NULL,
  `address` varchar(30) NOT NULL,
  `phone_no` varchar(30) NOT NULL,
  `personal_info` varchar(200) NOT NULL,
  `department` varchar(60) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `profile`
--

INSERT INTO `profile` (`username`, `name`, `priviledge`, `e_mail`, `address`, `phone_no`, `personal_info`, `department`) VALUES
('kunal', 'KUNAL BANSAL', 'MANAGER', '', 'BH-1,IIIT Allahabad', '9559704522', ' I AM A MANAGER .', 'FINANCIAL'),
('kbiiit', 'kb', 'Employee', 'kbiiit@gmail.com', 'BH-1', '9876543210', 'I AM A EMPLOYEE', 'CUSTOMER'),
('das', 'sdsa', 'asd', '', '', '', '', 'sad'),
('f', 'f', 'employee', '', '', '', '', 'financial'),
('bansal', 'bansal', 'employee', 'bansal@bansal.co.in', 'IIIT ALLAHABAD', '', 'I WORKED IN TECHNICAL DEPT.', 'technical'),
('shubham', 'shubham', 'employee', 'iit2010093@iiita.ac.in', 'BH-1,IIIT Allahabad', '', 'I AM CUSTOMER', 'customer'),
('a', 'a', 'employee', '', '', '', '', 'financial'),
('anoop2', 'anoop', 'employee', 'anoop', 'BH1', '9876543210', 'I am Employee', 'financial'),
('he boy', 'hello', 'Employee', '', '', '', '', 'technical'),
('an', 'an', 'employee', '', '', '', '', 'technical'),
('hel', 'hel', 'hel', '', '', '', '', 'hel'),
('hello', 'hel', 'hel', '', '', '', '', 'hel'),
('kbi', 'kunalb', 'employee', '', '', '', '', 'technical');

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE IF NOT EXISTS `rating` (
  `username` varchar(30) NOT NULL,
  `department` varchar(30) NOT NULL,
  `skills` varchar(30) NOT NULL,
  `quality` varchar(30) NOT NULL,
  `leader` varchar(30) NOT NULL,
  `consistency` varchar(30) NOT NULL,
  `reliability` varchar(30) NOT NULL,
  `initiative` varchar(30) NOT NULL,
  `ontime` varchar(30) NOT NULL,
  `workunder` varchar(30) NOT NULL,
  `guidance` varchar(30) NOT NULL,
  `adaptability` varchar(30) NOT NULL DEFAULT '0.00',
  `image` varchar(30) NOT NULL DEFAULT '0.00',
  `cooperation` varchar(30) NOT NULL,
  `communication` varchar(30) NOT NULL,
  `attitude` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rating`
--

INSERT INTO `rating` (`username`, `department`, `skills`, `quality`, `leader`, `consistency`, `reliability`, `initiative`, `ontime`, `workunder`, `guidance`, `adaptability`, `image`, `cooperation`, `communication`, `attitude`) VALUES
('anoop2', 'financial', '8.69', '22.23', '0', '8.0', '8.0', '8.0', '5.08', '7.19', '6.12', '4.05', '4.05', '6.25', '7.21', '5.12'),
('he boy', 'technical', '', '', '', '', '', '', '', '', '', '0.00', '0.00', '', '', NULL),
('a', 'financial', '8.69', '22.23', '0', '8.0', '8.0', '8.0', '5.08', '7.19', '6.12', '4.05', '4.05', '6.25', '7.21', '5.12'),
('f', 'financial', '8.69', '22.23', '0', '8.0', '8.0', '8.0', '5.08', '7.19', '6.12', '4.05', '4.05', '6.25', '7.21', '5.12'),
('das', 'sad', '', '', '', '', '', '', '', '', '', '0.00', '0.00', '', '', NULL),
('shubham', 'customer', '7.38', '16.0', '0', '7.83', '7.83', '7.83', '6.06', '7.11', '5.04', '4.02', '5.76', '7.17', '6.08', '11.9'),
('bansal', 'technical', '12.66', '27.2', '0', '7.89', '7.89', '7.89', '6.08', '7.14', '5.04', '4.02', '0', '4.12', '10.08', '0'),
('kbiiit', 'CUSTOMER', '7.38', '16.0', '0', '7.83', '7.83', '7.83', '6.06', '7.11', '5.04', '4.02', '5.76', '7.17', '6.08', '11.9'),
('an', 'technical', '12.66', '27.2', '0', '7.89', '7.89', '7.89', '6.08', '7.14', '5.04', '4.02', '0', '4.12', '10.08', '0'),
('hel', 'hel', '', '', '', '', '', '', '', '', '', '0.00', '0.00', '', '', NULL),
('hello', 'hel', '', '', '', '', '', '', '', '', '', '0.00', '0.00', '', '', NULL),
('kbi', 'technical', '', '', '', '', '', '', '', '', '', '0.00', '0.00', '', '', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `rating2`
--

CREATE TABLE IF NOT EXISTS `rating2` (
  `username` varchar(30) NOT NULL,
  `department` varchar(30) NOT NULL,
  `quality` varchar(30) NOT NULL,
  `leader` varchar(30) NOT NULL,
  `consistency` varchar(30) NOT NULL,
  `reliability` varchar(30) NOT NULL,
  `initiative` varchar(30) NOT NULL,
  `ontime` varchar(30) NOT NULL,
  `workunder` varchar(30) NOT NULL,
  `guidance` varchar(30) NOT NULL,
  `adaptability` varchar(30) NOT NULL,
  `image` varchar(30) NOT NULL,
  `cooperation` varchar(30) NOT NULL,
  `communication` varchar(30) NOT NULL,
  `attitude` varchar(30) NOT NULL,
  `skills` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rating2`
--

INSERT INTO `rating2` (`username`, `department`, `quality`, `leader`, `consistency`, `reliability`, `initiative`, `ontime`, `workunder`, `guidance`, `adaptability`, `image`, `cooperation`, `communication`, `attitude`, `skills`) VALUES
('f', 'financial', '16.6725', '0.0', '6.4', '4.0', '4.0', '2.54', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '4.345'),
('das', 'sad', '', '', '', '', '', '', '', '', '', '', '', '', '', NULL),
('bansal', 'technical', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0'),
('kbiiit', 'CUSTOMER', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0'),
('anoop2', 'financial', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0'),
('a', 'financial', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0'),
('shubham', 'customer', '8.0', '0.0', '3.915', '3.915', '3.915', '3.0300000000000002', '3.555', '2.52', '2.01', '2.88', '3.585', '3.04', '5.95', '3.69'),
('he boy', 'technical', '', '', '', '', '', '', '', '', '', '', '', '', '', NULL),
('an', 'technical', '13.6', '0.0', '3.945', '3.945', '3.945', '3.04', '5.3549999999999995', '2.52', '0.0', '0.0', '0.0', '0.0', '0.0', '6.33'),
('hel', 'hel', '', '', '', '', '', '', '', '', '', '', '', '', '', NULL),
('hello', 'hel', '', '', '', '', '', '', '', '', '', '', '', '', '', NULL),
('kbi', 'technical', '', '', '', '', '', '', '', '', '', '', '', '', '', NULL);
