-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema myreview
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema myreview
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `myreview` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema teste
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema teste
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `myreview` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `myreview` ;

-- -----------------------------------------------------
-- Table `myreview`.`sts_states`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myreview`.`sts_states` (
  `sts_id` BIGINT NOT NULL AUTO_INCREMENT,
  `sts_uf` VARCHAR(2) NOT NULL,
  `sts_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`sts_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `myreview`.`cty_citys`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myreview`.`cty_citys` (
  `cty_id` BIGINT NOT NULL AUTO_INCREMENT,
  `cty_name` VARCHAR(150) NOT NULL,
  `sts_id` BIGINT NOT NULL,
  PRIMARY KEY (`cty_id`),
  INDEX `fk_cty_citys_sts_states1_idx` (`sts_id` ASC) VISIBLE,
  CONSTRAINT `fk_cty_citys_sts_states1`
    FOREIGN KEY (`sts_id`)
    REFERENCES `myreview`.`sts_states` (`sts_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `myreview`.`dst_districts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myreview`.`dst_districts` (
  `dst_id` BIGINT NOT NULL AUTO_INCREMENT,
  `dst_name` VARCHAR(200) NOT NULL,
  `cty_id` BIGINT NOT NULL,
  PRIMARY KEY (`dst_id`),
  INDEX `fk_dst_districts_cty_citys1_idx` (`cty_id` ASC) VISIBLE,
  CONSTRAINT `fk_dst_districts_cty_citys1`
    FOREIGN KEY (`cty_id`)
    REFERENCES `myreview`.`cty_citys` (`cty_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `myreview`.`est_establishments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myreview`.`est_establishments` (
  `est_id` BIGINT NOT NULL AUTO_INCREMENT,
  `est_name` VARCHAR(50) NOT NULL,
  `est_cnpj` VARCHAR(14) NOT NULL,
  `dst_id` BIGINT NOT NULL,
  `est_number` INT NULL,
  `est_description` VARCHAR(100) NULL,
  `est_stars` DOUBLE NULL,
  PRIMARY KEY (`est_id`),
  UNIQUE INDEX `est_cnpj_UNIQUE` (`est_cnpj` ASC) VISIBLE,
  INDEX `fk_est_establishments_dst_districts1_idx` (`dst_id` ASC) VISIBLE,
  CONSTRAINT `fk_est_establishments_dst_districts1`
    FOREIGN KEY (`dst_id`)
    REFERENCES `myreview`.`dst_districts` (`dst_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `myreview`.`usr_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myreview`.`usr_users` (
  `usr_id` BIGINT NOT NULL AUTO_INCREMENT,
  `usr_first_name` VARCHAR(25) NOT NULL,
  `usr_last_name` VARCHAR(45) NOT NULL,
  `usr_email` VARCHAR(60) NOT NULL,
  `usr_password` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`usr_id`),
  UNIQUE INDEX `usr_email_UNIQUE` (`usr_email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `myreview`.`rvw_reviews`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myreview`.`rvw_reviews` (
  `rvw_id` BIGINT NOT NULL AUTO_INCREMENT,
  `rvw_stars` DOUBLE NOT NULL,
  `rvw_comment` VARCHAR(300) NOT NULL,
  `est_id` BIGINT NOT NULL,
  `usr_id` BIGINT NOT NULL,
  PRIMARY KEY (`rvw_id`),
  INDEX `fk_rvw_reviews_est_establishments1_idx` (`est_id` ASC) VISIBLE,
  INDEX `fk_rvw_reviews_usr_users1_idx` (`usr_id` ASC) VISIBLE,
  CONSTRAINT `fk_rvw_reviews_est_establishments1`
    FOREIGN KEY (`est_id`)
    REFERENCES `myreview`.`est_establishments` (`est_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rvw_reviews_usr_users1`
    FOREIGN KEY (`usr_id`)
    REFERENCES `myreview`.`usr_users` (`usr_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

