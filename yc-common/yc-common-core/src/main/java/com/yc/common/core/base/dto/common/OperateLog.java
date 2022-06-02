package com.yc.common.core.base.dto.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yc.common.core.base.annotation.Excel;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @description:
 * @author: youcong
 * @time: 2021/12/11 21:35
 */
@Data
@Document("operate_log")
public class OperateLog {
    private static final long serialVersionUID = 1L;

    /**
     * 日志主键
     */
    @Id
    private String operId;

    /**
     * 功能名称
     */
    private String functionName;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求方式
     */
    private String requestMethod;

    /**
     * 操作人员
     */
    private String operName;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 请求url
     */
    private String operUrl;

    /**
     * 操作地址
     */
    private String operIp;

    /**
     * 请求参数
     */
    private String operParam;

    /**
     * 返回参数
     */
    private String jsonResult;

    /**
     * 操作状态（0正常 1异常）
     */
    private Integer status;

    /**
     * 错误消息
     */
    private String errorMsg;

    /**
     * 操作时间
     */
    private Date operTime;
}
