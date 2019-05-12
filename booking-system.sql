-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2019 at 01:05 AM
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
-- Database: `booking-system`
--

-- --------------------------------------------------------

--
-- Table structure for table `band`
--

CREATE TABLE `band` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `agent_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `band`
--

INSERT INTO `band` (`id`, `name`, `genre_id`, `agent_id`) VALUES
(1, 'Wire Blast', 11, 29),
(2, 'test', 6, 1),
(3, 'Sword', 1, 32),
(4, 'Summer Light', 4, 36),
(5, 'Silver Blast Wire', 5, 31),
(6, 'Dub Dub', 6, 29),
(7, 'America', 7, 30),
(8, 'Chill Blast', 9, 32),
(9, 'Jazz Night', 10, 34),
(10, 'Elex', 11, 37),
(11, 'Indie Max', 12, 37),
(12, 'Max Pop', 2, 26);

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `id` int(11) NOT NULL,
  `number_of_tickets` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `payment_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`id`, `number_of_tickets`, `event_id`, `user_id`, `payment_id`) VALUES
(22, 11, 30, 1, 43),
(23, 21, 25, 1, 44),
(24, 21, 25, 1, 45),
(25, 312, 25, 1, 46),
(26, 21, 23, 1, 47),
(27, 1, 24, 1, 48);

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `id` int(11) NOT NULL,
  `location` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` longtext,
  `tickets_available` varchar(255) NOT NULL DEFAULT '0',
  `ticket_price` float DEFAULT '0',
  `event_type` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `organizer_id` int(11) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`id`, `location`, `date`, `name`, `description`, `tickets_available`, `ticket_price`, `event_type`, `status`, `organizer_id`, `created_at`, `updated_by`) VALUES
(21, 'Mallorca, Spain', '2019-04-10', 'Spanish Fiesta Mallorca', 'Spanish Fiesta Mallorca August 2019', '50000', 380, 'Concert', 1, 1, '2019-04-29 02:40:07', NULL),
(22, 'Tokyo, Japan', '2019-11-10', 'Tokyo Jazz Musical', 'Tokyo Jazz Musical November 2019', '70000', 1200, 'Concert', 0, 1, '2019-04-29 02:40:07', NULL),
(23, 'Marrakesh, Morocco', '2019-11-20', 'Rok Music Festival', 'Rok Music Festival November 2019', '70000', 985, 'Concert', 1, 1, '2019-04-29 02:40:07', NULL),
(24, 'Cape Town,South Africa', '2019-04-10', 'Sand Music Festival', 'Sand Festival November 2019', '50000', 785, 'Festival', 1, 1, '2019-04-29 02:40:07', NULL),
(25, 'Miami South Beach, USA', '2019-02-10', 'Buzz Miami Fiesta ', 'Buzz Miami Fiesta January 2019', '50000', 980, 'Concert', 1, 1, '2019-04-29 02:40:07', NULL),
(26, 'Montreal, Canada', '2020-01-15', 'Canadian Country Music Fiesta ', 'Performers: [11.Indie Max, 5.Silver Blast Wire]', '60000', 995, 'Concert', 1, 1, '2019-04-29 02:40:07', 1),
(27, 'Playa del Carmen, Mexico', '2019-04-10', 'Playa Festival Mexico', 'Playa Festival Mexico January 2020', '60000', 695, 'Concert', 1, 1, '2019-04-29 02:40:07', NULL),
(28, 'Mar Del Plata,Argentina', '2020-02-01', 'Mar Del Plata Musica', 'Latio Fiesta February 2020', '40000', 780, 'Concert', 0, 1, '2019-04-29 02:40:07', NULL),
(29, 'Rio de Janeiro, Brazil', '2019-10-15', ' Latio Electro Rio Musica', 'Latio Electro Rio Musica October 2019', '70000', 885, 'Concert', 1, 1, '2019-04-29 02:40:07', NULL),
(30, 'Trujillo, Peru', '2019-11-20', 'Lation Fiesta Trujillo', 'Performers [11.Indie Max, 5.Silver Blast Wire, 12.Max Pop, 5.Silver Blast Wire]', '50000', 850, 'Concert', 1, 1, '2019-04-29 02:40:07', 1),
(31, 'luton', '2019-05-01', 'test', 'Full Address: \nlu20en, hitchin road, in my parking spot\nPerformance Time: \n13:50\nPerformers: \n[10.Elex, 12.Max Pop, 5.Silver Blast Wire, 6.Dub Dub]\nOther Details: \n321312', '1000', 12, 'Concert', 1, 1, '2019-05-05 17:50:19', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `event_performers`
--

CREATE TABLE `event_performers` (
  `id` int(11) NOT NULL,
  `event_id` int(11) DEFAULT NULL,
  `band_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event_performers`
--

INSERT INTO `event_performers` (`id`, `event_id`, `band_id`) VALUES
(65, 26, 11),
(66, 26, 5),
(67, 30, 11),
(68, 30, 5),
(69, 30, 12),
(70, 30, 5),
(71, 31, 10),
(72, 31, 12),
(73, 31, 5),
(74, 31, 6);

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE `genre` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `genre`
--

INSERT INTO `genre` (`id`, `name`) VALUES
(1, 'Metal'),
(2, 'Pop'),
(3, 'Techno'),
(4, 'Country Music'),
(5, 'Electro Dance'),
(6, 'Dubstep'),
(7, 'Rock'),
(9, 'Rhythm and Blues'),
(10, 'Jazz'),
(11, 'Electro'),
(12, 'Indie Rock');

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `id` int(11) NOT NULL,
  `details` longtext NOT NULL,
  `user_id` int(11) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notification`
