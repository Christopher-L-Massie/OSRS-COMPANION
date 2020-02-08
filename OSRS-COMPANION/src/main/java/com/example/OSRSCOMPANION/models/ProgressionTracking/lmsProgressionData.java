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

    //|||METHODS|||

    //|||ACCESSORS|||

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getLmsRankChange() {
        return lmsRankChange;
    }

    public void setLmsRankChange(long lmsRankChange) {
        this.lmsRankChange = lmsRankChange;
    }

    public long getLmsScoreChange() {
        return lmsScoreChange;
    }

    public void setLmsScoreChange(long lmsScoreChange) {
        this.lmsScoreChange = lmsScoreChange;
    }
}
