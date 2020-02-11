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
}
