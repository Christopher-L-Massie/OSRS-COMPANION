package com.example.OSRSCOMPANION.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Tournament {

    //|||PROPERTIES|||

    @Id
    @GeneratedValue
    int id;

    @OneToOne
    private Player owner;

    private String tournamentName;

    private String skill;


    @ManyToMany
    private List<Player> contestants;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;

    private boolean isPublic;

    public Tournament(){}

    public Tournament(Player owner, String tournamentName, String skill,boolean isPublic, String tag){
        this.owner = owner;
        this.tournamentName = tournamentName;
        this.skill = skill;
        this.isPublic = isPublic;

    }

    public void addTag(Tag tag){
        this.tags.add(tag);
    }

}
