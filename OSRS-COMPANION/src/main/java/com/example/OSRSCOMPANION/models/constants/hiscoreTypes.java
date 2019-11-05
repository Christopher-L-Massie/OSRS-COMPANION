package com.example.OSRSCOMPANION.models.constants;

public enum hiscoreTypes {

    NORMAL(""),
    IRON("_ironman"),
    ULTIMATE("_ultimate"),
    HARDCORE("_hardcore_ironman");

    //|||PROPERTIES|||

    public String hiscore;

    //|||CONSTRUCTORS|||

    hiscoreTypes(String hiscore){
        this.hiscore = hiscore;
    }

    public String getHiscore() {
        return this.hiscore;
    }

    public void setHiscore(String hiscore){
        this.hiscore = hiscore;
    }
}
