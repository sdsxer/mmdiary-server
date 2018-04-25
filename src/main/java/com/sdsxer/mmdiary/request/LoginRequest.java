package com.sdsxer.mmdiary.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginRequest {

    @Size(min = 6, max = 20, message = "用户名长度必须在{min}-{max}个字符之间")
    @NotBlank(message = "用户名不能为空")
    private String username;
    @Pattern(regexp = "[a-zA-Z0-9]{32}", message = "密码格式错误")
    @NotBlank(message = "密码不能为空")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
