package com.example.OSRSCOMPANION.models.databuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class data {

    //|||PROPERTIES|||
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int dataType;
    private long rank;
    private long score;

    //|||CONSTRUCTORS|||
    public data(){}

    public data(String name,int dataType,long rank,long score){
        this.name = name;
        this.dataType = dataType;
        this.rank = rank;
        this.rank = rank;
    }
}
