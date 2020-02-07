package com.example.OSRSCOMPANION.models.databuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class bossData {

    //|||PROPERTIES|||

    @Id
    @GeneratedValue
    private int id;

    private String bossName;
    private Integer bossNumber;
    private long bossRank;
    private long bossScore;

    //|||Constructors|||
    public bossData(){}

    public bossData(String bossName,Integer bossNumber,long bossRank,long bossScore){
        this.bossName = bossName;
        this.bossNumber = bossNumber;
        this.bossRank = bossRank;
        this.bossScore = bossScore;
    }

    //|||Methods|||

    //|||ACCESSORS|||

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public Integer getBossNumber() {
        return bossNumber;
    }

    public void setBossNumber(Integer bossNumber) {
        this.bossNumber = bossNumber;
    }

    public long getBossRank() {
        return bossRank;
    }

    public void setBossRank(long bossRank) {
        this.bossRank = bossRank;
    }

    public long getBossScore() {
        return bossScore;
    }

    public void setBossScore(long bossScore) {
        this.bossScore = bossScore;
    }
}
