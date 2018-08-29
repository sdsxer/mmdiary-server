package com.sdsxer.mmdiary.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterRequest {

    @Size(min = 6, max = 20, message = "用户名长度必须在{min}-{max}个字符之间")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Pattern(regexp = "[a-zA-Z0-9]{6,16}", message = "密码是由6~16位的字母或数字组成")
    @NotBlank(message = "密码不能为空")
    private String password;

    @Pattern(regexp = "(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\\\d{8}", message = "手机号格式错误")
    @NotBlank(message = "手机号不能为空")
    private String mobile;

    private String nickname;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
