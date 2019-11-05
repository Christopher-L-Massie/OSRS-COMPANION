package com.example.OSRSCOMPANION.models.constants;

public enum playerAchievements {

    /*
        This enum contains the data for achievements that player characters can unlock
        ACHIVEMENTNAME("name","description")
    */

    //||Achievements||

    BASETEN(0,"Base 10 skills","Have level 10 or higher in all skills."),
    BASETWENTY(1,"Base 20 skills","Have level 20 or higher in all skills."),
    BASETHIRTY(2,"Base 30 skills","Have level 30 or higher in all skills."),
    BASEFOURTY(3,"Base 40 skills","Have level 40 or higher in all skills."),
    BASEFIFTY(4,"Base 50 skills","Have level 50 or higher in all skills."),
    BASESIXTY(5,"Base 60 skills","Have level 60 or higher in all skills."),
    BASESEVENTY(6,"Base 70 skills","Have level 70 or higher in all skills."),
    BASEEIGHTY(7,"Base 80 skills","Have level 80 or higher in all skills."),
    BASENINETY(8,"Base 90 skills","Have level 90 or higher in all skills."),
    HALFWAY(9,"Halfway there!","At least 92 in all skills."),
    MAXED(10,"Maxed Out!","Reach level 99 in all skills.");

    //||Properties||

    private int id;
    private String name;
    private String description;

    //||Constructors||

    playerAchievements(int id,String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    //|||ACCESSORS||

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
