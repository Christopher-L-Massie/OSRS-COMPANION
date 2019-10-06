package com.example.OSRSCOMPANION.models.calculatorBlocks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Step {

    @Id
    @GeneratedValue
    int id;

    private int firstValue;

    private int secondValue;

    private String operator;

    private int stepResult;

    public Step(){}

    public Step(int firstValue,int secondValue,String operator){
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.operator = operator;

        if (this.operator.equals("+")){
            this.stepResult = this.firstValue + this.secondValue;
        } else if (this.operator.equals("-")){
            this.stepResult = this.firstValue - this.secondValue;
        } else if (this.operator.equals("*")){
            this.stepResult = this.firstValue / this.secondValue;
        } else if (this.operator.equals("/")){
            this.stepResult = this.firstValue / this.secondValue;
        } else {
            System.out.println("This is not a valid operator. Use: + - * /");
        }
    }

    public int getStepResult(){return this.stepResult;}

}
