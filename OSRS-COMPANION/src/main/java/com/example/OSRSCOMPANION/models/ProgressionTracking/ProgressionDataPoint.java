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

    //|||METHODS|||

    //|||ACCESSORS|||

    public int getId() {
        return id;
    }

    public boolean isNormal() {
        return isNormal;
    }

    public boolean isHardcore() {
        return isHardcore;
    }

    public boolean isIronman() {
        return isIronman;
    }

    public boolean isUltimate() {
        return isUltimate;
    }

    public List<skillProgressionData> getProgressionData() {
        return progressionData;
    }
}
