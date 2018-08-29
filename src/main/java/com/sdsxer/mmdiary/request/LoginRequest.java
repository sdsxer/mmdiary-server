package com.sdsxer.mmdiary.request;

import com.sdsxer.mmdiary.exception.PasswordFormatException;
import com.sdsxer.mmdiary.exception.UsernameFormatException;
import org.springframework.util.StringUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginRequest {

    @Size(min = 6, max = 20, message = "用户名长度必须在{min}-{max}个字符之间")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Pattern(regexp = "[a-zA-Z0-9]{6,16}", message = "密码是由6~16位的字母或数字组成")
    @NotBlank(message = "密码不能为空")
    private String password;

    public LoginRequest() {

    }

    public LoginRequest(@Valid String username, @Valid String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(@Valid String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(@Valid String password) {
        this.password = password;
    }

    public void checkLegality() throws UsernameFormatException, PasswordFormatException {
        if(StringUtils.isEmpty(username)) {
            throw new UsernameFormatException("用户名不能为空");
        }
        if(StringUtils.isEmpty(password)) {
            throw new PasswordFormatException("密码不能为空");
        }
    }
}
