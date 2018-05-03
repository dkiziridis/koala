-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 22 Μαρ 2018 στις 18:35:45
-- Έκδοση διακομιστή: 10.1.30-MariaDB
-- Έκδοση PHP: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `koala`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `images`
--

CREATE TABLE `images` (
  `id` int(11) NOT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `image_name` varchar(250) NOT NULL,
  `img_data` longblob NOT NULL,
  `height` smallint(15) NOT NULL,
  `width` smallint(15) DEFAULT NULL,
  `mime_type` varchar(6) DEFAULT NULL,
  `file_size` int(11) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `camera_brand` varchar(15) DEFAULT NULL,
  `camera_model` varchar(15) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `megapixels` int(11) DEFAULT NULL,
  `dpi` smallint(10) DEFAULT NULL,
  `shutter_speed` float DEFAULT NULL,
  `flash` tinyint(1) DEFAULT NULL,
  `f_number` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=greek;

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `images`
--
ALTER TABLE `images`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
