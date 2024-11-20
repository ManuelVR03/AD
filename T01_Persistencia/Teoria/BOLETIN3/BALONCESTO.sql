REM ************ borrado de tablas: *********************
DROP TABLE PARTIDOS_JUGADORES CASCADE CONSTRAINTS;
DROP TABLE TEMP_EQUIPO_JUGADOR CASCADE CONSTRAINTS;
DROP TABLE JUGADORES CASCADE CONSTRAINTS;
DROP TABLE TEMPORADA CASCADE CONSTRAINTS;
DROP TABLE PARTIDOS CASCADE CONSTRAINTS;
DROP TABLE EQUIPOS CASCADE CONSTRAINTS;


CREATE TABLE equipos 
(
codEquipo VARCHAR2(10) ,
nombreEquipo VARCHAR2(50) NOT NULL ,
PRIMARY KEY (codEquipo) 
);



CREATE TABLE TEMPORADA
  (
    CODTEMP VARCHAR2(3 ),
    NOMBRE  VARCHAR2(30 ),
    PRIMARY KEY (CODTEMP) 
    );
    
    
CREATE  TABLE partidos (
  codPartido VARCHAR2(10) PRIMARY KEY ,
  fecha_partido date,
  temporada VARCHAR2(3) NOT NULL ,
  jornada NUMBER(2) NOT NULL ,
  puntosLocal NUMBER(2)  ,
  puntosVisitante NUMBER(2) ,
  codEquipoLocal VARCHAR2(10) NOT NULL ,
  codEquipoVisitante VARCHAR2(10) NOT NULL ,
  CONSTRAINT fk_partidos_equipos FOREIGN KEY(codEquipoLocal) REFERENCES equipos,  
  CONSTRAINT fk_partidos_equipos1 FOREIGN KEY (codEquipoVisitante )  REFERENCES equipos,
  CONSTRAINT fk_partidos_equipos2 FOREIGN KEY (temporada )  REFERENCES temporada
   );




CREATE TABLE JUGADORES
  (
    CODJUGADOR   VARCHAR2(10),
    NOMBREJUGADOR VARCHAR2(50) NOT NULL ,
    PRIMARY KEY (CODJUGADOR) ,
    fechanac date 
  );
  



CREATE TABLE PARTIDOS_JUGADORES
  (
    CODPARTIDO  VARCHAR2(10 ),
    CODJUGADOR  VARCHAR2(10 ),
    CANASTAS    NUMBER(2,0),
    ASISTENCIAS NUMBER(2,0),
    REBOTES     NUMBER(2,0),
    PRIMARY KEY (CODPARTIDO, CODJUGADOR) ,
    CONSTRAINT FK_JUGADAS2 FOREIGN KEY (CODJUGADOR) REFERENCES JUGADORES (CODJUGADOR),
    CONSTRAINT FK_JUGADAS3 FOREIGN KEY (CODPARTIDO) REFERENCES PARTIDOS (CODPARTIDO)
  );


CREATE TABLE TEMP_EQUIPO_JUGADOR
  (
    CODTEMP    VARCHAR2(3 ),
    CODEQUIPO  VARCHAR2(10 ),
    CODJUGADOR VARCHAR2(10 ),
    SALARIO NUMBER(10),
    fecha_ingreso date,
    CONSTRAINT PKF0 PRIMARY KEY (CODTEMP, CODEQUIPO, CODJUGADOR),
    CONSTRAINT FKF1 FOREIGN KEY (CODTEMP) REFERENCES TEMPORADA ,
    CONSTRAINT FKF2 FOREIGN KEY (CODEQUIPO) REFERENCES EQUIPOS,
    CONSTRAINT FKF3 FOREIGN KEY (CODJUGADOR) REFERENCES JUGADORES
  );


insert into  TEMPORADA   ( CODTEMP , NOMBRE )  values ('t1','2008_2009');
insert into  TEMPORADA   ( CODTEMP , NOMBRE )  values ('t2','2009_2010');
insert into  TEMPORADA   ( CODTEMP , NOMBRE )  values ('t3','2010_2011');



INSERT INTO equipos (codEquipo,nombreEquipo) VALUES ('e1','Asefa Estudiantes');
INSERT INTO equipos (codEquipo  ,nombreEquipo) VALUES ('e2','Caja Sol Sevilla');
INSERT INTO equipos (codEquipo  ,nombreEquipo) VALUES ('e3','Unicaja Málaga');
INSERT INTO equipos (codEquipo  ,nombreEquipo) VALUES ('e4','Madrid');



insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,fechanac) values ('j1','Esteban D.','10-10-1985');
insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,fechanac) values ('j2','Rafa Martinez','10-10-1980');
insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,fechanac) values ('j3','Banie','10-10-1990');

insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,fechanac) values ('j4','Fitch.','10-10-1992');
insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,fechanac) values ('j5','Telotovic','13-02-1989');
insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,fechanac) values ('j6','Juan Peñi','10-10-1985');
insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,fechanac) values ('j7','Juan Xi','02-10-1991');


insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,fechanac) values ('j8','Mario G','02-10-1991');
insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,fechanac) values ('j9','Telvio J','02-10-1992');


insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,fechanac) values ('j10','Mario G','02-10-1991');
insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,fechanac) values ('j11','Telvio J','02-10-1991');



insert into partidos  values ('p1','1-1-2008','t1','1',88,99,'e1','e2');
insert into partidos  values ('p2','1-1-2008','t1','1',77,66,'e3','e4');
insert into partidos  values ('p3','2-2-2008','t1','2',77,66,'e4','e3');
insert into partidos  values ('p4','2-2-2008','t1','2',77,66,'e2','e1');
insert into partidos  values ('p5','3-3-2008','t1','3',77,66,'e1','e4');
insert into partidos  values ('p6','3-3-2008','t1','3',77,66,'e3','e2');
insert into partidos  values ('p7','4-4-2008','t1','4',97,66,'e4','e1');
insert into partidos  values ('p8','4-4-2008','t1','4',70,90,'e2','e3');

insert into partidos  values ('p9','1-1-2009','t2','1',54,78,'e1','e2');
insert into partidos  values ('p10','1-1-2009','t2','1',79,56,'e3','e4');
insert into partidos  values ('p11','2-2-2009','t2','2',70,90,'e4','e3');
insert into partidos  values ('p12','2-2-2009','t2','2',90,66,'e2','e1');
insert into partidos  values ('p13','3-3-2009','t2','3',90,66,'e1','e4');
insert into partidos  values ('p14','3-3-2009','t2','3',77,65,'e3','e2');
insert into partidos  values ('p15','4-4-2009','t2','4',97,65,'e4','e1');
insert into partidos  values ('p16','4-4-2009','t2','4',90,90,'e2','e3');



insert into PARTIDOS_JUGADORES  (CODPARTIDO, CODJUGADOR,CANASTAS ,ASISTENCIAS, REBOTES) values ('p1','j1',4,5,6);
insert into PARTIDOS_JUGADORES  (CODPARTIDO, CODJUGADOR,CANASTAS ,ASISTENCIAS, REBOTES) values ('p1','j2',2,0,6);
insert into PARTIDOS_JUGADORES  (CODPARTIDO, CODJUGADOR,CANASTAS ,ASISTENCIAS, REBOTES) values ('p1','j3',4,5,3);
insert into PARTIDOS_JUGADORES  (CODPARTIDO, CODJUGADOR,CANASTAS ,ASISTENCIAS, REBOTES) values ('p1','j5',0,5,6);
insert into PARTIDOS_JUGADORES  (CODPARTIDO, CODJUGADOR,CANASTAS ,ASISTENCIAS, REBOTES) values ('p1','j6',2,5,6);


insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t1','e1','j1',1000,'1-1-2008');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t1','e1','j2',1050,'1-1-2008');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t1','e1','j3',1000,'1-1-2008');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t1','e2','j4',1000,'1-1-2008');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t1','e2','j5',1000,'1-1-2008');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t1','e2','j6',1000,'1-1-2008');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t1','e2','j7',1000,'1-1-2008');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t1','e3','j8',1000,'1-1-2008');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t1','e3','j9',1000,'1-1-2008');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t1','e3','j1',1000,'7-5-2008');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario ,fecha_ingreso) values ('t1','e2','j10',1000,'1-1-2008');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t1','e2','j11',1000,'1-1-2008');

insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t2','e2','j3',1000,'1-1-2009');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t2','e2','j7',1000,'1-1-2009');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t2','e1','j1',1000,'1-1-2009');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t2','e2','j5',1000,'1-1-2009');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t2','e3','j5',1000,'4-4-2009');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t2','e4','j5',1000,'6-6-2009');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t2','e3','j1',1000,'3-3-2009');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario ,fecha_ingreso) values ('t2','e4','j7',1000,'3-6-2009');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario ,fecha_ingreso) values ('t2','e2','j8',1000,'1-1-2009');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario ,fecha_ingreso) values ('t2','e2','j9',1000,'1-1-2009');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario ,fecha_ingreso) values ('t2','e1','j2',1000,'1-1-2009');
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,salario,fecha_ingreso ) values ('t2','e3','j2',1000,'2-3-2009');