package com.example.OSRSCOMPANION.models.merchantHelp.itemMarginLog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class check {

    //|||Properties|||

    @Id
    @GeneratedValue
    private int id;

    private long buyPrice;

    private long sellPrice;

    private long margin;

    private Timestamp timeChecked;

    //|||Constructors|||
    public check(){}

    public check(long buyPrice, long sellPrice){
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.margin = sellPrice - buyPrice;
        this.timeChecked = new Timestamp(System.currentTimeMillis());
    }

    //|||Methods|||

    //|||Accessors|||
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

    public Timestamp getTimeChecked() {
        return timeChecked;
    }

    public void setTimeChecked(Timestamp timeChecked) {
        this.timeChecked = timeChecked;
    }
}
