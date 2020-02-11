package com.example.OSRSCOMPANION.models.constants;

public enum dataNames {

    UKNOWN("Unknown",1),
    HUNTER("Hunter",2),
    ROGUE("Rogue",2),
    ALL("all",3),
    BEGINNER("beginner",3),
    EASY("easy",3),
    MEDIUM("medium",3),
    HARD("hard",3),
    ELITE("elite",3),
    MASTER("master",3),
    LMS("Last Man Standing",4),
    ABYSSAL_SIRE("Abyssal Sire",5),
    ALCHEMICAL_HYDRA("Alchemical Hydra",5),
    BARROWS_CHEST("Barrows Chest",5),
    BRYOPHYTA("Bryophyta",5),
    CALLISTO("Callisto",5),
    CERBERUS("Cerberus",5),
    CHAMBERS_OF_XERIC("Chambers of Xeric",5),
    CHAMBERS_OF_XERIC_CHALLENGE_MODE("Chambers of Xeric:Challenge Mode",5),
    CHAOS_ELEMENTAL("Chaos Elemental",5),
    CHAOS_FANATIC("Chaos Fanatic",5),
    COMMANDER_ZILYANA("Commander Zilyana",5),
    COPOREAL_BEAST("Coporeal Beast",5),
    CRAZY_ARCHAEOLOGIST("Crazy Archaeologist",5),
    DAGANOTH_PRIME("Daganoth Prime",5),
    DAGANOTH_REX("Daganoth Rex", 5),
    DAGANOTH_SUPREME("Daganoth Supreme",5),
    DERANGED_ARCHAEOLOGIST("Deranged Archaeologist",5),
    GENERAL_GRAARDOR("General Graardor",5),
    GIANT_MOLE("Giant Mole", 5),
    GROTESQUE_GUARDIANS("Grotesque Guardians",5),
    HESPORI("Hespori",5),
    KALPHITE_QUEEN("Kalphite Queen",5),
    KING_BLACK_DRAGON("King Black Dragon",5),
    KRAKEN("Kraken",5),
    KREEARRA("Kree'Arra",5),
    KRIL_TSUTSAROTH("K'ril Tsutsaroth",5),
    MIMIC("Mimic",5),
    OBOR("Obor",5),
    SARACHNIS("Sarachnis",5),
    SCORPIA("Scorpia",5),
    SKOTIZO("Skotizo",5),
    THE_GAUNTLET("The Gauntlet",5),
    THE_CORRUPTED_GAUNTLET("The Corrupted Gauntlet",5),
    THEATRE_OF_BLOOD("Theatre of Blood",5),
    THERMONUCLEAR_SMOKE_DEVIL("Thermonuclear Smoke Devil",34),
    TZKAL_ZUK("TzKal-Zuk",5),
    TZTOK_JAD("TzTok-Jad",5),
    VENENATIS("Venenatis",5),
    VETION("Vet'ion",5),
    VORKATH("Vorkath",5),
    WINTERTODT("Wintertodt",5),
    ZALCANO("Zalcano",5),
    ZULRAH("Zulrah",5);

    //|||PROPERTIES|||

    private String name;
    private int typeNumber;

    //|||CONSTRUCTORS|||

    dataNames(String name, int typeNumber){
        this.name = name;
        this.typeNumber = typeNumber;
    }

    //|||ACCESSORS|||

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(int typeNumber) {
        this.typeNumber = typeNumber;
    }
}
