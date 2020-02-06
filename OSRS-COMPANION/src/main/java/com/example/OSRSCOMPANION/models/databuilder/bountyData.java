package com.example.OSRSCOMPANION.models.databuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class bountyData {

    //|||PROPERTIES|||

    @Id
    @GeneratedValue
    private int id;

    public String bountyType;
    public long bountyRank;
    public long bountyScore;

    //|||CONSTRUCTORS|||

    public bountyData(){}

    public bountyData(String bountyType,long bountyRank,long bountyScore){
        this.bountyType = bountyType;
        this.bountyRank = bountyRank;
        this.bountyScore = bountyScore;
    }
}
