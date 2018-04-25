package com.sdsxer.mmdiary.utils;

import com.sdsxer.mmdiary.common.ErrorCode;
import com.sdsxer.mmdiary.common.RestResponse;

public class ResponseUtils {

    public static <T> RestResponse createSuccessRestResponse(String message) {
        return new RestResponse<>(ErrorCode.SUCCESS, message, null, null);
    }

    public static <T> RestResponse createSuccessRestResponse(T data) {
        return new RestResponse<>(ErrorCode.SUCCESS, null, null, data);
    }

    public static <T> RestResponse createSuccessRestResponse(String message, T data) {
        return new RestResponse<>(ErrorCode.SUCCESS, message, null, data);
    }

    public static <T> RestResponse createErrorRestResponse(int code) {
        return new RestResponse<>(code, ErrorCode.CodeMessageMap.get(code),null, null);
    }

    public static <T> RestResponse createErrorRestResponse(int code, String message) {
        return new RestResponse<>(code, message, null, null);
    }

    public static <T> RestResponse createErrorRestResponse(Exception e) {
        return new RestResponse<>(ErrorCode.UNKNOWN_ERROR, ErrorCode.CodeMessageMap.get(ErrorCode.UNKNOWN_ERROR),
                e.getClass().getName(), null);
    }
}
