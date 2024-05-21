package com.liangshou.jmoneyprinter.models.schema.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * 背景音乐检索响应类，封装了背景音乐查询结果的响应数据。
 *
 * @author X-L-S
 */
@Getter
@Setter
public class BgmRetrieveResponse extends BaseResponse {

    private BgmData data;

    /**
     * 默认构造函数，主要服务于JSON反序列化。
     */
    public BgmRetrieveResponse() {
        super();
    }

    /**
     * 带有所有字段的构造函数。
     *
     * @param status 响应状态码
     * @param message 响应消息
     * @param baseData 基础响应数据
     * @param bgmData 背景音乐数据
     */
    public BgmRetrieveResponse(int status, String message,
                               Map<String, Object> baseData, BgmData bgmData) {
        super(status, message, baseData);
        this.data = bgmData;
    }

    /**
     * 内部类，用于封装背景音乐的详细信息。
     */
    @Getter
    @Setter
    public static class BgmData {
        private List<BgmItem> items; // 背景音乐项列表
        private int total; // 总计背景音乐数量

        /**
         * 默认构造函数。
         */
        public BgmData() {
        }

        /**
         * 带参数的构造函数。
         *
         * @param items 背景音乐项列表
         * @param total 总计背景音乐数量
         */
        public BgmData(List<BgmItem> items, int total) {
            this.items = items;
            this.total = total;
        }
        // toString 方法，便于输出对象信息
        @Override
        public String toString() {
            return "BgmData{" +
                    "items=" + items +
                    ", total=" + total +
                    '}';
        }
    }

    /**
     * 内部类，表示单个背景音乐项。
     */
    @Getter
    @Setter
    public static class BgmItem {
        private String id; // 背景音乐ID
        private String name; // 背景音乐名称
        private String previewUrl; // 预览URL
        private String downloadUrl; // 下载URL
        private String format; // 文件格式
        private long duration; // 持续时长（毫秒）
        private String category; // 分类
        private String creator; // 创作者

        // toString 方法，便于输出对象信息
        @Override
        public String toString() {
            return "BgmItem{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", previewUrl='" + previewUrl + '\'' +
                    ", downloadUrl='" + downloadUrl + '\'' +
                    ", format='" + format + '\'' +
                    ", duration=" + duration +
                    ", category='" + category + '\'' +
                    ", creator='" + creator + '\'' +
                    '}';
        }
    }

    // 重写toString方法，方便查看对象信息
    @Override
    public String toString() {
        return "BgmRetrieveResponse{" +
                "status=" + getStatus() +
                ", message='" + getMessage() + '\'' +
                ", data=" + data +
                '}';
    }

}
