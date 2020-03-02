package com.example.OSRSCOMPANION.models.merchantHelp.editCode;

import com.example.OSRSCOMPANION.models.merchantHelp.data.CodeDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class editCode {

    @Autowired
    private CodeDao codeDao;

    //|||Properties|||
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private code code;

    //0 = profit
    //1 = margin
    private int logType;

    //|||Constructors|||
    public editCode(){}

    public editCode(int logType){
    }

    //|||Methods|||

    //|||Accessors|||
    public com.example.OSRSCOMPANION.models.merchantHelp.editCode.code getCode() {
        return code;
    }

    public void setCode(com.example.OSRSCOMPANION.models.merchantHelp.editCode.code code) {
        this.code = code;
    }

    public int getLogType() {
        return logType;
    }

    public void setLogType(int logType) {
        this.logType = logType;
    }
}
