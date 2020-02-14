package com.example.OSRSCOMPANION.models.merchantHelp.itemMarginLog;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class itemLog {

    //|||PROPERTIES|||
    private int id;

    private String owner;

    @OneToMany(cascade = CascadeType.ALL)
    private List<item> trackedItems = new ArrayList<>();

    //|||CONSTRUCTORS|||
    public itemLog(){}

    public itemLog(String owner){
        this.owner = owner;
    }

    //|||METHODS|||

    //|||ACCESSORS|||
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
