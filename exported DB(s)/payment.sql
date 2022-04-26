-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2022 at 08:19 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bill`
--

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE IF NOT EXISTS `payment` (
`payID` int(11) NOT NULL,
  `payDate` varchar(10) NOT NULL,
  `name` varchar(40) NOT NULL,
  `email` varchar(50) NOT NULL,
  `amount` float NOT NULL,
  `accNo` varchar(15) NOT NULL,
  `ccv` int(3) NOT NULL,
  `expireDate` varchar(12) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`payID`, `payDate`, `name`, `email`, `amount`, `accNo`, `ccv`, `expireDate`) VALUES
(4, '2009.09.8', 'L.K.Peiris', 'peiiris12@gmail.com', 1230, '1234567890', 556, '2022.9.12'),
(5, '2022.09.8', 'L.K.chasu', 'chan12@gmail.com', 1244, '123337890', 786, '2029.9.12'),
(6, '2009.9.12', ' L.A. Fonseka', 'fonseka123@gmail.com', 1345, '1256734543', 334, '2020.01.17'),
(8, '2018.9.22', ' L.A. upeka', 'eftewe3@gmail.com', 1105.08, '121122243', 355, '2024.01.17'),
(10, '2018.9.29', 'L.A.Nimalupdated', 'nimalupdated@gmail.com', 1005.08, '121198743', 319, '2024.01.17'),
(11, '2018.9.29', ' L.A. Nimal', 'nimal1e3@gmail.com', 1105.08, '121198743', 310, '2024.01.17');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
 ADD PRIMARY KEY (`payID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
MODIFY `payID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
