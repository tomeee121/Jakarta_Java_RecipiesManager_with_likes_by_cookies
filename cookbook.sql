-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cookbook
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cookbook
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cookbook` DEFAULT CHARACTER SET utf8 ;
USE `cookbook` ;

-- -----------------------------------------------------
-- Table `cookbook`.`recipe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cookbook`.`recipe` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `preptime` INT NOT NULL,
  `ingredients` VARCHAR(200) NOT NULL,
  `description` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `cookbook`.`vote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cookbook`.`vote` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `recipeId` INT NOT NULL,
  `dateAdded` DATETIME NOT NULL,
  `type` ENUM('UP', 'DOWN') NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_id_recipe_idx` (`recipeId` ASC) VISIBLE,
  CONSTRAINT `fk_id_recipe`
    FOREIGN KEY (`recipeId`)
    REFERENCES `cookbook`.`recipe` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 39
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
