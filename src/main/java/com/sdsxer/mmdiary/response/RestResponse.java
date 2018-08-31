package com.sdsxer.mmdiary.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sdsxer.mmdiary.common.SystemError;

import java.io.Serializable;

public class RestResponse<T> implements Serializable {

    private boolean status;
    private int code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String detail;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    // success
    public RestResponse(T data) {
        this.status = true;
        this.code = SystemError.Success.getCode();
        this.message = SystemError.Success.getMessage();
        this.data = data;
    }

    // error
    public RestResponse(SystemError error) {
        this.status = error == SystemError.Success;
        this.code = error.getCode();
        this.message = error.getMessage();
    }

    // error
    public RestResponse(SystemError error, String detail) {
        this(error);
        this.detail = detail;
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
