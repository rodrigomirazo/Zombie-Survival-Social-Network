--Create Schema
CREATE SCHEMA `zombie_land`;

--Create Survivor Table
CREATE TABLE `zombie_land`.`survivor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `age` INT NULL,
  `gender` VARCHAR(45) NULL,
  `latitude` DOUBLE NULL,
  `longitude` DOUBLE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

--Add
ALTER TABLE `zombie_land`.`survivor`
ADD COLUMN `infected` TINYINT NULL AFTER `longitude`;

CREATE TABLE `zombie_land`.`survivor_infected_assessment` (
  `id` INT NOT NULL,
  `survivor_infected_id` INT NULL,
  `survivor_witness_id` INT NULL,
  PRIMARY KEY (`id`));
