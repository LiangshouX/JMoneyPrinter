package com.liangshou.jmoneyprinter.models.schema.enums;

import lombok.Getter;

/**
 * 关于视频尺寸(类型)的枚举类
 * @author X-L-S
 */
@Getter
public enum VideoAspect {

    LANDSCAPE("16:9"),

    PORTRAIT("9:16"),

    SQUARE("1:1");

    private final String resolution;

    VideoAspect(String resolution) {
        this.resolution = resolution;
    }
}
