-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 26, 2017 at 11:29 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dailybus`
--

-- --------------------------------------------------------

--
-- Table structure for table `daily_tran`
--

CREATE TABLE `daily_tran` (
  `ID` int(9) NOT NULL,
  `product_name` varchar(30) NOT NULL,
  `quantity` float NOT NULL,
  `buy_cost` int(6) NOT NULL,
  `sell_price` int(6) NOT NULL,
  `total` int(6) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `user` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `daily_tran`
--

INSERT INTO `daily_tran` (`ID`, `product_name`, `quantity`, `buy_cost`, `sell_price`, `total`, `date`, `time`, `user`) VALUES
(0, '00', 0, 0, 0, 0, '2017-12-01', '00:00:00', 'admin'),
(1, 'Potato chips', 2, 7, 10, 20, '2017-12-27', '04:28:00', 'RH_Rafi'),
(1, 'Rice', 1.5, 35, 40, 60, '2017-12-27', '04:28:00', 'RH_Rafi'),
(1, 'Egg', 4, 8, 10, 40, '2017-12-27', '04:28:00', 'RH_Rafi');

-- --------------------------------------------------------

--
-- Table structure for table `product_list`
--

CREATE TABLE `product_list` (
  `ID` int(5) NOT NULL,
  `Product_Name` varchar(50) NOT NULL,
  `Quantity` int(5) NOT NULL,
  `Buy_Cost` int(5) NOT NULL,
  `Sell_Price` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_list`
--

INSERT INTO `product_list` (`ID`, `Product_Name`, `Quantity`, `Buy_Cost`, `Sell_Price`) VALUES
(1, 'Potato chips', 72, 7, 10),
(2, 'Rice', 64, 35, 40),
(3, 'pulse', 67, 25, 32),
(4, 'Pringles', 82, 70, 75),
(6, 'Snickers', 245, 20, 23),
(7, 'Cadbury Dairy Milk', 343, 10, 12),
(8, 'Butter', 198, 50, 53),
(9, 'Ghee', 100, 290, 295),
(10, 'Alooz Chips', 78, 13, 15),
(11, 'Noodles', 90, 60, 66),
(12, 'CornFlakes', 48, 190, 200),
(13, 'Tro. orange Juice', 28, 25, 30),
(14, 'Soap', 119, 20, 23),
(15, 'Milk', 95, 30, 35),
(16, 'Oil', 149, 100, 110),
(17, 'Garlic', 24, 40, 45),
(18, 'Egg', 488, 8, 10),
(19, 'AlClear Shampoo', 55, 38, 45),
(20, 'Coconut Oil', 50, 50, 60),
(21, 'Onion', 188, 110, 120);

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE `user_table` (
  `ID` int(4) NOT NULL,
  `User_name` varchar(30) NOT NULL DEFAULT 'admin',
  `Password` varchar(8) NOT NULL DEFAULT 'admin'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='we will use it for log in purpose';

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`ID`, `User_name`, `Password`) VALUES
(1, 'admin', 'admin'),
(2, 'RH_Rafi', '16316591'),
(3, 'SH_Shaon', '16315741'),
(4, 'Akash', '16310611');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product_list`
--
ALTER TABLE `product_list`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user_table`
--
ALTER TABLE `user_table`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `User_name` (`User_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product_list`
--
ALTER TABLE `product_list`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `user_table`
--
ALTER TABLE `user_table`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
