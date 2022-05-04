
/*
YC-Framework初始化数据
 */
INSERT INTO `yc-framework`.`yc_company`(`id`, `company_name`, `company_code`, `contact`, `phone`, `address`, `url`, `email`, `count`, `status`, `create_time`, `update_time`) VALUES (1, '油老板科技创新有限公司', '888888', '油老板', '保密', '中国', 'http://www.ycframework.com', 'youlaoban@163.com', 0, 1, '2021-09-20 11:55:45', '2021-09-20 11:55:48');

INSERT INTO `yc-framework`.`yc_user`(`id`, `user_name`, `password`, `email`, `phone`, `nick_name`, `company_id`, `sex`, `status`, `create_time`, `update_time`) VALUES ('f5799c7404a240f1b15bbad7bbd99b14', 'ycframework', '$2a$12$X.EH0xoYY4PazEbwvRViBeITD6uWPvnzcQOTl3LjVYywxAzUWVZRW', '15200740587@163.com', '15200740587', '油老板', 1, 0, 0, '2021-09-20 22:18:09', '2021-09-20 22:18:15');

/*
Nacos初始化数据 Nacos配置初始化信息详情参考官方文档:http://framework.youcongtech.com/
 */
INSERT INTO `nacos`.users (username, password, enabled) VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', TRUE);

INSERT INTO `nacos`.roles (username, role) VALUES ('nacos', 'ROLE_ADMIN');


/*
Xxl-Job
 */
INSERT INTO `xxl_job`.`xxl_job_group`(`id`, `app_name`, `title`, `address_type`, `address_list`, `update_time`) VALUES (1, 'xxl-job-executor-sample', '示例执行器', 0, NULL, '2018-11-03 22:21:31' );
INSERT INTO `xxl_job`.`xxl_job_info`(`id`, `job_group`, `job_desc`, `add_time`, `update_time`, `author`, `alarm_email`, `schedule_type`, `schedule_conf`, `misfire_strategy`, `executor_route_strategy`, `executor_handler`, `executor_param`, `executor_block_strategy`, `executor_timeout`, `executor_fail_retry_count`, `glue_type`, `glue_source`, `glue_remark`, `glue_updatetime`, `child_jobid`) VALUES (1, 1, '测试任务1', '2018-11-03 22:21:31', '2018-11-03 22:21:31', 'XXL', '', 'CRON', '0 0 0 * * ? *', 'DO_NOTHING', 'FIRST', 'demoJobHandler', '', 'SERIAL_EXECUTION', 0, 0, 'BEAN', '', 'GLUE代码初始化', '2018-11-03 22:21:31', '');
INSERT INTO `xxl_job`.`xxl_job_user`(`id`, `username`, `password`, `role`, `permission`) VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 1, NULL);
INSERT INTO `xxl_job`.`xxl_job_lock` ( `lock_name`) VALUES ( 'schedule_lock');
