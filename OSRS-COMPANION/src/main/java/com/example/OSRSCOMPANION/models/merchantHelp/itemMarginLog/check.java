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
}
