-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2019 at 03:25 PM
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
(28, 2, 31, 40, 49),
(29, 40, 21, 47, 50),
(30, 40, 25, 50, 51),
(31, 20, 26, 51, 52),
(32, 2, 31, 54, 53),
(33, 4, 27, 55, 54);

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
(29, 'Rio de Janeiro, Brazil', '2019-08-24', 'Rio Fiesta Musica', 'The biggest dance music festival in Rio de Janeiro,  The Best Festival of electronic music culture. An inclusive space offering the freedom to let loose and express yourself, the festival is a surrealistic social utopia set to massive beats and musical creativity.\r\nFrom: 24/08/2019 To: 30/08/2019\r\nTime: 18:00 - 05:00', '70000', 885, 'Festival', 1, 1, '2019-04-29 02:40:07', NULL),
(30, 'Trujillo, Peru', '2019-11-20', 'Lation Fiesta Trujillo', 'Performers [11.Indie Max, 5.Silver Blast Wire, 12.Max Pop, 5.Silver Blast Wire]', '50000', 850, 'Concert', 1, 1, '2019-04-29 02:40:07', 1),
(31, 'The Lake District', '2019-07-26', 'The Lake District Music Festival 2019', 'Full Address: \nThe Lake Forest Park, England, LA23 1U\nPerformance Time: 18:00 - 05:00\n13:50\nPerformers: \n[10.Elex, 12.Max Pop, 5.Silver Blast Wire, 6.Dub Dub]\nOther Details: \nThe Best Summer Music Festival in The Lake District.\n', '360', 850, 'Festival', 1, 1, '2019-05-05 17:50:19', 1),
(34, 'Munchen', '2019-08-30', 'Ostpark Munchen Rock Festival 2019', 'Full Address: \n81735 Munchen, BRD\nPerformance Time: \n18:00\nPerformers: \n[1.Wire Blast, 3.Sword, 5.Silver Blast Wire, 7.America, 10.Elex]\nOther Details: \nDas beste Rock- und Rockfestival in München 2019', '70000', 850, 'Festival', 1, 56, '2019-05-14 14:31:34', 56),
(37, 'Chiswick Park', '2019-06-28', 'London Summer Festival 2019', 'Full Address: \n London, W4 5YX\nPerformance Time: \n18:00\nPerformers: \n[4.Summer Light, 8.Chill Blast, 9.Jazz Night, 12.Max Pop]\nOther Details: \nThe Best Music in Town 2019 (Free Parking after 18:00) ', '2500', 460, 'Festival', 1, 57, '2019-05-14 15:14:11', 57);

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
(75, 31, 10),
(76, 31, 12),
(77, 31, 5),
(78, 31, 6),
(96, 34, 1),
(97, 34, 3),
(98, 34, 5),
(99, 34, 7),
(100, 34, 10),
(111, 37, 4),
(112, 37, 8),
(113, 37, 9),
(114, 37, 12);

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
(49, 1700, '5673231267533212', '08/21', 'Mike Rock', '731', 40, 1, '2x The Lake District Music Festival 2019 Concert tickets', '2019-05-12 22:09:57', 0),
(50, 12160, '7854386421974362', '07/21', 'Music Fiesta Lmited', '472', 47, 1, '40x Spanish Fiesta Mallorca Concert tickets', '2019-05-13 15:05:20', 1),
(51, 31360, '8462361382513492', '05/21', 'Light House Media', '563', 50, 1, '40x Buzz Miami Fiesta  Concert tickets', '2019-05-14 10:45:55', 1),
(52, 15920, NULL, NULL, NULL, NULL, 51, 0, '20x Canadian Country Music Fiesta  Concert tickets', '2019-05-14 11:33:01', 1),
(53, 1700, '2743925138423815', '02/21', 'Bob Ford', '732', 54, 1, '2x The Lake District Music Festival 2019 Festival tickets', '2019-05-14 12:51:08', 0),
(54, 2780, '3572351286321531', '02/21', 'Kate Broad', '831', 55, 1, '4x Playa Festival Mexico Concert tickets', '2019-05-14 13:04:39', 0);

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
(1, 'Mr.', 'Marian', 'Terchila', 'Male', 'Vikings Global House', '111 High Street', 'London', 'England', 'SW7 2NX', '2019-05-17', 'Barbara Great', '08846238821', NULL, 'admin@test.com', '08008454647', 'www.vikings.com', '$2a$08$0239z2O/uUWKIf.QHZ0d6.AAq.jGM0WXuHyGT06yalHlbNJxhzMiC', NULL, 1, 0, '2019-04-23 14:56:24'),
(20, 'Ms', 'Kate', 'White', 'Female', '5 Oaks', 'London Road', 'Brighton', 'England', 'BN1 ', '1999-04-07', 'Bob Gray', '07794683395', 'Music Stars Limited', 'info@music.starts.com', '08893618726', 'music-stars.com', '$2a$08$JCsnAzpEFbG8GR1Ki0SBVu0c66EFREYNNSLN9QLUUOfsgVnnko3YC', '', 0, 0, '2019-04-23 14:56:24'),
(21, 'Mr', 'Bob', 'Stone', 'Male', '5 Hill Road', 'Aldgate', 'London', 'England', 'E1 7AX', '1998-03-23', 'Jude Stake', '08863519952', 'Country Buzz Limited', 'info@cbl.com', '09775318352', 'www.cbl.com', '$2a$08$G0dJ7Nrsn.OOdK1fzb./r.WwcXEmv.MiksPXIi6ypUI1ryEhwQ/ZS', 'Null', 0, 1, '2019-04-23 14:56:24'),
(22, 'Ms', 'Rachel', 'Large', 'Female', '17 Robin House', 'Church Street', 'Luton', 'England', 'LU13 FX', '1985-01-25', 'Kate Smith', '07934267721', 'Festival Fiesta Limited', 'info@festival-fiesta.co.uk', '08372343321', 'www.festival-fiesta.co.uk', '$2a$08$2SteSn3yHH3Yb5AIYkScwOLRgbztreqlaf.ekEmUawp7vo6U1nkS6', '1', 0, 0, '2019-04-23 14:56:24'),
(26, 'Mrs.', 'Kate', 'Jakson', 'Female', '345 Luton Road', '', 'Luton', 'England', 'LU8', '2019-04-28', '', '', 'Music Festival Inc', 'info@mf.com', '07739235561', 'www.mf.com', '$2a$08$WlYBfNHZbmxY8nVL8gPr4.ltG6mdaVeJg8wjioVw5jJZ7mdMD4Awm', '1', 0, NULL, '2019-04-28 17:49:24'),
(27, 'Mr', 'Mike', 'Brown', 'Male', '309 Hill Road', NULL, 'London', 'England', 'SW5', '20/04/1989', NULL, '08846238821', 'Test Corporate', 'corporate@test.com', '08846238821', NULL, '$2a$08$0239z2O/uUWKIf.QHZ0d6.AAq.jGM0WXuHyGT06yalHlbNJxhzMiC', NULL, NULL, 0, '2019-04-28 20:51:18'),
(28, 'Miss', 'Sam', 'Gray', 'Female', '78 Forest Hill Way', '', 'London', 'England ', 'NW12', '1988-04-14', '', '', '', 'sam.g-indie@gmail.com', '09764357782', '', '$2a$08$Ya6UUbaa2pCoPksBl5vptOlIvxOO87G3psNGUOusbHaYMXCuugUEy', 'null', 0, 1, '2019-04-28 21:00:07'),
(29, 'Ms', 'Maria', 'Cat', 'Female', '83 Upper Street', '', 'Luton', 'England', 'LU9', '1988-09-06', '', '', '', 'Maria.C-Sword@live.com', '07893452216', '', '$2a$08$rBZbHZkzjQ1DqPsQHY.c2.pdBvq.DPle69r3BKD9XjIrnzHjx0XCe', 'null', 0, 1, '2019-04-28 21:04:30'),
(30, 'Mr.', 'Gary', 'White', 'Male', '6 Hill Street', '', 'London', 'England', 'SE5', '1990-12-09', '', '', '', 'gary.w-Smmer@gmail.com', '07793427781', '', '$2a$08$vtFW5Y2AA4Hz.1owHGTRReJRyZ5DvhK8LCUSl.j/B5/LrZyriY1H.', 'null', 0, 1, '2019-04-28 21:06:39'),
(31, 'Mr.', 'Harry', 'Smith', 'Male', '50 High Road', '', 'Uxbridge', 'England', 'UB7', '1987-04-17', '', '', '', 'Harry.S-Silver@gmail.com', '07794532281', '', '$2a$08$sJpxYHxeXOF3wVnWyHaiMOK25TUAPHfw7U12qxghnTqqm1.C3jhpC', 'null', 0, 1, '2019-04-28 21:28:17'),
(32, 'Mr.', 'Mike', 'Black', 'Male', '43 Long Road', '', 'London', 'England', 'NW7', '1989-04-08', '', '', '', 'mike.b-dubdub@live.com', '08864329941', '', '$2a$08$7XzSUFNzjuYZORzvptB/P.gWsIwJRKHGOquickndLNqkvNrAIVQOa', 'null', 0, 1, '2019-04-28 21:31:04'),
(33, 'Mr.', 'Katie', 'Brown', 'Male', '87 Hill Way', '', 'London', 'England', 'SE7', '1987-04-25', '', '', '', 'katie.b-america@live.com', '08895632291', '', '$2a$08$1VLeTA0vu5zINjhVQorU9OT0wJ8n48zz50RB/.YP3r1mYyDydvtLG', 'null', 0, 1, '2019-04-28 21:34:26'),
(34, 'Miss', 'Jane', 'Smart', 'Female', '70 Forest Drive', '', 'London', 'England', 'SW6', '1986-04-02', '', '', '', 'jane.s-chill@live.com', '09783456621', '', '$2a$08$4GW5SHyhIPnzEgCflSx4B.IF0nxfpEzOlauafynC0ykIhg5Z79wMu', 'null', 0, 1, '2019-04-28 21:37:03'),
(35, 'Mr.', 'Mike', 'Foster', 'Male', '12 Fox Drive', '', 'London', 'England', 'NW9', '1984-04-01', '', '', '', 'mike.f-jazz@gmail.com', '08895632271', '', '$2a$08$l8.pgscUl3BYpi4VS2W41OL8aVQX7X0ZLZknWY6AQ9FUb8pRhGHpG', 'null', 0, 1, '2019-04-28 21:40:43'),
(36, 'Ms', 'Kate', 'Oax', 'Female', '67 Robin Way', '', 'London', 'England', 'NE8', '1994-04-25', '', '', '', 'kate.o-elex@live.com', '09864271253', '', '$2a$08$o5KBVEtxab4tWlCUaQSCFuuHkx5NgKpNb1B4NYMkp2ymHQLkifKb2', 'null', 0, 1, '2019-04-28 21:44:34'),
(37, 'Mr.', 'Tom', 'Smith', 'Male', '23 Horse Hill Road', '', 'Luton', 'England', 'LU3', '1986-03-17', '', '', '', 'tom.s-wire@hotmail.com', '08874532218', '', '$2a$08$mzTk3b9cn4S3h73bcPbOQ.y8WLzsrCvarnHc2ILndTExk/Yh0vVwy', 'null', 0, 1, '2019-04-28 21:48:43'),
(40, 'Mr.', 'Mike ', 'Rock', 'Male', 'Forest House', 'Dencora Way', 'Luton', 'England', 'LU3 3HJ', '1997-05-17', 'Jane Rock', '08703539914', '', 'organiser@test.com', '08834143351', '', '$2a$08$0239z2O/uUWKIf.QHZ0d6.AAq.jGM0WXuHyGT06yalHlbNJxhzMiC', 'Organiser Test', 0, NULL, '2019-05-12 21:49:40'),
(41, 'Mr.', 'Steven', 'Great', 'Male', 'Medow Close', 'Robin Way', 'Luton', 'England', 'LU4 5TE', '1965-02-13', 'Barbara Great', '08956342281', '', 'agent@test.com', '08935427631', '', '$2a$08$0239z2O/uUWKIf.QHZ0d6.AAq.jGM0WXuHyGT06yalHlbNJxhzMiC', NULL, 0, 1, '2019-05-13 13:15:21'),
(42, 'Miss', 'Belen', 'Silver', 'Female', '45 Lavender Way', 'Flat A', 'Dunstable', 'England', 'LU6 6OD', '1985-03-14', 'Tracy White', '08458241125', '', 'customer@test.com', '07945236613', '', '$2a$08$0239z2O/uUWKIf.QHZ0d6.AAq.jGM0WXuHyGT06yalHlbNJxhzMiC', NULL, 0, NULL, '2019-05-13 13:18:43'),
(43, 'Mr.', 'Harry ', 'Long', 'Male', '12 Forest Close', 'London Road', 'London', 'England ', 'W1 7FR', '1999-05-27', 'Bob Smith', '07853421186', '', 'harry.long@hotmail.com', '07853428864', '', '$2a$08$.0HWmqIvzppyI6D/obhUI.Payw/Yo4c3eJ9CJInyEE83Yh851JexC', NULL, 0, NULL, '2019-05-13 13:24:29'),
(44, 'Mrs.', 'Kate', 'Forest', 'Female', '65 Upper Road', 'Flat B', 'London', 'England', 'W11 8ED', '1998-09-20', 'Mike Forest', '08654752312', '', 'k.m.forest@aol.com', '08647529521', '', '$2a$08$PsF5VyxlXzYwNkdkGYyiuOZpVOz631bz/mPQyBVZ8fCkFZU3XWwue', NULL, 0, NULL, '2019-05-13 13:28:00'),
(45, 'Miss', 'Avril', 'Jones', 'Female', '76 Uxbridge Road', 'Flat C', 'London', 'England', 'W14 9SW', '1982-05-10', 'Maria Black', '08674532186', '', 'a.jones@live.com', '08653752231', '', '$2a$08$cpRR0P1J8/DZb2iQ2U9CjOxdKXGqec0PJp5DtpGyMbrEAeBS29Whi', NULL, 0, NULL, '2019-05-13 13:30:59'),
(46, 'Mr.', 'Alex', 'Smith', 'Male', '95 High Street', 'Flat F', 'London', 'England', 'W1U 6YW', '1991-09-05', 'Sam Gray', '07856432286', '', 'alex.smith@hotmail.com', '08473427628', '', '$2a$08$xCqTvyjIWhImkWDF./T4yuIx4qZGe1qYOTXwWLCXEAsokCOYOU.G.', NULL, 0, NULL, '2019-05-13 13:34:08'),
(47, 'Mrs.', 'Kate', 'Smith', 'Female', '26 Great Street', 'Flat A', 'London', 'England', 'SW1P 6DX', '1995-05-20', 'Bob Smith', '08735413276', 'Music Fiesta Limited', 'info@music-fiesta.com', '0800 687 4289', 'www.music-fiesta.com', '$2a$08$66B3XRwGR3gLsdmbna2P..z4lymmYPx5odfTkscETNhE8dQisIZhK', 'null', 0, NULL, '2019-05-13 15:00:54'),
(48, 'Mr.', 'Harry ', 'White', 'Male', ' MECF House', '582 High Street', 'Birmingham', 'England', 'B4 1AA', '1993-02-01', 'Fran Salt', '08735235821', 'Events Music Limited', 'info@events.com', '08001118811', 'www.events.com', '$2a$08$eOO8GAMhLLECvz6WcAXT/uI33nPGJquywp52oTt0wUDNmquz205r.', 'null', 0, NULL, '2019-05-13 15:55:30'),
(49, 'Ms', 'Mel', 'Hopkins', 'Female', 'Power House', 'High Street', 'Luton ', 'England', 'LU1', '1995-11-15', 'Charlie Black', '08734512342', 'Hopkins Studios Limited', 'info@hopkins-studios.com', '08004538721', 'www.hopkins-studios.com', '$2a$08$G92DS7vLdfma10FKahjykOAmhb/1Ose3peKbdNZ68D1usDWQFVyZ6', 'null', 0, NULL, '2019-05-14 09:53:44'),
(50, 'Mrs.', 'Alice', 'Jones', 'Male', '894 Light House', 'Upper Street', 'Brighton', 'England', 'BR1 4SK', '1996-06-20', 'Gary Jones', '08452343124', 'Lighthouse Media Limited', 'info@lighthouse-media.com', '0800 345 2316', 'www.lighthouse-media.com', '$2a$08$5ULjzv7ZQGj7.4xsDpotg.kNtp96mGcyo12jMUWLpPKr9bCF8vBW6', 'null', 0, NULL, '2019-05-14 10:14:30'),
(51, 'Mr.', 'Harry', 'Great', 'Male', '782 Power House', 'High Street', 'Luton', 'England', 'LU1 5RU', '1992-02-10', 'Alex Great', '07563428863', 'Power House Media Limited', 'info@powerhouse-media.com', '0800 3473 348', 'www.powerhouse-media.com', '$2a$08$yYSHkKXKo85XIILhTGV9aO8Ve4z8a/T9QfykC7.War8q4TbC2fDSS', 'null', 0, NULL, '2019-05-14 11:27:07'),
(52, 'Mr.', 'Bob ', 'Ford', 'Male', '4 Forest Close', 'Long Street', 'London', 'England ', 'SW5 2PH', '1997-05-17', 'Ellen Ford', '07563428867', NULL, 'fords.family@live.com', 'Telephone: 02063428867', '', '$2a$08$N/Kw/2Q.8KtMS7RUqhe05.VXwlIxb8f0FQ3.NioeHLuSN6J8d4NAK', 'null', 0, NULL, '2019-05-14 12:13:21'),
(54, 'Mr.', 'Bob', 'Ford ', 'Male', '4 Forest Close', 'Long Street', 'London', 'England ', 'SW5 2PH', '1996-05-20', 'Ellen Ford', '07563428867', '', 'fords@live.com ', '02063428867', '', '$2a$08$.XLczuAaTsraLNGlIE1IBOl/CysuCkspToci1dCFAB98m008qak0i', 'null', 0, NULL, '2019-05-14 12:39:48'),
(55, 'Mrs.', 'Kate', 'Broad', 'Female', 'Robin House', 'Meadow Road', 'Luton', 'England', 'LU1 8FS', '1997-09-11', 'Gary Jones ', '08452343432', '', 'kate.b@gmail.com', '07452343465', '', '$2a$08$j8Ge9twsFulvi2elrtuFwezWd6xleHgS2WSecgzpKDlzl2yq31yem', 'null', 0, NULL, '2019-05-14 13:03:25'),
(56, 'Mr.', 'Dolf', 'Schwarz', 'Male', 'Florian Haus', 'langer Weg ', 'Munchen', 'Deutschland', '80331 ', '1991-07-05', 'Vivian  Haus', '+49 (089) 754-3013', '', 'info@musikkonzerte.com', '+49 (089) 754-3032', 'www.musikkonzerte.com', '$2a$08$TLEPi/k1q9uTpRgwDPePlePNmd7leNzSoy3ckq6pQwkdpi9/oJ1wS', '1', 0, NULL, '2019-05-14 13:55:16'),
(57, 'Mrs.', 'Avril', 'House', 'Female', 'Garden Close', 'Valley Road', 'London', 'England', 'SW5 7SQ', '1988-01-02', 'Alex House', '08452343411', '', 'info@power-entertainment.com', '0800 463 8941', 'www.power-entertainment.com', '$2a$08$tAJJnkM.WFPmHf8IyeTiBeqIa5eIc2GwtuTOskfmaQRAGm8UCjSmy', '1', 0, 0, '2019-05-14 15:01:18'),
(58, 'Mrs.', 'test', 'test', 'Female', 'test', '', 'test', 'test', 'test', '2019-05-09', '', '', '', 'test', 'test', 'test', '$2a$08$alS7HxIcRQuMvUctXjOBdufsUzK2LwyIl1KekPOKvrkYcxq87cks.', 'null', 0, NULL, '2019-05-15 11:22:00');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `event_performers`
--
ALTER TABLE `event_performers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=115;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

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
