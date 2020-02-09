package com.example.OSRSCOMPANION.models.constants;

public enum dataTypes {

    //|||VALUES|||

    SKILLDATA(),
    UNKNOWNDATA(),
    BOUNTYDATA(),
    CLUEDATA(),
    LMSDATA(),
    BOSSDATA();

    //|||PROPERTIES|||

    private int typeNumber;
    private String typeName;

    //|||CONSTRUCTORS|||

    dataTypes(int typeNumber,String typeName){
        this.typeNumber = typeNumber;
        this.typeName = typeName;
    }




}
