package com.example.OSRSCOMPANION.models.ProgressionTracking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class clueProgressionData {

    //|||Properties|||

    @Id
    @GeneratedValue
    private int id;

    private Integer clueTypeNumber;
    private String clueTypeName;
    private long rankChange;
    private long scoreChange;
    private long days;

    //|||CONSTRUCTORS|||
    public clueProgressionData(){}

    public clueProgressionData(Integer clueTypeNumber,String clueTypeName,long rankChange,long scoreChange,long days){
        this.clueTypeName = clueTypeName;
        this.clueTypeName = clueTypeName;
        this.rankChange = rankChange;
        this.scoreChange = scoreChange;
        this.days = days;
    }

    //|||Methods|||

    //|||ACCESSORS|||

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getClueTypeNumber() {
        return clueTypeNumber;
    }

    public void setClueTypeNumber(Integer clueTypeNumber) {
        this.clueTypeNumber = clueTypeNumber;
    }

    public String getClueTypeName() {
        return clueTypeName;
    }

    public void setClueTypeName(String clueTypeName) {
        this.clueTypeName = clueTypeName;
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

    public long getDays() {
        return days;
    }

    public void setDays(long days) {
        this.days = days;
    }
}
