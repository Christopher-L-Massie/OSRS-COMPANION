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
    

}
