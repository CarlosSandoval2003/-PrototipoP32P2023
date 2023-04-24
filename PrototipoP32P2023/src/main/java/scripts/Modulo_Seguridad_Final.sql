CREATE SCHEMA IF NOT EXISTS `PrototipoP32P2023` DEFAULT CHARACTER SET utf8 ;
USE `PrototipoP32P2023` ;

CREATE TABLE IF NOT EXISTS tbl_tipousuario (
	tipuid INT NOT NULL AUTO_INCREMENT,
	tipunombre VARCHAR(60) NOT NULL,
	tipuestatus VARCHAR(60) NOT NULL,
	PRIMARY KEY (tipuid) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_usuario (
	usuid INT NOT NULL AUTO_INCREMENT,
	usunombre VARCHAR(45) NOT NULL,
	usucontrasena VARCHAR(25) NOT NULL,
	usuultimasesion DATE,
	usuestatus VARCHAR(1) NOT NULL,
	usunombrereal VARCHAR(60),
	usucorreoe VARCHAR(60),
	usutelefono VARCHAR(25),
	usudireccion VARCHAR(80),
    tipuid INT NOT NULL,
	PRIMARY KEY (usuid),
    FOREIGN KEY (tipuid) REFERENCES tbl_tipousuario (tipuid)
    )
ENGINE = InnoDB CHARACTER SET = latin1;



CREATE TABLE IF NOT EXISTS tbl_vendedores (
	venid int NOT NULL AUTO_INCREMENT,
	vennombre VARCHAR(50),
	vennumeroventas int NOT NULL,
        venareaventas VARCHAR(50),
	PRIMARY KEY (venid)
) ENGINE=InnoDB CHARACTER SET = latin1;    

CREATE TABLE IF NOT EXISTS tbl_aplicacion (
	aplid int NOT NULL AUTO_INCREMENT,
	aplnombre VARCHAR(50),
	aplestatus VARCHAR(50),
	PRIMARY KEY (aplid)
) ENGINE=InnoDB CHARACTER SET = latin1;    



CREATE TABLE IF NOT EXISTS tbl_bitacora (
    bitid int auto_increment PRIMARY KEY,
    bitfecha datetime NULL, 
	bitaccion VARCHAR(10) NOT NULL,
    bitip VARCHAR(25) NOT NULL,
    usuid INT NOT NULL,
    aplid INT NOT NULL,
	FOREIGN KEY (aplid) references tbl_aplicacion (aplid),
	FOREIGN KEY (usuid) references tbl_usuario (usuid)    
) ENGINE=InnoDB DEFAULT CHARSET=latin1;	