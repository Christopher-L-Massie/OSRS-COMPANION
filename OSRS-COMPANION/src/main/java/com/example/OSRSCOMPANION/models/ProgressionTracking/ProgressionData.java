package com.example.OSRSCOMPANION.models.ProgressionTracking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProgressionData {

    //|||PROPERTIES|||

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int dataType;
    private long rankChange;
    private long scoreChange;

    //|||CONSTRUCTORS|||
    
    ProgressionData(){}

    ProgressionData(String name,int dataType,long rankChange,long scoreChange){
        this.name = name;
        this.dataType = dataType;
        this.rankChange = rankChange;
        this.scoreChange = scoreChange;
    }

    //|||METHODS|||

    //|||ACCESSORS|||

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

    public long getRankChange() {
        return rankChange;
    }

    public void setRankChange(long rankChange) {
        this.rankChange = rankChange;
    }

    public long getScoreChange() {
        return scoreChange;
    }

    public void setScoreChange(long scoreChange) {
        this.scoreChange = scoreChange;
    }
}
