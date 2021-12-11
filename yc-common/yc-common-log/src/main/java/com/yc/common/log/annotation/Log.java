package com.yc.common.log.annotation;


import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解
 *
 * @author youcong
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 功能描述
     *
     * @return
     */
    public String value() default "";

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveReqData() default true;
}
