# 线程池
关于为什么要自定义Java线程池，可以阅读阿里巴巴开发手册，地址如下:[个人知识库之阿里巴巴开发手册](https://github.com/developers-youcong/Personal-Learning-Library/blob/master/%E6%8A%80%E6%9C%AF%E6%88%90%E9%95%BF/%E9%98%BF%E9%87%8C/Java%E5%BC%80%E5%8F%91%E6%89%8B%E5%86%8C.pdf)

## 一、核心代码
```
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


```

## 二、使用模板
```
   ExecutorService executorService = ThreadPoolUtil.getThreadPool();
        executorService.execute(() -> {
            //放入相关的业务代码
        });
```

源代码示例:
https://github.com/developers-youcong/yc-framework/tree/main/yc-example/yc-example-thread