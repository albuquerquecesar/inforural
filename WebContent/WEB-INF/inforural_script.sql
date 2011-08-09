-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.6-rc


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema inforural
--

CREATE DATABASE IF NOT EXISTS inforural;
USE inforural;

--
-- Definition of table `animal`
--

DROP TABLE IF EXISTS `animal`;
CREATE TABLE `animal` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `apelido` varchar(50) DEFAULT NULL,
  `cor` int(3) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `sexo` int(2) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `data_aquisicao` date DEFAULT NULL,
  `situacao` int(3) DEFAULT NULL,
  `obs` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `foreign_sexo` (`sexo`),
  KEY `foreign_cor` (`cor`),
  KEY `foreign_situacao` (`situacao`),
  CONSTRAINT `animal_ibfk_1` FOREIGN KEY (`sexo`) REFERENCES `genero` (`id`),
  CONSTRAINT `animal_ibfk_2` FOREIGN KEY (`cor`) REFERENCES `cor` (`id`),
  CONSTRAINT `animal_ibfk_3` FOREIGN KEY (`situacao`) REFERENCES `situacao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `animal`
--

/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` (`id`,`apelido`,`cor`,`descricao`,`sexo`,`data_nascimento`,`data_aquisicao`,`situacao`,`obs`) VALUES 
 (2,'VAQUINHA DE TESTE',3,'É UMA VAQUINHA MUITO BOA',1,'2006-06-14','2010-06-09',2,'NÃO FALA NADA'),
 (3,'VAQUINHA DE TESTE TRES',5,'VDFVDVDVDFV',1,'2011-08-18','2011-08-23',2,''),
 (4,'teste',2,'nao tem descriçao que eu nao sei',1,'2011-08-01','2011-08-27',2,'cdcwwew');
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;


--
-- Definition of table `animal_tem_vacina`
--

DROP TABLE IF EXISTS `animal_tem_vacina`;
CREATE TABLE `animal_tem_vacina` (
  `animal` int(11) NOT NULL DEFAULT '0',
  `vacina` int(11) NOT NULL DEFAULT '0',
  `data` date DEFAULT NULL,
  `lugar` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`animal`,`vacina`),
  KEY `foreign_vacina` (`vacina`),
  CONSTRAINT `animal_tem_vacina_ibfk_1` FOREIGN KEY (`animal`) REFERENCES `animal` (`id`),
  CONSTRAINT `animal_tem_vacina_ibfk_2` FOREIGN KEY (`vacina`) REFERENCES `vacina` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `animal_tem_vacina`
--

/*!40000 ALTER TABLE `animal_tem_vacina` DISABLE KEYS */;
/*!40000 ALTER TABLE `animal_tem_vacina` ENABLE KEYS */;


--
-- Definition of table `cor`
--

DROP TABLE IF EXISTS `cor`;
CREATE TABLE `cor` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cor`
--

/*!40000 ALTER TABLE `cor` DISABLE KEYS */;
INSERT INTO `cor` (`id`,`nome`) VALUES 
 (1,'BRANCA'),
 (2,'PRETA'),
 (3,'LAVRADA'),
 (4,'CASTANHA'),
 (5,'CINZA'),
 (6,'SEM COR'),
 (14,'SEM COR'),
 (15,'SEM COR'),
 (16,'SEM COR'),
 (17,'SEM COR'),
 (18,'SEM COR'),
 (19,'SEM COR'),
 (20,'SEM COR'),
 (21,'SEM COR'),
 (22,'SEM COR'),
 (23,'SEM COR'),
 (24,'SEM COR');
/*!40000 ALTER TABLE `cor` ENABLE KEYS */;


--
-- Definition of table `foto`
--

DROP TABLE IF EXISTS `foto`;
CREATE TABLE `foto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `foto` blob,
  `animal` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `foreign_key_animal` (`animal`),
  CONSTRAINT `foto_ibfk_1` FOREIGN KEY (`animal`) REFERENCES `animal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `foto`
--

/*!40000 ALTER TABLE `foto` DISABLE KEYS */;
/*!40000 ALTER TABLE `foto` ENABLE KEYS */;


--
-- Definition of table `genero`
--

DROP TABLE IF EXISTS `genero`;
CREATE TABLE `genero` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `genero`
--

/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` (`id`,`descricao`) VALUES 
 (1,'FÊMEA'),
 (2,'MACHO');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;


