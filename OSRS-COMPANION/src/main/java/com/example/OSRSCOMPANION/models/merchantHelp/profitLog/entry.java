package com.example.OSRSCOMPANION.models.merchantHelp.profitLog;

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
    private long buyLimit;
    private long profitPerHour;

    //|||Constructors|||
    public entry(){}

    public entry(String itemName,long amountBought,long buyPrice, long sellPrice,long buyLimit){
        this.itemName = itemName;
        this.amountBought = amountBought;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.margin = sellPrice- buyPrice;
        this.goldInvestment = buyPrice * amountBought;
        this.profit = this.margin * amountBought;
        this.buyLimit = buyLimit;
        this.profitPerHour = margin * buyLimit / 4;
    }

    //|||METHODS|||

    //|||ACCESSORS|||

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public long getAmountBought() {
        return amountBought;
    }

    public void setAmountBought(long amountBought) {
        this.amountBought = amountBought;
    }

    public long getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(long buyPrice) {
        this.buyPrice = buyPrice;
    }

    public long getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(long sellPrice) {
        this.sellPrice = sellPrice;
    }

    public long getMargin() {
        return margin;
    }

    public void setMargin(long margin) {
        this.margin = margin;
    }

    public long getGoldInvestment() {
        return goldInvestment;
    }

    public void setGoldInvestment(long goldInvestment) {
        this.goldInvestment = goldInvestment;
    }

    public long getProfit() {
        return profit;
    }

    public void setProfit(long profit) {
        this.profit = profit;
    }

    public long getBuyLimit() {
        return buyLimit;
    }

    public void setBuyLimit(long buyLimit) {
        this.buyLimit = buyLimit;
    }

    public long getProfitPerHour() {
        return profitPerHour;
    }

    public void setProfitPerHour(long profitPerHour) {
        this.profitPerHour = profitPerHour;
    }
}
