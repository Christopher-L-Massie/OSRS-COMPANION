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
}
