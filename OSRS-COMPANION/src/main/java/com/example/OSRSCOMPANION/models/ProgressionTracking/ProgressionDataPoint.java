package com.example.OSRSCOMPANION.models.ProgressionTracking;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProgressionDataPoint {

    @Id
    @GeneratedValue
    private int id;

    private boolean isNormal = false;

    private boolean isHardcore = false;

    private boolean isIronman = false;

    private boolean isUltimate = false;

    @OneToMany(cascade = CascadeType.ALL)
    private List<skillProgressionData> progressionData = new ArrayList<>();

    //constructors

    //empty constructor for database functionality
    public ProgressionDataPoint(){}


}
