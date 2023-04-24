# TABLA PRONOSTICO
## proyecto es el nombre de mi bd
CREATE TABLE `proyecto`.`pronostico` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Participante` VARCHAR(45) NULL,
  `equipo1` VARCHAR(45) NOT NULL,
  `ganado` VARCHAR(1) NULL,
  `empatado` VARCHAR(1) NULL,
  `perdido` VARCHAR(1) NULL,
  `equipo2` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `proyecto`.`punto` (
  `id` INT NOT NULL,
  `ptosGanar` INT NULL,
  `ptosEmpatar` INT NULL,
  `ptosPerder` INT NULL,
  `ptosAcertar` INT NULL,
  `ptosRonda` INT NULL,
  `ptosFase` INT NULL,
  PRIMARY KEY (`id`));





