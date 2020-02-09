package com.example.OSRSCOMPANION.models.constants;

public enum dataTypes {

    //|||VALUES|||

    SKILLDATA(0,"skillData"),
    UNKNOWNDATA(1,"unknownData"),
    BOUNTYDATA(2,"bountyData"),
    CLUEDATA(3,"clueData"),
    LMSDATA(4,"lmsData"),
    BOSSDATA(5,"bossData");

    //|||PROPERTIES|||

    private int typeNumber;
    private String typeName;

    //|||CONSTRUCTORS|||

    dataTypes(int typeNumber,String typeName){
        this.typeNumber = typeNumber;
        this.typeName = typeName;
    }




}
