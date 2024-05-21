package com.liangshou.jmoneyprinter.models.schema.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author X-L-S
 */
@Getter
@Setter
public class BgmUploadResponse extends BaseResponse {

    private BgmUploadData data;

    /**
     * 默认构造函数，主要服务于JSON反序列化。
     */
    public BgmUploadResponse() {
        super();
    }

    /**
     * 包含所有字段的构造函数。
     *
     * @param status 响应状态码
     * @param message 响应消息
     * @param baseData 基础响应数据
     * @param bgmUploadData 背景音乐上传数据
     */
    public BgmUploadResponse(int status, String message, Map<String, Object> baseData, BgmUploadData bgmUploadData) {
        super(status, message, baseData);
        this.data = bgmUploadData;
    }

    /**
     * 内部类，用于封装背景音乐上传的详细信息。
     */
    @Getter
    public static class BgmUploadData {
        private String fileId; // 上传后的文件ID
        private String url; // 背景音乐的访问URL
        private String name; // 文件名
        private String format; // 文件格式
        private long size; // 文件大小（字节）
        private String uploadTime; // 上传时间戳

        /**
         * 默认构造函数。
         */
        public BgmUploadData() {
        }

        /**
         * 带参数的构造函数。
         *
         * @param fileId 文件ID
         * @param url 访问URL
         * @param name 文件名
         * @param format 文件格式
         * @param size 文件大小（字节）
         * @param uploadTime 上传时间戳
         */
        public BgmUploadData(String fileId, String url, String name, String format, long size, String uploadTime) {
            this.fileId = fileId;
            this.url = url;
            this.name = name;
            this.format = format;
            this.size = size;
            this.uploadTime = uploadTime;
        }

        // toString 方法，便于输出对象信息
        @Override
        public String toString() {
            return "BgmUploadData{" +
                    "fileId='" + fileId + '\'' +
                    ", url='" + url + '\'' +
                    ", name='" + name + '\'' +
                    ", format='" + format + '\'' +
                    ", size=" + size +
                    ", uploadTime='" + uploadTime + '\'' +
                    '}';
        }
    }

    // 重写toString方法，方便查看对象信息
    @Override
    public String toString() {
        return "BgmUploadResponse{" +
                "status=" + getStatus() +
                ", message='" + getMessage() + '\'' +
                ", data=" + data +
                '}';
    }
}
