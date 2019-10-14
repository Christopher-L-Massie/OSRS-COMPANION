package com.example.OSRSCOMPANION.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Tournament {

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
    private List<String> tags;

    private boolean isPublic;

    public Tournament(){}

    public Tournament(Player owner, String tournamentName, String skill,boolean isPublic){
        this.owner = owner;
        this.tournamentName = tournamentName;
        this.skill = skill;
        this.isPublic = isPublic;
    }

    public void addTag(String tag){
        this.tags.add(tag);
    }

}
