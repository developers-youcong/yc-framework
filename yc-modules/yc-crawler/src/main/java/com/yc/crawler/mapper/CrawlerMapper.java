package com.yc.crawler.mapper;

import com.yc.common.core.base.vo.crawler.PollutantVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: youcong
 * @time: 2021/5/26 20:09
 */
@Repository
public interface CrawlerMapper {


    /**
     * 插入城市-小时级数据
     *
     * @param vo
     * @return
     */
    int insert(PollutantVO vo);

    /**
     * 获取所有城市
     *
     * @return
     */
    List<String> selectAllCity();


}
