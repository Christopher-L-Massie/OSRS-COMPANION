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

    //|||ACCESSORS|||

    public int getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(int typeNumber) {
        this.typeNumber = typeNumber;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
