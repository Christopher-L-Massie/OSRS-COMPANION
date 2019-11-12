package com.example.OSRSCOMPANION.models.ProgressionTracking;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProgressionDataPoint {

    //|||PROPERTIES|||
    @Id
    @GeneratedValue
    private int id;

    private boolean isNormal = false;

    private boolean isHardcore = false;

    private boolean isIronman = false;

    private boolean isUltimate = false;

    @OneToMany(cascade = CascadeType.ALL)
    private List<skillProgressionData> progressionData = new ArrayList<>();

    //|||CONSTRUCTORS|||

    //empty constructor for database functionality
    public ProgressionDataPoint(){}

    public ProgressionDataPoint(skillProgressionData skillProgressionData,boolean isNormal, boolean isIronman, boolean isHardcore, boolean isUltimate){
        this.progressionData.add(skillProgressionData);
        this.isNormal = isNormal;
        this.isIronman = isIronman;
        this.isHardcore = isHardcore;
        this.isUltimate = isUltimate;
    }

    //|||METHODS|||

    //|||ACCESSORS|||

    public int getId() {
        return this.id;
    }

    public boolean isNormal() {
        return this.isNormal;
    }

    public boolean isHardcore() {
        return this.isHardcore;
    }

    public boolean isIronman() {
        return this.isIronman;
    }

    public boolean isUltimate() {
        return this.isUltimate;
    }

    public List<skillProgressionData> getProgressionData() {
        return this.progressionData;
    }


}
