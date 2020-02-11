package com.example.OSRSCOMPANION.models.merchantHelp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class entry {

    //|||Properties|||
    @Id
    @GeneratedValue
    private int id;

    private String itemName;
    private long amountBought;
    private long buyPrice;
    private long sellPrice;
    private long margin;
    private long goldInvestment;
    private long profit;

    //|||Constructors|||
    public entry(){}

    public entry(String itemName,long amountBought,long buyPrice, long sellPrice){
        this.itemName = itemName;
        this.amountBought = amountBought;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.margin = sellPrice- buyPrice;
        this.goldInvestment = buyPrice * amountBought;
        this.profit = this.margin * amountBought;
    }
}
