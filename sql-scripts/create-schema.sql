USE epsi;

CREATE TABLE seances (
 seanceId VARCHAR(40) NOT NULL,
 startDateTime DATETIME NOT NULL,
 PRIMARY KEY (seanceId));

 CREATE TABLE inscriptions (
     inscriptionId VARCHAR(40) NOT NULL,
     seanceId VARCHAR(40) NOT NULL,
     adherentId VARCHAR(40) NOT NULL,
     PRIMARY KEY (inscriptionId));
 
 CREATE TABLE adherents (
     adherentId VARCHAR(40) NOT NULL,
     nom VARCHAR(128) NOT NULL,
     PRIMARY KEY (adherentId));
 