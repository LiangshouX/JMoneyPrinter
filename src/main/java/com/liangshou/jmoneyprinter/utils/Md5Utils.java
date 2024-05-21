package com.liangshou.jmoneyprinter.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具类，提供计算字符串 MD5 哈希值的方法。
 *
 * @author X-L-S
 */
public class Md5Utils {

    /**
     * 计算并返回给定字符串的MD5哈希值。
     *
     * @param input 原始字符串
     * @return MD5哈希值的16进制字符串表示形式
     */
    public static String generateMD5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b)); // 使用16进制格式化每个字节
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 Algorithm is not available", e);
        }
    }
}
