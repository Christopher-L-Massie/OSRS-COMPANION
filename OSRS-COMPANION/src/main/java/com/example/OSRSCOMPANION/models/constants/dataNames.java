package com.example.OSRSCOMPANION.models.constants;

public enum dataNames {

    UKNOWN("Unknown",1,24),
    HUNTER("Hunter",2,25),
    ROGUE("Rogue",2,26),
    ALL("all",3,27),
    BEGINNER("beginner",3,28),
    EASY("easy",3,29),
    MEDIUM("medium",3,30),
    HARD("hard",3,31),
    ELITE("elite",3,32),
    MASTER("master",3,33),
    LMS("Last Man Standing",4,34),
    ABYSSAL_SIRE("Abyssal Sire",5,35),
    ALCHEMICAL_HYDRA("Alchemical Hydra",5,36),
    BARROWS_CHEST("Barrows Chest",5,37),
    BRYOPHYTA("Bryophyta",5,38),
    CALLISTO("Callisto",5,39),
    CERBERUS("Cerberus",5,40),
    CHAMBERS_OF_XERIC("Chambers of Xeric",5,41),
    CHAMBERS_OF_XERIC_CHALLENGE_MODE("Chambers of Xeric:Challenge Mode",5,42),
    CHAOS_ELEMENTAL("Chaos Elemental",5,43),
    CHAOS_FANATIC("Chaos Fanatic",5,44),
    COMMANDER_ZILYANA("Commander Zilyana",5,45),
    COPOREAL_BEAST("Coporeal Beast",5,46),
    CRAZY_ARCHAEOLOGIST("Crazy Archaeologist",5,47),
    DAGANOTH_PRIME("Daganoth Prime",5,48),
    DAGANOTH_REX("Daganoth Rex", 5,49),
    DAGANOTH_SUPREME("Daganoth Supreme",5,50),
    DERANGED_ARCHAEOLOGIST("Deranged Archaeologist",5,51),
    GENERAL_GRAARDOR("General Graardor",5,52),
    GIANT_MOLE("Giant Mole", 5,53),
    GROTESQUE_GUARDIANS("Grotesque Guardians",5,54),
    HESPORI("Hespori",5,55),
    KALPHITE_QUEEN("Kalphite Queen",5,56),
    KING_BLACK_DRAGON("King Black Dragon",5,57),
    KRAKEN("Kraken",5,58),
    KREEARRA("Kree'Arra",5,59),
    KRIL_TSUTSAROTH("K'ril Tsutsaroth",5,60),
    MIMIC("Mimic",5,61),
    OBOR("Obor",5,62),
    SARACHNIS("Sarachnis",5,63),
    SCORPIA("Scorpia",5,64),
    SKOTIZO("Skotizo",5,65),
    THE_GAUNTLET("The Gauntlet",5,66),
    THE_CORRUPTED_GAUNTLET("The Corrupted Gauntlet",5,67),
    THEATRE_OF_BLOOD("Theatre of Blood",5,68),
    THERMONUCLEAR_SMOKE_DEVIL("Thermonuclear Smoke Devil",34,69),
    TZKAL_ZUK("TzKal-Zuk",5,70),
    TZTOK_JAD("TzTok-Jad",5,71),
    VENENATIS("Venenatis",5,72),
    VETION("Vet'ion",5,73),
    VORKATH("Vorkath",5,74),
    WINTERTODT("Wintertodt",5,75),
    ZALCANO("Zalcano",5,76),
    ZULRAH("Zulrah",5,77);

    //|||PROPERTIES|||

    private String name;
    private int typeNumber;
    private int dataPlaceValue;

    //|||CONSTRUCTORS|||

    dataNames(String name, int typeNumber, int dataPlaceValue){
        this.name = name;
        this.typeNumber = typeNumber;
        this.dataPlaceValue = dataPlaceValue;
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

    public int getDataPlaceValue() {return this.dataPlaceValue;}
}
