package com.liangshou.jmoneyprinter.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 字幕格式化工具类，用于生成SRT格式的字幕字符串。
 *
 * @author X-L-S
 */
public class SubtitleFormatter {
    private static final String TIME_FORMAT = "HH:mm:ss,SSS";

    /**
     * 将给定的索引、消息、开始时间和结束时间转换为SRT字幕格式的字符串。
     *
     * @param index       字幕的序号
     * @param content     字幕的内容
     * @param startTimeMs 开始时间，单位为毫秒
     * @param endTimeMs   结束时间，单位为毫秒
     * @return SRT格式的字幕字符串
     */
    public static String formatSubtitle(int index, String content, long startTimeMs, long endTimeMs) {
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC")); // 使用UTC时区以保持一致性

        String startTimeStr = sdf.format(new Date(startTimeMs));
        String endTimeStr = sdf.format(new Date(endTimeMs));

        // 格式化SRT字幕行
        return String.format("%d\n%s --> %s\n%s\n", index, startTimeStr, endTimeStr, content);
    }
}
