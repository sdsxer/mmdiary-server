package com.sdsxer.mmdiary.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Profession {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String alphabeticIndex;

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

    public String getAlphabeticIndex() {
        return alphabeticIndex;
    }

    public void setAlphabeticIndex(String alphabeticIndex) {
        this.alphabeticIndex = alphabeticIndex;
    }
}
