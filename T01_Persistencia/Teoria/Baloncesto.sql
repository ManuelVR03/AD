DROP DATABASE IF EXISTS baloncesto;
CREATE DATABASE baloncesto;
USE baloncesto;

CREATE TABLE EQUIPOS 
(
codEquipo VARCHAR(10) ,
nombreEquipo VARCHAR(50) NOT NULL ,
PRIMARY KEY (codEquipo) 
);



CREATE TABLE TEMPORADA
  (
    codTemp VARCHAR(3),
    nombre  VARCHAR(30),
    PRIMARY KEY (codTemp) 
    );
    
    
CREATE  TABLE PARTIDOS (
  codPartido VARCHAR(10) PRIMARY KEY ,
  fecha_partido DATE,
  temporada VARCHAR(3) NOT NULL ,
  jornada INT NOT NULL ,
  puntosLocal INT ,
  puntosVisitante INT ,
  codEquipoLocal VARCHAR(10) NOT NULL ,
  codEquipoVisitante VARCHAR(10) NOT NULL ,
  CONSTRAINT FK_PARTIDOS_EQUIPOS FOREIGN KEY(codEquipoLocal) REFERENCES EQUIPOS (codEquipo),  
  CONSTRAINT FK_PARTIDOS_EQUIPOS1 FOREIGN KEY (codEquipoVisitante)  REFERENCES EQUIPOS (codEquipo),
  CONSTRAINT FK_PARTIDOS_EQUIPOS2 FOREIGN KEY (temporada)  REFERENCES TEMPORADA (codTemp)
   );




CREATE TABLE JUGADORES
  (
    codJugador   VARCHAR(10),
    nombreJugador VARCHAR(50) NOT NULL ,
    PRIMARY KEY (codJugador) ,
    fechaNac DATE 
  );
  



CREATE TABLE PARTIDOS_JUGADORES
  (
    codPartido  VARCHAR(10),
    codJugador  VARCHAR(10),
    canastas INT,
    asistencias INT,
    rebotes     INT,
    PRIMARY KEY (codPartido, codJugador) ,
    CONSTRAINT FK_JUGADAS2 FOREIGN KEY (codJugador) REFERENCES JUGADORES (codJugador),
    CONSTRAINT FK_JUGADAS3 FOREIGN KEY (codPartido) REFERENCES PARTIDOS (codPartido)
  );


CREATE TABLE TEMP_EQUIPO_JUGADOR
  (
    codTemp    VARCHAR(3),
    codEquipo  VARCHAR(10),
    codJugador VARCHAR(10),
    salario INT,
    fecha_ingreso DATE,
    CONSTRAINT PKF0 PRIMARY KEY (codTemp, codEquipo, codJugador),
    CONSTRAINT FKF1 FOREIGN KEY (codTemp) REFERENCES TEMPORADA (codTemp),
    CONSTRAINT FKF2 FOREIGN KEY (codEquipo) REFERENCES EQUIPOS (codEquipo),
    CONSTRAINT FKF3 FOREIGN KEY (codJugador) REFERENCES JUGADORES (codJugador)
  );


INSERT INTO TEMPORADA (codTemp, nombre) VALUES ('t1', '2008_2009');
INSERT INTO TEMPORADA (codTemp, nombre) VALUES ('t2', '2009_2010');
INSERT INTO TEMPORADA (codTemp, nombre) VALUES ('t3', '2010_2011');

INSERT INTO EQUIPOS (codEquipo, nombreEquipo) VALUES ('e1', 'Asefa Estudiantes');
INSERT INTO EQUIPOS (codEquipo, nombreEquipo) VALUES ('e2', 'Caja Sol Sevilla');
INSERT INTO EQUIPOS (codEquipo, nombreEquipo) VALUES ('e3', 'Unicaja Málaga');
INSERT INTO EQUIPOS (codEquipo, nombreEquipo) VALUES ('e4', 'Madrid');

INSERT INTO JUGADORES (codJugador, nombreJugador, fechaNac) VALUES ('j1', 'Esteban D.', '1985-10-10');
INSERT INTO JUGADORES (codJugador, nombreJugador, fechaNac) VALUES ('j2', 'Rafa Martinez', '1980-10-10');
INSERT INTO JUGADORES (codJugador, nombreJugador, fechaNac) VALUES ('j3', 'Banie', '1990-10-10');
INSERT INTO JUGADORES (codJugador, nombreJugador, fechaNac) VALUES ('j4', 'Fitch.', '1992-10-10');
INSERT INTO JUGADORES (codJugador, nombreJugador, fechaNac) VALUES ('j5', 'Telotovic', '1989-02-13');
INSERT INTO JUGADORES (codJugador, nombreJugador, fechaNac) VALUES ('j6', 'Juan Peñi', '1985-10-10');
INSERT INTO JUGADORES (codJugador, nombreJugador, fechaNac) VALUES ('j7', 'Juan Xi', '1991-10-02');
INSERT INTO JUGADORES (codJugador, nombreJugador, fechaNac) VALUES ('j8', 'Mario G', '1991-10-02');
INSERT INTO JUGADORES (codJugador, nombreJugador, fechaNac) VALUES ('j9', 'Telvio J', '1992-10-02');
INSERT INTO JUGADORES (codJugador, nombreJugador, fechaNac) VALUES ('j10', 'Mario G', '1991-10-02');
INSERT INTO JUGADORES (codJugador, nombreJugador, fechaNac) VALUES ('j11', 'Telvio J', '1991-10-02');

