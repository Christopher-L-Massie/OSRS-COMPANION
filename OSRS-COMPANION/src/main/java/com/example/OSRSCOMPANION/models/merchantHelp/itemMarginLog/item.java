package com.example.OSRSCOMPANION.models.merchantHelp.itemMarginLog;

import javax.persistence.*;
import java.sql.Timestamp;
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

    private Timestamp firstCheck = new Timestamp(System.currentTimeMillis());

    private Timestamp recentCheck;

    //DATA stuff

    //Highs and lows and margins.

    private long dailyLow;
    private long dailyHigh;
    private long dailyMargin;

    private long weeklyLow;
    private long weeklyHigh;
    private long weeklyMargin;

    private long monthlyLow;
    private long monthlyHigh;
    private long monthlyMargin;

    private long yearlyLow;
    private long yearlyHigh;
    private long yearlyMargin;

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

    //|||METHODS|||

    public void updateItemInfo(){

        if (this.priceChecks.size() > 0 ){
            for (check check : this.priceChecks){

            }
        }
    }

    public List<check> findChecksInTimeRange(List<check> checks,Timestamp earliestDate){
        List<check> pointsInTimeRange = new ArrayList<>();
        for(check check: checks){
            if(check.getTimeChecked().after(earliestDate)){
                pointsInTimeRange.add(check);
            } else {
                continue;
            }
        }
        return pointsInTimeRange;
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
