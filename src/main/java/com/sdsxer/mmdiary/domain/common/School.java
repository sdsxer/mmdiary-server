package com.sdsxer.mmdiary.domain.common;

import com.sdsxer.mmdiary.domain.base.IdEntity;

import javax.persistence.Entity;

@Entity
public class School extends IdEntity {

    private String name;
    private int type; // 0x0001-Primary School，0x0010-Middle School
    private String location;
    private String telephone;
    private String zipCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
