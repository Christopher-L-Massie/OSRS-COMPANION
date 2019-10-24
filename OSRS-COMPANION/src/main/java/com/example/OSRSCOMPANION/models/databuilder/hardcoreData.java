package com.example.OSRSCOMPANION.models.databuilder;

import com.example.OSRSCOMPANION.models.databuilder.DataPoint;

import javax.net.ssl.HttpsURLConnection;
import javax.persistence.Entity;

@Entity
public class hardcoreData extends DataPoint {

    public hardcoreData(){}

    public hardcoreData(String displayName, String hiscoreName, HttpsURLConnection connection, Boolean isNormal,Boolean isIronman,Boolean isUltimate,Boolean isHardcore){
        super(displayName,hiscoreName,connection,isNormal,isIronman,isUltimate,isHardcore);
    }

}
