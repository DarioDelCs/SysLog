-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-04-2019 a las 21:55:11
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `test_syslog`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertUser` (IN `name` CHAR(20), IN `login` CHAR(20), IN `pass` CHAR(20), IN `profile` CHAR(20), IN `email` CHAR(20))  BEGIN
   INSERT INTO users (LOGIN_ID,NOMBRE,PASSWORD,EMAIL,PROFILENAME)
   VALUES
   ( login, name,pass,email,profile );
   END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUsers` (IN `mail` CHAR(20), IN `id` CHAR(20))  BEGIN
  UPDATE users SET EMAIL=mail 
  WHERE USER_ID = id;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `USER_ID` int(11) NOT NULL,
  `LOGIN_ID` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `NOMBRE` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `PASSWORD` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `EMAIL` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `PROFILENAME` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`USER_ID`, `LOGIN_ID`, `NOMBRE`, `PASSWORD`, `EMAIL`, `PROFILENAME`) VALUES
(1, 'Login', 'Name', '111', 'Email', 'profile'),
(2, 'log2', 'Name', 'Pass2', 'email', 'Profile'),
(3, 'log3', 'nom', 'pass', 'email', 'profile');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`USER_ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `USER_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
