package com.example.OSRSCOMPANION.models.ProgressionTracking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class clueProgressionData {

    @Id
    @GeneratedValue
    private int id;

    private Integer clueTypeNumber;
    private String clueTypeName;
    private long rankChange;
    private long scoreChange;
    private long days;
}
