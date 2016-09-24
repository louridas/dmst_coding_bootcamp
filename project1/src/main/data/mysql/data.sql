CREATE DATABASE project;

USE project;
GRANT ALL PRIVILEGES ON project1.* TO 'root'@'localhost';

DROP TABLE subjects;
DROP TABLE user_roles;
DROP TABLE users;

CREATE TABLE users(
	id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(30),
    name VARCHAR(30),
    sur VARCHAR(30),
    password CHAR(60),
    email VARCHAR(30),
    address VARCHAR(200),
    age INT NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE roles(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30),
    PRIMARY KEY (id),
    UNIQUE KEY role_name(name)
);

CREATE TABLE user_roles(
	id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY(id),
    UNIQUE KEY user_id_role_id(role_id, user_id),
    CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES users(id)
);

INSERT INTO roles(name) VALUES("user");

CREATE TABLE `project1`.`subjects` (
  `subjectId` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `math` INT(10) UNSIGNED NULL DEFAULT NULL,
  `java` INT(10) UNSIGNED NULL DEFAULT NULL,
  `posotikes` INT(10) UNSIGNED NULL DEFAULT NULL,
  `oikonomia` INT(10) UNSIGNED NULL DEFAULT NULL,
  `logistiki` INT(10) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`subjectId`));
  
  

