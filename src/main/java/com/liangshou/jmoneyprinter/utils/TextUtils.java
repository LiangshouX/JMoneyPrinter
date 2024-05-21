package com.liangshou.jmoneyprinter.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 文本处理工具类，提供字符串相关操作的便捷方法, 包含检查字符串是否包含标点符号及按标点符号分割字符串的方法。
 *
 * @author X-L-S
 */
public class TextUtils {

    // 定义常用的标点符号集合，可以根据需要进行扩展
    private static final String PUNCTUATIONS_REGEX = "\\p{Punct}";

    /**
     * 检查字符串中是否包含标点符号。
     *
     * @param word 待检查的字符串
     * @return 如果字符串包含标点符号则返回true，否则返回false
     */
    public static boolean containsPunctuation(String word) {
        return Pattern.compile(PUNCTUATIONS_REGEX).matcher(word).find();
    }

    /**
     * 按照标点符号分割字符串为子串列表。
     * 特别处理了数字中的小数点不应作为分隔符的情况。
     *
     * @param text 待分割的原始字符串
     * @return 分割后的字符串列表
     */
    public static List<String> splitByPunctuations(String text) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char prevChar = ' ';
        char nextChar;
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            nextChar = i < text.length() - 1 ? text.charAt(i + 1) : ' ';

            if (currentChar == '\n') {
                result.add(sb.toString().trim());
                sb.setLength(0);
            } else if (i > 0 && containsPunctuation(String.valueOf(currentChar))) {
                if (!(prevChar >= '0' && prevChar <= '9' && currentChar == '.' && nextChar >= '0' && nextChar <= '9')) {
                    result.add(sb.toString().trim());
                    sb.setLength(0);
                } else {
                    sb.append(currentChar);
                }
            } else {
                sb.append(currentChar);
            }
            prevChar = currentChar;
        }
        result.add(sb.toString().trim()); // 添加最后一个部分
        return result;
    }

    /**
     * 判断字符串是否为空 或 仅包含空白字符。
     *
     * @param str 待检查的字符串
     * @return 如果字符串为null或仅包含空白字符则返回true，否则返回false
     */
    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }
}
