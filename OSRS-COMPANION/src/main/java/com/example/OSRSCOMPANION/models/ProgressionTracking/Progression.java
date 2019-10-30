package com.example.OSRSCOMPANION.models.ProgressionTracking;

import com.example.OSRSCOMPANION.models.Player;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "progression")
public class Progression {

    //|||PROPERTIES|||

    @Id
    @GeneratedValue
    private int id;

    /*
    Links the Progression object with the player object that owns it.
    */
    @OneToOne
    @MapsId
    private Player player;

    @OneToMany(cascade = CascadeType.ALL)
    private List<normalProgressionDataPoint> normalProgression;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ironmanProgressionDataPoint> ironmanProgression;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ultimateProgressionDataPoint> ultimateProgession;

    @OneToMany(cascade = CascadeType.ALL)
    private List<hardcoreProgressionDataPoint> hardcoreProgression;


    //|||METHODS|||


    //|||CONSTRUCTORS|||

    //empty for database functionality
    public Progression(){}

    //|||ACCESSORS|||

    public int getId() {
        return id;
    }

    public List getNormalProgression() {
        return normalProgression;
    }

    public List getIronmanProgression() {
        return ironmanProgression;
    }

    public List getUltimateProgession() {
        return ultimateProgession;
    }

    public List getHardcoreProgression() {
        return hardcoreProgression;
    }

    public Player getPlayer() {
        return player;
    }
}
