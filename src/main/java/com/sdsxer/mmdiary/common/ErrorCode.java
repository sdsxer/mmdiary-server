package com.sdsxer.mmdiary.common;

import java.util.HashMap;
import java.util.Map;

public class ErrorCode {

    public static final int SUCCESS = 200;

    public static final int BAD_REQUEST = 400;
    public static final int NOT_FOUND = 404;

    public static final int UNKNOWN_ERROR = 500;

    public static final int USER_NOT_EXIST = 1001;
    public static final int PASSWORD_ERROR = 1002;
    public static final int CREDENTIALS_EXPIRED = 1003;
    public static final int AUTHENTICATION_FAILED = 1004;
    public static final int ACCOUNT_DISABLED = 1005;

    public static final Map<Integer, String> CodeMessageMap = new HashMap<>();

    static {
        CodeMessageMap.put(SUCCESS, "操作成功");
        CodeMessageMap.put(BAD_REQUEST, "无效的请求");
        CodeMessageMap.put(NOT_FOUND, "非法的请求地址");
        CodeMessageMap.put(UNKNOWN_ERROR, "未知错误");
        CodeMessageMap.put(USER_NOT_EXIST, "用户不存在");
        CodeMessageMap.put(PASSWORD_ERROR, "密码错误");
        CodeMessageMap.put(CREDENTIALS_EXPIRED, "用户凭据已过期");
        CodeMessageMap.put(AUTHENTICATION_FAILED, "无法验证用户");
        CodeMessageMap.put(ACCOUNT_DISABLED, "该账户被禁用");
    }
}
