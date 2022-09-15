package com.yc.example.clickhouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yc.example.clickhouse.entity.UserEntity;
import com.yc.example.clickhouse.mapper.UserMapper;
import com.yc.example.clickhouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: youcong
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveData(UserEntity userInfo) {
        userMapper.saveData(userInfo);
    }

    @Override
    public UserEntity selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<UserEntity> selectList() {
        return userMapper.selectList();
    }
}
