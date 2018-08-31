package com.sdsxer.mmdiary.dto;

import com.sdsxer.mmdiary.domain.User;

import java.util.Date;

public class UserDto {

    private String nickname;
    private String username;
    private String mobile;
    private int sex;
    private String avatarUrl;
    private Date birthday;

    public UserDto(User user) {
        this.nickname = user.getNickname();
        this.username = user.getUsername();
        this.avatarUrl = user.getAvatarUrl();
        this.mobile = user.getMobile();
        this.sex = user.getSex();
        this.birthday = user.getBirthday();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
