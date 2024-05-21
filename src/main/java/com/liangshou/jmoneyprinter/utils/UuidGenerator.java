package com.liangshou.jmoneyprinter.utils;

import java.util.UUID;

/**
 * 负责生成UUID字符串，包括带或不带连字符的版本
 *
 * @author X-L-S
 */
public class UuidGenerator {

    /**
     * 生成UUID字符串，可选择是否移除连字符。
     *
     * @param removeHyphen 如果为true，则生成的UUID字符串中不包含连字符
     * @return UUID字符串
     */
    public static String generateUuid(boolean removeHyphen) {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();

        if (removeHyphen) {
            // 移除UUID字符串中的连字符
            uuidStr = uuidStr.replace("-", "");
        }

        return uuidStr;
    }
}
