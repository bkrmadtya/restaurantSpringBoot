
-- -----------------------------------------------------
-- Table `restaurant`.`person_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurant`.`person_roles` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `person_id` INT(11) NULL DEFAULT NULL,
  `role_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `person_id` (`person_id` ASC) VISIBLE,
  INDEX `role_id` (`role_id` ASC) VISIBLE,
  CONSTRAINT `person_roles_ibfk_1`
    FOREIGN KEY (`person_id`)
    REFERENCES `restaurant`.`people` (`id`),
  CONSTRAINT `person_roles_ibfk_2`
    FOREIGN KEY (`role_id`)
    REFERENCES `restaurant`.`roles` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
