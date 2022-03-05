package com.yc.example.page.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yc.common.core.base.dto.admin.UserAddOrUpdateReqDTO;
import com.yc.common.core.base.dto.admin.UserChangePwdReqDTO;
import com.yc.common.core.base.dto.admin.UserOneReqDTO;
import com.yc.common.core.base.dto.admin.UserPageReqDTO;
import com.yc.common.core.base.entity.admin.UserEntity;
import com.yc.common.core.base.vo.admin.UserOneVO;

/**
 * @description:
 * @author: youcong
 */
public interface ExampleUserService extends IService<UserEntity> {
    /**
     * 列表分页查询
     *
     * @param reqDTO
     * @return
     */
    IPage<UserEntity> queryUserPageListExample(UserPageReqDTO reqDTO);

}
