package com.sdsxer.mmdiary.common;


public enum SystemError {

    Success(200, "操作成功"),

    BadRequest(400, "无效的请求"),
    Unauthorized(401, "没有权限"),
    Forbidden(403, "拒绝访问"),
    NotFound(404, "无效的请求路径"),
    UnknownError(500, "系统内部错误"),

    UserNotExist(1001, "用户名不存在"),
    MalformedUsername(1002, "用户名格式错误"),
    PasswordError(1003, "密码错误"),
    MalformedPassword(1004, "密码格式错误"),
    InvalidLoginInfo(1005, "无效的登录信息"),
    LoginInfoNotFound(1006, "没有找到登录信息"),
    TokenExpired(1007, "认证信息已过期"),
    MalformedToken(1008, "Token格式错误"),
    TokenNotFound(1009, "认证信息缺失"),
    InvalidToken(1010, "无效的认证信息"),
    AccountDisabled(1011, "账号已被禁用"),
    AccountLocked(1012, "账户已被锁定");


    private int code;
    private String message;

    SystemError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
