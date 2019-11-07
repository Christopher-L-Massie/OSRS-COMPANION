package com.example.OSRSCOMPANION.models.constants;

public enum playerAchievements {

    /*
        This enum contains the data for achievements that player characters can unlock
        ACHIVEMENTNAME("name","description")
    */

    //||Achievements||

    BASETEN(0,"Base 10 skills","Have level 10 or higher in all skills.",10),
    BASETWENTY(1,"Base 20 skills","Have level 20 or higher in all skills.",20),
    BASETHIRTY(2,"Base 30 skills","Have level 30 or higher in all skills.",30),
    BASEFOURTY(3,"Base 40 skills","Have level 40 or higher in all skills.",40),
    BASEFIFTY(4,"Base 50 skills","Have level 50 or higher in all skills.",50),
    BASESIXTY(5,"Base 60 skills","Have level 60 or higher in all skills.",60),
    BASESEVENTY(6,"Base 70 skills","Have level 70 or higher in all skills.",70),
    BASEEIGHTY(7,"Base 80 skills","Have level 80 or higher in all skills.",80),
    BASENINETY(8,"Base 90 skills","Have level 90 or higher in all skills.",90),
    HALFWAY(9,"Halfway there!","At least 92 in all skills.",92),
    MAXED(10,"Maxed Out!","Reach level 99 in all skills.",99),
    TENMILLTOTAL(11,"Ten Million!","Have 10,000,000 or more total experience.",10000000),
    TWENTYMILLTOTAL(12,"Twenty Million!","Have 20,000,000 or more total experience.",20000000),
    THIRTYMILLTOTAL(13,"Thirty Million!","Have 30,000,000 or more total experience.",30000000),
    FOURTYMILLTOTAL(14,"Fourty Million!","Have 40,000,000 or more total experience.",40000000),
    FIFTYMILLTOTAL(15,"Fifty Million!","Have 50,000,000 or more total experience.",50000000),
    SIXTYMILLTOTAL(16,"Sixty Million!","Have 60,000,000 or more total experience.",60000000),
    SEVENTYMILLTOTAL(17,"Seventy Million!","Have 70,000,000 or more total experience.",70000000),
    EIGHTYMILLTOTAL(18,"Eighty Million!","Have 80,000,000 or more total experience.",80000000),
    NINETYMILLTOTAL(19,"Ninety Million!","Have 90,000,000 or more total experience.",90000000),
    ONEHUNDREDMILLTOTAL(20,"One Hundred Million!","Have 100,000,000 or more total experience.",100000000),
    TWOHUNDREDMILLTOTAL(21,"Two Hundred Million!","Have 200,000,000 or more total experience.",200000000),
    THREEHUNDREDMILLTOTAL(22,"Three Hundred Million!","Have 300,000,000 or more total experience.",300000000),
    FOURHUNDREDMILLTOTAL(23,"Four Hundred Million!","Have 400,000,000 or more total experience.",400000000),
    FIVEHUNDREDMILLTOTAL(24,"Five Hundred Million!","Have 500,000,000 or more total experience.",500000000),
    SIXHUNDREDMILLTOTAL(25,"Six Hundred Million!","Have 600,000,000 or more total experience.",600000000),
    SEVENHUNDREDMILLTOTAL(26,"Seven Hundred Million!","Have 700,000,000 or more total experience.",700000000),
    EIGHTHUNDREDMILLTOTAL(27,"Eight Hundred Million!","Have 800,000,000 or more total experience.",800000000),
    NINEHUNDREDMILLTOTAL(28,"Nine Hundred Million!","Have 900,000,000 or more total experience.",900000000),
    ONEBILLIONTOTAL(29,"One Billion!","Have 1,000,000,000 or more total experience.",1000000000),
    TWOBILLIONTOTAL(30,"Two Billion!","Have 2,000,000,000 or more total experience.",2000000000),
    THREEBILLIONTOTAL(31,"Three Billion!","Have 3,000,000,000 or more total experience.",3000000000L),
    FOURBILLIONTOTAL(32,"Four Billion!","Have 4,000,000,000 or more total experience.",4000000000L),
    MAXTOTALEXPERIENCE(33,"Maxed Experience!","Have 4,600,000,000 total experience.",4600000000L);



    //||Properties||

    private int id;
    private String name;
    private String description;
    private long testValue;

    //||Constructors||

    playerAchievements(int id,String name,String description,long testValue){
        this.id = id;
        this.name = name;
        this.description = description;
        this.testValue = testValue;
    }

    //||METHODS||

    //|||ACCESSORS||

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getTestValue() {
        return this.testValue;
    }
}
