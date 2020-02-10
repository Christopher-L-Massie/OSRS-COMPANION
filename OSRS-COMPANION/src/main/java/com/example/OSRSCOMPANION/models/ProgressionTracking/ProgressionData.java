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
}
