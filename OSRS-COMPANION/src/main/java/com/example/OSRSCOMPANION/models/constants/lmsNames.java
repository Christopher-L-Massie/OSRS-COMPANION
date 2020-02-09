package com.example.OSRSCOMPANION.models.constants;

public enum lmsNames {

    //|||VALUES|||

    LMS("Last Man Standing");

    //|||PROPERTIES|||

    private String name;

    //|||CONSTRUCTORS|||

    lmsNames(String name){
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
