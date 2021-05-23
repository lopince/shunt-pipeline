package org.example.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolUtils {

    private static ExecutorService threadPool;

    static {
        threadPool = initExecutor();
    }

    private static ExecutorService initExecutor() {
        return Executors.newCachedThreadPool();
    }

    public static Future<?> submit(Runnable task) {
        return threadPool.submit(task);
    }

    public static <T> Future<T> submit(Callable<T> task) {
        return submit(task);
    }
}
