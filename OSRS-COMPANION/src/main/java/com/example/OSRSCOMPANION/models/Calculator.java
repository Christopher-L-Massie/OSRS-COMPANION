package com.example.OSRSCOMPANION.models;

import com.example.OSRSCOMPANION.models.calculatorBlocks.Step;

import javax.persistence.*;
import java.util.List;

@Entity
public class Calculator {

    //|||PROPERTIES|||

    @Id
    @GeneratedValue
    int id;

    private String calculatorName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Step> stepsNeeded;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;

    private int likes;

    private int dislikes;


    public Calculator(){}

    public Calculator(String calculatorName){
        this.calculatorName = calculatorName;
    }

    //method to add steps to stepsNeeded
    public void addStep(int firstValue,int secondValue,String operator){
        this.stepsNeeded.add(new Step(firstValue,secondValue,operator));
    }

    public void addLike(){
        this.likes =+ 1;
    }

    public void addDislike(){
        this.dislikes =+ 1;
    }

    public void addTag(Tag tag){
        this.tags.add(tag);
    }


    /*
    //work in progress
    public int calculate(){
        for (Step step : stepsNeeded){

        }
        return 0;
    }
     */




}
