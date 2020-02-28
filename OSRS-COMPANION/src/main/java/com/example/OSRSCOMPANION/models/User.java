package com.example.OSRSCOMPANION.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames = {"userName"}))
public class User {

    //|||PROPERTIES|||

    @Id
    @GeneratedValue
    int id;

    @Column(name="userName")
    @Min(value = 3)
    @Max(value = 25)
    private String name;

    @Column(name = "password")
    @Min(value = 5)
    @Max(value = 25)
    private String password;

    private boolean isPrivate;


    //@OneToMany(cascade = CascadeType.ALL)
    //private List<Calculator> ownedCalculator = new ArrayList<>();

    /*
    //mapping out the user class with features that will eventually
    //be implemented but i'm commenting out
    //untill it's finished

    @OneToMany(cascade = CascadeType.All)
    private List<Tournament> ownedTournaments = new ArrayList<>();

    @OneToMany(cascade = CascadeType.All)
    private List<profitLog> ownedLogs = new ArrayList<>();

     */

    //empty constructor
    public User(){}

    public User(String name,String password, boolean isPrivate){
        this.name = name;
        this.password = password;
        this.isPrivate = isPrivate;
    }

    //accessors
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

}
