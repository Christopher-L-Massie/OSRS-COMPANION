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

    private String name;

    private String owner;

    @OneToMany(cascade = CascadeType.ALL)
    private List<item> trackedItems = new ArrayList<>();

    private boolean isPrivate;

    private boolean isOldschool;

    private boolean isDeleted;

    private String editCode;

    //|||CONSTRUCTORS|||
    public marginLog(){}

    public marginLog(String owner, boolean isPrivate, boolean isOldschool,String name,String editCode){
        this.owner = owner;
        this.isPrivate = isPrivate;
        this.isOldschool = isOldschool;
        this.isDeleted = false;
        this.name = name;
        this.editCode = editCode;
    }

    //|||METHODS|||

    //|||ACCESSORS|||
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean getIsPrivate(){
        return this.isPrivate;
    }

    public boolean getIsOldschool() {
        return this.isOldschool;
    }

    public boolean getIsDeleted() {
        return this.isDeleted;
    }

     public String getName() {
        return this.name;
     }

     public void setName(String name){
        this.name = name;
     }

     public int getId() {
        return this.id;
     }

     public String getEditCode() {return this.editCode;}
}
