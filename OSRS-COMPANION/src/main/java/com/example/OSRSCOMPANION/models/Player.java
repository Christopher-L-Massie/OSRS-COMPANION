package com.example.OSRSCOMPANION.models;

import com.example.OSRSCOMPANION.models.constants.hiscoreTypes;
import com.example.OSRSCOMPANION.models.databuilder.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NaturalId;

import javax.net.ssl.HttpsURLConnection;
import javax.persistence.*;
import java.io.IOException;
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

    //create constructor
    public Player(){}

    public Player(String displayName){this.displayName = displayName;}

    public void updateData(){
        try{
            for (hiscoreTypes hiscore : hiscoreTypes.values()){
                HttpsURLConnection connection = DataPoint.buildResponse(displayName, hiscore.getHiscore());
                int responseCode = connection.getResponseCode();
                if (connection.getResponseCode() == 200) {
                    if (hiscore.getHiscore().equals("")) {
                        normalData.add(new normalData(displayName, hiscore.getHiscore(), connection));
                    } else if (hiscore.getHiscore().equals("_ironman")) {
                        ironmanData.add(new ironmanData(displayName, hiscore.getHiscore(), connection));
                    } else if (hiscore.getHiscore().equals("_ultimate")) {
                        ultimateData.add(new ultimateData(displayName, hiscore.getHiscore(), connection));
                    } else if (hiscore.getHiscore().equals("_hardcore_ironman")) {
                        hardcoreData.add(new hardcoreData(displayName, hiscore.getHiscore(), connection));
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
        }
    }
    public List getNormalData(){return this.normalData;}

    public List getIronmanData(){return this.ironmanData;}

    public List getUltimateData(){return this.ultimateData;}

    public List getHardcoreData(){return this.hardcoreData;}
}



