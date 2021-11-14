package com.yc.common.core.base.vo.crawler;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: youcong
 * @time: 2021/5/26 20:30
 */
@Data
public class PollutantVO {

    private String city;

    private String day;

    private String hour;

    private String aqi;

    private String pm2_5;

    private String pm10;

    private String so2;

    private String no2;

    private String co;

    private String o3;

    private Date createTime;
}
