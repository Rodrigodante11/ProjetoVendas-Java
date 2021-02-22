CREATE DATABASE  IF NOT EXISTS `bdvendas` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `bdvendas`;
-- MariaDB dump 10.17  Distrib 10.4.13-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: bdvendas
-- ------------------------------------------------------
-- Server version	10.4.13-MariaDB

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
-- Table structure for table `tb_clientes`
--

DROP TABLE IF EXISTS `tb_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `rg` varchar(30) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_clientes`
--

LOCK TABLES `tb_clientes` WRITE;
/*!40000 ALTER TABLE `tb_clientes` DISABLE KEYS */;
INSERT INTO `tb_clientes` VALUES (1,'Ricardo Silva2','22.222.222-22','888.888.888-88','Usuário','(22) 22222-2222','(11) 11111-1111','18133-400','Rua José Gomide de Castro',2222,'Casa','Jardim Maria Trindade','São Roque','SP'),(2,'Maria23','25.373.738-48','584.893.939-22','maria2@yahoo.com','(11) 11111-1112','(55) 55555-5552','34567-882','ddd2',7772,'Hotel2','testeBairro2','testeCidade2','RJ'),(5,'althur','08.573.736-26','756.822.828-49','Althurr@yahoo.com','(11) 77777-7777','(55) 66666-6666','55555-555','rrrrr',9999,'Casa','testeBairro3','testeCidade3','MG'),(7,'Thiago f','86.774.838-39','785.783.838-83','Althurr@yahoo.com','(11) 77777-7777','(55) 66666-6666','55555-555','rrrrr',9999,'Casa','testeBairro3','testeCidade3','MG'),(8,'Thiago f','38.636.737-37','498.858.858-84','Althurr@yahoo.com','(11) 77777-7777','(55) 66666-6666','55555-555','rrrrr',9999,'Casa','testeBairro3','testeCidade3','MG'),(9,'Thiago','65.656.565-62','191.919.191-92','Althurr@yahoo.com','(11) 77777-7777','(55) 66666-6666','55555-555','rrrrr',9999,'Casa','testeBairro3','testeCidade3','MG'),(12,'pedro','25.373.738-48','584.893.939-22','maria2@yahoo.com','(11) 11111-1112','(55) 55555-5552','34567-882','ddd2',7772,'Hotel2','testeBairro2','testeCidade2','RJ');
/*!40000 ALTER TABLE `tb_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_fornecedores`
--

DROP TABLE IF EXISTS `tb_fornecedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_fornecedores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `cnpj` varchar(100) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_fornecedores`
--

LOCK TABLES `tb_fornecedores` WRITE;
/*!40000 ALTER TABLE `tb_fornecedores` DISABLE KEYS */;
INSERT INTO `tb_fornecedores` VALUES (3,'coca','38.857.046/0001-02','coca@gmail.com','(11) 11111-1111','(22) 22222-2222','18133-400','Rua José Gomide de Castro',111,'Empresa','Jardim Maria Trindade','São Roque','SP'),(4,'fanta','38.857.046/0001-02','fanta@gmail.com','(11) 11111-1111','(22) 22222-2222','18133-400','Rua José Gomide de Castro',111,'Empresa','Jardim Maria Trindade','São Roque','SP'),(5,'Skol','38.857.046/0001-02','Skol@gmail.com','(11) 11111-1111','(22) 22222-2222','18133-400','Rua José Gomide de Castro',111,'Empresa','Jardim Maria Trindade','São Roque','SP'),(10,'BolachaNestle','38.857.046/0001-11','nestle@gmail.com','(11) 11111-1111','(22) 22222-2222','18133-400','Rua José Gomide de Castro',222,'Empresa','Jardim Maria Trindade','São Roque','RS');
/*!40000 ALTER TABLE `tb_fornecedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_funcionarios`
--

DROP TABLE IF EXISTS `tb_funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_funcionarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `rg` varchar(30) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `senha` varchar(10) DEFAULT NULL,
  `cargo` varchar(100) DEFAULT NULL,
  `nivel_acesso` varchar(50) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_funcionarios`
--

LOCK TABLES `tb_funcionarios` WRITE;
/*!40000 ALTER TABLE `tb_funcionarios` DISABLE KEYS */;
INSERT INTO `tb_funcionarios` VALUES (3,'Rodrigo ss','10.101.010-10','111.111.111-11','rodrigo88@gmail.com','1234567','Vendedor','Administrador','(22) 22222-2222','(11) 11111-1111','18133-400','Rua José Gomide de Castro',222,'Casa','Jardim Maria Trindade','São Roque','SP'),(6,'PedroPaulo2','10.101.010-10','111.111.111-11','PedroPaulo@gmail.com','1234567','Vendedor','Usuário','(22) 22222-2222','(11) 11111-1111','18133-400','Rua José Gomide de Castro',222,'Casa','Jardim Maria Trindade','São Roque','SP'),(10,'Milena','49.383.726-26','463.552.525-25','milena34@gmail.com','1234567','Vendedor','Administrador','(22) 22222-2222','(11) 11111-1111','18133-400','Rua José Gomide de Castro',123,'Casa','Jardim Maria Trindade','São Roque','RO'),(11,'Rodrigo de Oliveira','10.101.010-10','111.111.111-11','rodrigo88@gmail.com','1234567','Vendedor','Administrador','(22) 22222-2222','(11) 11111-1111','18133-400','Rua José Gomide de Castro',222,'Casa','Jardim Maria Trindade','São Roque','SP');
/*!40000 ALTER TABLE `tb_funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_itensvendas`
--

DROP TABLE IF EXISTS `tb_itensvendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_itensvendas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `venda_id` int(11) DEFAULT NULL,
  `produto_id` int(11) DEFAULT NULL,
  `qtd` int(11) DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `venda_id` (`venda_id`),
  KEY `produto_id` (`produto_id`),
  CONSTRAINT `tb_itensvendas_ibfk_1` FOREIGN KEY (`venda_id`) REFERENCES `tb_vendas` (`id`),
  CONSTRAINT `tb_itensvendas_ibfk_2` FOREIGN KEY (`produto_id`) REFERENCES `tb_produtos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_itensvendas`
--

LOCK TABLES `tb_itensvendas` WRITE;
/*!40000 ALTER TABLE `tb_itensvendas` DISABLE KEYS */;
INSERT INTO `tb_itensvendas` VALUES (1,7,6,3,13.50),(2,8,5,5,42.50),(3,8,6,3,13.50),(4,9,5,15,127.50),(5,10,5,15,127.50),(6,12,5,12,102.00),(7,12,6,12,54.00),(8,14,5,3,25.50),(9,14,6,5,22.50),(10,14,5,12,54.00),(11,15,9,8,80.00),(12,15,6,10,45.00),(13,15,5,10,85.00);
/*!40000 ALTER TABLE `tb_itensvendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_produtos`
--

DROP TABLE IF EXISTS `tb_produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_produtos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) DEFAULT NULL,
  `preco` decimal(10,2) DEFAULT NULL,
  `qtd_estoque` int(11) DEFAULT NULL,
  `for_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `for_id` (`for_id`),
  CONSTRAINT `tb_produtos_ibfk_1` FOREIGN KEY (`for_id`) REFERENCES `tb_fornecedores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_produtos`
--

LOCK TABLES `tb_produtos` WRITE;
/*!40000 ALTER TABLE `tb_produtos` DISABLE KEYS */;
INSERT INTO `tb_produtos` VALUES (5,'Refrigerante 2L',8.50,525,3),(6,'Refrigerante 600ml',4.50,400,4),(9,'Bolacha chocolate',10.00,600,10);
/*!40000 ALTER TABLE `tb_produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_vendas`
--

DROP TABLE IF EXISTS `tb_vendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_vendas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_id` int(11) DEFAULT NULL,
  `data_venda` datetime DEFAULT NULL,
  `total_venda` decimal(10,2) DEFAULT NULL,
  `observacoes` text DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `tb_vendas_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `tb_clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_vendas`
--

LOCK TABLES `tb_vendas` WRITE;
/*!40000 ALTER TABLE `tb_vendas` DISABLE KEYS */;
INSERT INTO `tb_vendas` VALUES (1,1,'2021-02-19 00:00:00',22.50,'Refrigerante'),(2,2,'2021-02-19 00:00:00',34.00,'Entregar no endereço Centro 155'),(3,1,'2021-02-19 00:00:00',17.00,'aaaaa'),(4,1,'2021-02-20 00:00:00',42.50,''),(5,1,'2021-02-20 00:00:00',85.00,''),(6,1,'2021-02-20 00:00:00',49.50,''),(7,1,'2021-02-20 00:00:00',81.50,'Embalar para presente'),(8,9,'2021-02-20 00:00:00',56.00,'sem'),(9,1,'2021-02-21 00:00:00',172.50,''),(10,1,'2021-02-21 00:00:00',127.50,''),(11,1,'2021-02-21 00:00:00',765.00,''),(12,1,'2021-02-21 00:00:00',156.00,''),(13,1,'2021-02-21 00:00:00',1700.00,''),(14,1,'2021-02-21 00:00:00',102.00,''),(15,1,'2021-02-21 00:00:00',210.00,'');
/*!40000 ALTER TABLE `tb_vendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bdvendas'
--

--
-- Dumping routines for database 'bdvendas'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-22  0:22:32
