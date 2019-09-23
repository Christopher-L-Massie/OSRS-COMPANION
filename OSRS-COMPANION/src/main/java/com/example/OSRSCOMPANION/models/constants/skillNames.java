package com.example.OSRSCOMPANION.models.constants;

public enum skillNames {

    OVERALL("overall"),
    ATTACK("attack"),
    DEFENCE("defence"),
    STRENGTH("strength"),
    HITPOINTS("hitpoints"),
    RANGED("ranged"),
    PRAYER("prayer"),
    MAGIC("magic"),
    COOKING("cooking"),
    WOODCUTTING("woodcutting"),
    FLETCHING("fletching"),
    FISHING("fishing"),
    FIREMAKING("firemaking"),
    CRAFTING("crafting"),
    SMITHING("smithing"),
    MINING("mining"),
    HERBLORE("herblore"),
    AGILITY("agility"),
    THIEVING("thieving"),
    SLAYER("slayer"),
    RUNECRAFTING("runecrafting"),
    HUNTER("hunter"),
    CONSTRUCTION("construction");

    private String skillName;

    private skillNames(String skillName){
        this.skillName = skillName;
    }

    public String getName(){
        return skillName;
    }

}
