package com.example.OSRSCOMPANION.models.merchantHelp.editCode;

import com.example.OSRSCOMPANION.models.merchantHelp.data.CodeDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class editCode {

    @Autowired
    private CodeDao codeDao;

    //|||Properties
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private code code;
}
