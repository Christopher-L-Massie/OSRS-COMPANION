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
}
