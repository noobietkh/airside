package com.ncs.airside.model.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Transponder {

    @Id
    @GeneratedValue
    private int TransponderID;

    private String serialNumber;
    private String callSign;
    private int description;

    public Transponder() {
    }

    public Transponder(int transponderID, String serialNumber, String callSign, int description) {
        TransponderID = transponderID;
        this.serialNumber = serialNumber;
        this.callSign = callSign;
        this.description = description;
    }

    public int getTransponderID() {
        return TransponderID;
    }

    public void setTransponderID(int transponderID) {
        TransponderID = transponderID;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }
}
