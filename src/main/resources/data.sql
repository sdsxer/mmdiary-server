INSERT INTO `system_privilege`(`id`, `name`, `desc`) VALUES (1, 'VIEW_ITEM', 'view item');
INSERT INTO `system_privilege`(`id`, `name`, `desc`) VALUES (2, 'ADD_ITEM', 'add item');
INSERT INTO `system_privilege`(`id`, `name`, `desc`) VALUES (3, 'DELETE_ITEM', 'delete item');
INSERT INTO `system_privilege`(`id`, `name`, `desc`) VALUES (4, 'UPDATE_ITEM', 'update item');
INSERT INTO `system_privilege`(`id`, `name`, `desc`) VALUES (5, 'RELEASE_ITEM', 'release item');
INSERT INTO `system_privilege`(`id`, `name`, `desc`) VALUES (6, 'REVOKE_ITEM', 'revoke item');

INSERT INTO `system_privilege`(`id`, `name`, `desc`) VALUES (7, 'VIEW_EDITOR', 'view editor');
INSERT INTO `system_privilege`(`id`, `name`, `desc`) VALUES (8, 'ADD_EDITOR', 'add editor');
INSERT INTO `system_privilege`(`id`, `name`, `desc`) VALUES (9, 'DELETE_EDITOR', 'delete editor');
INSERT INTO `system_privilege`(`id`, `name`, `desc`) VALUES (10, 'UPDATE_EDITOR', 'update editor');
INSERT INTO `system_privilege`(`id`, `name`, `desc`) VALUES (11, 'FREEZE_EDITOR', 'freeze editor');

INSERT INTO `system_privilege`(`id`, `name`, `desc`) VALUES (12, 'VIEW_USER', 'view user');
INSERT INTO `system_privilege`(`id`, `name`, `desc`) VALUES (13, 'ADD_USER', 'add user');
INSERT INTO `system_privilege`(`id`, `name`, `desc`) VALUES (14, 'DELETE_USER', 'delete user');
INSERT INTO `system_privilege`(`id`, `name`, `desc`) VALUES (15, 'UPDATE_USER', 'update user');
INSERT INTO `system_privilege`(`id`, `name`, `desc`) VALUES (16, 'FREEZE_USER', 'freeze user');

INSERT INTO `system_role`(`id`, `name`, `desc`) VALUES (1, 'ADMIN', 'admin');
INSERT INTO `system_role`(`id`, `name`, `desc`) VALUES (2, 'EDITOR', 'editor');
INSERT INTO `system_role`(`id`, `name`, `desc`) VALUES (3, 'USER', 'user');

INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (1, 1);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (1, 2);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (1, 3);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (1, 4);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (1, 5);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (1, 6);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (1, 7);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (1, 8);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (1, 9);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (1, 10);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (1, 11);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (1, 12);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (1, 13);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (1, 14);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (1, 15);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (1, 16);

INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (2, 1);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (2, 2);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (2, 3);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (2, 4);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (2, 5);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (2, 6);

INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (2, 12);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (2, 13);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (2, 14);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (2, 15);
INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (2, 16);

INSERT INTO `system_role_privileges`(`system_role_id`, `privileges_id`) VALUES (3, 1);

INSERT INTO `user`(`id`, `username`, `nickname`, `mobile`, `password`, `role_id`) VALUES (0, 'admin', 'King', '18810789600', '123456', 1);
INSERT INTO `user`(`id`, `username`, `nickname`, `mobile`, `password`, `sex`, `role_id`) VALUES (1, 'sdsxla', '李昂', '18810789600', '123456', 1, 3);
INSERT INTO `user`(`id`, `username`, `nickname`, `mobile`, `password`, `sex`, `role_id`) VALUES (2, 'sdsxhq', '黄青', '15011210071', '123456', 2, 3);
INSERT INTO `user`(`id`, `username`, `nickname`, `mobile`, `password`, `sex`, `role_id`) VALUES (3, 'sdsxwfj', '王凤娟', '15506566117', '123456', 2, 3);
INSERT INTO `user`(`id`, `username`, `nickname`, `mobile`, `password`, `sex`, `role_id`) VALUES (4, 'sdsxlxy', '李晓益', '13583029338', '123456', 1, 3);

-- INSERT INTO `school`(`id`, `name`, `location`, `telephone`, `zip_code`, `type`) VALUES (1, '徐寨镇明德小学（原仁德庵小学）', '徐寨镇杜楼村东侧', '0530-4511233', '427380', 1);
-- INSERT INTO `school`(`id`, `name`, `location`, `telephone`, `zip_code`, `type`) VALUES (2, '李新庄中心学校', '李新庄镇修庄村', '0530-4790126', '274334', 1);
-- INSERT INTO `school`(`id`, `name`, `location`, `telephone`, `zip_code`, `type`) VALUES (3, '徐寨镇中心学校', '单县徐寨镇徐寨村', '0530-4511233', '274332', 1);
-- INSERT INTO `school`(`id`, `name`, `location`, `telephone`, `zip_code`, `type`) VALUES (4, '时楼镇中心小学', '时楼镇家庙村', '0530-4551009', '274300', 1);
--
-- INSERT INTO `administrative_division`(`id`, `code`, `name`, `parent`) VALUES (1, '371722001000', '北城', 0);
-- INSERT INTO `administrative_division`(`id`, `code`, `name`, `parent`) VALUES (2, '371722002000', '南城', 0);
-- INSERT INTO `administrative_division`(`id`, `code`, `name`, `parent`) VALUES (3, '371722003000', '园艺', 0);
-- INSERT INTO `administrative_division`(`id`, `code`, `name`, `parent`) VALUES (4, '371722004000', '东城', 0);
-- INSERT INTO `administrative_division`(`id`, `code`, `name`, `parent`) VALUES (5, '371722101000', '郭村', 0);
-- INSERT INTO `administrative_division`(`id`, `code`, `name`, `parent`) VALUES (5, '371722102000', '黄岗', 0);
