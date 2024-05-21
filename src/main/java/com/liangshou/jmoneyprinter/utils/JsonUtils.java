package com.liangshou.jmoneyprinter.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * JSON工具类，提供 JSON 序列化与反序列化的便捷方法。
 *
 * @author X-L-S
 */
public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    /**
     * 将Java对象转换为JSON字符串。
     *
     * @param obj 待转换的对象
     * @return JSON字符串，转换失败时返回null
     */
    public static String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            // 记录日志或其他处理逻辑
            logger.error("Failed to convert obj to JSON String: {}" , e.getMessage());
            return null;
        }
    }

    /**
     * 将JSON字符串转换为指定类型的Java对象。
     *
     * @param jsonString JSON字符串
     * @param clazz      目标Java类型
     * @param <T>        泛型标记
     * @return 转换后的Java对象，转换失败时返回null
     */
    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            // 记录日志或其他处理逻辑
            logger.warn("Failed to convert JSON String to obj: {}",  e.getMessage());
            return null;
        }
    }

    /**
     * 将JSON字符串转换为List对象。
     *
     * @param jsonString JSON字符串
     * @param clazz      List内元素的类型
     * @param <T>        泛型标记
     * @return 转换后的List对象，转换失败时返回null
     */
    public static <T> List<T> fromJsonToList(String jsonString, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonString, TypeFactory.defaultInstance().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            // 记录日志或其他处理逻辑
            logger.error("Failed to convert JSON String to List: {}",  e.getMessage());
            return null;
        }
    }

    // TODO:根据需要继续添加更多 JSON 处理方法，如Map的序列化与反序列化等
}
