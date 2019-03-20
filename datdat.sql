# Set ut schema and clear database
CREATE SCHEMA IF NOT EXISTS `DatDat`;
USE `DatDat`;


DROP TABLE IF EXISTS `DatDat`.`FriOvelse`;
DROP TABLE IF EXISTS `DatDat`.`FastOvelse`;
DROP TABLE IF EXISTS `DatDat`.`OvelseiGruppe`;
DROP TABLE IF EXISTS `DatDat`.`Ovelse`;
DROP TABLE IF EXISTS `DatDat`.`Ovelsegruppe`;
DROP TABLE IF EXISTS `DatDat`.`Treningsokt`;
DROP TABLE IF EXISTS `DatDat`.`Apparat`;
DROP TABLE IF EXISTS `DatDat`.`Favorittokt`;

CREATE USER IF NOT EXISTS 'bruker'@'localhost' IDENTIFIED BY 'passord123';
GRANT SELECT, INSERT ON DatDat.* TO 'bruker'@'localhost';
FLUSH PRIVILEGES;


# Create tables
CREATE TABLE `DatDat`.`Ovelsegruppe`
(
  `idOvelsegruppe` 		INT           NOT NULL AUTO_INCREMENT,
  `Name`				VARCHAR(45)   NOT NULL,
  `MuskelgruppeNavn`	VARCHAR(45)   NOT NULL,
  PRIMARY KEY (`idOvelsegruppe`)
);

CREATE TABLE `DatDat`.`Ovelse`
(
  `idOvelse`	INT           NOT NULL AUTO_INCREMENT,
  `Name`        VARCHAR(45)   NOT NULL,
  `idOvelsegruppe` INT 			NOT NULL,
  PRIMARY KEY (`idOvelse`),
	CONSTRAINT `ovelseidFk` 
		FOREIGN KEY (`idOvelsegruppe`) 
			REFERENCES `DatDat`.`Ovelsegruppe` (`idOvelsegruppe`)
  	ON DELETE CASCADE
	ON UPDATE CASCADE
);

CREATE TABLE `DatDat`.`Treningsokt`
(
  `idTreningsokt`	INT         NOT NULL AUTO_INCREMENT,
  `Date`			VARCHAR(20) 	NOT NULL,
  `Time`			INT 		NOT NULL,
  `Length` 			INT  		NOT NULL,
  `PersonalShape`	INT  		NOT NULL,
  `Performance`		INT  		NOT NULL,
  `Note`			VARCHAR(400),
  PRIMARY KEY (`idTreningsokt`)
);

CREATE TABLE `DatDat`.`Apparat` 
(
  `idApparat`   INT           NOT NULL AUTO_INCREMENT,
  `Name`     	VARCHAR(45)   NOT NULL,
  `Description` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`idApparat`)
);

CREATE TABLE `DatDat`.`Favorittokt`
(
  `idFavorittokt`	INT           NOT NULL AUTO_INCREMENT,
  `Name`        	VARCHAR(45)   NOT NULL,
  `Description`		VARCHAR(400),	
  PRIMARY KEY (`idFavorittokt`)
);

CREATE TABLE `DatDat`.`FastOvelse`
(
  `Kilo`        	INT   	NOT NULL,
  `Set`				INT		NOT NULL,	
  `idOvelse`		INT		NOT NULL,
  FOREIGN KEY (idOvelse) REFERENCES Ovelse (idOvelse)
  	ON DELETE CASCADE
	ON UPDATE CASCADE
);

CREATE TABLE `DatDat`.`FriOvelse`
(
  `Description`		VARCHAR(400),	
  `idOvelse`		INT		NOT NULL,
  FOREIGN KEY (idOvelse) REFERENCES Ovelse (idOvelse)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);
CREATE TABLE `DatDat`.`OvelseiGruppe`
(
`idOvelse`				INT		NOT NULL,
`idOvelsegruppe`		INT		NOT NULL,
FOREIGN KEY (idOvelse) REFERENCES Ovelse (idOvelse)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
FOREIGN KEY (idOvelsegruppe) REFERENCES Ovelsegruppe (idOvelsegruppe)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);

# Ovelsegruppe
INSERT INTO Ovelsegruppe(`Name`,`MuskelgruppeNavn`)
VALUES ('Kule øvelse', 'Armer');
# Ovelse
INSERT INTO Ovelse(`Name`,`idOvelsegruppe`)
VALUES ('Benkpress','1');
# Ovelse
INSERT INTO Ovelse(`Name`,`idOvelsegruppe`)
VALUES ('MuscelUps','1');
# Ovelse
INSERT INTO Ovelse(`Name`,`idOvelsegruppe`)
VALUES ('ChinUps','1');
# Ovelse
INSERT INTO Ovelse(`Name`,`idOvelsegruppe`)
VALUES ('Incline Benkpress','1');
# Treningsokt
INSERT INTO Treningsokt(`Date`,`Time`,`Length`,`PersonalShape`,`Performance`,`Note`)
VALUES ('12.02.19','90.12','39','9','1','imgay');
# Treningsokt
INSERT INTO Treningsokt(`Date`,`Time`,`Length`,`PersonalShape`,`Performance`,`Note`)
VALUES ('12.02.19','90.12','39','9','1','rip');
# Treningsokt
INSERT INTO Treningsokt(`Date`,`Time`,`Length`,`PersonalShape`,`Performance`,`Note`)
VALUES ('12.02.19','90.12','39','9','1','imgayandkms');