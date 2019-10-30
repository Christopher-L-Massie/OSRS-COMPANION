package com.example.OSRSCOMPANION.models.constants;

public enum skillNames {

    OVERALL("overall",0),
    ATTACK("attack",1),
    DEFENCE("defence",2),
    STRENGTH("strength",3),
    HITPOINTS("hitpoints",4),
    RANGED("ranged",5),
    PRAYER("prayer",6),
    MAGIC("magic",7),
    COOKING("cooking",8),
    WOODCUTTING("woodcutting",9),
    FLETCHING("fletching",10),
    FISHING("fishing",11),
    FIREMAKING("firemaking",12),
    CRAFTING("crafting",13),
    SMITHING("smithing",14),
    MINING("mining",15),
    HERBLORE("herblore",16),
    AGILITY("agility",17),
    THIEVING("thieving",18),
    SLAYER("slayer",19),
    FARMING("farming",20),
    RUNECRAFTING("runecrafting",21),
    HUNTER("hunter",22),
    CONSTRUCTION("construction",23);


    //properties

    private String skillName;
    private int skillNumber;

    //constructors

    private skillNames(String skillName, int skillNumber){
        this.skillName = skillName;
        this.skillNumber = skillNumber;
    }

    //accessors

    public String getSkillName(){
        return skillName;
    }

    public void setSkillName(String skillName){
        this.skillName = skillName;
    }

    public int getSkillNumber() {
        return skillNumber;
    }

    public void setSkillNumber(int skillNumber) {
        this.skillNumber = skillNumber;
    }
}
