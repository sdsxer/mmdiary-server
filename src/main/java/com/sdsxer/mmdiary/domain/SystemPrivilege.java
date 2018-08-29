package com.sdsxer.mmdiary.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SystemPrivilege {

    public static String VIEW_ITEM = "VIEW_ITEM";
    public static String ADD_ITEM = "ADD_ITEM";
    public static String DELETE_ITEM = "DELETE_ITEM";
    public static String UPDATE_ITEM = "UPDATE_ITEM";
    public static String RELEASE_ITEM = "RELEASE_ITEM";
    public static String REVOKE_ITEM = "REVOKE_ITEM";

    public static String VIEW_EDITOR = "VIEW_EDITOR";
    public static String ADD_EDITOR = "ADD_EDITOR";
    public static String UPDATE_EDITOR = "UPDATE_EDITOR";
    public static String DELETE_EDITOR = "DELETE_EDITOR";
    public static String FREEZE_EDITOR = "FREEZE_EDITOR";

    public static String VIEW_USER = "VIEW_USER";
    public static String ADD_USER = "ADD_USER";
    public static String UPDATE_USER = "UPDATE_USER";
    public static String DELETE_USER = "DELETE_USER";
    public static String FREEZE_USER = "FREEZE_USER";

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String desc;

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
}
