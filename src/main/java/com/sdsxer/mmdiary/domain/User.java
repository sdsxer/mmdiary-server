package com.sdsxer.mmdiary.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    public enum Status {
        NORMAL(0), DISABLED(1), LOCKED(2);

        int value;

        Status(int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }
    }

    enum Sex {
        UNKNOWN(0), MALE(1), FEMALE(2);

        int value;

        Sex(int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }
    }

    @JsonIgnore
    @Id
    @GeneratedValue
    protected long id;
    @Column(nullable = false)
    protected String username;
    private String nickname;
    @JsonIgnore
    @Column(nullable = false)
    protected String password;
    @Column(nullable = false)
    protected String mobile;
    private String email;
    @Column(columnDefinition = "integer default 0")
    private int sex;
    private Date birthday;
    private String avatarUrl;
    @JsonIgnore
    @Column(columnDefinition = "integer default 0")
    protected int status;
    @JsonIgnore
    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date createTime;
    @JsonIgnore
    private Date lastModifyTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany
    private List<EducationExperience> educationExperiences;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne(fetch = FetchType.LAZY)
    private Area hometown;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne(fetch = FetchType.LAZY)
    private Area residence;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne(fetch = FetchType.LAZY)
    private Profession profession;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToMany
    private List<User> friends;

    @JsonIgnore
    @ManyToOne
    protected SystemRole role;

    public User() {
        createTime = new Date();
        sex = Sex.UNKNOWN.value;
        status = Status.NORMAL.value;
        educationExperiences = new ArrayList<>();
        friends = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public List<EducationExperience> getEducationExperiences() {
        return educationExperiences;
    }

    public void setEducationExperiences(List<EducationExperience> educationExperiences) {
        this.educationExperiences = educationExperiences;
    }

    public Area getHometown() {
        return hometown;
    }

    public void setHometown(Area hometown) {
        this.hometown = hometown;
    }

    public Area getResidence() {
        return residence;
    }

    public void setResidence(Area residence) {
        this.residence = residence;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public SystemRole getRole() {
        return role;
    }

    public void setRole(SystemRole role) {
        this.role = role;
    }
}
