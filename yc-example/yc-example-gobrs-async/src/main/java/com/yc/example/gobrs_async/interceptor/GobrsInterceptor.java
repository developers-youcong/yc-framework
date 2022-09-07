package com.yc.example.gobrs_async.interceptor;
import com.gobrs.async.callback.AsyncTaskExceptionInterceptor;
import com.gobrs.async.callback.ErrorCallback;
import com.gobrs.async.util.JsonUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
/**
 * @description:
 * @author: youcong
 */
@Slf4j
@Component
public class GobrsInterceptor implements AsyncTaskExceptionInterceptor {


    @SneakyThrows
    @Override
    public void exception(ErrorCallback errorCallback) {

        log.error("Execute global interceptor  error{}", JsonUtil.obj2String(errorCallback.getThrowable()));
    }
}
