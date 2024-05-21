package com.liangshou.jmoneyprinter.models.schema.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/**
 * @author X-L-S
 */
@Getter
@Setter
public class VideoScriptParams {

    private Optional<String> videoSubject = Optional.of("春天的花海"); // 默认值
    private Optional<String> videoLanguage = Optional.empty(); // 默认为空，代表自动检测
    private Optional<Integer> paragraphNumber = Optional.of(1); // 默认段落数为1

    // 默认构造方法
    public VideoScriptParams() {

    }

    // 带参数的构造方法，允许初始化所有属性
    public VideoScriptParams(String videoSubject, String videoLanguage, Integer paragraphNumber) {
        this.videoSubject = Optional.ofNullable(videoSubject);
        this.videoLanguage = Optional.ofNullable(videoLanguage);
        this.paragraphNumber = Optional.ofNullable(paragraphNumber);
    }

    // 重写toString方法，方便打印对象信息
    @Override
    public String toString() {
        return "VideoScriptParams{" +
                "videoSubject=" + videoSubject +
                ", videoLanguage=" + videoLanguage +
                ", paragraphNumber=" + paragraphNumber +
                '}';
    }
}
