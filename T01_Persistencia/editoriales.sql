drop database editoriales;
create database editoriales;
use editoriales;
CREATE TABLE `autor` (
  `codautor` varchar(10) ,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(12),
  `direccion` varchar(50),
  `ciudad` varchar(50),
  `cp` int,
   PRIMARY KEY (`codautor`)
);

CREATE TABLE editorial (
	cod_editorial INT NOT NULL,
	nombre VARCHAR(32) NOT NULL unique,
	ciudad varchar(30),
        pais varchar(20),
	PRIMARY KEY (cod_editorial)
);

CREATE TABLE titulo(
   codtitulo      VARCHAR(6)       PRIMARY KEY, /*Código del libro, como el ISBN*/
   titulo         VARCHAR(80)      NOT NULL,  /*Título del libro*/
   genero         VARCHAR(12)      DEFAULT 'GENERAL' NOT NULL , /*Género libro*/
   codeditorial   int, /*Código de la editorial que publica el libro*/
   precio         double,  /*Precio del ejemplar*/
   tirada         double,  /*Número de ejemplares impresos*/
   derechos_autor double,  /*Cantidad total cobrada por los autores por ejemplar vendido*/
   ventas         double,  /*Número de ejemplares vendidos hasta el momento*/
   sinopsis    VARCHAR(200),  /*-Breve descripción del contenido del libro*/
   fechapub       DATE    NOT NULL,  /*Fecha de publicación*/
   FOREIGN KEY(codeditorial) REFERENCES editorial(cod_editorial)
);

/*Tabla que relaciona los libros con sus autores. Un libro puede tener más de un autor y un autor puede publicar más de un libro*/
CREATE TABLE autorestitulos(
   codautor       VARCHAR(11), /*Código del autor que participa en la autoría*/
   codtitulo      VARCHAR(6),  /*Código del libro Importancia del autor en la creación del libro 1: Autor principal  2: Autor secundario, etc.*/
   orden          int   NOT NULL, 
   pct           int DEFAULT 0 NOT NULL, /*Porcentaje de participación en los derechos de autor del autor en el libro*/
   PRIMARY KEY (codautor, codtitulo),
   FOREIGN KEY (codautor) REFERENCES autor (codautor),
   FOREIGN KEY (codtitulo) REFERENCES titulo (codtitulo)
);


INSERT INTO `editoriales`.`autor` (`codautor`, `nombre`, `telefono`, `direccion`, `ciudad`, `cp`) VALUES ('a1', 'autor1', '955555', 'alfareria', 'sevilla', '41001');
INSERT INTO `editoriales`.`autor` (`codautor`, `nombre`, `telefono`, `direccion`, `ciudad`, `cp`) VALUES ('a2', 'autor2', '955222', 'sol', 'sevilla', '41000');
INSERT INTO `editoriales`.`autor` (`codautor`, `nombre`, `telefono`, `direccion`, `ciudad`, `cp`) VALUES ('a3', 'autor3', '955555', 'mix', 'madrid', '51001');



INSERT INTO `editoriales`.`editorial` (`cod_editorial`, `nombre`, `ciudad`, `pais`) VALUES ('1', 'editorial1', 'sevilla', 'españa');
INSERT INTO `editoriales`.`editorial` (`cod_editorial`, `nombre`, `ciudad`, `pais`) VALUES ('2', 'editorial2', 'malaga', 'españa');
INSERT INTO `editoriales`.`editorial` (`cod_editorial`, `nombre`, `ciudad`) VALUES ('3', 'editorial3', 'dublin');



INSERT INTO `editoriales`.`titulo` (`codtitulo`, `titulo`, `genero`, `codeditorial`, `precio`, `tirada`, `derechos_autor`, `ventas`, `sinopsis`, `fechapub`) VALUES ('t1', 'titulo1', 'novela', '2', '19.2', '1000', '10', '100', 'jjjjj', '2024-10-10');
INSERT INTO `editoriales`.`titulo` (`codtitulo`, `titulo`, `genero`, `codeditorial`, `precio`, `tirada`, `derechos_autor`, `ventas`, `sinopsis`, `fechapub`) VALUES ('t2', 'titulo2', 'historia', '2', '18.2', '200', '5', '100', 'jjjjj', '2023-10-10');
INSERT INTO `editoriales`.`titulo` (`codtitulo`, `titulo`, `genero`, `codeditorial`, `precio`, `tirada`, `derechos_autor`, `ventas`, `sinopsis`, `fechapub`) VALUES ('t3', 'titulo3', 'business', '2', '18.2', '200', '5', '100', 'jjjjj', '2017-10-10');
INSERT INTO `editoriales`.`titulo` (`codtitulo`, `titulo`, `genero`, `codeditorial`, `precio`, `tirada`, `derechos_autor`, `ventas`, `sinopsis`, `fechapub`) VALUES ('t4', 'titulo4', 'business', '2', '18.2', '200', '5', '200', 'jjjjj', '2017-10-10');
INSERT INTO `editoriales`.`titulo` (`codtitulo`, `titulo`, `genero`, `codeditorial`, `precio`, `tirada`, `derechos_autor`, `ventas`, `sinopsis`, `fechapub`) VALUES ('t5', 'titulo5', 'psychology', '2', '18.2', '200', '5', '200', 'jjjjj', '2017-10-10');


INSERT INTO `editoriales`.`autorestitulos` (`codautor`, `codtitulo`, `orden`, `pct`) VALUES ('a1', 't1', '2', '10');
INSERT INTO `editoriales`.`autorestitulos` (`codautor`, `codtitulo`, `orden`, `pct`) VALUES ('a1', 't2', '1', '2');
INSERT INTO `editoriales`.`autorestitulos` (`codautor`, `codtitulo`, `orden`, `pct`) VALUES ('a1', 't3', '2', '10');
INSERT INTO `editoriales`.`autorestitulos` (`codautor`, `codtitulo`, `orden`, `pct`) VALUES ('a2', 't3', '2', '10');
INSERT INTO `editoriales`.`autorestitulos` (`codautor`, `codtitulo`, `orden`, `pct`) VALUES ('a2', 't4', '2', '10');
INSERT INTO `editoriales`.`autorestitulos` (`codautor`, `codtitulo`, `orden`, `pct`) VALUES ('a3', 't3', '2', '10');
INSERT INTO `editoriales`.`autorestitulos` (`codautor`, `codtitulo`, `orden`) VALUES ('a2', 't1', '1');

commit;
