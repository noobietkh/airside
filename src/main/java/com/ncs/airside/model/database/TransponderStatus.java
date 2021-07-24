package com.ncs.airside.model.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity //add this will automatically let spring boot create the table for you.
public class TransponderStatus {

    @Id
    @GeneratedValue
    private int transponderStatusID;

    private int companyID;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private String status ;

    public TransponderStatus() {
    }

    public TransponderStatus(int companyID, int statusID, LocalDateTime checkInTime, LocalDateTime checkOutTime, String status) {
        this.companyID = companyID;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.status = status;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTransponderStatusID() {
        return transponderStatusID;
    }

    public void setTransponderStatusID(int transponderStatusID) {
        this.transponderStatusID = transponderStatusID;
    }

}
