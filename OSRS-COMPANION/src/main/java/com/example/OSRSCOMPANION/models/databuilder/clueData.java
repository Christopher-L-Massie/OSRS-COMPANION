package com.example.OSRSCOMPANION.models.databuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class clueData {

    //|||PROPERTIES|||

    @Id
    @GeneratedValue
    public int id;

    public Integer clueType;
    public long clueRank;
    public long clueScore;
}
