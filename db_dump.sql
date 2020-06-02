-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 02, 2020 at 11:34 PM
-- Server version: 10.3.15-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smit`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `published` datetime DEFAULT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `author`, `location`, `name`, `published`, `quantity`) VALUES
(1, 'author', 'location', 'name', '2020-03-01 00:00:00', 5);

-- --------------------------------------------------------

--
-- Table structure for table `book_lender`
--

CREATE TABLE `book_lender` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `deadline` date NOT NULL,
  `returned` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `book_lender`
--

INSERT INTO `book_lender` (`id`, `user_id`, `book_id`, `deadline`, `returned`) VALUES
(1, 1, 1, '2019-06-01', 1),
(2, 1, 1, '2020-06-01', 0),
(3, 1, 1, '2020-06-16', 0),
(4, 1, 1, '2020-06-09', 1),
(5, 1, 1, '2020-06-09', 0),
(6, 1, 1, '2020-06-30', 0);

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE `log` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `description` text NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`id`, `user_id`, `description`, `created_at`) VALUES
(1, 0, '[START]getLibrarySummary', '2020-06-02 19:48:21'),
(2, 0, '[END]getLibrarySummary', '2020-06-02 19:48:21'),
(3, 0, '[START]getLibrarySummary', '2020-06-02 20:13:57'),
(4, 0, '[END]getLibrarySummary', '2020-06-02 20:13:57'),
(5, 0, '[START]getLibrarySummary', '2020-06-02 20:14:29'),
(6, 0, '[END]getLibrarySummary', '2020-06-02 20:14:29'),
(7, 0, '[START]getLateLenders', '2020-06-02 20:14:47'),
(8, 0, '[START]getLateLenders', '2020-06-02 20:15:36'),
(9, 0, '[END]getLateLenders', '2020-06-02 20:15:36'),
(10, 0, 'getLateLenders:Init', '2020-06-02 20:22:47'),
(11, 0, 'getLateLenders:Access denied', '2020-06-02 20:22:47'),
(12, 0, 'getLateLenders:Init', '2020-06-02 20:24:47'),
(13, 0, 'getLateLenders:Access denied', '2020-06-02 20:24:47'),
(14, 0, 'getLateLenders:Init', '2020-06-02 20:25:02'),
(15, 0, 'getLateLenders:Access denied', '2020-06-02 20:25:02'),
(16, 0, 'getLateLenders:Init', '2020-06-02 20:25:37'),
(17, 0, 'getLateLenders:Access denied', '2020-06-02 20:25:37'),
(18, 0, 'getLateLenders:Init', '2020-06-02 20:26:16'),
(19, 0, 'getLateLenders:Access denied', '2020-06-02 20:26:16'),
(20, 0, 'getLateLenders:Init', '2020-06-02 20:28:31'),
(21, 0, 'getLateLenders:Access denied', '2020-06-02 20:28:31'),
(22, 0, 'getLateLenders:Init', '2020-06-02 20:30:07'),
(23, 0, 'getLateLenders:Access denied', '2020-06-02 20:30:07'),
(24, 1, 'getLateLenders:Init', '2020-06-02 20:31:13'),
(25, 1, 'getLateLenders:Access denied', '2020-06-02 20:31:13'),
(26, 1, 'getLateLenders:Init', '2020-06-02 20:32:52'),
(27, 1, 'getLateLenders:Access denied', '2020-06-02 20:32:52'),
(28, 1, 'getLateLenders:Init', '2020-06-02 20:33:54'),
(29, 1, 'getLateLenders:Success', '2020-06-02 20:33:54'),
(30, 1, 'getLateLenders:Init', '2020-06-02 20:37:49'),
(31, 1, 'getLateLenders:Success', '2020-06-02 20:37:49');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'library-worker-tender'),
(2, 'library-worker');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `ssn` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `firstname`, `lastname`, `password`, `ssn`) VALUES
(1, 'eemail', 'firstn', 'lastn', 'ppass', '39303190');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(1, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book_lender`
--
ALTER TABLE `book_lender`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `book_lender`
--
ALTER TABLE `book_lender`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `log`
--
ALTER TABLE `log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
