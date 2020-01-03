package com.example.OSRSCOMPANION.models.Tournaments;


import com.example.OSRSCOMPANION.models.Player;
import com.example.OSRSCOMPANION.models.Tag;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.List;

@Entity
public class Tournament {

    //|||PROPERTIES|||

    @Id
    @GeneratedValue
    int id;

    /*
    //will be added back once account system is added later
    @OneToOne
    private Player owner;
    */

    private String tournamentName;

    private String skill;

    private String editCode;

    private Timestamp tournamentStartTime;

    private Timestamp tournamentEndTime;


    @ManyToMany
    private List<Player> contestants;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;

    private boolean isPublic;

    public Tournament(){}

    public Tournament(String tournamentName, String skill,boolean isPublic, String tag){
        this.tournamentName = tournamentName;
        this.skill = skill;
        this.isPublic = isPublic;
    }

    public void addTag(Tag tag){
        this.tags.add(tag);
    }

    public void addContestant(Player player){
        this.contestants.add(player);
    }



}
