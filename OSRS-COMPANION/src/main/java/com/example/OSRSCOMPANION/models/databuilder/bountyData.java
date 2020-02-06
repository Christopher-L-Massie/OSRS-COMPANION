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
}
