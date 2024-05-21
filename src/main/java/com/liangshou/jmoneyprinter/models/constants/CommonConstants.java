package com.liangshou.jmoneyprinter.models.constants;

import lombok.Getter;

/**
 * @author X-L-S
 */
@Getter
public class CommonConstants {

    // 定义标点符号数组
    public static final String[] PUNCTUATIONS = {
            "?", ",", ".", "、", ";", ":", "!", "…",
            "？", "，", "。", "、", "；", "：", "！", "..."
    };

    // 定义任务状态
    public static final int TASK_STATE_FAILED = -1;
    public static final int TASK_STATE_COMPLETE = 1;
    public static final int TASK_STATE_PROCESSING = 4;

    // 定义文件类型
    public static final String[] FILE_TYPE_VIDEOS = {"mp4", "mov", "mkv", "webm"};
    public static final String[] FILE_TYPE_IMAGES = {"jpg", "jpeg", "png", "bmp"};

    // 为了防止实例化这个类，构造方法设为私有
    private CommonConstants() {
        throw new AssertionError("This class should not be instantiated");
    }
}
