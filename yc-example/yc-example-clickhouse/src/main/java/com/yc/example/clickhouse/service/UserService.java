package com.yc.example.clickhouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yc.example.clickhouse.entity.UserEntity;

import java.util.List;

/**
 * @description:
 * @author: youcong
 */
public interface UserService extends IService<UserEntity> {
    // 写入数据
    void saveData (UserEntity userInfo);
    // ID 查询
    UserEntity selectById (Integer id);
    // 查询全部
    List<UserEntity> selectList ();
}
