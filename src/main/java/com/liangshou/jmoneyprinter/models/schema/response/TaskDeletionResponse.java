package com.liangshou.jmoneyprinter.models.schema.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * @author X-L-S
 */
@Getter
@Setter
public class TaskDeletionResponse extends BaseResponse {
    private int state;
    private int progress;
    private List<String> videos;
    private List<String> combinedVideos;

    // Default constructor for JSON deserialization libraries
    public TaskDeletionResponse() {
        super();
    }

    // Constructor with all fields
    public TaskDeletionResponse(int status, String message, Map<String, Object> data,
                                int state, int progress, List<String> videos, List<String> combinedVideos) {
        super(status, message, data);
        this.state = state;
        this.progress = progress;
        this.videos = videos;
        this.combinedVideos = combinedVideos;
    }

    @Override
    public String toString() {
        return "TaskDeletionResponse{" +
                "status=" + getStatus() +
                ", message='" + getMessage() + '\'' +
                ", data=" + getData() +
                ", state=" + state +
                ", progress=" + progress +
                ", videos=" + videos +
                ", combinedVideos=" + combinedVideos +
                '}';
    }
}
