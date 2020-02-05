package com.example.OSRSCOMPANION.models.constants;

public enum bossNames {

    //|||VALUES|||

    ABYSSAL_SIRE("Abyssal Sire",0),
    ALCHEMICAL_HYDRA("Alchemical Hydra",1),
    BARROWS_CHEST("Barrows Chest",2),
    BRYOPHYTA("Bryophyta",3),
    CALLISTO("Callisto",4),
    CERBERUS("Cerberus",5),
    CHAMBERS_OF_XERIC("Chambers of Xeric",6),
    CHAMBERS_OF_XERIC_CHALLENGE_MODE("Chambers of Xeric:Challenge Mode",7),
    CHAOS_ELEMENTAL("Chaos Elemental",8),
    CHAOS_FANATIC("Chaos Fanatic",9),
    COMMANDER_ZILYANA("Commander Zilyana",10),
    COPOREAL_BEAST("Coporeal Beast",11),
    CRAZY_ARCHAEOLOGIST("Crazy Archaeologist",12),
    DAGANOTH_PRIME("Daganoth Prime",13),
    DAGANOTH_REX("Daganoth Rex", 14),
    DAGANOTH_SUPREME("Daganoth Supreme",15),
    DERANGED_ARCHAEOLOGIST("Deranged Archaeologist",16),
    GENERAL_GRAARDOR("General Graardor",17),
    GIANT_MOLE("Giant Mole", 18),
    GROTESQUE_GUARDIANS("Grotesque Guardians",19),
    HESPORI("Hespori",20),
    KALPHITE_QUEEN("Kalphite Queen",21),
    KING_BLACK_DRAGON("King Black Dragon",22),
    KRAKEN("Kraken",23),
    KREEARRA("Kree'Arra",24),
    KRIL_TSUTSAROTH("K'ril Tsutsaroth",25),
    MIMIC("Mimic",26),
    OBOR("Obor",27),
    SARACHNIS("Sarachnis",28),
    SCORPIA("Scorpia",29),
    SKOTIZO("Skotizo",30),
    THE_GAUNTLET("The Gauntlet",31),
    THE_CORRUPTED_GAUNTLET("The Corrupted Gauntlet",32),
    THEATRE_OF_BLOOD("Theatre of Blood",33),
    THERMONUCLEAR_SMOKE_DEVIL("Thermonuclear Smoke Devil",34),
    TZKAL_ZUK("TzKal-Zuk",35),
    TZTOK_JAD("TzTok-Jad",36),
    VENENATIS("Venenatis",37),
    VETION("Vet'ion",38),
    VORKATH("Vorkath",39),
    WINTERTODT("Wintertodt",40),
    ZALCANO("Zalcano",41),
    ZULRAH("Zulrah",42);

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