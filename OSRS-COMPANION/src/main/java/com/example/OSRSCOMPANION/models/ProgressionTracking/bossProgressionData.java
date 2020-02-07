package com.example.OSRSCOMPANION.models.ProgressionTracking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class bossProgressionData {

    //|||PROPERTIES|||

    @Id
    @GeneratedValue
    private int id;

    private Integer bossNumber;
    private String bossName;
    private long bossRankChange;
    private long bossScoreChange;

    //|||CONSTRUCTORS|||

    public bossProgressionData(){}

    public bossProgressionData(Integer bossNumber,String bossName,long bossRankChange,long bossScoreChange){
        this.bossNumber = bossNumber;
        this.bossName = bossName;
        this.bossRankChange = bossRankChange;
        this.bossScoreChange = bossScoreChange;
    }

    //|||METHODS|||

    //|||ACCESSORS|||

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getBossNumber() {
        return bossNumber;
    }

    public void setBossNumber(Integer bossNumber) {
        this.bossNumber = bossNumber;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public long getBossRankChange() {
        return bossRankChange;
    }

    public void setBossRankChange(long bossRankChange) {
        this.bossRankChange = bossRankChange;
    }

    public long getBossScoreChange() {
        return bossScoreChange;
    }

    public void setBossScoreChange(long bossScoreChange) {
        this.bossScoreChange = bossScoreChange;
    }
}
