package com.liangshou.jmoneyprinter.models.schema.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * 视频脚本响应类，用于封装从服务器获取的视频脚本相关数据。
 *
 * @author X-L-S
 */
@Getter
@Setter
public class VideoScriptResponse extends BaseResponse {

    private VideoScriptData data;

    /**
     * 默认构造函数，主要用于JSON反序列化。
     */
    public VideoScriptResponse() {
        super();
    }

    /**
     * 带有所有字段的构造函数。
     *
     * @param status 状态码
     * @param message 消息内容
     * @param baseData 基础数据
     * @param videoScriptData 视频脚本数据
     */
    public VideoScriptResponse(int status, String message, Map<String, Object> baseData, VideoScriptData videoScriptData) {
        super(status, message, baseData);
        this.data = videoScriptData;
    }

    /**
     * 内部类，用于封装视频脚本的具体数据。
     */
    @Getter
    @Setter
    public static class VideoScriptData {
        private String scriptContent; // 脚本内容
        private List<String> keywords; // 关键词列表
        private String language; // 脚本语言

        /**
         * 默认构造函数。
         */
        public VideoScriptData() {
        }

        /**
         * 带参数的构造函数。
         *
         * @param scriptContent 脚本内容
         * @param keywords 关键词列表
         * @param language 脚本语言
         */
        public VideoScriptData(String scriptContent, List<String> keywords, String language) {
            this.scriptContent = scriptContent;
            this.keywords = keywords;
            this.language = language;
        }

        // toString 方法，方便打印对象信息
        @Override
        public String toString() {
            return "VideoScriptData{" +
                    "scriptContent='" + scriptContent + '\'' +
                    ", keywords=" + keywords +
                    ", language='" + language + '\'' +
                    '}';
        }
    }

    // 重写toString方法，方便查看对象信息
    @Override
    public String toString() {
        return "VideoScriptResponse{" +
                "status=" + getStatus() +
                ", message='" + getMessage() + '\'' +
                ", data=" + data +
                '}';
    }
}
