-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         10.10.2-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando estructura para tabla navesoftka.naves
CREATE TABLE IF NOT EXISTS `naves` (
  `Nombre` varchar(50) DEFAULT NULL,
  `Potencia` int(11) DEFAULT NULL,
  `Empuje` int(11) DEFAULT NULL,
  `Velocidad` float DEFAULT NULL,
  `Altura` float DEFAULT NULL,
  `Pais` varchar(50) DEFAULT NULL,
  `Peso` float DEFAULT NULL,
  `Tipo` varchar(50) DEFAULT NULL,
  `Combustible` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla navesoftka.naves: ~10 rows (aproximadamente)
/*!40000 ALTER TABLE `naves` DISABLE KEYS */;
INSERT INTO `naves` (`Nombre`, `Potencia`, `Empuje`, `Velocidad`, `Altura`, `Pais`, `Peso`, `Tipo`, `Combustible`) VALUES
	('Saturno V', 25000, 12000, 36000, 30, 'USA', 5000, 'Nave Lanzadera', 'Hidrogeno Liquido'),
	('Proton', 18000, 5000, 20000, 20, 'Rusia', 4500, 'Nave Lanzadera', 'Queroseno'),
	('Larga Marcha', 23000, 6200, 14000, 32, 'China', 3600, 'Nave Lanzadera', 'UDMH'),
	('Galileo', 32500, 25000, 25000, 35, 'USA', 5800, 'Nave No Tripulada', 'NO4 MMH'),
	('Sputnik', 22500, 32400, 18740, 26, 'Rusia', 6300, 'Nave No Tripulada', 'N2H4 Amina'),
	('Cassini', 36000, 24530, 23700, 32, 'Japon', 5600, 'Nave No Tripulada', 'MMH NO'),
	('Apolo', 25000, 19600, 24000, 35, 'USA', 4700, 'Nave Tripulada', 'NO4 UDMH'),
	('Vostok', 16980, 12000, 35000, 23, 'Rusia', 3690, 'Nave Tripulada', 'NO Amina'),
	('Shenzou', 25000, 21500, 26000, 50, 'China', 4800, 'Nave Tripulada', 'N204 MMH'),
	('Prueba3', 25000, 25800, 32000, 20, 'USA', 5220, 'Nave Lanzadera', 'NA MMH');
/*!40000 ALTER TABLE `naves` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
