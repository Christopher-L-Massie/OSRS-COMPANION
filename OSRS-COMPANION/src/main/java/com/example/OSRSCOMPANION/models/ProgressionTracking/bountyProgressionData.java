package com.example.OSRSCOMPANION.models.ProgressionTracking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class bountyProgressionData {

    //|||Properties|||
    @Id
    @GeneratedValue
    private int id;

    private Integer bountyTypeNumber;
    private String bountyTypeName;
    private long bountyRankChange;
    private long bountyScoreChange;

    //|||Constructors|||
    public bountyProgressionData(){}

    public bountyProgressionData(Integer bountyTypeNumber,String bountyTypeName,long bountyRankChange,long bountyScoreChange){
        this.bountyTypeNumber = bountyTypeNumber;
        this.bountyTypeName = bountyTypeName;
        this.bountyRankChange = bountyRankChange;
        this.bountyScoreChange = bountyScoreChange;
    }

    //|||Methods|||

    //|||Accessors|||
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getBountyTypeNumber() {
        return bountyTypeNumber;
    }

    public void setBountyTypeNumber(Integer bountyTypeNumber) {
        this.bountyTypeNumber = bountyTypeNumber;
    }

    public String getBountyTypeName() {
        return bountyTypeName;
    }

    public void setBountyTypeName(String bountyTypeName) {
        this.bountyTypeName = bountyTypeName;
    }

    public long getBountyRankChange() {
        return bountyRankChange;
    }

    public void setBountyRankChange(long bountyRankChange) {
        this.bountyRankChange = bountyRankChange;
    }

    public long getBountyScoreChange() {
        return bountyScoreChange;
    }

    public void setBountyScoreChange(long bountyScoreChange) {
        this.bountyScoreChange = bountyScoreChange;
    }
}
