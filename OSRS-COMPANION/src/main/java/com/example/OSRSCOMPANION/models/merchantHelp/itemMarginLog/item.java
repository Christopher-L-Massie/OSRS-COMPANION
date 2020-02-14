package com.example.OSRSCOMPANION.models.merchantHelp.itemMarginLog;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="itemTable")
@Entity
public class item {

    //|||Properties|||
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private long buyLimit;

    @Column(name="priceChecks")
    @OneToMany(cascade = CascadeType.ALL)
    private List<check> priceChecks = new ArrayList<>();

    //|||Constructors|||
    public item() {}

    public item(String name, long buyLimit,check check){
        this.name = name;
        this.buyLimit = buyLimit;
        this.priceChecks.add(check);
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
        return this.priceChecks;
    }

    public void setPriceChecks(List<check> priceChecks) {
        this.priceChecks = priceChecks;
    }
}
