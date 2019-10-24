package com.example.OSRSCOMPANION.models.ProgressionTracking;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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


}
