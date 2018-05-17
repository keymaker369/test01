CREATE SCHEMA `test01` ;

CREATE TABLE `test01`.`user` (
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(45) NULL,
  `create_time` DATETIME NULL,
  `last_update_time` DATETIME NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `test01`.`note` (
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NULL,
  `note` VARCHAR(1000) NULL,
  `create_time` DATETIME NULL,
  `last_update_time` DATETIME NULL,
  `user_id` INT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_note_1_idx` (`user_id` ASC),
  CONSTRAINT `fk_note_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `test01`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
ALTER TABLE `test01`.`user` 
ADD UNIQUE INDEX `email_UNIQUE` (`email` ASC);


    
