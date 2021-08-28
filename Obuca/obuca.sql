-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2021 at 08:17 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `obuca`
--

-- --------------------------------------------------------

--
-- Table structure for table `obuce`
--

CREATE TABLE `obuce` (
  `id` int(5) NOT NULL,
  `vrsta` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `muske` tinyint(1) NOT NULL,
  `zenske` tinyint(1) NOT NULL,
  `djecije` tinyint(1) NOT NULL,
  `brKomada` int(11) NOT NULL,
  `cena` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `obuce`
--

INSERT INTO `obuce` (`id`, `vrsta`, `muske`, `zenske`, `djecije`, `brKomada`, `cena`) VALUES
(5, 'Cizme', 0, 1, 0, 1, 155),
(6, 'Cipele', 0, 0, 1, 1, 111),
(8, 'Cipele', 1, 0, 0, 1, 160),
(10, 'Cizme', 1, 0, 0, 1, 235),
(11, 'Cizme', 0, 0, 1, 1, 51),
(12, 'Cizme', 0, 0, 1, 1, 75),
(13, 'Cizme', 0, 0, 1, 1, 85),
(14, 'Cizme', 1, 0, 0, 1, 168),
(15, 'Cipele', 0, 1, 0, 1, 223),
(16, 'Cipele', 0, 1, 0, 1, 135),
(17, 'Cizme', 0, 1, 0, 1, 184),
(18, 'Cizme', 0, 0, 1, 1, 66),
(19, 'Cizme', 0, 1, 0, 1, 999),
(20, 'Cipele', 0, 0, 1, 1, 31),
(21, 'Cizme', 0, 0, 1, 1, 68),
(22, 'Cipele', 0, 0, 1, 3, 60),
(23, 'Cipele', 1, 0, 0, 3, 270);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `obuce`
--
ALTER TABLE `obuce`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `obuce`
--
ALTER TABLE `obuce`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
