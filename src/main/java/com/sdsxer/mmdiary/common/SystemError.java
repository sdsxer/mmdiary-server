package com.sdsxer.mmdiary.common;


public enum SystemError {

    Success(200, "操作成功"),

    BadRequest(400, "无效的请求"),
    Unauthorized(401, "没有权限"),
    Forbidden(403, "拒绝访问"),
    NotFound(404, "无效的请求路径"),
    UnknownError(500, "系统内部错误"),

    UserNotExist(1001, "用户名不存在"),
    UsernameFormatError(1002, "用户名格式错误"),
    PasswordError(1003, "密码错误"),
    PasswordFormatError(1004, "密码格式错误"),
    InvalidLoginInfo(1005, "无效的登录信息"),
    TokenExpired(1006, "认证信息已过期"),
    InvalidToken(1007, "无效的认证信息"),
    TokenNotFound(1008, "认证信息缺失"),
    AccountDisabled(1009, "账号已被禁用"),
    LoginFailed(1010, "登录失败");

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
