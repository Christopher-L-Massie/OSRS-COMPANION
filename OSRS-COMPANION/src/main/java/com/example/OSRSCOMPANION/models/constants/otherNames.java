package com.example.OSRSCOMPANION.models.constants;

public class otherNames {

    UKNOWN("Unknown"),
    HUNTER("Hunter"),
    ROGUE("Rogue"),
    ALL("all",0),
    BEGINNER("beginner",1),
    EASY("easy",2),
    MEDIUM("medium",3),
    HARD("hard",4),
    ELITE("elite",5),
    MASTER("master",6),
    LMS("Last Man Standing"),
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

    private String name;
    private int typeNumber;

    //|||CONSTRUCTORS|||

    otherNames(String name,int typeNumber){
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
