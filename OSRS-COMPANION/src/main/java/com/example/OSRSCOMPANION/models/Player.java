package com.example.OSRSCOMPANION.models;

import com.example.OSRSCOMPANION.models.constants.hiscoreTypes;
import com.example.OSRSCOMPANION.models.databuilder.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NaturalId;

import javax.net.ssl.HttpsURLConnection;
import javax.persistence.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

@Entity
public class Player {

    @Id
    @GeneratedValue
    int id;

    @NaturalId
    @Column(name="displayname")
    private String displayName;

    //all will be one-to-many or many-to-one <

    @OneToMany(cascade = CascadeType.ALL)
    private List<DataPoint> normalData = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<DataPoint> ironmanData = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<DataPoint> ultimateData = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<DataPoint> hardcoreData = new ArrayList<>();

    @Column(name="lastUpdated")
    private Timestamp lastUpdated = new Timestamp(System.currentTimeMillis());

    private boolean isNormal;

    private boolean isHardcore;

    private boolean isIronman;

    private boolean isUltimate;

    //create constructor
    public Player(){}

    public Player(String displayName){this.displayName = displayName;}

    public void setNotRecent(String dataType){
        if (dataType.equals("")) {
            for (DataPoint data : this.normalData) {
                data.setIsRecent(false);
            }
        } else if (dataType.equals("_ironman")) {
            for (DataPoint data : this.ironmanData) {
                data.setIsRecent(false);
            }
        } else if (dataType.equals("_ultimate")) {
            for (DataPoint data : this.ultimateData) {
                data.setIsRecent(false);
            }
        } else if (dataType.equals("_hardcore_ironman")) {
            for (DataPoint data : this.hardcoreData) {
                data.setIsRecent(false);
            }
        }
    }

    public void updateData(){
        try{
            for (hiscoreTypes hiscore : hiscoreTypes.values()){
                HttpsURLConnection connection = DataPoint.buildResponse(displayName, hiscore.getHiscore());
                int responseCode = connection.getResponseCode();
                if (connection.getResponseCode() == 200) {
                    if (hiscore.getHiscore().equals("")) {
                        isNormal = true;
                        setNotRecent(hiscore.getHiscore());
                        normalData.add(new normalData(displayName, hiscore.getHiscore(), connection));
                    } else if (hiscore.getHiscore().equals("_ironman")) {
                        isIronman = true;
                        setNotRecent(hiscore.getHiscore());
                        ironmanData.add(new ironmanData(displayName, hiscore.getHiscore(), connection));
                    } else if (hiscore.getHiscore().equals("_ultimate")) {
                        isUltimate = true;
                        setNotRecent(hiscore.getHiscore());
                        ultimateData.add(new ultimateData(displayName, hiscore.getHiscore(), connection));
                    } else if (hiscore.getHiscore().equals("_hardcore_ironman")) {
                        isHardcore = true;
                        setNotRecent(hiscore.getHiscore());
                        hardcoreData.add(new hardcoreData(displayName, hiscore.getHiscore(), connection));
                    }
                    this.lastUpdated = new Timestamp(System.currentTimeMillis());
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
        }
    }

    public int getId(){return this.id;}

    public String getDisplayName(){return this.displayName;}

    public Timestamp getLastUpdated() {return lastUpdated;}

    public List getNormalData(){return this.normalData;}

    public List getIronmanData(){return this.ironmanData;}

    public List getUltimateData(){return this.ultimateData;}

    public List getHardcoreData(){return this.hardcoreData;}

    public boolean getIsNormal(){return this.isNormal;}

    public boolean getIsIronman(){return this.isIronman;}

    public boolean getIsUltimate(){return this.isUltimate;}

    public boolean getIsHardcore(){return this.isHardcore;}
}



