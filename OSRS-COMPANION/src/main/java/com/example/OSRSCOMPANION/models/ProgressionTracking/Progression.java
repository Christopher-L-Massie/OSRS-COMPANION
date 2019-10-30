package com.example.OSRSCOMPANION.models.ProgressionTracking;
import com.example.OSRSCOMPANION.models.Player;
import com.example.OSRSCOMPANION.models.constants.timeValues;

import com.example.OSRSCOMPANION.models.data.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Entity
public class Progression {

    @Autowired
    private PlayerDao playerDao;

    //creates a day variable with correct number of milliseconds in a day
    private long day = timeValues.DAY.getMilliseconds();

    //properties

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

    //constructors


    //methods

    public void checkProgression(long days){


        Timestamp now = new Timestamp(System.currentTimeMillis());
        Timestamp check = new Timestamp(System.currentTimeMillis()-(days * day));




    }

    //constructors

}
