package com.sdsxer.mmdiary.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class RestResponse<T> implements Serializable {

    private boolean status;
    private int code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String detail;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public RestResponse(int code, String message, String detail, T data) {
        this.status = (code == ErrorCode.SUCCESS);
        this.code = code;
        this.message = message;
        this.detail = detail;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
