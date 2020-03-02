package com.example.OSRSCOMPANION.models.merchantHelp.editCode;

import javax.persistence.*;

@Entity
public class editCode {

    //|||Properties
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private code code;
}
