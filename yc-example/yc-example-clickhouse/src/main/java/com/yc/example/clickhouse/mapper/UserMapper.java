package com.yc.example.clickhouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yc.example.clickhouse.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: youcong
 */
@Repository
public interface UserMapper extends BaseMapper<UserEntity> {
    /**
     * 写入数据
     *
     * @param userInfo
     */
    void saveData(UserEntity userInfo);

    /**
     * ID 查询
     *
     * @param id
     * @return
     */
    UserEntity selectById(@Param("id") Integer id);

    /**
     * 查询全部
     *
     * @return
     */
    List<UserEntity> selectList();

}
