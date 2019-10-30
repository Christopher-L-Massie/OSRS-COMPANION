package com.example.OSRSCOMPANION.models.constants;

public enum timeValues {

    SECOND(1000),
    MINUTE(60000),
    HOUR(3600000),
    DAY(86400000),
    WEEK(604800000);

    //|||PROPERTIES|||

    private long milliseconds;

    //|||CONSTRUCTORS|||

    private timeValues(long milliseconds){
        this.milliseconds = milliseconds;
    }

    //|||ACCESSORS|||

    public long getMilliseconds(){
        return milliseconds;
    }

    public void setMilliseconds(long milliseconds){
        this.milliseconds = milliseconds;
    }
}
