package com.sdsxer.mmdiary.common;

import java.util.HashMap;
import java.util.Map;

public class ErrorCode {

    public static final int SUCCESS = 200;

    public static final int BAD_REQUEST = 400;
    public static final int NOT_FOUND = 404;

    public static final int UNKNOWN_ERROR = 500;
    public static final int USER_NOT_EXIST = 501;
    public static final int PASSWORD_ERROR = 502;

    public static final Map<Integer, String> CodeMessageMap = new HashMap<>();

    static {
        CodeMessageMap.put(SUCCESS, "操作成功");
        CodeMessageMap.put(BAD_REQUEST, "无效的请求");
        CodeMessageMap.put(NOT_FOUND, "非法的请求地址");
        CodeMessageMap.put(UNKNOWN_ERROR, "未知错误");
        CodeMessageMap.put(USER_NOT_EXIST, "用户不存在");
        CodeMessageMap.put(PASSWORD_ERROR, "密码错误");
    }
}
