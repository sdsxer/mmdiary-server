package com.sdsxer.mmdiary.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SystemRole {

    public static String ADMIN = "ADMIN";
    public static String EDITOR = "EDITOR";
    public static String USER = "USER";

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String desc;

    @ManyToMany
    private List<SystemPrivilege> privileges;

    public SystemRole() {
        privileges = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<SystemPrivilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<SystemPrivilege> privileges) {
        this.privileges = privileges;
    }
}
