package com.sdsxer.mmdiary.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdsxer.mmdiary.common.ErrorCode;
import com.sdsxer.mmdiary.common.RestResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ResponseUtils {

    public static <T> RestResponse createSuccessRestResponse(String message) {
        return new RestResponse<>(ErrorCode.SUCCESS, message, null, null);
    }

    public static <T> RestResponse createSuccessRestResponse(T data) {
        return new RestResponse<>(ErrorCode.SUCCESS, ErrorCode.CodeMessageMap.get(ErrorCode.SUCCESS), null, data);
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

    public static void responseJson(HttpServletResponse response, Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(object);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(json.getBytes(StandardCharsets.UTF_8.name()));
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {

        }
    }
}
