
/*
YC-Framework初始化数据
 */
INSERT INTO `yc-framework`.`yc_company`(`id`, `company_name`, `company_code`, `contact`, `phone`, `address`, `url`, `email`, `count`, `status`, `create_time`, `update_time`) VALUES (1, '油老板科技创新有限公司', '888888', '油老板', '保密', '中国', 'http://www.ycframework.com', 'youlaoban@163.com', 0, 1, '2021-09-20 11:55:45', '2021-09-20 11:55:48');

INSERT INTO `yc-framework`.`yc_user`(`id`, `user_name`, `password`, `email`, `phone`, `nick_name`, `company_id`, `sex`, `status`, `create_time`, `update_time`) VALUES ('f5799c7404a240f1b15bbad7bbd99b14', 'ycframework', '$2a$12$X.EH0xoYY4PazEbwvRViBeITD6uWPvnzcQOTl3LjVYywxAzUWVZRW', '15200740587@163.com', '15200740587', '油老板', 1, 0, 0, '2021-09-20 22:18:09', '2021-09-20 22:18:15');

/*
Nacos初始化数据 Nacos配置初始化信息详情参考官方文档:http://framework.youcongtech.com/
 */
INSERT INTO users (username, password, enabled) VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', TRUE);

INSERT INTO roles (username, role) VALUES ('nacos', 'ROLE_ADMIN');


