package com.yc.common.core.base.utils.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author youcong
 * @description 线程池
 */
public class ThreadPoolUtil {

    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolUtil.class);

    private static final ExecutorService threadPool;

    static {
        int corePoolSize = 20;
        int maxPoolSize = 180;
        long keepAliveTime = 30;
        TimeUnit keepAliveTimeUnit = TimeUnit.MINUTES;
        int queSize = 100_000;
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("ThreadPoolUtil")
                .build();

        threadPool = new ThreadPoolExecutor(corePoolSize, maxPoolSize,
                keepAliveTime, keepAliveTimeUnit, new LinkedBlockingQueue<>(queSize)
                , threadFactory);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                logger.info("线程池关闭:" + threadPool);
                threadPool.shutdown();
            }
        });
    }


    /**
     * 获取线程池
     *
     * @return 线程池
     */
    public static ExecutorService getThreadPool() {
        return threadPool;
    }

    public static void execute(Runnable work) {
        if (logger.isInfoEnabled()) {
            logger.info("向线程池提交任务" + threadPool.toString());
        }
        threadPool.execute(work);
    }

    public static <T> Future<T> submit(Callable<T> work) {
        return threadPool.submit(work);
    }

    public static <T> Future<T> submit(Runnable task, T result) {
        return threadPool.submit(task, result);
    }

    public static Future<?> submit(Runnable task) {
        return threadPool.submit(task);
    }
}
