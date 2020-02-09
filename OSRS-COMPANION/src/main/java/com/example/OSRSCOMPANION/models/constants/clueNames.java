package com.example.OSRSCOMPANION.models.constants;

public enum clueNames {

    //|||VALUES|||

    ALL("all",0),
    BEGINNER("beginner",1),
    EASY("easy",2),
    MEDIUM("medium",3),
    HARD("hard",4),
    ELITE("elite",5),
    MASTER("master",6);

    //|||PROPERTIES|||

    private String clueName;
    private Integer clueType;

    //|||CONSTRUCTORS|||

    clueNames(String clueName, Integer clueType){
        this.clueName = clueName;
        this.clueType = clueType;
    }

    //|||ACCESSORS|||

    public String getClueName() {
        return clueName;
    }

    public void setClueName(String clueName) {
        this.clueName = clueName;
    }

    public Integer getClueType() {
        return clueType;
    }

    public void setClueType(Integer clueType) {
        this.clueType = clueType;
    }
}
