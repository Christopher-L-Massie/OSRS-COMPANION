package com.example.OSRSCOMPANION.models.forms;

import javax.validation.constraints.NotNull;

public class Search {

    //properties

    @NotNull
    private String displayName;

    //accessors

    public String getDisplayName(){return this.displayName;}

}
