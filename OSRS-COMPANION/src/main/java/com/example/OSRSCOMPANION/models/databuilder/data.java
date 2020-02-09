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

    //|||METHODS|||

    //|||ACCESSORS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}
