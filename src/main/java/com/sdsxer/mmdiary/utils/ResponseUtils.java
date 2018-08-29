package com.sdsxer.mmdiary.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdsxer.mmdiary.response.RestResponse;
import com.sdsxer.mmdiary.common.SystemError;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ResponseUtils {

    public static RestResponse createSuccessResponse() {
        return new RestResponse(SystemError.Success);
    }

    public static <T> RestResponse createSuccessResponse(T data) {
        return new RestResponse<>(data);
    }

    public static RestResponse createErrorResponse(SystemError error) {
        return new RestResponse(error);
    }

    public static RestResponse createErrorResponse(SystemError error, String detail) {
        return new RestResponse(error, detail);
    }

    public static RestResponse createErrorResponse(Exception e) {
        return new RestResponse(SystemError.UnknownError, ExceptionUtils.printStackTraceToString(e));
    }

    public static void createErrorResponse(HttpServletResponse response, SystemError error) {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        RestResponse restResponse = createErrorResponse(error);
        try {
            responseJson(response, restResponse);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void responseJson(HttpServletResponse response, Object data) throws Exception {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(data);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(json.getBytes(StandardCharsets.UTF_8.name()));
            outputStream.flush();
            outputStream.close();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
