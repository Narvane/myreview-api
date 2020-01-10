CREATE TABLE IF NOT EXISTS sts_states(
  sts_id SERIAL NOT NULL,
  sts_uf VARCHAR(2) NOT NULL,
  sts_name VARCHAR(100) NOT NULL,
  PRIMARY KEY (sts_id));
-- -----------------------------------------------------
-- Table `mydb`.`cty_citys`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS cty_citys(
  cty_id SERIAL NOT NULL ,
  cty_name VARCHAR(150) NOT NULL,
  sts_id BIGINT NOT NULL,
  PRIMARY KEY (cty_id),
  FOREIGN KEY (sts_id) REFERENCES sts_states(sts_id));

-- -------------------------------------------------
-- Table `mydb`.`dst_districts`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS dst_districts(
  dst_id SERIAL NOT NULL ,
  dst_name VARCHAR(200) NOT NULL,
  cty_id BIGINT NOT NULL,
  PRIMARY KEY (dst_id),
  FOREIGN KEY (cty_id) REFERENCES cty_citys (cty_id));


-- -----------------------------------------------------
-- Table `mydb`.`est_establishments`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS est_establishments (
  est_id SERIAL NOT NULL ,
  est_name VARCHAR(50) NOT NULL,
  est_cnpj VARCHAR(14) NOT NULL,
  dst_id BIGINT NOT NULL,
  est_number INT NULL,
  est_description VARCHAR(100) NULL,
  est_stars NUMERIC(2,1) NULL,
  PRIMARY KEY (est_id),
    FOREIGN KEY (dst_id)
    REFERENCES dst_districts(dst_id));


-- -----------------------------------------------------
-- Table `mydb`.`usr_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS usr_users (
  usr_id SERIAL NOT NULL ,
  usr_first_name VARCHAR(25) NOT NULL,
  usr_last_name VARCHAR(45) NOT NULL,
  usr_email VARCHAR(60) NOT NULL,
  usr_password VARCHAR(60) NOT NULL,
  PRIMARY KEY (usr_id));


-- -----------------------------------------------------
-- Table `mydb`.`rvw_reviews`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS rvw_reviews (
  rvw_id SERIAL NOT NULL,
  rvw_stars NUMERIC(2,1) NOT NULL,
  rvw_comment VARCHAR(300) NOT NULL,
  est_id BIGINT NOT NULL,
  usr_id BIGINT NOT NULL,
  PRIMARY KEY (rvw_id),
    FOREIGN KEY (est_id)
    REFERENCES est_establishments (est_id),
    FOREIGN KEY (usr_id)
    REFERENCES usr_users (usr_id));



