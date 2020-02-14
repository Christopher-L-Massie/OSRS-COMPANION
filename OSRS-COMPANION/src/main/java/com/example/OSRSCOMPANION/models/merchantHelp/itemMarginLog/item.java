package com.example.OSRSCOMPANION.models.merchantHelp.itemMarginLog;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class item {

    //|||Properties|||
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private long buyLimit;

    @OneToMany(cascade = CascadeType.ALL)
    private List<check> priceChecks = new ArrayList<>();

    


}
