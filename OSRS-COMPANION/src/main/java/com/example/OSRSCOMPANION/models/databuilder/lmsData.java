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

    //|||Methods|||

    //|||Accessors|||

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getLmsRank() {
        return lmsRank;
    }

    public void setLmsRank(long lmsRank) {
        this.lmsRank = lmsRank;
    }

    public long getLmsScore() {
        return lmsScore;
    }

    public void setLmsScore(long lmsScore) {
        this.lmsScore = lmsScore;
    }
}
