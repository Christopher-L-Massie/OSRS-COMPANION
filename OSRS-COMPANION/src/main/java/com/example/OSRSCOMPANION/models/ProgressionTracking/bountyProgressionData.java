package com.example.OSRSCOMPANION.models.ProgressionTracking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class bountyProgressionData {

    @Id
    @GeneratedValue
    private int id;

    private Integer bountyTypeNumber;
    private String bountyTypeName;
    private long bountyRankChange;
    private long bountyScoreChange;
}