--
-- Definition of table `permissao`
--

DROP TABLE IF EXISTS `permissao`;
CREATE TABLE `permissao` (
  `role` varchar(40) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `permissao`
--

/*!40000 ALTER TABLE `permissao` DISABLE KEYS */;
/*!40000 ALTER TABLE `permissao` ENABLE KEYS */;


--
-- Definition of table `situacao`
--

DROP TABLE IF EXISTS `situacao`;
CREATE TABLE `situacao` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `situacao`
--

/*!40000 ALTER TABLE `situacao` DISABLE KEYS */;
INSERT INTO `situacao` (`id`,`descricao`) VALUES 
 (1,'VENDIDO'),
 (2,'EM POSSE'),
 (3,'MORTO'),
 (4,'EMPRESTADO'),
 (5,'EM POSSE, COMPRADO'),
 (6,'VENDIDO'),
 (7,'EM POSSE'),
 (8,'MORTO'),
 (9,'EMPRESTADO'),
 (10,'EM POSSE, COMPRADO');
/*!40000 ALTER TABLE `situacao` ENABLE KEYS */;


--
-- Definition of table `tipo_animal`
--

DROP TABLE IF EXISTS `tipo_animal`;
CREATE TABLE `tipo_animal` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_animal`
--

/*!40000 ALTER TABLE `tipo_animal` DISABLE KEYS */;
INSERT INTO `tipo_animal` (`id`,`nome`) VALUES 
 (1,'BOVINO'),
 (2,'SUÍNO'),
 (3,'EQUÍNO'),
 (4,'AVE'),
 (5,'CAPRINO'),
 (6,'FELINO'),
 (7,'CANINO');
/*!40000 ALTER TABLE `tipo_animal` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `nome` varchar(40) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `senha` varchar(255) DEFAULT NULL,
  `abilitado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`nome`,`id`,`senha`,`abilitado`) VALUES 
 ('CESAR',6,'a564de63c2d0da68cf47586ee05984d7',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;


--
-- Definition of table `usuario_tem_permissao`
--

DROP TABLE IF EXISTS `usuario_tem_permissao`;
CREATE TABLE `usuario_tem_permissao` (
  `usuario` int(11) NOT NULL DEFAULT '0',
  `permissao` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`usuario`,`permissao`),
  KEY `foreign_permissao` (`permissao`),
  CONSTRAINT `usuario_tem_permissao_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`),
  CONSTRAINT `usuario_tem_permissao_ibfk_2` FOREIGN KEY (`permissao`) REFERENCES `permissao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario_tem_permissao`
--

/*!40000 ALTER TABLE `usuario_tem_permissao` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_tem_permissao` ENABLE KEYS */;


--
-- Definition of table `vacina`
--

DROP TABLE IF EXISTS `vacina`;
CREATE TABLE `vacina` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `idade_permitida` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vacina`
--

/*!40000 ALTER TABLE `vacina` DISABLE KEYS */;
INSERT INTO `vacina` (`id`,`nome`,`idade_permitida`) VALUES 
 (1,'AFTOSE',0),
 (2,'MANQUEIRA',0),
 (3,'MANQUEIRA teste',0),
 (4,'testando mais uma vez',3),
 (5,'TESTE',0),
 (6,'Esaa r testando novamente',0),
 (7,'novo total',0),
 (8,'FZDBVZDF',56);
/*!40000 ALTER TABLE `vacina` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
