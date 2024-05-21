package com.liangshou.jmoneyprinter.models.schema.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author X-L-S
 */
@Getter
@Setter
public class VideoTermsRequest {

    private String videoSubject;
    private String videoScript;
    private Integer amount;

    // 默认构造方法
    public VideoTermsRequest() {
    }

    // 带参数的构造方法，允许初始化所有属性
    public VideoTermsRequest(String videoSubject, String videoScript, Integer amount) {
        this.videoSubject = videoSubject;
        this.videoScript = videoScript;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "VideoTermsRequest{" +
                "videoSubject='" + videoSubject + '\'' +
                ", videoScript='" + videoScript + '\'' +
                ", amount=" + amount +
                '}';
    }
}
