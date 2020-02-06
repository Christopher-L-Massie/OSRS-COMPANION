package com.example.OSRSCOMPANION.models.databuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class clueData {

    //|||PROPERTIES|||

    @Id
    @GeneratedValue
    public int id;

    public Integer clueType;
    public long clueRank;
    public long clueScore;

    //|||CONSTRUCTORS|||

    public clueData(){}

    public clueData(Integer clueType,long clueRank,long clueScore){
        this.clueType = clueType;
        this.clueRank = clueRank;
        this.clueScore = clueScore;
    }

}
