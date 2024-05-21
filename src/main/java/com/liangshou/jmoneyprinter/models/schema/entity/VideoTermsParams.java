package com.liangshou.jmoneyprinter.models.schema.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/**
 * @author X-L-S
 */
@Getter
@Setter
public class VideoTermsParams {

    private Optional<String> videoSubject = Optional.empty();
    private Optional<String> videoScript = Optional.empty();
    private Optional<Integer> amount = Optional.of(5); // 默认关键词数量为5

    // 构造方法
    public VideoTermsParams() {
        // 默认构造方法
    }

    // 带参数的构造方法，允许初始化所有属性
    public VideoTermsParams(String videoSubject, String videoScript, Integer amount) {
        this.videoSubject = Optional.ofNullable(videoSubject);
        this.videoScript = Optional.ofNullable(videoScript);
        this.amount = Optional.ofNullable(amount);
    }

    // 重写toString方法，方便打印对象信息
    @Override
    public String toString() {
        return "VideoTermsParams{" +
                "videoSubject=" + videoSubject +
                ", videoScript=" + videoScript +
                ", amount=" + amount +
                '}';
    }
}
