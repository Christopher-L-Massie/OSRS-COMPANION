package com.example.OSRSCOMPANION.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tag {

    //|||PROPERTIES|||

    @Id
    @GeneratedValue
    int id;

    private String tag;

    //accessors
    public int getId(){
        return this.id;
    }

    public String getTag(){
        return this.tag;
    }

}
