package com.yc.common.core.base.result;


import com.yc.common.core.base.enums.IErrorCode;
import com.yc.common.core.base.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBody<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

    public ResultBody(String code) {
        this.code = code;
        this.msg = ResultCode.SELECT_SUCCESS.getCode();
    }

    public ResultBody(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultBody(T data) {
        this.code = ResultCode.SELECT_SUCCESS.getCode();
        this.data = data;
        this.msg = ResultCode.SELECT_SUCCESS.getMsg();
    }

    public static ResultBody success() {
        return new ResultBody(ResultCode.SELECT_SUCCESS.getCode());
    }

    public static ResultBody success(Object data) {
        return new ResultBody(data);
    }

    public static ResultBody fail() {
        return new ResultBody(ResultCode.FAIL_ERROR);
    }

    public static ResultBody fail(String msg) {
        return ResultBody.fail(ResultCode.FAIL_ERROR.getCode(), msg);
    }

    public static ResultBody fail(String code, String msg) {
        return new ResultBody(code, msg);
    }

    public static <T> ResultBody<T> failed(IErrorCode errorCode) {
        return new ResultBody<T>(errorCode.getCode(), errorCode.getMsg(), null);
    }

}