--

INSERT INTO `notification` (`id`, `details`, `user_id`, `created_at`) VALUES
(1, 'Unfortunately we had to cancel 11 Event, no worries. We will refund you the whole ammount of 0.0 GBP It may take a few days for the refund to appear on your statement.', 1, '2019-04-30 14:17:18'),
(2, 'Unfortunately we had to cancel 11 Event, no worries. We will refund you the whole ammount of 0.0 GBP It may take a few days for the refund to appear on your statement.', 1, '2019-04-30 14:17:18');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id` int(11) NOT NULL,
  `ammount` float NOT NULL,
  `card_no` varchar(255) DEFAULT NULL,
  `expire_date` varchar(255) DEFAULT NULL,
  `card_holder_name` varchar(255) DEFAULT NULL,
  `cvs` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `description` varchar(255) NOT NULL,
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `discounted` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`id`, `ammount`, `card_no`, `expire_date`, `card_holder_name`, `cvs`, `user_id`, `status`, `description`, `date_created`, `discounted`) VALUES
(43, 7480, '1111111111111111', '1111111111111111/1111111111111111', 'test', '1111111111111111', 1, 1, '11x Lation Fiesta Trujillo Concert tickets', '2019-04-30 14:33:28', 1),
(44, 20580, '1111111111111111', '1111111111111111/1111111111111111', '1111111111111111', '1111111111111111', 1, 1, '21x Buzz Miami Fiesta  Concert tickets', '2019-05-03 04:09:26', 0),
(45, 20580, '1111111111111111', '11111111111111111/11111111111111111', '11111111111111111', '11111111111111111', 1, 1, '21x Buzz Miami Fiesta  Concert tickets', '2019-05-05 17:21:04', 0),
(46, 305760, '1111111111111111', '1111111111111111/1111111111111111', '1111111111111111', '1111111111111111', 1, 1, '312x Buzz Miami Fiesta  Concert tickets', '2019-05-05 17:29:54', 0),
(47, 16548, '1111111111111111', '1111111111111111/1111111111111111', 'test', '1111111111111111', 1, 1, '21x Rok Music Festival Concert tickets', '2019-05-05 17:34:35', 1),
(48, 628, NULL, NULL, NULL, NULL, 1, 1, '1x Sand Music Festival Festival tickets', '2019-05-05 17:36:19', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `address_line` varchar(255) NOT NULL,
  `address_line2` varchar(255) DEFAULT NULL,
  `town` varchar(255) NOT NULL,
  `county` varchar(255) NOT NULL,
  `postcode` varchar(8) NOT NULL,
  `dob` varchar(255) NOT NULL,
  `contact_name` varchar(255) DEFAULT NULL,
  `contact_phone` varchar(255) DEFAULT NULL,
  `corporate_organisation_name` varchar(255) DEFAULT NULL,
  `email_address` varchar(255) NOT NULL,
  `mobile_no` varchar(255) NOT NULL,
  `web_address` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `events_organiser_name` varchar(255) DEFAULT NULL,
  `is_admin` tinyint(1) DEFAULT NULL,
  `is_agent` tinyint(1) DEFAULT NULL,
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `title`, `first_name`, `last_name`, `gender`, `address_line`, `address_line2`, `town`, `county`, `postcode`, `dob`, `contact_name`, `contact_phone`, `corporate_organisation_name`, `email_address`, `mobile_no`, `web_address`, `password`, `events_organiser_name`, `is_admin`, `is_agent`, `date_created`) VALUES
(1, 'Mr.', 'Marian', 'Terchila', 'Male', '242 Hitchin Road', '3 Hilary Court', 'Luton', 'Bedfordshire', 'lu20en', '2019-04-01', '123', '12312', NULL, 'terkea', '07466652400', 'wwww.terkea.com', '$2a$08$0239z2O/uUWKIf.QHZ0d6.AAq.jGM0WXuHyGT06yalHlbNJxhzMiC', NULL, 0, 1, '2019-04-23 14:56:24'),
(3, 'Mr.', 'Marian', 'Terchila', 'Male', '242 Hitchin Road', '3 Hilary Court', 'Luton', 'Bedfordshire', 'lu20en', '08.09.1997', NULL, NULL, '1', 'terkea@gmail.com', '07466652400', 'wwww.terkea.com', '$2a$08$LXJ2DS3ZazIYGCzNW7GIjevlNGPhYEMCqmTz4fizkwKGCisjk8R.6', NULL, 1, 0, '2019-04-23 14:56:24'),
(8, 'Ms', 'Pula', 'In', 'Male', 'Si', 'Bani', 'Drum', 'Hai', 'Haii', '2019-04-07', 'Haiii', 'Haiii', 'null', '1', 'Cur', 'De', '$2a$08$JCsnAzpEFbG8GR1Ki0SBVu0c66EFREYNNSLN9QLUUOfsgVnnko3YC', '', 0, 0, '2019-04-23 14:56:24'),
(9, 'Ms', '1', '1', 'Male', '1', '', '1', '1', '1', '2019-04-07', '', '', 'null', '565', '1', '2', '$2a$08$G0dJ7Nrsn.OOdK1fzb./r.WwcXEmv.MiksPXIi6ypUI1ryEhwQ/ZS', 'test', 0, 0, '2019-04-23 14:56:24'),
(10, 'Ms', '1', '1', 'Male', '1', 'test', '1', '1', '1', '2019-04-07', 'test', 'test', 'null', '2', '1', '2', '$2a$08$2SteSn3yHH3Yb5AIYkScwOLRgbztreqlaf.ekEmUawp7vo6U1nkS6', 'test', 0, 0, '2019-04-23 14:56:24'),
(11, 'title', 'test', 'test', 'Male', 'SELECT * FROM USER', 'test', 'test', 'test', 'test', 'null', '', '', '', 'test', 'test', 'test', '$2a$08$UXRvh0FidoANOwE4Npw/7.bKFnWO4oeku3KMRMOOFa/CtO3wATsbO', '', 0, 0, '2019-04-23 14:56:24'),
(18, 'Mr.', 'Marian', 'Terchila', 'Male', '242 Hitchin Road', '3 Hilary Court', 'Luton', 'Bedfordshire', 'lu20en', '2019-04-01', 'null', 'null', 'null', 'terkea123', '07466652400', 'wwww.terkea.com', '$2a$08$.sTcI5bTjhCosuwChOLTu.IwRx1NoPBXs.IoXN9vQ48ygK2ImHZOq', NULL, 1, 0, '2019-04-23 14:56:24'),
(19, 'Mr.', 'Marian', 'Terchila', 'Male', '242 Hitchin Road', '3 Hilary Court', 'Luton', 'Bedfordshire', 'lu20en', '08.09.1997', NULL, NULL, NULL, 'terkea@gmail.com123', '07466652400', 'wwww.terkea.com', '$2a$08$LXJ2DS3ZazIYGCzNW7GIjevlNGPhYEMCqmTz4fizkwKGCisjk8R.6', NULL, 1, 0, '2019-04-23 14:56:24'),
(20, 'Ms', 'Kate', 'White', 'Female', '5 Oaks', 'London Road', 'Brighton', 'England', 'BN1 ', '1999-04-07', 'Bob Gray', '07794683395', 'Music Stars Limited', 'info@music.starts.com', '08893618726', 'music-stars.com', '$2a$08$JCsnAzpEFbG8GR1Ki0SBVu0c66EFREYNNSLN9QLUUOfsgVnnko3YC', '', 0, 0, '2019-04-23 14:56:24'),
(21, 'Mr', 'Bob', 'Stone', 'Male', '5 Hill Road', 'Aldgate', 'London', 'England', 'E1 7AX', '1998-03-23', 'Jude Stake', '08863519952', 'Country Buzz Limited', 'info@cbl.com', '09775318352', 'www.cbl.com', '$2a$08$G0dJ7Nrsn.OOdK1fzb./r.WwcXEmv.MiksPXIi6ypUI1ryEhwQ/ZS', 'Null', 0, 0, '2019-04-23 14:56:24'),
(22, 'Ms', 'Rachel', 'Large', 'Female', '17 Robin House', 'Church Street', 'Luton', 'England', 'LU13 FX', '1985-01-25', 'Kate Smith', '07934267721', 'Festival Fiesta Limited', 'info@festival-fiesta.co.uk', '08372343321', 'www.festival-fiesta.co.uk', '$2a$08$2SteSn3yHH3Yb5AIYkScwOLRgbztreqlaf.ekEmUawp7vo6U1nkS6', 'test', 0, 0, '2019-04-23 14:56:24'),
(23, 'title', 'test', 'test', 'Male', 'SELECT * FROM USER', 'test', 'test', 'test', 'test', 'null', '', '', 'test', 'test123', 'test', 'test', '$2a$08$UXRvh0FidoANOwE4Npw/7.bKFnWO4oeku3KMRMOOFa/CtO3wATsbO', '', 0, 0, '2019-04-23 14:56:24'),
(24, 'Mr.', 'updateTest', 'updateTest', 'Female', 'updateTest', 'updateTest', 'i forgot', 'haha', 'blabla', '2019-04-10', '', '', 'updateTestTTTTTTTTTTTTT', '1@b.com', 'updateTest', 'updateTest', '$2a$08$xeYZKU432Fkj2qGvHQWAauaeyiKSh0jjvbp2LfIbRbQd.zfTNmXxO', 'null', 0, 0, '2019-04-23 14:56:24'),
(25, 'Miss', 'test', '123', 'Female', '123', '', '123', '123', '123', '2019-04-10', '', '', '', '123', '123', '', '$2a$08$zdIaaA3.IMasDSFW4NwIk.Y8o08Lg4Vh2ox9elttxdNI05BpddiE6', 'null', 0, 0, '2019-04-25 21:36:42'),
(26, 'Mrs.', 'Kate', 'Jakson', 'Female', '345 Luton Road', '', 'Luton', 'England', 'LU8', '2019-04-28', '', '', 'Music Festival Inc', 'info@mf.com', '07739235561', 'www.mf.com', '$2a$08$WlYBfNHZbmxY8nVL8gPr4.ltG6mdaVeJg8wjioVw5jJZ7mdMD4Awm', 'null', 0, NULL, '2019-04-28 17:49:24'),
(27, 'Mr', 'Mike', 'Brown', 'Male', '309 Hill Road', NULL, 'London', 'England', 'SW5', '20/04/1989', NULL, '08846238821', NULL, 'mike.B-Pop@live.com', '08846238821', NULL, '12345', NULL, NULL, 1, '2019-04-28 20:51:18'),
(28, 'Miss', 'Sam', 'Gray', 'Female', '78 Forest Hill Way', '', 'London', 'England ', 'NW12', '1988-04-14', '', '', '', 'sam.g-indie@gmail.com', '09764357782', '', '$2a$08$Ya6UUbaa2pCoPksBl5vptOlIvxOO87G3psNGUOusbHaYMXCuugUEy', 'null', 0, 1, '2019-04-28 21:00:07'),
(29, 'Ms', 'Maria', 'Cat', 'Female', '83 Upper Street', '', 'Luton', 'England', 'LU9', '1988-09-06', '', '', '', 'Maria.C-Sword@live.com', '07893452216', '', '$2a$08$rBZbHZkzjQ1DqPsQHY.c2.pdBvq.DPle69r3BKD9XjIrnzHjx0XCe', 'null', 0, 1, '2019-04-28 21:04:30'),
(30, 'Mr.', 'Gary', 'White', 'Male', '6 Hill Street', '', 'London', 'England', 'SE5', '1990-12-09', '', '', '', 'gary.w-Smmer@gmail.com', '07793427781', '', '$2a$08$vtFW5Y2AA4Hz.1owHGTRReJRyZ5DvhK8LCUSl.j/B5/LrZyriY1H.', 'null', 0, 1, '2019-04-28 21:06:39'),
(31, 'Mr.', 'Harry', 'Smith', 'Male', '50 High Road', '', 'Uxbridge', 'England', 'UB7', '1987-04-17', '', '', '', 'Harry.S-Silver@gmail.com', '07794532281', '', '$2a$08$sJpxYHxeXOF3wVnWyHaiMOK25TUAPHfw7U12qxghnTqqm1.C3jhpC', 'null', 0, 1, '2019-04-28 21:28:17'),
(32, 'Mr.', 'Mike', 'Black', 'Male', '43 Long Road', '', 'London', 'England', 'NW7', '1989-04-08', '', '', '', 'mike.b-dubdub@live.com', '08864329941', '', '$2a$08$7XzSUFNzjuYZORzvptB/P.gWsIwJRKHGOquickndLNqkvNrAIVQOa', 'null', 0, 1, '2019-04-28 21:31:04'),
(33, 'Mr.', 'Katie', 'Brown', 'Male', '87 Hill Way', '', 'London', 'England', 'SE7', '1987-04-25', '', '', '', 'katie.b-america@live.com', '08895632291', '', '$2a$08$1VLeTA0vu5zINjhVQorU9OT0wJ8n48zz50RB/.YP3r1mYyDydvtLG', 'null', 0, 1, '2019-04-28 21:34:26'),
(34, 'Miss', 'Jane', 'Smart', 'Female', '70 Forest Drive', '', 'London', 'England', 'SW6', '1986-04-02', '', '', '', 'jane.s-chill@live.com', '09783456621', '', '$2a$08$4GW5SHyhIPnzEgCflSx4B.IF0nxfpEzOlauafynC0ykIhg5Z79wMu', 'null', 0, 1, '2019-04-28 21:37:03'),
(35, 'Mr.', 'Mike', 'Foster', 'Male', '12 Fox Drive', '', 'London', 'England', 'NW9', '1984-04-01', '', '', '', 'mike.f-jazz@gmail.com', '08895632271', '', '$2a$08$l8.pgscUl3BYpi4VS2W41OL8aVQX7X0ZLZknWY6AQ9FUb8pRhGHpG', 'null', 0, 1, '2019-04-28 21:40:43'),
(36, 'Ms', 'Kate', 'Oax', 'Female', '67 Robin Way', '', 'London', 'England', 'NE8', '1994-04-25', '', '', '', 'kate.o-elex@live.com', '09864271253', '', '$2a$08$o5KBVEtxab4tWlCUaQSCFuuHkx5NgKpNb1B4NYMkp2ymHQLkifKb2', 'null', 0, 1, '2019-04-28 21:44:34'),
(37, 'Mr.', 'Tom', 'Smith', 'Male', '23 Horse Hill Road', '', 'Luton', 'England', 'LU3', '1986-03-17', '', '', '', 'tom.s-wire@hotmail.com', '08874532218', '', '$2a$08$mzTk3b9cn4S3h73bcPbOQ.y8WLzsrCvarnHc2ILndTExk/Yh0vVwy', 'null', 0, 1, '2019-04-28 21:48:43');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `band`
--
ALTER TABLE `band`
  ADD PRIMARY KEY (`id`),
  ADD KEY `genre` (`genre_id`),
  ADD KEY `agent_id` (`agent_id`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`id`),
  ADD KEY `festival_id` (`event_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `payment_id` (`payment_id`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`id`),
  ADD KEY `organizer_id` (`organizer_id`),
  ADD KEY `updated_by` (`updated_by`);

--
-- Indexes for table `event_performers`
--
ALTER TABLE `event_performers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `festival_id` (`event_id`),
  ADD KEY `band_id` (`band_id`);

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email_address` (`email_address`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `band`
--
ALTER TABLE `band`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `event_performers`
--
ALTER TABLE `event_performers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;

--
-- AUTO_INCREMENT for table `genre`
--
ALTER TABLE `genre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `band`
--
ALTER TABLE `band`
  ADD CONSTRAINT `band_ibfk_1` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`),
  ADD CONSTRAINT `band_ibfk_2` FOREIGN KEY (`agent_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`),
  ADD CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `booking_ibfk_3` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`);

--
-- Constraints for table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `event_ibfk_1` FOREIGN KEY (`organizer_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `event_ibfk_2` FOREIGN KEY (`updated_by`) REFERENCES `user` (`id`);

--
-- Constraints for table `event_performers`
--
ALTER TABLE `event_performers`
  ADD CONSTRAINT `event_performers_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`),
  ADD CONSTRAINT `event_performers_ibfk_2` FOREIGN KEY (`band_id`) REFERENCES `band` (`id`);

--
-- Constraints for table `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `notification_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
