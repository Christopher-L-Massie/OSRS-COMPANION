package com.example.OSRSCOMPANION.models.ProgressionTracking;

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

        Timestamp check = new Timestamp(System.currentTimeMillis()-(days * 86400000));

    }

    //constructors

}
