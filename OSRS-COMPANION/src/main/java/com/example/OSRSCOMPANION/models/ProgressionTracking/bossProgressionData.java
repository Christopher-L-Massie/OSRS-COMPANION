package com.example.OSRSCOMPANION.models.ProgressionTracking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class bossProgressionData {

    //|||PROPERTIES
    
    @Id
    @GeneratedValue
    private int id;

    private Integer bossNumber;
    private String bossName;
    private long bossRankChange;
    private long bossScoreChange;
}
