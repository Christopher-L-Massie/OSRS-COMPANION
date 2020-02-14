package com.example.OSRSCOMPANION.models.merchantHelp.itemMarginLog;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class item {

    //|||Properties|||
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private long buyLimit;

    @OneToMany(cascade = CascadeType.ALL)
    private List<check> priceChecks = new ArrayList<>();

    //|||Constructors|||
    public item() {}

    public item(String name, long buyLimit){
        this.name = name;
        this.buyLimit = buyLimit;
    }

    //|||Accessors|||
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBuyLimit() {
        return buyLimit;
    }

    public void setBuyLimit(long buyLimit) {
        this.buyLimit = buyLimit;
    }

    public List<check> getPriceChecks() {
        return priceChecks;
    }

    public void setPriceChecks(List<check> priceChecks) {
        this.priceChecks = priceChecks;
    }
}
