package com.liangshou.jmoneyprinter.models.schema.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 代表视频素材信息的实体类
 *
 * @author X-L-S
 */
@Getter
@Setter
public class MaterialInfo {

    // 视频素材提供方，默认为"Pixels"
    @JsonProperty("provider")
    private String provider = "pixels";

    // 视频素材的URL链接
    @JsonProperty("url")
    private String url = "";

    // 视频素材的时长，单位通常是秒
    @JsonProperty("duration")
    private int duration = 0;

    // 默认构造方法
    public MaterialInfo() {
    }

    // 带参数的构造方法，用于直接设置所有属性
    public MaterialInfo(String provider, String url, int duration) {
        this.provider = provider;
        this.url = url;
        this.duration = duration;
    }
}
