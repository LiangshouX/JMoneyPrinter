package com.liangshou.jmoneyprinter.models.schema.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.liangshou.jmoneyprinter.models.schema.enums.VideoAspect;
import com.liangshou.jmoneyprinter.models.schema.enums.VideoConcatMode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.liangshou.jmoneyprinter.models.schema.enums.VideoAspect.PORTRAIT;
import static com.liangshou.jmoneyprinter.models.schema.enums.VideoConcatMode.RANDOM;

/**
 * 视频参数相关的实体类，封装了视频处理任务所需的基本配置信息。
 *
 * @author X-L-S
 */
@Getter
@Setter
public class VideoParams {

    private String videoSubject;
    private String videoScript;
    private List<String> videoTerms; // 假设视频关键词可以是一个字符串列表
    private VideoAspect videoAspect = PORTRAIT;
    private VideoConcatMode videoConcatMode = RANDOM;
    private int videoClipDuration = 5;
    private int videoCount = 1;
    private String videoSource = "pexels";
    private List<MaterialInfo> videoMaterials;
    private String videoLanguage = ""; // 自动检测
    private String voiceName = "";
    private float voiceVolume = 1.0f;
    private String bgmName = "random";
    private String bgmFile = "";
    private float bgmVolume = 0.2f;
    private boolean subtitleEnabled = true;
    private String subtitlePosition = "bottom";
    private String fontName = "STHeitiMedium.ttc";
    private String textForeColor = "#FFFFFF";
    private String textBackgroundColor = "transparent";
    private int fontSize = 60;
    private String strokeColor = "#000000";
    private float strokeWidth = 1.5f;
    private int nThreads = 2;
    private int paragraphNumber = 1;

    // 构造方法
    @JsonCreator
    public VideoParams(
            @JsonProperty("video_subject") String videoSubject,
            @JsonProperty("video_script") String videoScript,
            @JsonProperty("video_terms") List<String> videoTerms,
            @JsonProperty("video_aspect") VideoAspect videoAspect,
            @JsonProperty("video_concat_mode") VideoConcatMode videoConcatMode,
            @JsonProperty("video_clip_duration") int videoClipDuration,
            @JsonProperty("video_count") int videoCount,
            @JsonProperty("video_source") String videoSource,
            @JsonProperty("video_materials") List<MaterialInfo> videoMaterials,
            @JsonProperty("video_language") String videoLanguage,
            @JsonProperty("voice_name") String voiceName,
            @JsonProperty("voice_volume") float voiceVolume,
            @JsonProperty("bgm_name") String bgmName,
            @JsonProperty("bgm_file") String bgmFile,
            @JsonProperty("bgm_volume") float bgmVolume,
            @JsonProperty("subtitle_enabled") Boolean subtitleEnabled,
            @JsonProperty("subtitle_position") String subtitlePosition,
            @JsonProperty("font_name") String fontName,
            @JsonProperty("text_color") String textForeColor,
            @JsonProperty("text_background_color") String textBackgroundColor,
            @JsonProperty("font_size") int fontSize,
            @JsonProperty("stroke_color") String strokeColor,
            @JsonProperty("stroke_width") float strokeWidth,
            @JsonProperty("n_threads") int nThreads,
            @JsonProperty("paragraph_number") int paragraphNumber) {
        this.videoSubject = videoSubject;
        this.videoScript = videoScript;
        this.videoTerms = videoTerms;
        this.videoAspect = videoAspect != null ? videoAspect : PORTRAIT;
        this.videoConcatMode = videoConcatMode != null ? videoConcatMode : RANDOM;
        this.videoClipDuration = videoClipDuration;
        this.videoCount = videoCount;
        this.videoSource = videoSource != null ? videoSource : "pexels";
        this.videoMaterials = videoMaterials;
        this.videoLanguage = videoLanguage;
        this.voiceName = voiceName;
        this.voiceVolume = voiceVolume;
        this.bgmName = bgmName;
        this.bgmFile = bgmFile;
        this.bgmVolume = bgmVolume;
        this.subtitleEnabled = subtitleEnabled != null ? subtitleEnabled : true;
        this.subtitlePosition = subtitlePosition != null ? subtitlePosition : "bottom";
        this.fontName = fontName != null ? fontName : "STHeitiMedium.ttc";
        this.textForeColor = textForeColor != null ? textForeColor : "#FFFFFF";
        this.textBackgroundColor = textBackgroundColor != null ? textBackgroundColor : "transparent";
        this.fontSize = fontSize;
        this.strokeColor = strokeColor != null ? strokeColor : "#000000";
        this.strokeWidth = strokeWidth;
        this.nThreads = nThreads;
        this.paragraphNumber = paragraphNumber;
    }
}
