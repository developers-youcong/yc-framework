package com.yc.common.core.base.enums;


/**
 * @Author: youcong
 * @Description: 返回码
 * @Date: 2020/8/20 18:53
 * @Version: 1.0.0
 */
public enum ResultCode {

    SELECT_SUCCESS("200", "成功"),
    FAIL_ERROR("500", "服务器异常"),
    TOKEN_ERROR("999999","没有携带token或token已被踢下线"),
    USER_NO_EXIST_ERROR("A001","该用户不存在"),
    USER_OR_PASSWD_ERROR("A002","用户名或密码错误"),
    ILLEGAL_PARAMETER_ERROR("400", "参数不合法");
    private String code;
    private String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
