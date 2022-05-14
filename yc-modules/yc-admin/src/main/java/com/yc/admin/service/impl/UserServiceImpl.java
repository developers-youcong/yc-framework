package com.yc.admin.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yc.admin.mapper.UserMapper;
import com.yc.admin.service.UserService;
import com.yc.common.core.base.constant.UserConst;
import com.yc.common.core.base.dto.admin.UserAddOrUpdateReqDTO;
import com.yc.common.core.base.dto.admin.UserChangePwdReqDTO;
import com.yc.common.core.base.dto.admin.UserOneReqDTO;
import com.yc.common.core.base.dto.admin.UserPageReqDTO;
import com.yc.common.core.base.entity.admin.UserEntity;
import com.yc.common.core.base.utils.JbcryptUtil;
import com.yc.common.core.base.vo.admin.UserOneVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: youcong
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveOrUpdateUser(UserAddOrUpdateReqDTO reqDTO) {
        return handleUserAddOrUpdate(reqDTO);
    }

    @Override
    public int changeUserStatus(String userId, Integer userStatus) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        userEntity.setStatus(userStatus);
        return userMapper.updateById(userEntity);
    }

    @Override
    public UserOneVO selectUserOne(UserOneReqDTO reqDTO) {
        UserEntity userEntity = userMapper.selectById(reqDTO.getUserId());
        UserOneVO userOneVO = new UserOneVO();
        if (!StrUtil.isEmpty(userEntity.getId())) {
            userOneVO.setId(userEntity.getId());
            userOneVO.setCompanyId(userEntity.getCompanyId());
            userOneVO.setUserName(userEntity.getUserName());
            userOneVO.setNickName(userEntity.getPassword());
            userOneVO.setEmail(userEntity.getEmail());
            userOneVO.setPhone(userEntity.getPhone());
            userOneVO.setSex(userEntity.getSex());
            userOneVO.setStatus(userEntity.getStatus());
        }
        return userOneVO;
    }

    @Override
    public IPage<UserEntity> queryUserPageList(UserPageReqDTO reqDTO) {
        Page<UserEntity> page = new Page<>(reqDTO.getPageNum(), reqDTO.getPageSize());
        return userMapper.selectUserPageList(page, reqDTO);
    }

    @Override
    public int changePwd(UserChangePwdReqDTO reqDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(reqDTO.getUserId());
        userEntity.setPassword(JbcryptUtil.bcryptPwd(reqDTO.getNewPwd()));
        return userMapper.updateById(userEntity);
    }

    private int handleUserAddOrUpdate(UserAddOrUpdateReqDTO reqDTO) {
        UserEntity userEntity = new UserEntity();
        if (StrUtil.isEmpty(reqDTO.getUserId())) {
            userEntity.setId(IdUtil.simpleUUID());
            userEntity.setCompanyId(reqDTO.getCompanyId());
            userEntity.setUserName(reqDTO.getUserName());
            userEntity.setNickName(reqDTO.getNickName());
            userEntity.setPassword(JbcryptUtil.bcryptPwd(reqDTO.getPassword()));
            userEntity.setEmail(reqDTO.getEmail());
            userEntity.setPhone(reqDTO.getPhone());
            userEntity.setSex(reqDTO.getSex());
            userEntity.setStatus(UserConst.USER_STATUS_NORMAL);
            userEntity.setCreateTime(DateUtil.date());
            userEntity.setUpdateTime(DateUtil.date());
            return userMapper.insert(userEntity);
        } else {
            userEntity.setId(reqDTO.getUserId());
            userEntity.setCompanyId(reqDTO.getCompanyId());
            userEntity.setUserName(reqDTO.getUserName());
            userEntity.setNickName(reqDTO.getNickName());
            userEntity.setEmail(reqDTO.getEmail());
            userEntity.setPhone(reqDTO.getPhone());
            userEntity.setSex(reqDTO.getSex());
            userEntity.setStatus(UserConst.USER_STATUS_NORMAL);
            userEntity.setUpdateTime(DateUtil.date());
            return userMapper.updateById(userEntity);
        }
    }
}
