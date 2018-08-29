package com.sdsxer.mmdiary.domain.user;

import com.sdsxer.mmdiary.domain.base.IdEntity;

import javax.persistence.Entity;

@Entity
public class Profession extends IdEntity {

    private String name;
    private String alphabeticIndex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlphabeticIndex() {
        return alphabeticIndex;
    }

    public void setAlphabeticIndex(String alphabeticIndex) {
        this.alphabeticIndex = alphabeticIndex;
    }
}
