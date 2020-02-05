package com.example.OSRSCOMPANION.models.constants;

public enum bossNames {

    //|||VALUES|||

    ABYSSAL_SIRE,
    ALCHEMICAL_HYDRA,
    BARROWS_CHEST,
    BRYOPHYTA,
    CALLISTO,
    CERBERUS,
    CHAMBERS_OF_XERIC,
    CHAMBERS_OF_XERIC_CHALLENGE_MODE,
    CHAOS_ELEMENTAL,
    CHAOS_FANATIC,
    COMMANDER_ZILYANA,
    COPOREAL_BEAST,
    CRAZY_ARCHAEOLOGIST,
    DAGANOTH_PRIME,
    DAGANOTH_REX,
    DAGANOTH_SUPREME,
    DERANGED_ARCHAEOLOGIST,
    GENERAL_GRAARDOR,
    GIANT_MOLE,
    GROTESQUE_GAURDIANS,
    HESPORI,
    KALPHITE_QUEEN,
    KING_BLACK_DRAGON,
    KRAKEN,
    KREEARRA,
    KRIL_TSUTSAROTH,
    MIMIC,
    OBOR,
    SARACHNIS,
    SCORPIA,
    SKOTIZO,
    THE_GAUNTLET,
    THE_CORRUPTED_GAUNTLET,
    THEATRE_OF_BLOOD,
    THERMONUCLEAR_SMOKE_DEVIL,
    TZKAL_ZUK,
    TZTOK_JAD,
    VENENATIS,
    VETION,
    VORKATH,
    WINTERTODT,
    ZALCANO,
    ZULRAH;

    //|||PROPERTIES|||

    private String bossName;
    //below is technically not needed as is but! future editions on JAGEX's end may make this needed to keep old data working
    //I believe they will want to keep the bosses in alphabetical order. Hopefully they just amend to the end of the existing data string and keep them in order
    //(I will actually find out 2/6/2020 what happens when the new boss is added.)
    private Integer bossNumber;

    //|||CONSTRUCTORS|||

    bossNames(String bossName, Integer bossNumber) {
        this.bossName = bossName;
        this.bossNumber = bossNumber;
    }

    //|||ACCESSORS|||
    
    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public Integer getBossNumber() {
        return bossNumber;
    }

    public void setBossNumber(Integer bossNumber) {
        this.bossNumber = bossNumber;
    }
}