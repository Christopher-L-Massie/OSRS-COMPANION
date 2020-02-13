package com.example.OSRSCOMPANION.models.merchantHelp;

import com.example.OSRSCOMPANION.models.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class log {

    //|||PROPERTIES|||
    @Id
    @GeneratedValue
    private int id;


    private String owner;
    private long gold;

    @OneToMany(cascade = CascadeType.ALL)
    private List<entry> entries = new ArrayList<>();

    //|||CONSTRUCTORS|||
    public log(){}

    public log(String owner,long startingGold){
        this.owner = owner;
        this.gold = startingGold;
    }

    //|||METHODS|||


    //|||ACCESSORS|||
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getGold() {
        return gold;
    }

    public void setGold(long gold) {
        this.gold = gold;
    }
}
