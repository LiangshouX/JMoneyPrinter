package com.liangshou.jmoneyprinter.models.exceptions;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * TODO： HTTP 异常相关的类
 *
 * @author X-L-S
 */

@Getter
public class HttpException extends Exception {

    private final int statusCode;
    private final String taskId;
    private final String message;
    private final Map<String, Object> data; // 使用Map泛型表示Any类型的数据

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public HttpException(String taskId, int statusCode, String message, Map<String, Object> data) {
        super(message); // 调用父类构造方法传递message
        this.taskId = taskId;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;

        // Java中通常不直接在此处记录日志，但可以根据需要提供一个日志方法
        logException(statusCode);
    }

    // 提供一个方法来根据状态码记录日志，模拟Python中的行为
    private void logException(int statusCode) {
        String logMessage = String.format("HttpException: %d, %s, %s", statusCode, taskId, getMessage());
        if (statusCode == 400) {
            logger.warn(logMessage);
        } else {
            logger.error(logMessage);
            // 如果需要打印堆栈信息，可以调用fillInStackTrace().toString()
            // 但通常异常被捕获时，堆栈信息会自动打印
        }
    }

}
