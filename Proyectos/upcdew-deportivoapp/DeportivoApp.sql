-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.44-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema deportivoprueba
--

CREATE DATABASE IF NOT EXISTS deportivoprueba;
USE deportivoprueba;

--
-- Definition of table `t_examenfisico`
--

DROP TABLE IF EXISTS `t_examenfisico`;
CREATE TABLE `t_examenfisico` (
  `Co_ExamenFisico` int(11) NOT NULL AUTO_INCREMENT,
  `Co_Jugador` int(11) NOT NULL,
  `Tx_Descripcion` varchar(255) NOT NULL,
  `Tx_TipoExamenFisico` varchar(255) NOT NULL,
  `Nu_resultado` double NOT NULL,
  `Tx_Temporada` varchar(255) NOT NULL,
  PRIMARY KEY (`Co_ExamenFisico`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_examenfisico`
--

/*!40000 ALTER TABLE `t_examenfisico` DISABLE KEYS */;
INSERT INTO `t_examenfisico` (`Co_ExamenFisico`,`Co_Jugador`,`Tx_Descripcion`,`Tx_TipoExamenFisico`,`Nu_resultado`,`Tx_Temporada`) VALUES 
 (4,4,'3200 MT.','RESISTENCIA',4,'TEMPORADA_2010-01'),
 (6,6,'2950 MT.','RESISTENCIA',4,'TEMPORADA_2010-01'),
 (7,7,'2800 MT.','RESISTENCIA',4,'TEMPORADA_2010-01'),
 (8,8,'2950 MT.','RESISTENCIA',4,'TEMPORADA_2010-01'),
 (9,9,'3150 MT.','RESISTENCIA',4,'TEMPORADA_2010-01'),
 (10,10,'3200 MT.','RESISTENCIA',4,'TEMPORADA_2010-01'),
 (14,4,'3200 MT.','RESISTENCIA',4,'TEMPORADA_2010-02'),
 (16,6,'2950 MT.','RESISTENCIA',4,'TEMPORADA_2010-02'),
 (17,7,'2800 MT.','RESISTENCIA',4,'TEMPORADA_2010-02'),
 (18,8,'2950 MT.','RESISTENCIA',4,'TEMPORADA_2010-02'),
 (19,9,'3150 MT.','RESISTENCIA',4,'TEMPORADA_2010-02'),
 (20,10,'3200 MT.','RESISTENCIA',4,'TEMPORADA_2010-02'),
 (24,4,'3.49 MT','RESISTENCIA PIERNAS',4,'TEMPORADA_2010-01'),
 (25,5,'3.48 MT','RESISTENCIA PIERNAS',4,'TEMPORADA_2010-01'),
 (26,6,'3.56 MT','RESISTENCIA PIERNAS',5,'TEMPORADA_2010-01'),
 (27,7,'3.57 MT','RESISTENCIA PIERNAS',4,'TEMPORADA_2010-01'),
 (28,8,'3.49 MT','RESISTENCIA PIERNAS',5,'TEMPORADA_2010-01'),
 (29,9,'3.50 MT','RESISTENCIA PIERNAS',4,'TEMPORADA_2010-01'),
 (30,10,'3.51 MT','RESISTENCIA PIERNAS',5,'TEMPORADA_2010-01'),
 (34,4,'3.49 MT','RESISTENCIA PIERNAS',4,'TEMPORADA_2010-02'),
 (35,5,'3.51 MT','RESISTENCIA PIERNAS',4,'TEMPORADA_2010-02'),
 (36,6,'3.56 MT','RESISTENCIA PIERNAS',5,'TEMPORADA_2010-02'),
 (37,7,'3.56 MT','RESISTENCIA PIERNAS',4,'TEMPORADA_2010-02'),
 (38,8,'3.49 MT','RESISTENCIA PIERNAS',5,'TEMPORADA_2010-02'),
 (39,9,'3.50 MT','RESISTENCIA PIERNAS',4,'TEMPORADA_2010-02'),
 (40,10,'3.53 MT','RESISTENCIA PIERNAS',5,'TEMPORADA_2010-02'),
 (48,1,'1ewre','Fuerza',1,'Temporada 1');
/*!40000 ALTER TABLE `t_examenfisico` ENABLE KEYS */;


--
-- Definition of table `t_examenmedico`
--

DROP TABLE IF EXISTS `t_examenmedico`;
CREATE TABLE `t_examenmedico` (
  `Co_ExamenMedico` int(11) NOT NULL AUTO_INCREMENT,
  `Co_Jugador` int(11) NOT NULL,
  `Nu_Talla` double NOT NULL,
  `Tx_ExamenSangre` varchar(255) NOT NULL,
  `Tx_ExamenOrina` varchar(255) NOT NULL,
  `Nu_AlturaPromedioSalto` double NOT NULL,
  `Tx_Temporada` varchar(255) NOT NULL,
  `Nu_Resistencia` double NOT NULL,
  `Nu_LongitudMuslo` double NOT NULL,
  `Nu_LongitudCintura` double NOT NULL,
  `Nu_LongitudPecho` double NOT NULL,
  `Nu_LongitudAntebrazo` double NOT NULL,
  `Nu_LongitudBrazo` double NOT NULL,
  `Nu_LongitudCuello` double NOT NULL,
  `Nu_Peso` double NOT NULL,
  PRIMARY KEY (`Co_ExamenMedico`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_examenmedico`
--

/*!40000 ALTER TABLE `t_examenmedico` DISABLE KEYS */;
INSERT INTO `t_examenmedico` (`Co_ExamenMedico`,`Co_Jugador`,`Nu_Talla`,`Tx_ExamenSangre`,`Tx_ExamenOrina`,`Nu_AlturaPromedioSalto`,`Tx_Temporada`,`Nu_Resistencia`,`Nu_LongitudMuslo`,`Nu_LongitudCintura`,`Nu_LongitudPecho`,`Nu_LongitudAntebrazo`,`Nu_LongitudBrazo`,`Nu_LongitudCuello`,`Nu_Peso`) VALUES 
 (1,1,1.78,'NORMAL','NORMAL',2.78,'TEMPORADA_2010-01',4,0.68,0.78,0.52,0.45,0.82,0.12,77),
 (54,2,1.79,'LEUCOCITOS BAJOS3ere','ACIDO URICO ALTO2re',2.79,'Temporada 1',4,0.64,0.78,0.61,0.42,0.81,0.11,78),
 (55,1,1,'1','1',1,'Temporada 1',1,1,1,1,1,1,1,1),
 (56,1,1.78,'NORMAL','NORMAL234234',2.78,'Temporada 1',4,0.68,0.78,0.52,0.45,0.82,0.12,77),
 (57,3,2.34324324324324e+016,'f234f23f23f32f','4234324234234',23423432,'Temporada 1',4234324234,43242342342,2342342,234234234,234324,234324234,2343242432,234234324),
 (58,3,2.34324324324324e+016,'f234f23f23f32f','4234324234234333333333',23423432,'Temporada 1',4234324234,43242342342,2342342,234234234,234324,234324234,2343242432,234234324),
 (59,3,2342323232,'f234f23f23f32f','4234324234234333333333',23423432,'Temporada 1',4234324234,43242342342,2342342,234234234,234324,234324234,2343242432,234234324);
/*!40000 ALTER TABLE `t_examenmedico` ENABLE KEYS */;


--
-- Definition of table `t_indisciplina`
--

DROP TABLE IF EXISTS `t_indisciplina`;
CREATE TABLE `t_indisciplina` (
  `Co_Indisciplina` int(11) NOT NULL AUTO_INCREMENT,
  `Fe_Indisciplina` smallint(6) NOT NULL,
  `Tx_Descripcion` smallint(6) NOT NULL,
  `Tx_TipoCastipo` smallint(6) NOT NULL,
  `Nu_PorcentajeDescuento` smallint(6) NOT NULL,
  `Nu_DiasSuspension` smallint(6) NOT NULL,
  `Nu_TarjeAmarilla` smallint(6) NOT NULL,
  `Nu_TarjetaRojas` smallint(6) NOT NULL,
  `T_JugadorPartido_ID` int(11) NOT NULL,
  `Co_Campeonato` int(11) NOT NULL,
  `Co_Jugador` int(11) NOT NULL,
  PRIMARY KEY (`Co_Indisciplina`,`Co_Campeonato`,`Co_Jugador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_indisciplina`
--

/*!40000 ALTER TABLE `t_indisciplina` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_indisciplina` ENABLE KEYS */;


--
-- Definition of table `t_jugador`
--

DROP TABLE IF EXISTS `t_jugador`;
CREATE TABLE `t_jugador` (
  `Co_Jugador` int(11) NOT NULL AUTO_INCREMENT,
  `Tx_Telefono` varchar(255) NOT NULL,
  `No_Jugador` varchar(255) NOT NULL,
  `Tx_ApellidoPaterno` varchar(255) NOT NULL,
  `Tx_ApellidoMaterno` varchar(255) NOT NULL,
  `Tx_Direccion` varchar(255) NOT NULL,
  `Tx_Contrato` varchar(255) NOT NULL,
  `Fe_Registro` date NOT NULL,
  `Tx_Posicion` varchar(255) NOT NULL,
  PRIMARY KEY (`Co_Jugador`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_jugador`
--

/*!40000 ALTER TABLE `t_jugador` DISABLE KEYS */;
INSERT INTO `t_jugador` (`Co_Jugador`,`Tx_Telefono`,`No_Jugador`,`Tx_ApellidoPaterno`,`Tx_ApellidoMaterno`,`Tx_Direccion`,`Tx_Contrato`,`Fe_Registro`,`Tx_Posicion`) VALUES 
 (1,'2639073','RENZO','REVOREDO','SUAZO','AV. ARIZONA 3456, URB. CERO GRADOS','C2008M0916','2008-03-01','DEFENSA'),
 (2,'4269073','GIANCARLO','CARMONA','MALDONADO','AV. ASTEROIDES 4956, URB. PETARDOS','C2009M0416','2009-04-01','DEFENSA'),
 (3,'28945235','ADRIAN','ZELA ','TERRY','AV. JUPITER 6585, URB. TERMOPILAS','C2010M0428','2009-12-06','DEFENSA'),
 (4,'4648515','JORGE','VASQUEZ','ROSALES','JR. NEPTUNO 1278, URB. MADRID','C20090628','2009-04-01','MEDIOCAMPO'),
 (5,'2657869','ANTONIO','GONZALES','CANCHARI','JR. GANIMEDES 1278, URB. PALACIOS','C20080618','2009-12-06','MEDIOCAMPO'),
 (7,'7125458','MIGUEL','TORRES','QUINTANA','JR. CONDORES 1278, URB. SAN JOAQUIN','C20101218','2009-12-06','MEDIOCAMPO'),
 (8,'9125458','GIANFRANCO','LABARTHE','TOME','JR. CALLAO 1278, URB. CASUARINAS','C20090128','2009-04-01','DELANTERO'),
 (9,'6584512','JORGE','MALPARTIDA','VALLE','JR. AZPITIA 1278, URB. MALA','C20080228','2009-12-06','DELANTERO'),
 (10,'4598658','JANKARLO','CHIRINOS','TELLO','JR. CERRO AZUL 1278, URB. SAN ANTONIO','C20090530','2009-04-01','DELANTERO'),
 (11,'4598658','JANKARLO2','CHIRINOS','TELLO','JR. CERRO AZUL 1278, URB. SAN ANTONIO','C20090530','2009-04-01','Delantero'),
 (12,'4598658','JANKARLO','CHIRINOS','TELLO','JR. CERRO AZUL 1278, URB. SAN ANTONIO','C20090530','2009-04-01','Delantero');
/*!40000 ALTER TABLE `t_jugador` ENABLE KEYS */;


--
-- Definition of table `t_jugadorpartido`
--

DROP TABLE IF EXISTS `t_jugadorpartido`;
CREATE TABLE `t_jugadorpartido` (
  `Co_JugadorPartido` int(11) NOT NULL AUTO_INCREMENT,
  `Nu_Pasesbuenos` int(11) DEFAULT NULL,
  `Nu_PasesErrados` int(11) DEFAULT NULL,
  `Fl_PosicionAdelanta` smallint(6) DEFAULT NULL,
  `Nu_ScalaRendimiento` double DEFAULT NULL,
  `Co_Campeonato` varchar(255) DEFAULT NULL,
  `Co_Jugador` int(11) unsigned DEFAULT NULL,
  `Nu_Goles` int(11) unsigned DEFAULT NULL,
  `Nu_TarjetaAmarillas` int(11) unsigned DEFAULT NULL,
  `Nu_TarjetaRojas` int(11) unsigned DEFAULT NULL,
  `Tx_Indisciplina` varchar(255) DEFAULT NULL,
  `Tx_Lesiones` varchar(255) DEFAULT NULL,
  `Co_Partido` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`Co_JugadorPartido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_jugadorpartido`
--

/*!40000 ALTER TABLE `t_jugadorpartido` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_jugadorpartido` ENABLE KEYS */;


--
-- Definition of table `t_partido`
--

DROP TABLE IF EXISTS `t_partido`;
CREATE TABLE `t_partido` (
  `Co_Partido` int(11) NOT NULL AUTO_INCREMENT,
  `Co_Campeonato` varchar(255) DEFAULT NULL,
  `Fe_Partido` date DEFAULT NULL,
  `Tx_Ciudad` varchar(255) DEFAULT NULL,
  `Tx_TipoCancha` varchar(255) DEFAULT NULL,
  `Tx_EquipoContrario` varchar(255) DEFAULT NULL,
  `Tx_Localidad` varchar(100) DEFAULT NULL,
  `Nu_GolFavor` int(11) unsigned DEFAULT NULL,
  `Nu_GolContra` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`Co_Partido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_partido`
--

/*!40000 ALTER TABLE `t_partido` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_partido` ENABLE KEYS */;


--
-- Definition of procedure `USP_ELIMINAR_EXAMENFISICO`
--

DROP PROCEDURE IF EXISTS `USP_ELIMINAR_EXAMENFISICO`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_ELIMINAR_EXAMENFISICO`(
IN p_Co_ExamenFisico VARCHAR(255)
 )
BEGIN


    DELETE FROM T_examenfisico  WHERE Co_ExamenFisico= p_Co_ExamenFisico  ;


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `USP_ELIMINAR_EXAMEN_MEDICO`
--

DROP PROCEDURE IF EXISTS `USP_ELIMINAR_EXAMEN_MEDICO`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_ELIMINAR_EXAMEN_MEDICO`(
IN p_Co_ExamenMedico INT(11)
)
BEGIN
DELETE FROM t_Examenmedico where Co_ExamenMedico=p_Co_ExamenMedico ;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `USP_ELIMINAR_JUGADOR`
--

DROP PROCEDURE IF EXISTS `USP_ELIMINAR_JUGADOR`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_ELIMINAR_JUGADOR`(
IN p_Co_Jugador VARCHAR(255)
 )
BEGIN


    DELETE FROM T_JUGADOR  WHERE Co_Jugador= p_Co_Jugador  ;


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `USP_ELIMINAR_JUGADOR_PARTIDO`
--

DROP PROCEDURE IF EXISTS `USP_ELIMINAR_JUGADOR_PARTIDO`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_ELIMINAR_JUGADOR_PARTIDO`(
IN p_Co_JugadorPartido INT(11),
IN p_Co_Jugador INT(11) )
BEGIN
 DECLARE txn_error INTEGER DEFAULT 0 ;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION BEGIN
     SET txn_error=1;
    END;
  START TRANSACTION;

  DELETE FROM t_jugadorpartido where Co_JugadorPartido=p_Co_JugadorPartido and Co_Jugador=p_Co_Jugador;

  IF txn_error THEN
       ROLLBACK;
       SELECT 'Transfer aborted ';
   ELSE
         COMMIT;
   END IF;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `USP_ELIMINAR_PARTIDO`
--

DROP PROCEDURE IF EXISTS `USP_ELIMINAR_PARTIDO`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_ELIMINAR_PARTIDO`(
IN p_Co_Partido INT(11)
)
BEGIN
 DECLARE txn_error INTEGER DEFAULT 0 ;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION BEGIN
     SET txn_error=1;
    END;
  START TRANSACTION;

  DELETE FROM t_jugadorPartido where Co_Partido=p_Co_Partido;

  DELETE FROM t_partido where Co_Partido=p_Co_Partido;

  IF txn_error THEN
       ROLLBACK;
       SELECT 'Transfer aborted ';
   ELSE
         COMMIT;
   END IF;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `USP_INSERTA_EXAMENFISICO`
--

DROP PROCEDURE IF EXISTS `USP_INSERTA_EXAMENFISICO`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_INSERTA_EXAMENFISICO`(
IN p_Co_ExamenFisico INT(11),
IN p_Co_Jugador INT(11),
IN p_Tx_Descripcion VARCHAR(255),
IN p_Tx_TipoExamenFisico VARCHAR(255),
IN p_Nu_Resultado DOUBLE,
IN p_Tx_Temporada VARCHAR(255)
 )
BEGIN
 DECLARE nExistExamenFisico INT DEFAULT 0;
    DECLARE txn_error INTEGER DEFAULT 0 ;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION BEGIN
     SET txn_error=1;
    END;
  START TRANSACTION;

      SELECT COUNT(*)
    INTO nExistExamenFisico
    FROM T_ExamenFisico
    WHERE Co_ExamenFisico=p_Co_ExamenFisico;
   IF nExistExamenFisico =0 THEN
    INSERT INTO T_ExamenFisico
         (
            Co_Jugador,
            Tx_Descripcion,
            Tx_TipoExamenFisico,
            Nu_Resultado,
            Tx_Temporada
         )
      VALUES
         (
            p_Co_Jugador,
            p_Tx_Descripcion,
            p_Tx_TipoExamenFisico,
            p_Nu_Resultado,
            p_Tx_Temporada
            ) ;
    ELSE

    UPDATE T_ExamenFisico SET
            Co_Jugador=p_Co_Jugador,
            Tx_Descripcion=p_Tx_Descripcion,
            Tx_TipoExamenFisico=p_Tx_TipoExamenFisico,
            Nu_Resultado=p_Nu_Resultado,
            Tx_Temporada =p_Tx_Temporada where Co_ExamenFisico=p_Co_ExamenFisico;

END IF ;
   IF txn_error THEN
       ROLLBACK;
       SELECT 'Transfer aborted ';
   ELSE
         COMMIT;
   END IF;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `USP_INSERTA_EXAMEN_MEDICO`
--

DROP PROCEDURE IF EXISTS `USP_INSERTA_EXAMEN_MEDICO`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_INSERTA_EXAMEN_MEDICO`(
IN p_Co_ExamenMedico INT(11),
IN p_Co_Jugador INT(11),
IN p_Nu_Talla DOUBLE,
IN p_Tx_ExamenSangre VARCHAR(255),
IN p_Tx_ExamenOrina VARCHAR(255),
IN p_Nu_AlturaPromedioSalto Double,
IN p_Tx_Temporada VARCHAR(255),
IN p_Nu_Resistencia DOUBLE,
IN p_Nu_LongitudMuslo DOUBLE,
IN p_Nu_LongitudCintura DOUBLE,
IN p_Nu_LongitudPecho DOUBLE,
IN p_Nu_LongitudAntebrazo DOUBLE,
IN p_Nu_LongitudBrazo DOUBLE,
IN p_Nu_LongitudCuello DOUBLE,
IN p_Nu_Peso DOUBLE
 )
BEGIN
 DECLARE nExistExamen INT DEFAULT 0;
    DECLARE txn_error INTEGER DEFAULT 0 ;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION BEGIN
     SET txn_error=1;
    END;
  START TRANSACTION;

      SELECT COUNT(*)
    INTO nExistExamen
    FROM t_examenmedico
    WHERE Co_ExamenMedico=p_Co_ExamenMedico;
   IF nExistExamen =0 THEN
    INSERT INTO t_examenmedico
         (
	          Co_Jugador,
            Nu_Talla,
            Tx_ExamenSangre,
            Tx_ExamenOrina,
            Nu_AlturaPromedioSalto,
            Tx_Temporada,
            Nu_Resistencia,
            Nu_LongitudMuslo,
            Nu_LongitudCintura,
            Nu_LongitudPecho,
            Nu_LongitudAntebrazo,
            Nu_LongitudBrazo,
            Nu_LongitudCuello,
            Nu_Peso
         )
      VALUES
         (
	          p_Co_Jugador,
            p_Nu_Talla,
            p_Tx_ExamenSangre,
            p_Tx_ExamenOrina,
            p_Nu_AlturaPromedioSalto,
            p_Tx_Temporada,
            p_Nu_Resistencia,
            p_Nu_LongitudMuslo,
            p_Nu_LongitudCintura,
            p_Nu_LongitudPecho,
            p_Nu_LongitudAntebrazo,
            p_Nu_LongitudBrazo,
            p_Nu_LongitudCuello,
            p_Nu_Peso
            ) ;
    ELSE

    UPDATE t_examenmedico SET
            Nu_Talla=p_Nu_Talla,
            Tx_ExamenSangre=p_Tx_ExamenSangre,
            Tx_ExamenOrina=p_Tx_ExamenOrina,
            Nu_AlturaPromedioSalto=p_Nu_AlturaPromedioSalto,
            Tx_Temporada=p_Tx_Temporada,
            Nu_Resistencia=p_Nu_Resistencia,
            Nu_LongitudMuslo=p_Nu_LongitudMuslo,
            Nu_LongitudCintura=p_Nu_LongitudCintura,
            Nu_LongitudPecho=p_Nu_LongitudPecho,
            Nu_LongitudAntebrazo=p_Nu_LongitudAntebrazo,
            Nu_LongitudBrazo=p_Nu_LongitudBrazo,
            Nu_LongitudCuello=p_Nu_LongitudCuello,
            Nu_Peso=p_Nu_Peso where Co_ExamenMedico=p_Co_ExamenMedico;
END IF ;
   IF txn_error THEN
       ROLLBACK;
       SELECT 'Transfer aborted ';
   ELSE
         COMMIT;
   END IF;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `USP_INSERTA_JUGADOR`
--

DROP PROCEDURE IF EXISTS `USP_INSERTA_JUGADOR`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_INSERTA_JUGADOR`(
IN p_Co_Jugador VARCHAR(255),
IN p_Tx_Telefono VARCHAR(255),
IN p_No_Jugador VARCHAR(255),
IN p_Tx_ApellidoPaterno VARCHAR(255),
IN p_Tx_ApellidoMaterno VARCHAR(255),
IN p_Tx_Direccion VARCHAR(255),
IN p_Tx_Contrato VARCHAR(255),
IN p_Fe_Registro DATE,
IN p_Tx_Posicion VARCHAR(255)
 )
BEGIN
 DECLARE nExistJugador INT DEFAULT 0;
    DECLARE txn_error INTEGER DEFAULT 0 ;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION BEGIN
     SET txn_error=1;
    END;
  START TRANSACTION;

      SELECT COUNT(*)
    INTO nExistJugador
    FROM T_Jugador
    WHERE Co_Jugador=p_Co_Jugador;
   IF nExistJugador =0 THEN
    INSERT INTO T_Jugador
         (
          	Tx_Telefono,
	          No_Jugador,
            Tx_ApellidoPaterno,
            Tx_ApellidoMaterno,
            Tx_Direccion,
            Tx_Contrato,
            Fe_Registro,
            Tx_Posicion
         )
      VALUES
         (
	          p_Tx_Telefono,
	          p_No_Jugador,
            p_Tx_ApellidoPaterno,
            p_Tx_ApellidoMaterno,
            p_Tx_Direccion,
            p_Tx_Contrato,
            p_Fe_Registro,
            p_Tx_Posicion
            ) ;
    ELSE

    UPDATE T_Jugador SET
            Tx_Telefono=p_Tx_Telefono,
	          No_Jugador=p_No_Jugador,
            Tx_ApellidoPaterno=p_Tx_ApellidoPaterno,
            Tx_ApellidoMaterno=p_Tx_ApellidoMaterno,
            Tx_Direccion=p_Tx_Direccion,
            Tx_Contrato=p_Tx_Contrato,
            Fe_Registro=p_Fe_Registro,
            Tx_Posicion =p_Tx_Posicion where Co_Jugador=p_Co_Jugador;

END IF ;
   IF txn_error THEN
       ROLLBACK;
       SELECT 'Transfer aborted ';
   ELSE
         COMMIT;
   END IF;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `USP_INSERTA_JUGADOR_PARTIDO`
--

DROP PROCEDURE IF EXISTS `USP_INSERTA_JUGADOR_PARTIDO`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_INSERTA_JUGADOR_PARTIDO`(
IN p_Co_JugadorPartido INT(11),
IN p_Nu_Pasesbuenos INT(11),
IN p_Fl_PosicionAdelanta INT(11),
IN p_Nu_ScalaRendimiento INT(11),
IN p_Co_Jugador INT(11),
IN p_Nu_Goles INT(11),
IN p_Nu_TarjetaAmarillas INT(11),
IN p_Nu_TarjetaRojas INT(11),
IN p_Tx_Indisciplina VARCHAR(255),
IN p_Tx_Lesiones VARCHAR(255),
IN p_Co_Partido INT(11)
 )
BEGIN

DECLARE nExistJugadorPartido INT DEFAULT 0;
    DECLARE txn_error INTEGER DEFAULT 0 ;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION BEGIN
     SET txn_error=1;
    END;
  START TRANSACTION;

      SELECT COUNT(*)
    INTO nExistJugadorPartido
    FROM t_jugadorpartido
    WHERE Co_JugadorPartido=p_Co_JugadorPartido;
   IF nExistJugadorPartido =0 THEN
    INSERT INTO t_jugadorpartido
         (
          Nu_Pasesbuenos,

          Fl_PosicionAdelanta,
          Nu_ScalaRendimiento,
          Co_Jugador,
          Nu_Goles,
          Nu_TarjetaAmarillas,
          Nu_TarjetaRojas,
          Tx_Indisciplina,
          Tx_Lesiones,
          Co_Partido
         )
      VALUES
         (
          p_Nu_Pasesbuenos,
      p_Fl_PosicionAdelanta,
          p_Nu_ScalaRendimiento,
      p_Co_Jugador,
          p_Nu_Goles,
          p_Nu_TarjetaAmarillas,
          p_Nu_TarjetaRojas,
          p_Tx_Indisciplina,
          p_Tx_Lesiones,
          p_Co_Partido

            ) ;
    ELSE

   UPDATE t_jugadorpartido SET
          Nu_Pasesbuenos=p_Nu_Pasesbuenos,

          Fl_PosicionAdelanta=p_Fl_PosicionAdelanta,
          Nu_ScalaRendimiento=p_Nu_ScalaRendimiento,

          Co_Jugador=p_Co_Jugador,
          Nu_Goles=p_Nu_Goles,
          Nu_TarjetaAmarillas=p_Nu_TarjetaAmarillas,
          Nu_TarjetaRojas=p_Nu_TarjetaRojas,
          Tx_Indisciplina=p_Tx_Indisciplina,
          Tx_Lesiones=p_Tx_Lesiones,
          Co_Partido=p_Co_Partido
          where Co_JugadorPartido=p_Co_JugadorPartido;

END IF ;
   IF txn_error THEN
       ROLLBACK;
       SELECT 'Transfer aborted ';
   ELSE
         COMMIT;
   END IF;
   


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `USP_INSERTA_PARTIDO`
--

DROP PROCEDURE IF EXISTS `USP_INSERTA_PARTIDO`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_INSERTA_PARTIDO`(
IN p_Co_Partido INT(11),
IN p_Co_Campeonato VARCHAR(255),
IN p_Fe_Partido DATE,
IN p_Tx_Ciudad  VARCHAR(255),
IN p_Tx_TipoCancha VARCHAR(255),
IN p_Tx_EquipoContrario VARCHAR(255),
IN p_Tx_Localidad VARCHAR(100),
IN p_Nu_GolFavor INT(11),
IN p_Nu_GolContra INT(11))
BEGIN
    DECLARE nExistPartido INT DEFAULT 0;
    DECLARE txn_error INTEGER DEFAULT 0 ;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION BEGIN
     SET txn_error=1;
    END;

 START TRANSACTION;

    IF p_Co_Partido=-1 THEN
    INSERT INTO t_partido
         (  Co_Campeonato,
          	Fe_Partido,
	          Tx_Ciudad,
            Tx_TipoCancha,
            Tx_EquipoContrario,
            Tx_Localidad,
            Nu_GolFavor,
            Nu_GolContra

         )
      VALUES
         (  p_Co_Campeonato,
	          p_Fe_Partido,
	          p_Tx_Ciudad,
            p_Tx_TipoCancha,
            p_Tx_EquipoContrario,
            p_Tx_Localidad,
            p_Nu_GolFavor,
            p_Nu_GolContra
            ) ;
    ELSE

    UPDATE t_partido SET
            Fe_Partido=p_Fe_Partido,
	          Tx_Ciudad=p_Tx_Ciudad,
            Tx_TipoCancha=p_Tx_TipoCancha,
            Tx_EquipoContrario=p_Tx_EquipoContrario,
            Tx_Localidad=p_Tx_Localidad,
            Nu_GolFavor=p_Nu_GolFavor,
            Nu_GolContra=p_Nu_GolContra,
            Co_Campeonato=p_Co_Campeonato
             Where Co_Partido=p_Co_Partido;

END IF ;


    COMMIT;

   IF p_Co_Partido=-1 THEN

   select Max(Co_Partido) as co_partido from t_partido;

   ELSE
    
     select p_Co_Partido as co_partido;
   END IF;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `USP_OBTENER_EXAMENESFISICOS`
--

DROP PROCEDURE IF EXISTS `USP_OBTENER_EXAMENESFISICOS`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_OBTENER_EXAMENESFISICOS`(
IN p_Co_Jugador INT(11))
BEGIN

  select  Co_ExamenFisico,Co_Jugador,Tx_Descripcion,Tx_TipoExamenFisico,Nu_Resultado,Tx_Temporada
  from t_examenfisico where Co_Jugador=p_Co_Jugador;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `USP_OBTENER_EXAMENES_MEDICOS`
--

DROP PROCEDURE IF EXISTS `USP_OBTENER_EXAMENES_MEDICOS`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_OBTENER_EXAMENES_MEDICOS`(
IN p_Co_Jugador INT(11))
BEGIN

Select Co_ExamenMedico,e.Co_Jugador,No_Jugador,Tx_ApellidoPaterno,Tx_ApellidoMaterno,
Nu_Talla,Tx_ExamenSangre,Tx_ExamenOrina,
Nu_AlturaPromedioSalto,Tx_Temporada,Nu_Resistencia,Nu_LongitudMuslo,Nu_LongitudCintura,
Nu_LongitudPecho,Nu_LongitudAntebrazo,Nu_LongitudBrazo,Nu_LongitudCuello,Nu_Peso
 from t_examenmedico e,t_jugador j where e.Co_Jugador=j.Co_Jugador and e.Co_Jugador=p_Co_Jugador;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `USP_OBTENER_FILTRO_JUGADOR`
--

DROP PROCEDURE IF EXISTS `USP_OBTENER_FILTRO_JUGADOR`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_OBTENER_FILTRO_JUGADOR`(
IN p_Tx_Posicion VARCHAR(255),
IN p_No_Jugador VARCHAR(255))
BEGIN
IF p_Tx_Posicion<>'' then
  select * from t_jugador where Tx_Posicion like concat('%', p_Tx_Posicion, '%');
else
  select * from t_jugador where No_Jugador like concat('%', p_No_Jugador, '%') ;
end if ;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `USP_OBTENER_JUGADOR`
--

DROP PROCEDURE IF EXISTS `USP_OBTENER_JUGADOR`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_OBTENER_JUGADOR`(
IN p_Co_Jugador INT(11))
BEGIN
  select j.Co_Jugador ,j.Tx_Telefono,j.No_Jugador,j.Tx_ApellidoPaterno,j.Tx_ApellidoMaterno,j.Tx_ApellidoMaterno,j.Tx_Direccion,
  j.Tx_Contrato,j.Fe_Registro,j.Tx_Posicion,e.Nu_Talla, e.Tx_ExamenSangre,e.Tx_ExamenOrina,e.Nu_AlturaPromedioSalto,e.Tx_temporada,
  e.Nu_Resistencia,e.Nu_LongitudMuslo,e.Nu_LongitudCintura,e.Nu_LongitudPecho,e.Nu_LongitudAntebrazo,e.Nu_LongitudBrazo,e.Nu_LongitudCuello,
  e.Nu_Peso,f.No_ExamenFisico,f.Tx_Descripcion,f.Tx_TipoExamenFisico,f.Nu_Resultado,f.Tx_Temporada as Tx_TemporadaFisico
  from t_jugador j,t_examenmedico e,t_examenfisico f where j.Co_Jugador=e.Co_Jugador and j.Co_Jugador=f.Co_Jugador
  and e.Co_Jugador=f.Co_Jugador and j.Co_Jugador= p_Co_Jugador;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `USP_OBTENER_JUGADORES`
--

DROP PROCEDURE IF EXISTS `USP_OBTENER_JUGADORES`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_OBTENER_JUGADORES`()
BEGIN

  select  Co_Jugador,tx_Telefono,No_Jugador,Tx_ApellidoPaterno,Tx_ApellidoMaterno,Tx_Direccion,Tx_Contrato,Fe_Registro,Tx_Posicion from t_jugador ;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `USP_OBTENER_JUGADORES_PARTIDO`
--

DROP PROCEDURE IF EXISTS `USP_OBTENER_JUGADORES_PARTIDO`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_OBTENER_JUGADORES_PARTIDO`(
IN p_Co_Partido INT(11)
)
BEGIN

  select  Co_JugadorPartido,Nu_pasesbuenos,Fl_PosicionAdelanta,Nu_ScalaRendimiento,jp.Co_jugador,Nu_Goles,Nu_TarjetaAmarillas,Nu_TarjetaRojas,Tx_Indisciplina,tx_Lesiones,Co_partido,j.No_Jugador
  from t_jugadorpartido jp inner join t_jugador j
  on jp.co_jugador=j.co_jugador
  where Co_Partido=p_Co_Partido ;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `USP_OBTENER_PARTIDO`
--

DROP PROCEDURE IF EXISTS `USP_OBTENER_PARTIDO`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_OBTENER_PARTIDO`(IN p_Co_Partido INT(11))
BEGIN
SELECT co_campeonato,fe_partido,tx_ciudad,tx_tipoCancha,tx_EquipoContrario,tx_Localidad,Nu_GolFavor,Nu_GolContra,Co_Partido FROM t_Partido where co_partido=p_Co_Partido;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `USP_OBTENER_PARTIDOS`
--

DROP PROCEDURE IF EXISTS `USP_OBTENER_PARTIDOS`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_OBTENER_PARTIDOS`()
BEGIN
SELECT * FROM t_Partido;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `USP_OBTIENE_PORCENTAJES_PARTIDO`
--

DROP PROCEDURE IF EXISTS `USP_OBTIENE_PORCENTAJES_PARTIDO`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_OBTIENE_PORCENTAJES_PARTIDO`()
BEGIN


SELECT ROUND((sum(IF (Nu_GolFavor>Nu_GolContra,1,0))/count(Co_Partido)),2)*100 as partidoGanado,
ROUND((sum(IF (Nu_GolFavor<Nu_GolContra,1,0))/count(Co_Partido)),2)*100 as partidoPerdido,
ROUND((sum(IF (Nu_GolFavor=Nu_GolContra,1,0))/count(Co_Partido)),2)*100 as partidoEmpate
    FROM T_PARTIDO;


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
