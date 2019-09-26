package com.example.OSRSCOMPANION.models.databuilder;

import com.example.OSRSCOMPANION.models.databuilder.DataPoint;

import javax.net.ssl.HttpsURLConnection;
import javax.persistence.Entity;

@Entity
public class ironmanData extends DataPoint {

    public ironmanData(){}

    public ironmanData(String displayName,String hiscoreName, HttpsURLConnection connection){
        super(displayName,hiscoreName,connection);
    }
}
