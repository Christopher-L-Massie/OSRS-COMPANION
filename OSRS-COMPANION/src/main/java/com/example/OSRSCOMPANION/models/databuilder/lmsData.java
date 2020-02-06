package com.example.OSRSCOMPANION.models.databuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class lmsData {

    //|||PROPERTIES|||

    @Id
    @GeneratedValue
    private int id;

    private long lmsRank;
    private long lmsScore;

    //|||Constructors|||
    public lmsData(){}

    public lmsData(long lmsRank, long lmsScore){
        this.lmsRank = lmsRank;
        this.lmsScore = lmsScore;
    }
}
