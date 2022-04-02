package com.yc.common.core.base.result;


import com.yc.common.core.base.enums.ErrorCode;
import com.yc.common.core.base.enums.RespCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespBody<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

    public RespBody(String code) {
        this.code = code;
        this.msg = RespCode.SELECT_SUCCESS.getCode();
    }

    public RespBody(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RespBody(T data) {
        this.code = RespCode.SELECT_SUCCESS.getCode();
        this.data = data;
        this.msg = RespCode.SELECT_SUCCESS.getMsg();
    }

    public static RespBody success() {
        return new RespBody(RespCode.SELECT_SUCCESS.getCode());
    }

    public static RespBody success(Object data) {
        return new RespBody(data);
    }

    public static RespBody fail() {
        return new RespBody(RespCode.FAIL_ERROR);
    }

    public static RespBody fail(String msg) {
        return RespBody.fail(RespCode.FAIL_ERROR.getCode(), msg);
    }

    public static RespBody fail(String code, String msg) {
        return new RespBody(code, msg);
    }

    public static <T> RespBody<T> failed(ErrorCode errorCode) {
        return new RespBody<T>(errorCode.getCode(), errorCode.getMsg(), null);
    }

}
