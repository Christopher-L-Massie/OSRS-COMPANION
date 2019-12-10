package com.example.OSRSCOMPANION.models;


import javax.persistence.*;
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

    private int editCode;


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

}
