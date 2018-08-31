package com.sdsxer.mmdiary.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Food {

    @Id
    @GeneratedValue
    private int id;
}
