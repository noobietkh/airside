package com.ncs.airside.model.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VehicleInformation {

    @Id
    @GeneratedValue
    private int vehicleID;

    private int CompanyID;
    private int registrationNumber;

    public VehicleInformation() {
    }

    public VehicleInformation(int companyID, int vehicleID, int registrationNumber) {
        CompanyID = companyID;
        this.vehicleID = vehicleID;
        this.registrationNumber = registrationNumber;
    }

    public int getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(int companyID) {
        CompanyID = companyID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
