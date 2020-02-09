package com.example.OSRSCOMPANION.models.constants;

public enum bountyNames {

    //|||VALUES|||

    HUNTER("Hunter"),
    ROGUE("Rogue");

    //|||PROPERTIES|||

    private String bountyName;

    //|||CONSTRUCTORS|||

    bountyNames(String bountyName){
        this.bountyName = bountyName;
    }

    //|||ACCESSORS|||

    public String getBountyName() {
        return bountyName;
    }

    public void setBountyName(String bountyName) {
        this.bountyName = bountyName;
    }
}
