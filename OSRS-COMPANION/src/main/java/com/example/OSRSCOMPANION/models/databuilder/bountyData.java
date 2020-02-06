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

    //|||METHODS|||

    //|||ACCESSSORS||

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBountyType() {
        return bountyType;
    }

    public void setBountyType(String bountyType) {
        this.bountyType = bountyType;
    }

    public long getBountyRank() {
        return bountyRank;
    }

    public void setBountyRank(long bountyRank) {
        this.bountyRank = bountyRank;
    }

    public long getBountyScore() {
        return bountyScore;
    }

    public void setBountyScore(long bountyScore) {
        this.bountyScore = bountyScore;
    }
}
