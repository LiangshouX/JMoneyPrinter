package com.liangshou.jmoneyprinter.models.schema.request;

import com.liangshou.jmoneyprinter.models.schema.entity.VideoParams;
import com.liangshou.jmoneyprinter.models.schema.entity.VideoScriptParams;
import com.liangshou.jmoneyprinter.models.schema.entity.VideoTermsParams;
import lombok.Getter;
import lombok.Setter;

/**
 * @author X-L-S
 */
@Getter
@Setter
public class TaskVideoRequest {
    private VideoParams videoParams;
    private VideoScriptParams videoScriptParams;
    private VideoTermsParams videoTermsParams;

    // 构造方法
    public TaskVideoRequest(VideoParams videoParams) {
        this.videoParams = videoParams;
    }

    public TaskVideoRequest(VideoParams videoParams, VideoScriptParams videoScriptParams) {
        this.videoParams = videoParams;
        this.videoScriptParams = videoScriptParams;
    }

    public TaskVideoRequest(VideoParams videoParams, VideoTermsParams videoTermsParams) {
        this.videoParams = videoParams;
        this.videoTermsParams = videoTermsParams;
    }

    public TaskVideoRequest(VideoParams videoParams, VideoScriptParams videoScriptParams, VideoTermsParams videoTermsParams) {
        this.videoParams = videoParams;
        this.videoScriptParams = videoScriptParams;
        this.videoTermsParams = videoTermsParams;
    }

    // 重写toString方法，方便打印对象信息
    @Override
    public String toString() {
        return "TaskVideoRequest{" +
                "videoParams=" + videoParams +
                ", videoScriptParams=" + videoScriptParams +
                ", videoTermsParams=" + videoTermsParams +
                '}';
    }
}
