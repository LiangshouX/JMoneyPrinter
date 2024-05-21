package com.liangshou.jmoneyprinter.utils;

/**
 * 将秒数转换为小时、分钟、秒和毫秒的格式。
 *
 * @author X-L-S
 */
public class TimeConverter {

    /**
     * 将秒数转换为小时、分钟、秒和毫秒的格式。
     *
     * @param seconds 输入的秒数
     * @return 格式化的字符串，形如"00:00:00,000"
     */
    public static String convertSecondsToHMSM(long seconds) {
        long hours = seconds / 3600;
        seconds %= 3600;
        long minutes = seconds / 60;
        seconds %= 60;
        long milliseconds = (seconds * 1000) % 1000;

        return String.format("%02d:%02d:%02d,%03d", hours, minutes, seconds, milliseconds);
    }
}
