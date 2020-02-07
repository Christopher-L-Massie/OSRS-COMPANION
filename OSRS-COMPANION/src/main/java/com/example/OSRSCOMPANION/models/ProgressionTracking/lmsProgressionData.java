package com.example.OSRSCOMPANION.models.ProgressionTracking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class lmsProgressionData {

    //|||PROPERTIES|||

    @Id
    @GeneratedValue
    private int id;

    private long lmsRankChange;
    private long lmsScoreChange;

    //|||CONSTRUCTORS|||

    public lmsProgressionData(){}

    public lmsProgressionData(long lmsRankChange,long lmsScoreChange){
        this.lmsRankChange = lmsRankChange;
        this.lmsScoreChange = lmsScoreChange;
    }

}
