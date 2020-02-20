package com.example.OSRSCOMPANION.models.merchantHelp.itemMarginLog;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="marginLog")
@Entity
public class marginLog {

    //|||PROPERTIES|||
    @Id
    @GeneratedValue
    private int id;

    private String owner;

    @OneToMany(cascade = CascadeType.ALL)
    private List<item> trackedItems = new ArrayList<>();

    private boolean isPrivate;

    private boolean isOldschool;

    //|||CONSTRUCTORS|||
    public marginLog(){}

    public marginLog(String owner, boolean isPrivate, boolean isOldschool){
        this.owner = owner;
        this.isPrivate = isPrivate;
        this.isOldschool = isOldschool;
    }

    //|||METHODS|||

    //|||ACCESSORS|||
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isPrivate(){
        return this.isPrivate;
    }

    public boolean isOldschool() {
        return this.isOldschool;
    }
}
