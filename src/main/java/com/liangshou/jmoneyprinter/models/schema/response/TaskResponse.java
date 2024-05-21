package com.liangshou.jmoneyprinter.models.schema.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author X-L-S
 */
@Getter
@Setter
public class TaskResponse extends BaseResponse {
    private TaskResponseData data;

    // 默认构造
    public TaskResponse() {
        super();
    }

    // 含参构造
    public TaskResponse(int status, String message, Map<String, Object> baseData, TaskResponseData taskData) {
        super(status, message, baseData);
        this.data = taskData;
    }

    // 表示响应的特定数据部分的内部类
    @Getter
    @Setter
    public static class TaskResponseData {
        private String task_id;

        public TaskResponseData(String taskId) {
            this.task_id = taskId;
        }

        @Override
        public String toString() {
            return "TaskResponseData{" +
                    "taskId='" + task_id + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TaskResponse{" +
                "status=" + getStatus() +
                ", message='" + getMessage() + '\'' +
                ", data=" + data +
                '}';
    }
}
