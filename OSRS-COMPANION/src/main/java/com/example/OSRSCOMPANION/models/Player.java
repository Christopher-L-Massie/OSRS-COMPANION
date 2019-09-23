package com.example.OSRSCOMPANION.models;

import com.example.OSRSCOMPANION.models.constants.hiscoreTypes;
import com.example.OSRSCOMPANION.models.databuilder.*;

import javax.net.ssl.HttpsURLConnection;
import javax.persistence.*;
import java.io.IOException;
import java.util.*;

@Entity
public class Player {

    @Id
    @GeneratedValue
    int id;


    private String displayName;

    //all will be one-to-many or many-to-one <
    @OneToMany
    @JoinColumn(name="datapoint_id")
    private ArrayList<DataPoint> normalData = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="datapoint_id")
    private ArrayList<DataPoint> ironmanData = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="datapoint_id")
    private ArrayList<DataPoint> ultimateData = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="datapoint_id")
    private ArrayList<DataPoint> hardcoreData = new ArrayList<>();

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
}
