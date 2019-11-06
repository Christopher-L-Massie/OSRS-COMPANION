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
    MAXED(10,"Maxed Out!","Reach level 99 in all skills."),
    TENMILLTOTAL(11,"Ten Million!","Have 10,000,000 or more total experience."),
    TWENTYMILLTOTAL(12,"Twenty Million!","Have 20,000,000 or more total experience."),
    THIRTYMILLTOTAL(13,"Thirty Million!","Have 30,000,000 or more total experience."),
    FOURTYMILLTOTAL(14,"Fourty Million!","Have 40,000,000 or more total experience."),
    FIFTYMILLTOTAL(15,"Fifty Million!","Have 50,000,000 or more total experience."),
    SIXTYMILLTOTAL(16,"Sixty Million!","Have 60,000,000 or more total experience."),
    SEVENTYMILLTOTAL(17,"Seventy Million!","Have 70,000,000 or more total experience."),
    EIGHTYMILLTOTAL(18,"Eighty Million!","Have 80,000,000 or more total experience."),
    NINETYMILLTOTAL(19,"Ninety Million!","Have 90,000,000 or more total experience."),
    ONEHUNDREDMILLTOTAL(20,"One Hundred Million!","Have 100,000,000 or more total experience."),
    TWOHUNDREDMILLTOTAL(21,"Two Hundred Million!","Have 200,000,000 or more total experience."),
    THREEHUNDREDMILLTOTAL(22,"Three Hundred Million!","Have 300,000,000 or more total experience."),
    FOURHUNDREDMILLTOTAL(23,"Four Hundred Million!","Have 400,000,000 or more total experience."),
    FIVEHUNDREDMILLTOTAL(24,"Five Hundred Million!","Have 500,000,000 or more total experience."),
    SIXHUNDREDMILLTOTAL(25,"Six Hundred Million!","Have 600,000,000 or more total experience."),
    SEVENHUNDREDMILLTOTAL(26,"Seven Hundred Million!","Have 700,000,000 or more total experience."),
    EIGHTHUNDREDMILLTOTAL(27,"Eight Hundred Million!","Have 800,000,000 or more total experience."),
    NINEHUNDREDMILLTOTAL(28,"Nine Hundred Million!","Have 900,000,000 or more total experience."),
    ONEBILLIONTOTAL(29,"One Billion!","Have 1,000,000,000 or more total experience."),
    TWOBILLIONTOTAL(30,"Two Billion!","Have 2,000,000,000 or more total experience."),
    MAXTOTALEXPERIENCE(31,"Maxed Experience!","Have 2,400,000,000 total experience.");



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
