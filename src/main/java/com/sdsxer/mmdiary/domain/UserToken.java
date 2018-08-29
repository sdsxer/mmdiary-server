package com.sdsxer.mmdiary.domain;

public class UserToken {

    public static final String KEY_USER_ID = "userId";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_ROLE_ID = "roleId";

    private long userId;
    private String username;
    private int roleId;

    public UserToken() {

    }

    public UserToken(long userId, String username, int roleId) {
        this.userId = userId;
        this.username = username;
        this.roleId = roleId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
