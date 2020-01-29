package com.example.OSRSCOMPANION.models.constants;

public enum hiscoreTypes {

    NORMAL("",0),
    IRON("_ironman",1),
    ULTIMATE("_ultimate",2),
    HARDCORE("_hardcore_ironman",3);

    //|||PROPERTIES|||

    public String hiscore;
    private int typeNumber;

    //|||CONSTRUCTORS|||

    hiscoreTypes(String hiscore,int typeNumber){
        this.hiscore = hiscore;
        this.typeNumber = typeNumber;
    }

    public String getHiscore() {
        return this.hiscore;
    }

    public void setHiscore(String hiscore){
        this.hiscore = hiscore;
    }
    
    public int getTypeNumber(){
        return this.typeNumber;
    }

    public void setTypeNumber(int typeNumber){
        this.typeNumber = typeNumber;
    }
}
