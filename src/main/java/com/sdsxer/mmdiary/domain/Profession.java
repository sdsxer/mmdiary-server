package com.sdsxer.mmdiary.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Profession {

    @Id
    @GeneratedValue
    @JsonIgnore
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
