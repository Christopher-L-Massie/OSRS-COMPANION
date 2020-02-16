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
    private String userName;

    @Column(name = "password")
    @Min(value = 5)
    @Max(value = 25)
    private String password;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Calculator> ownedCalculator = new ArrayList<>();

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

    public User(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    //accessors
    public String getUserName(){return this.userName;}




}
