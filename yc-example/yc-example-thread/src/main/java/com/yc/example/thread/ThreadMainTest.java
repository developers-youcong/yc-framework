package com.yc.example.thread;

import cn.hutool.core.thread.ThreadUtil;
import com.yc.common.core.base.utils.thread.ThreadPoolUtil;

/**
 * @description:
 * @author: youcong
 */
public class ThreadMainTest {

    public static void main(String[] args) {
        ThreadUtil.execute(() ->
                System.out.println("Hutool自带线程池处理")
        );

        ThreadPoolUtil.getThreadPool().execute(() -> {
            System.out.println("自定义线程池处理");
        });
    }
}
