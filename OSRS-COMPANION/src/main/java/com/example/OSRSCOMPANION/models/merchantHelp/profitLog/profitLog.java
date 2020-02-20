package com.example.OSRSCOMPANION.models.merchantHelp.profitLog;

import com.example.OSRSCOMPANION.models.merchantHelp.profitLog.entry;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class profitLog {

    //|||PROPERTIES|||
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String owner;

    private long gold;

    private long startingGold;

    @OneToMany(cascade = CascadeType.ALL)
    private List<entry> entries = new ArrayList<>();

    private boolean isPrivate;

    private boolean isOldschool;

    private boolean isDeleted;

    //|||CONSTRUCTORS|||
    public profitLog(){}

    public profitLog(String owner, long startingGold, boolean isPrivate, boolean isOldschool, String name){
        this.owner = owner;
        this.gold = startingGold;
        this.startingGold = startingGold;
        this.isPrivate = isPrivate;
        this.isOldschool = isOldschool;
        this.isDeleted = false;
        this.name = name;
    }

    //|||METHODS|||

    public void addEntry(entry entry){
        this.entries.add(entry);
    }


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

    public boolean isPrivate(){
        return this.isPrivate;
    }

    public boolean isOldschool() {
        return this.isOldschool;
    }

    public boolean isDeleted() {
        return this.isDeleted();
    }

    public long getStartingGold() {
        return this.startingGold;
    }

    public String getName(){
        return this.name;
    }
}
