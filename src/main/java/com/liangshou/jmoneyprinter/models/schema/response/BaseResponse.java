package com.liangshou.jmoneyprinter.models.schema.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author X-L-S
 */
@Getter
@Setter
public class BaseResponse {

    private int status;
    private String message;
    private Map<String, Object> data;

    public BaseResponse() {
        // Default constructor
    }

    public BaseResponse(int status, String message, Map<String, Object> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
