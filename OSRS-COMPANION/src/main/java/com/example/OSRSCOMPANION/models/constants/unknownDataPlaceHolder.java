package com.example.OSRSCOMPANION.models.constants;

public enum unknownDataPlaceHolder {
    
    //|||VALUES|||

    UKNOWN("Unknown");

    //|||PROPERTIES|||

    private String name;

    //|||CONSTRUCTORS|||

    unknownDataPlaceHolder(String name){
        this.name = name;
    }

    //|||ACCESSORS|||

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
