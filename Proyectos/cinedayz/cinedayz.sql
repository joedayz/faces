/*
SQLyog Community v8.53 
MySQL - 5.5.24-log : Database - cinesummer
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cinesummer` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `cinesummer`;

/*Table structure for table `accesos` */

DROP TABLE IF EXISTS `accesos`;

CREATE TABLE `accesos` (
  `acccodig` varchar(5) NOT NULL,
  `accdescr` varchar(20) DEFAULT NULL,
  `accacces` int(2) DEFAULT NULL COMMENT 'acceso',
  PRIMARY KEY (`acccodig`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `accesos` */

insert  into `accesos`(`acccodig`,`accdescr`,`accacces`) values ('1','1',1);

/*Table structure for table `actor` */

DROP TABLE IF EXISTS `actor`;

CREATE TABLE `actor` (
  `actcodig` varchar(10) NOT NULL,
  `actnombr` varchar(20) DEFAULT NULL,
  `actapell` varchar(20) DEFAULT NULL,
  `acturlac` varchar(20) DEFAULT NULL COMMENT 'url del actor',
  PRIMARY KEY (`actcodig`),
  KEY `actnombr` (`actnombr`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `actor` */

insert  into `actor`(`actcodig`,`actnombr`,`actapell`,`acturlac`) values ('412227','Penelope','Cruz',NULL),('412727','Tom','Cruise',NULL),('412728','Tom','Hanks',NULL);

/*Table structure for table `actuacion` */

DROP TABLE IF EXISTS `actuacion`;

CREATE TABLE `actuacion` (
  `actccodi` int(11) NOT NULL,
  `pelcodig` varchar(5) NOT NULL,
  `actcodig` varchar(5) NOT NULL,
  PRIMARY KEY (`actccodi`),
  KEY `actcodig` (`actcodig`),
  KEY `pelcodig` (`pelcodig`),
  CONSTRAINT `pelxactor_fk` FOREIGN KEY (`actcodig`) REFERENCES `actor` (`actcodig`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pelxactor_fk1` FOREIGN KEY (`pelcodig`) REFERENCES `pelicula` (`pelcodig`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `actuacion` */

/*Table structure for table `busqueda` */

DROP TABLE IF EXISTS `busqueda`;

CREATE TABLE `busqueda` (
  `buscodig` int(11) NOT NULL,
  `buscineb` varchar(20) DEFAULT NULL,
  `busartis` varchar(20) DEFAULT NULL,
  `bushorar` varchar(20) DEFAULT NULL,
  `bustipop` varchar(20) DEFAULT NULL,
  `bussubti` varchar(20) DEFAULT NULL,
  `buspaiso` varchar(20) DEFAULT NULL,
  `buspubob` varchar(20) DEFAULT NULL,
  `bustipoe` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`buscodig`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `busqueda` */

/*Table structure for table `cartelera` */

DROP TABLE IF EXISTS `cartelera`;

CREATE TABLE `cartelera` (
  `carcodig` int(5) NOT NULL,
  `pelcodig` varchar(5) DEFAULT NULL,
  `carfecin` date DEFAULT NULL,
  `carfecfi` date DEFAULT NULL,
  `carstatu` char(1) DEFAULT NULL COMMENT 'cartelera status=Vigente, Future, Pasada',
  PRIMARY KEY (`carcodig`),
  KEY `pelcodig` (`pelcodig`),
  CONSTRAINT `cartelera_fk` FOREIGN KEY (`pelcodig`) REFERENCES `pelicula` (`pelcodig`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AVG_ROW_LENGTH=5461;

/*Data for the table `cartelera` */

insert  into `cartelera`(`carcodig`,`pelcodig`,`carfecin`,`carfecfi`,`carstatu`) values (1,'1900','2011-02-25','2011-02-25','V'),(3,'1900','2011-02-20','2011-02-20','P'),(4,'1902','2011-02-20','2011-02-20','V'),(5,'1904','2011-02-20','2011-02-20','V'),(6,'1904','2011-02-20','2011-02-20','P'),(7,'1904','2011-02-25','2011-02-25','V'),(8,'1901','2011-02-25','2011-02-25','V');

/*Table structure for table `comentario` */

DROP TABLE IF EXISTS `comentario`;

CREATE TABLE `comentario` (
  `comcodig` int(5) NOT NULL,
  `pelcodig` varchar(5) DEFAULT NULL,
  `comdescr` text,
  `usucodig` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`comcodig`),
  KEY `usucodig` (`usucodig`),
  KEY `pelcodig` (`pelcodig`),
  CONSTRAINT `comentarios_fk` FOREIGN KEY (`usucodig`) REFERENCES `usuario` (`usucodig`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `comentarios_fk1` FOREIGN KEY (`pelcodig`) REFERENCES `pelicula` (`pelcodig`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `comentario` */

insert  into `comentario`(`comcodig`,`pelcodig`,`comdescr`,`usucodig`) values (1,'1907','**The length of the movie was perfect. It kept to the story to an amazing degree. The few changes didn\'t hurt the feeling nor the telling. The story itself is stirring and captivating. The casting of the parts and their portrayal were right on. This is one of the best movie versions of a Steven King novel I\'ve ever seen, and I think I\'ve seen them all. If you\'re prone to tears at a film, take extra tissues, you\'ll need them. The theater I was in was a mass of sniffles through the end credits. If you like fantasy/drama the film cannot be missed. There are some graphic scenes that may upset some, but this is Steven King. This is a movie I plan to add to my video collection as soon as the Letter Box version hits the shelves.','whitehorse'),(2,'1904','I absolutely loved Black Swan. Iï¿½m just not sure I can accurately say that I enjoyed it. When I first walked into Black Swan, I wasnï¿½t sure what to think. When the movie was over and I walked out, I still wasnï¿½t sure what to think. Despite how that might sound, that is not a criticism, but rather high praise for director Darren Aronofsky (The Wrestler, Requiem for a Dream), and Natalie Portman, who present a movie that is complex, compelling, and never ordinary. It is also one of the yearï¿½s best.','whitehorse'),(3,'1902','Cuando vi al oso Yogi en TV allï¿½ en mi niï¿½ez (en una de las mï¿½ltiples veces que lo han transmitido, pues hay que reconocer que no soy tan viejo y que la serie existe desde finales de los cincuenta), debo decir que no era mi mï¿½ximo. Entre Los Picapiedra, Don Gato y su pandilla y otras joyas de Hanna-Barbera de la ï¿½poca, Yogi era un punto medio: ni nefasto como Pixie y Dixie, pero tampoco glorioso como el Manotas','whitehorse');

/*Table structure for table `detcartelera` */

DROP TABLE IF EXISTS `detcartelera`;

CREATE TABLE `detcartelera` (
  `dcacodig` int(5) NOT NULL COMMENT 'codigo autogenerado',
  `carcodig` int(5) DEFAULT NULL COMMENT 'codigo de la cartelera',
  `salcodig` varchar(5) DEFAULT NULL COMMENT 'codigo de la sala',
  `dcahorar` varchar(20) DEFAULT NULL COMMENT 'Detalle del horario: 8-10pm',
  `dcapreci` int(3) DEFAULT NULL COMMENT 'precio de la entrada',
  `dcaprede` varchar(20) DEFAULT NULL COMMENT 'Detalle del precio de cartelera:Nino, adulto,Senior',
  PRIMARY KEY (`dcacodig`),
  KEY `carcodig` (`carcodig`),
  KEY `salcodig` (`salcodig`),
  CONSTRAINT `detcartelera_fk` FOREIGN KEY (`carcodig`) REFERENCES `cartelera` (`carcodig`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `detcartelera_fk1` FOREIGN KEY (`salcodig`) REFERENCES `sala` (`salcodig`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AVG_ROW_LENGTH=4096;

/*Data for the table `detcartelera` */

insert  into `detcartelera`(`dcacodig`,`carcodig`,`salcodig`,`dcahorar`,`dcapreci`,`dcaprede`) values (1,1,'00001','6:00pm-8.00pm',15,'Adulto'),(2,1,'00001','8:00pm-10.00pm',15,'Adulto'),(3,4,'00002','6:00pm-8.00pm',15,'Adulto'),(4,4,'00002','8:00pm-10.00pm',15,'Adulto'),(5,7,'00003','**6:00pm-8:00pm',17,'**Adulto'),(6,8,'00003','8:00pm-10:00pm',15,'Adulto');

/*Table structure for table `local` */

DROP TABLE IF EXISTS `local`;

CREATE TABLE `local` (
  `loccodig` varchar(5) NOT NULL,
  `locnombr` varchar(20) DEFAULT NULL,
  `locdirec` varchar(20) DEFAULT NULL,
  `usucodig` varchar(20) DEFAULT NULL COMMENT 'FK de tabla usuarios. codigo del manager del cine',
  PRIMARY KEY (`loccodig`),
  KEY `usucodig` (`usucodig`),
  CONSTRAINT `local_fk` FOREIGN KEY (`usucodig`) REFERENCES `usuario` (`usucodig`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `local` */

insert  into `local`(`loccodig`,`locnombr`,`locdirec`,`usucodig`) values ('00001','Cine Angamos','Av Angamos 2030','u4127282014'),('00002','Cine SanJuan','Av. Heroes','u4127282013');

/*Table structure for table `merchandise` */

DROP TABLE IF EXISTS `merchandise`;

CREATE TABLE `merchandise` (
  `mercodig` varchar(5) NOT NULL,
  `pelcodig` varchar(5) DEFAULT NULL,
  `mertipoi` varchar(20) DEFAULT NULL,
  `merdetal` text,
  `merfotoi` blob,
  `merpreci` decimal(7,2) DEFAULT NULL,
  PRIMARY KEY (`mercodig`),
  KEY `pelcodig` (`pelcodig`),
  CONSTRAINT `merchandise_fk` FOREIGN KEY (`mercodig`) REFERENCES `pelicula` (`pelcodig`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `merchandise_fk1` FOREIGN KEY (`pelcodig`) REFERENCES `pelicula` (`pelcodig`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `merchandise` */

/*Table structure for table `pelicula` */

DROP TABLE IF EXISTS `pelicula`;

CREATE TABLE `pelicula` (
  `pelcodig` varchar(5) NOT NULL COMMENT 'Codigo de pelicula',
  `peltitul` varchar(40) DEFAULT NULL COMMENT 'Titulo de pelicula',
  `pelabstr` text COMMENT 'Abstract pelicula',
  `pelgener` varchar(20) DEFAULT NULL COMMENT 'pelicula genre:comedia,drama',
  `pelsubti` varchar(40) DEFAULT NULL COMMENT 'Subtitulo de pelicula',
  `pelpaiso` varchar(20) DEFAULT NULL COMMENT 'pelicula pais origen',
  `pelpubob` varchar(20) DEFAULT NULL COMMENT 'pelicula publico objetivo:Ninos,Adultos,Familia',
  `peltipem` varchar(20) DEFAULT NULL COMMENT 'Tipo de emision de pelicula:2D,3D',
  `pelposte` varchar(20) DEFAULT NULL COMMENT 'poster pelicula',
  `pelmerch` char(1) DEFAULT 'T' COMMENT 'Indicador si existe productos to merchandize asociados a la pelicula',
  `pellongi` varchar(40) DEFAULT NULL,
  `peldirec` varchar(100) DEFAULT NULL,
  `pelescri` varchar(100) DEFAULT NULL,
  `pelidiom` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`pelcodig`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pelicula` */

insert  into `pelicula`(`pelcodig`,`peltitul`,`pelabstr`,`pelgener`,`pelsubti`,`pelpaiso`,`pelpubob`,`peltipem`,`pelposte`,`pelmerch`,`pellongi`,`peldirec`,`pelescri`,`pelidiom`) values ('1900','The Green Mille','*Historia de hombres encarcelados...','*Adultos','*Green Mille','*USA','*Adultos','*2D','mille.jpg','F',NULL,NULL,NULL,NULL),('1901','Bora','Kazakh TV talking head Borat is dispatched to the United States to report on the greatest country in the world. With a documentary crew in tow, Borat becomes more interested in locating and marrying Pamela Anderson.','Romance','Bora Bora 1970','USA','Adultos','2D','bora.gif','T',NULL,NULL,NULL,NULL),('1902','El oso Yogui','****El osos yogui y bubu','****Familiar','****El oso yogui aventuras','****USA','****Familiar','****2D','yogui.jpg','F',NULL,NULL,NULL,NULL),('1904','Black Swam','Historia de ...','Adultos','Black Swam','USA','Familiar','2D','swam.jpg','T',NULL,NULL,NULL,NULL),('1907','The Green Mille','Historia de hombres encarcelados...','Drama','Green Mille','USA','Adultos','2D','mille.jpg','T',NULL,NULL,NULL,NULL),('1908','Flash Dance','Historia de una pareja de bailarines...','Accion','The Flash Dance','USA','Adultos','2D','dance.gif','T',NULL,NULL,NULL,NULL);

/*Table structure for table `permiso` */

DROP TABLE IF EXISTS `permiso`;

CREATE TABLE `permiso` (
  `percodig` varchar(5) NOT NULL,
  `acccodig` varchar(5) DEFAULT NULL,
  `usucodig` varchar(20) NOT NULL,
  `perfecin` date DEFAULT NULL,
  `perfecba` date DEFAULT NULL COMMENT 'permiso fecha de baja',
  `perstatu` char(1) DEFAULT NULL COMMENT 'status del permiso A=activo,B=suspendido, C=cancelado',
  PRIMARY KEY (`percodig`),
  KEY `acccodig` (`acccodig`),
  CONSTRAINT `permisos_fk` FOREIGN KEY (`acccodig`) REFERENCES `accesos` (`acccodig`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `permiso` */

insert  into `permiso`(`percodig`,`acccodig`,`usucodig`,`perfecin`,`perfecba`,`perstatu`) values ('1','1','1','2025-11-11','2025-11-11','1'),('2','1','1',NULL,NULL,NULL),('41222','1','whitehorse','2011-02-20','2011-02-20',NULL);

/*Table structure for table `sala` */

DROP TABLE IF EXISTS `sala`;

CREATE TABLE `sala` (
  `salcodig` varchar(5) NOT NULL COMMENT 'codigo sala',
  `salnombr` varchar(20) DEFAULT NULL,
  `saldescr` varchar(40) DEFAULT NULL COMMENT 'descripcion sala',
  `salcapac` int(11) DEFAULT NULL COMMENT 'capacidad de sala',
  `loccodig` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`salcodig`),
  KEY `loccodig` (`loccodig`),
  CONSTRAINT `sala_fk` FOREIGN KEY (`loccodig`) REFERENCES `local` (`loccodig`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sala` */

insert  into `sala`(`salcodig`,`salnombr`,`saldescr`,`salcapac`,`loccodig`) values ('00001','Sala 1','Sala especial para eventos',150,'00001'),('00002','Sala 2','Sala con asientos de lujo',100,'00001'),('00003','Sala 3','Sala especial para eventos',150,'00001');

/*Table structure for table `shopcart` */

DROP TABLE IF EXISTS `shopcart`;

CREATE TABLE `shopcart` (
  `shofactu` varchar(10) NOT NULL,
  `shofecha` date DEFAULT NULL,
  `usucodig` varchar(20) DEFAULT NULL,
  `shopagot` varchar(20) DEFAULT NULL COMMENT 'tipo de pago:visa,debito,cash',
  `shosubto` double(7,2) DEFAULT NULL,
  `shotaxvt` double(7,2) DEFAULT NULL,
  `shototal` double(7,2) DEFAULT NULL,
  PRIMARY KEY (`shofactu`),
  KEY `usucodig` (`usucodig`),
  CONSTRAINT `shopcart_fk` FOREIGN KEY (`usucodig`) REFERENCES `usuario` (`usucodig`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `shopcart` */

/*Table structure for table `shopcartdetail` */

DROP TABLE IF EXISTS `shopcartdetail`;

CREATE TABLE `shopcartdetail` (
  `shcnumer` bigint(10) NOT NULL,
  `shcfactu` varchar(10) NOT NULL,
  `shclinea` int(2) DEFAULT NULL,
  `carcodig` int(5) DEFAULT NULL,
  `ciscodig` varchar(5) DEFAULT NULL,
  `shccanti` int(2) DEFAULT NULL,
  `mercodig` varchar(5) DEFAULT NULL,
  `shcpreci` double(7,2) DEFAULT NULL,
  PRIMARY KEY (`shcnumer`),
  KEY `ciscodig` (`ciscodig`),
  KEY `mercodig` (`mercodig`),
  KEY `carcodig` (`carcodig`),
  KEY `shcfactu` (`shcfactu`),
  CONSTRAINT `shopcartdetail_fk` FOREIGN KEY (`shcfactu`) REFERENCES `shopcart` (`shofactu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `shopcartdetail_fk1` FOREIGN KEY (`carcodig`) REFERENCES `cartelera` (`carcodig`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `shopcartdetail_fk2` FOREIGN KEY (`mercodig`) REFERENCES `merchandise` (`mercodig`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `shopcartdetail` */

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `usucodig` varchar(20) NOT NULL,
  `usuclave` varchar(20) DEFAULT NULL,
  `usutipou` char(1) DEFAULT NULL COMMENT 'Usuario I=interno; E=Externo',
  `usunombr` varchar(20) DEFAULT NULL,
  `usuapel1` varchar(20) DEFAULT NULL,
  `usuapel2` varchar(20) DEFAULT NULL,
  `usuemail` varchar(40) DEFAULT NULL,
  `usutatus` char(1) DEFAULT NULL COMMENT 'usuario status A=activo B=baja S=suspendido',
  `usuinten` int(1) DEFAULT NULL,
  `usudirec` varchar(20) DEFAULT NULL,
  `usunidad` varchar(20) DEFAULT NULL,
  `usuposci` varchar(20) DEFAULT NULL COMMENT 'cashier, supervisor',
  `usutelef` varchar(10) DEFAULT NULL,
  `usuTipDo` varchar(20) DEFAULT NULL COMMENT 'DNI,CE,passport',
  `usuNumDo` varchar(20) DEFAULT NULL COMMENT 'numero de documento',
  PRIMARY KEY (`usucodig`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`usucodig`,`usuclave`,`usutipou`,`usunombr`,`usuapel1`,`usuapel2`,`usuemail`,`usutatus`,`usuinten`,`usudirec`,`usunidad`,`usuposci`,`usutelef`,`usuTipDo`,`usuNumDo`) values ('u201020925',NULL,'E','tcsihsai','tcsihsai','tcsihsai',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('u201020926',NULL,'E','tcsihsai','tcsihsai','tcsihsai',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('u201020927',NULL,'E','tcsihsai','tcsihsai','tcsihsai',NULL,'A',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('u4127282010','u4127282010','I','@@@rmejia','@@@mejia','@@@paredes','@@@rmejia@upc.edu.pe','A',3,'@@@4th Avenue 4058','@@@Ventas','@@@Cashier','6672987','***DNI','***09684275'),('u4127282013','u4127282013','I','@rmejia','@mejia','@paredes','@rmejia@upc.edu.pe','A',1,'@4th Avenue 4058','@Ventas','@Cashier','6672987','*DNI','*09684275'),('u4127282014','u4127282014','I','@cmeade','@cmeade','@connie','@rmejia@upc.edu.pe','A',1,'@4th Avenue 4058','@Ventas','@Cashier','6672987','*DNI','*09684275'),('whitehorse','whitehorse','E','Rocio','Mejia',NULL,'chiocjava@yahoo.es','0',2,NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
