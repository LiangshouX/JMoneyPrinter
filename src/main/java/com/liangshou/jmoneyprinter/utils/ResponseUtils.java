package com.liangshou.jmoneyprinter.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Response 工具类，用于构建标准的HTTP响应对象。
 *
 * @author X-L-S
 */
public class ResponseUtils {
    private static final Logger logger = LoggerFactory.getLogger(ResponseUtils.class);
    private static final ObjectMapper objectMapper = new ObjectMapper(); // 初始化ObjectMapper用于JSON操作

    /**
     * 构建并返回一个标准的HTTP响应对象。
     *
     * @param status 响应状态码
     * @param data   响应携带的数据，可以是任何可序列化的Java对象
     * @param message 响应消息，描述响应的详细信息
     * @return 返回一个包含状态码、数据、消息的Map对象，该对象后续可被转换为JSON字符串发送给客户端
     */
    public static Map<String, Object> getResponse(int status, Object data, String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", status);

        if (data != null) {
            try {
                // 尝试将数据对象序列化为JSON字符串，然后放入响应中
                String jsonData = objectMapper.writeValueAsString(data);
                response.put("data", jsonData);
            } catch (IOException e) {
                // 如果序列化失败，记录错误日志并将原始数据放入（这一步取决于你的错误处理策略）
                logger.error("数据序列化失败", e);
                response.put("data", data);
            }
        }

        if (message != null && !message.isEmpty()) {
            response.put("message", message);
        }

        return response;
    }

    // TODO：在实际应用中，可能还需要一个方法将Map转换为JSON字符串，可以使用ObjectMapper的writeValueAsString方法来完成这一转换。
}
