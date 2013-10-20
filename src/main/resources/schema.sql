CREATE SCHEMA IF NOT EXISTS `foodFactory` DEFAULT CHARACTER SET cp1251 COLLATE cp1251_general_ci ;
USE `foodFactory` ;

-- -----------------------------------------------------
-- Table `foodFactory`.`ProductGroup`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `foodFactory`.`ProductGroup` ;

CREATE TABLE IF NOT EXISTS `foodFactory`.`ProductGroup` (
  `idProductGroup` INT NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProductGroup`))
DEFAULT CHARACTER SET=cp1251,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foodFactory`.`Product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `foodFactory`.`Product` ;

CREATE TABLE IF NOT EXISTS `foodFactory`.`Product` (
  `idProduct` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `ProductGroup_id` INT NOT NULL,
  PRIMARY KEY (`idProduct`, `ProductGroup_id`))
DEFAULT CHARACTER SET=cp1251,
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `foodFactory`.`Recipe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `foodFactory`.`Recipe` ;

CREATE TABLE IF NOT EXISTS `foodFactory`.`Recipe` (
  `idRecipe` INT NOT NULL,
  `Product_id` INT NOT NULL,
  `number` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`idRecipe`, `Product_id`))
DEFAULT CHARACTER SET=cp1251,
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `foodFactory`.`Author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `foodFactory`.`Author` ;

CREATE TABLE IF NOT EXISTS `foodFactory`.`Author` (
  `idAuthor` INT NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `year` INT NULL,
  PRIMARY KEY (`idAuthor`))
DEFAULT CHARACTER SET=cp1251,
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `foodFactory`.`Recipe_Author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `foodFactory`.`Recipe_Author` ;

CREATE TABLE IF NOT EXISTS `foodFactory`.`Recipe_Author` (
  `Recipe_id` INT NOT NULL,
  `Author_id` INT NOT NULL,
  PRIMARY KEY (`Recipe_id`, `Author_id`))
DEFAULT CHARACTER SET=cp1251,
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `foodFactory`.`Provider`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `foodFactory`.`Provider` ;

CREATE TABLE IF NOT EXISTS `foodFactory`.`Provider` (
  `idProvider` INT NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  PRIMARY KEY (`idProvider`))
DEFAULT CHARACTER SET=cp1251,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foodFactory`.`Ingredient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `foodFactory`.`Ingredient` ;

CREATE TABLE IF NOT EXISTS `foodFactory`.`Ingredient` (
  `idIngredient` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `caloriesNumPerGram` INT NULL,
  PRIMARY KEY (`idIngredient`, `Provider_id`))
DEFAULT CHARACTER SET=cp1251,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foodFactory`.`PreparationMethod`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `foodFactory`.`PreparationMethod` ;

CREATE TABLE IF NOT EXISTS `foodFactory`.`PreparationMethod` (
  `idPreparationMethod` INT NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPreparationMethod`))
DEFAULT CHARACTER SET=cp1251,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foodFactory`.`Recipe_Ingredient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `foodFactory`.`Recipe_Ingredient` ;

CREATE TABLE IF NOT EXISTS `foodFactory`.`Recipe_Ingredient` (
  `idRecipe_Ingredient` INT NOT NULL,
  `gramNum` INT NULL,
  `Recipe_id` INT NOT NULL,
  `Ingredient_id` INT NOT NULL,
  `PreparationMethod_id` INT NOT NULL,
  PRIMARY KEY (`idRecipe_Ingredient`, `Recipe_id`, `Ingredient_id`, `PreparationMethod_id`))
DEFAULT CHARACTER SET=cp1251,
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foodFactory`.`Bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `foodFactory`.`Bill` ;

CREATE TABLE IF NOT EXISTS `foodFactory`.`Bill` (
  `idBill` INT NOT NULL,
  `price` DOUBLE NOT NULL,
  `receiptDate` DATE NULL,
  `Provider_id` INT NOT NULL,
  `Ingredient_id` INT NOT NULL,
  PRIMARY KEY (`idBill`, `Provider_id`, `Ingredient_id`))
DEFAULT CHARACTER SET=cp1251,
ENGINE = InnoDB;