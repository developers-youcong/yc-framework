package com.yc.crawler.mapper;

import com.yc.common.core.base.dto.crawler.PostCrawlerReqDTO;
import com.yc.common.core.base.dto.crawler.UserCrawlerReqDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: youcong
 */
@Repository
public interface PostCrawlerMapper {
    /**
     * 批量新增爬虫文章数据
     *
     * @param list
     */
    void insertPostCrawlerList(@Param("list") List<PostCrawlerReqDTO> list);

    /**
     * 新增爬虫用户数据
     *
     * @param reqDTO
     * @return
     */
    int insertUser(UserCrawlerReqDTO reqDTO);

    /**
     * 获取用户ID
     *
     * @param userName
     * @param companyId
     * @return
     */
    String selectUserName(@Param("userName") String userName, @Param("companyId") Long companyId);

    /**
     * 根据用户ID+文章标题判断文章是否存在
     *
     * @param postAuthor
     * @param postTitle
     * @return
     */
    int selectAuthorPost(@Param("postAuthor") String postAuthor, @Param("postTitle") String postTitle);


    /**
     * 根据公司ID获取所有用户名
     *
     * @param companyId
     * @return
     */
    List<String> selectAllUserName(@Param("companyId") Long companyId);
}
