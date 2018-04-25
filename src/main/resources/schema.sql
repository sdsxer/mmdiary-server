-- CREATE TABLE `system_role` (
-- 	`id` INT(11) NOT NULL AUTO_INCREMENT,
-- 	`name` VARCHAR(20) NOT NULL DEFAULT '',
-- 	PRIMARY KEY (`id`)
-- );
--
-- CREATE TABLE `system_permission` (
-- 	`id` INT(11) NOT NULL AUTO_INCREMENT,
-- 	`name` VARCHAR(20) NOT NULL DEFAULT '',
-- 	PRIMARY KEY (`id`)
-- );
--
-- CREATE TABLE `role_permission` (
-- 	`id` INT(11) NOT NULL AUTO_INCREMENT,
-- 	`role` int(11) NOT NULL,
-- 	`permission` int(11) NOT NULL,
-- 	constraint fk_rp_role foreign key(`role`) references system_role(`id`),
-- 	constraint fk_rp_permission foreign key(`permission`) references system_permission(`id`),
-- 	PRIMARY KEY (`id`)
-- );

CREATE TABLE `user` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`account` VARCHAR(20) NOT NULL DEFAULT '',
	`nickname` VARCHAR(20) NOT NULL DEFAULT '',
	`mobile` CHAR(11) NOT NULL DEFAULT '',
	`password` CHAR(32) NOT NULL DEFAULT '',
  `sex` TINYINT(4) NOT NULL DEFAULT 0,
	`avatar` VARCHAR(128) NOT NULL DEFAULT '',
-- 	`role` int(11) NOT NULL DEFAULT 2,
-- 	constraint fk_user_role foreign key(`role`) references system_role(`id`),
	PRIMARY KEY (`id`)
);

