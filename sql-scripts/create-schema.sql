USE epsi;

CREATE TABLE seances (
 seanceId VARCHAR(40) NOT NULL,
 startDate DATE NOT NULL,
 startTime VARCHAR(10) NOT NULL,
 name VARCHAR(100) NOT NULL,
 jeuId varchar(100),
 PRIMARY KEY (seanceId));

CREATE TABLE jeu (
  jeuId VARCHAR(50) NOT NULL,
  nom VARCHAR(50) NOT NULL,
  PRIMARY KEY (jeuId)
);

 CREATE TABLE inscriptions (
     inscriptionId VARCHAR(40) NOT NULL,
     seanceId VARCHAR(40) NOT NULL,
     adherentId VARCHAR(40) NOT NULL,
     PRIMARY KEY (inscriptionId));
 
 CREATE TABLE adherents (
     adherentId VARCHAR(40) NOT NULL,
     nom VARCHAR(128) NOT NULL,
     login VARCHAR(40) NOT NULL,
     mdp VARCHAR(50) NOT NULL,
     admin tinyint(1),
     jeuId VARCHAR(50) NULL,
     alreadyConnected tinyint(1) not null DEFAULT 0,
     PRIMARY KEY (adherentId));

CREATE TABLE mesjeux(
    mesjeuxId   VARCHAR(50) not null ,
    adherentId VARCHAR(40) not null,
    jeuId  VARCHAR(50) not null,
    PRIMARY KEY (mesjeuxId)
);