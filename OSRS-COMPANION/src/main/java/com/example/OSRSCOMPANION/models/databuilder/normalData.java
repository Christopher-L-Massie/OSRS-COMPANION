package com.example.OSRSCOMPANION.models.databuilder;

import com.example.OSRSCOMPANION.models.databuilder.DataPoint;

import javax.net.ssl.HttpsURLConnection;

public class normalData extends DataPoint {

    public normalData(String displayName, String hiscoreName, HttpsURLConnection connection){
        super(displayName,hiscoreName,connection);
    }
}
