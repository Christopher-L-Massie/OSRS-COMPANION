package com.example.OSRSCOMPANION.models.ProgressionTracking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Progression {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private normalProgressionDataPoint normalProgression;

    @OneToOne
    private ironmanProgressionDataPoint ironmanProgression;

    @OneToOne
    private ultimateProgressionDataPoint ultimateProgession;

    @OneToOne
    private hardcoreProgressionDataPoint hardcoreProgression;
}
