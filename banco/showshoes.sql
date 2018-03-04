-- MySQL dump 10.13  Distrib 5.7.21, for Win64 (x86_64)
--
-- Host: localhost    Database: showshoes
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `linha_item`
--

DROP TABLE IF EXISTS `linha_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linha_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantidade` bigint(20) NOT NULL,
  `id_pedido` bigint(20) NOT NULL,
  `id_produto` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_produto` (`id_produto`),
  KEY `id_pedido` (`id_pedido`),
  CONSTRAINT `linha_item_ibfk_1` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id`),
  CONSTRAINT `linha_item_ibfk_2` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linha_item`
--

LOCK TABLES `linha_item` WRITE;
/*!40000 ALTER TABLE `linha_item` DISABLE KEYS */;
INSERT INTO `linha_item` VALUES (2,1,1,1),(3,1,2,2),(4,1,3,3),(5,1,4,2),(6,1,5,3),(7,3,6,2),(8,2,6,3),(9,3,7,2),(10,2,7,3),(11,3,8,2),(12,2,8,3),(13,1,9,2),(14,2,10,2),(15,1,11,2),(16,1,12,2),(17,1,13,2),(18,1,14,2),(19,2,15,1),(20,1,16,1),(21,1,17,1),(22,1,18,2),(23,1,18,3),(24,1,19,1),(25,4,19,5);
/*!40000 ALTER TABLE `linha_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_cliente` bigint(20) NOT NULL,
  `data_realizado` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,1,'2018-03-04 16:02:27'),(2,1,'2018-03-04 16:02:27'),(3,1,'2018-03-04 16:02:27'),(4,1,'2018-03-04 16:02:27'),(5,1,'2018-03-04 16:02:27'),(6,1,'2018-03-04 16:02:27'),(7,1,'2018-03-04 16:02:27'),(8,1,'2018-03-04 16:02:27'),(9,1,'2018-03-04 16:02:27'),(10,1,'2018-03-04 16:02:27'),(11,1,'2018-03-04 16:02:27'),(12,1,'2018-03-04 16:02:27'),(13,1,'2018-03-04 16:02:27'),(14,1,'2018-03-04 16:02:27'),(15,1,'2018-03-04 16:02:27'),(16,1,'2018-03-04 03:00:00'),(17,1,'2018-03-04 16:25:02'),(18,1,'2018-03-04 17:12:25'),(19,1,'2018-03-04 17:12:49');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `descricao` varchar(100) NOT NULL,
  `info` varchar(1000) NOT NULL,
  `urlImg` varchar(100) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valor` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES ('Tênis Asics Gel Quantum 180 2','Conforto é uma ferramenta necessária para a melhora de desempenho em corridas e caminhadas o inovador Tênis Asics Gel Quantum 360 Cm foi desenvolvido para suprir essa necessidade, devido a presença da tecnologia gel em toda a região do solado. Seu cabedal sem costuras torna mais fácil o calce além de tecido leve com boa circulação interna de ar','img/img-01.jpg',1,600),('Tênis Adidas Hoops Team Mid','Inspirado no basquete e aderindo todo o conforto de um calçado esportivo o Tênis Adidas Hoops Team Mid é macio e combina também com diversos look’s urbanos. Desenvolvido em material sintético com partes em mesh seu cabedal contem costuras reforçadas garantindo maior resistência. Sua entressola apresenta tecnologia de espuma em EVA elevando','img/img-02.jpg',2,200),('Tênis Puma Evospeed 1.4 Scuderia Ferrari Mid 10','Para comemorar a velocidade de uma década de parceria entre PUMA e Scuderia Ferrari o Tênis Puma Evospeed 1.4 Scuderia Ferrari Mid 10  marca este 10º aniversário com este modelo confortável e estiloso para os amantes de automobilismo.  Confeccionado em material sintético e com cano Mid deixando seu calcanhar mais confortável seu cabedal é','img/img-03.jpg',3,350),('Tênis Reebok Npc 2 Syn','Discreto e ao mesmo tempo elegante o Tênis Reebok Npc 2 Syn apresenta praticidade e um design que combina com diversos visuais. Desenvolvido em couro com costuras reforçadas seu cabedal e duradouro e acompanha bordado da marca na lateral. Sua entressola em EVA proporciona um melhor conforto a cada passada. Já o solado de borracha','img/img-04.jpg',4,280),('Tênis Olympikus Provoke','Estruturado em dupla frontura com tecido de tramas abertas para respirabilidade, o Tênis Olympikus Provoke é o passo certo para sua corrida. Conta com tecnologia de amortecimento. Design sofisticado o cabedal é confeccionado em materiais leves e resistentes que garantem maior respirabilidade.','img/img-05.jpg',5,300),('Tênis Mizuno Wave Viper','Pioneira na categoria running a Mizuno apresenta uma inovação para corredores dos mais diversos tipos, o Tênis Mizuno Wave Viper que privilegia atletas desde o amador até o mais preocupado com performance e resultado. Seu cabedal desenvolvido em mesh (Tecido de tramas abertas para ventilação interna) é composto por partes material sintético.','img/img-06.jpg',6,800);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin@admin.com','21232f297a57a5a743894a0e4a801fc3','Rua Bla Bla Bla');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'showshoes'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-04 14:17:58
