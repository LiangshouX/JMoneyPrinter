package com.liangshou.jmoneyprinter.models.schema.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * 视频关键词响应类，用于封装视频关键词查询的响应数据。
 *
 * @author X-L-S
 */
@Getter
@Setter
public class VideoTermsResponse extends BaseResponse {

    private VideoTermsData data;

    /**
     * 默认构造函数，主要服务于JSON反序列化。
     */
    public VideoTermsResponse() {
        super();
    }

    /**
     * 包含所有字段的构造函数。
     *
     * @param status 响应状态码
     * @param message 响应消息
     * @param baseData 基础响应数据
     * @param videoTermsData 视频关键词数据
     */
    public VideoTermsResponse(int status, String message, Map<String, Object> baseData, VideoTermsData videoTermsData) {
        super(status, message, baseData);
        this.data = videoTermsData;
    }

    /**
     * 内部类，用于封装视频关键词的详细信息。
     */
    @Getter
    @Setter
    public static class VideoTermsData {
        private List<String> terms; // 视频关键词列表
        private int total; // 关键词总数
        private String language; // 关键词提取的语言环境

        /**
         * 默认构造函数。
         */
        public VideoTermsData() {
        }

        /**
         * 带参数的构造函数。
         *
         * @param terms 关键词列表
         * @param total 关键词总数
         * @param language 语言环境
         */
        public VideoTermsData(List<String> terms, int total, String language) {
            this.terms = terms;
            this.total = total;
            this.language = language;
        }


        // toString 方法，便于输出对象信息
        @Override
        public String toString() {
            return "VideoTermsData{" +
                    "terms=" + terms +
                    ", total=" + total +
                    ", language='" + language + '\'' +
                    '}';
        }
    }

    // 重写toString方法，方便查看对象信息
    @Override
    public String toString() {
        return "VideoTermsResponse{" +
                "status=" + getStatus() +
                ", message='" + getMessage() + '\'' +
                ", data=" + data +
                '}';
    }
}
