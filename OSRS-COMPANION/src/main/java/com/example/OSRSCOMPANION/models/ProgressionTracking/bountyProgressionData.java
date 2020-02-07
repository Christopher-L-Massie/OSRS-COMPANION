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
}
