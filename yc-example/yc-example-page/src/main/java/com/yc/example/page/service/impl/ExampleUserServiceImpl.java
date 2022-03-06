package com.yc.example.page.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yc.common.core.base.dto.admin.UserPageReqDTO;
import com.yc.common.core.base.entity.admin.UserEntity;
import com.yc.example.page.mapper.ExampleUserMapper;
import com.yc.example.page.service.ExampleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: youcong
 */
@Service
public class ExampleUserServiceImpl extends ServiceImpl<ExampleUserMapper, UserEntity> implements ExampleUserService {

    @Autowired
    private ExampleUserMapper userMapper;


    @Override
    public IPage<UserEntity> queryUserPageListExample(UserPageReqDTO reqDTO) {
        Page<UserEntity> page = new Page<>(reqDTO.getPageNum(), reqDTO.getPageSize());
        return userMapper.selectUserPageListExample(page, reqDTO);
    }

}
