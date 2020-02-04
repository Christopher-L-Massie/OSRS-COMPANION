package com.example.OSRSCOMPANION.models.constants;

public enum clueNames {

    //|||VALUES|||

    BEGINNER("beginner",0),
    EASY("easy",1),
    MEDIUM("medium",2),
    HARD("hard",3),
    ELITE("elite",4),
    MASTER("master",5);

    //|||PROPERTIES|||

    private String clueName;
    private Integer clueType;

    //|||CONSTRUCTORS|||

    private clueNames(String clueName, Integer clueType){
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
