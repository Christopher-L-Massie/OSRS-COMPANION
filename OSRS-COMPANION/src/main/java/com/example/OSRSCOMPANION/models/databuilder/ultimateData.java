package com.example.OSRSCOMPANION.models.databuilder;

import com.example.OSRSCOMPANION.models.databuilder.DataPoint;

import javax.net.ssl.HttpsURLConnection;

public class ultimateData extends DataPoint {

    public ultimateData(String displayName,String hiscoreName, HttpsURLConnection connection){
        super(displayName,hiscoreName,connection);
    }
}