INSERT INTO PARTIDOS VALUES ('p1', '2008-01-01', 't1', '1', 88, 99, 'e1', 'e2');
INSERT INTO PARTIDOS VALUES ('p2', '2008-01-01', 't1', '1', 77, 66, 'e3', 'e4');
INSERT INTO PARTIDOS VALUES ('p3', '2008-02-02', 't1', '2', 77, 66, 'e4', 'e3');
INSERT INTO PARTIDOS VALUES ('p4', '2008-02-02', 't1', '2', 77, 66, 'e2', 'e1');
INSERT INTO PARTIDOS VALUES ('p5', '2008-03-03', 't1', '3', 77, 66, 'e1', 'e4');
INSERT INTO PARTIDOS VALUES ('p6', '2008-03-03', 't1', '3', 77, 66, 'e3', 'e2');
INSERT INTO PARTIDOS VALUES ('p7', '2008-04-04', 't1', '4', 97, 66, 'e4', 'e1');
INSERT INTO PARTIDOS VALUES ('p8', '2008-04-04', 't1', '4', 70, 90, 'e2', 'e3');
INSERT INTO PARTIDOS VALUES ('p9', '2009-01-01', 't2', '1', 54, 78, 'e1', 'e2');
INSERT INTO PARTIDOS VALUES ('p10', '2009-01-01', 't2', '1', 79, 56, 'e3', 'e4');
INSERT INTO PARTIDOS VALUES ('p11', '2009-02-02', 't2', '2', 70, 90, 'e4', 'e3');
INSERT INTO PARTIDOS VALUES ('p12', '2009-02-02', 't2', '2', 90, 66, 'e2', 'e1');
INSERT INTO PARTIDOS VALUES ('p13', '2009-03-03', 't2', '3', 90, 66, 'e1', 'e4');
INSERT INTO PARTIDOS VALUES ('p14', '2009-03-03', 't2', '3', 77, 65, 'e3', 'e2');
INSERT INTO PARTIDOS VALUES ('p15', '2009-04-04', 't2', '4', 97, 65, 'e4', 'e1');
INSERT INTO PARTIDOS VALUES ('p16', '2009-04-04', 't2', '4', 90, 90, 'e2', 'e3');

INSERT INTO PARTIDOS_JUGADORES (codPartido, codJugador, canastas, asistencias, rebotes) VALUES ('p1', 'j1', 4, 5, 6);
INSERT INTO PARTIDOS_JUGADORES (codPartido, codJugador, canastas, asistencias, rebotes) VALUES ('p1', 'j2', 2, 0, 6);
INSERT INTO PARTIDOS_JUGADORES (codPartido, codJugador, canastas, asistencias, rebotes) VALUES ('p1', 'j3', 4, 5, 3);
INSERT INTO PARTIDOS_JUGADORES (codPartido, codJugador, canastas, asistencias, rebotes) VALUES ('p1', 'j5', 0, 5, 6);
INSERT INTO PARTIDOS_JUGADORES (codPartido, codJugador, canastas, asistencias, rebotes) VALUES ('p1', 'j6', 2, 5, 6);

INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t1', 'e1', 'j1', 1000, '2008-01-01');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t1', 'e1', 'j2', 1050, '2008-01-01');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t1', 'e1', 'j3', 1000, '2008-01-01');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t1', 'e2', 'j4', 1000, '2008-01-01');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t1', 'e2', 'j5', 1000, '2008-01-01');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t1', 'e2', 'j6', 1000, '2008-01-01');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t1', 'e2', 'j7', 1000, '2008-01-01');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t1', 'e3', 'j8', 1000, '2008-01-01');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t1', 'e3', 'j9', 1000, '2008-01-01');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t1', 'e3', 'j1', 1000, '2008-05-07');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t1', 'e2', 'j10', 1000, '2008-01-01');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t1', 'e2', 'j11', 1000, '2008-01-01');

INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t2', 'e2', 'j3', 1000, '2009-01-01');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t2', 'e2', 'j7', 1000, '2009-01-01');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t2', 'e1', 'j1', 1000, '2009-01-01');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t2', 'e2', 'j5', 1000, '2009-01-01');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t2', 'e3', 'j5', 1000, '2009-04-04');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t2', 'e4', 'j5', 1000, '2009-06-06');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t2', 'e3', 'j1', 1000, '2009-03-03');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t2', 'e4', 'j7', 1000, '2009-06-03');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t2', 'e2', 'j8', 1000, '2009-01-01');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t2', 'e2', 'j9', 1000, '2009-01-01');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t2', 'e1', 'j2', 1000, '2009-01-01');
INSERT INTO TEMP_EQUIPO_JUGADOR (codTemp, codEquipo, codJugador, salario, fecha_ingreso) VALUES ('t2', 'e3', 'j2', 1000, '2009-03-02');
