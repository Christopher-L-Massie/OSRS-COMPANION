package com.example.OSRSCOMPANION.models.constants;

public enum hiscoreTypes {

    NORMAL("",0),
    IRON("_ironman",1),
    ULTIMATE("_ultimate",2),
    HARDCORE("_hardcore_ironman",3),
    DEADMAN("_deadman",4),
    SEASONAL("_seasonal", 5),
    TOURNAMENT("_tournament",6);

    //|||PROPERTIES|||

    private String hiscore;
    private Integer typeNumber;

    //|||CONSTRUCTORS|||

    hiscoreTypes(String hiscore,Integer typeNumber){
        this.hiscore = hiscore;
        this.typeNumber = typeNumber;
    }

    //|||ACCESSORS|||

    public String getHiscore() {
        return this.hiscore;
    }

    public void setHiscore(String hiscore){
        this.hiscore = hiscore;
    }

    public Integer getTypeNumber(){
        return this.typeNumber;
    }

    public void setTypeNumber(int typeNumber){
        this.typeNumber = typeNumber;
    }
}
