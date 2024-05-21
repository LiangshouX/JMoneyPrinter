package com.liangshou.jmoneyprinter.models.schema.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author X-L-S
 */
@Getter
@Setter
public class VideoScriptRequest {

    private String videoSubject;
    private String videoLanguage;
    private Integer paragraphNumber;

    // 默认构造方法，主要用于 JSON 反序列化
    public VideoScriptRequest() {
    }

    // 带参数的构造方法
    public VideoScriptRequest(String videoSubject, String videoLanguage, Integer paragraphNumber) {
        this.videoSubject = videoSubject;
        this.videoLanguage = videoLanguage;
        this.paragraphNumber = paragraphNumber;
    }

    @Override
    public String toString() {
        return "VideoScriptRequest{" +
                "videoSubject='" + videoSubject + '\'' +
                ", videoLanguage='" + videoLanguage + '\'' +
                ", paragraphNumber=" + paragraphNumber +
                '}';
    }
}
