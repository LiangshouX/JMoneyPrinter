package com.liangshou.jmoneyprinter.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 提供在新线程中执行任务的方法
 *
 * @author X-L-S
 */
public class ThreadUtils {

    private static final Logger logger = LoggerFactory.getLogger(ThreadUtils.class);

    /**
     * 在后台线程中异步执行指定的任务。
     * 如果任务执行过程中发生异常，该异常会被记录到日志中。
     *
     * @param task 要在后台执行的任务，作为Runnable接口的实例
     * @return 返回执行任务的线程对象
     */
    public static Thread runInBackground(Runnable task) {
        Thread thread = new Thread(() -> {
            try {
                task.run();
            } catch (Exception e) {
                // 捕获并记录运行时异常
                logger.error("后台任务执行时发生错误:", e);
            }
        });
        thread.setDaemon(true); // 设置为守护线程，当主线程结束时自动结束
        thread.start();
        return thread;
    }
}
