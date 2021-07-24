package com.ncs.airside.model.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BillingInformation {

    @Id
    @GeneratedValue
    private int billingID;

    private int companyID;
    private String department;
    private String contactPerson;
    private int contactNumber;

    public BillingInformation() {
    }

    public BillingInformation(int billingID, int companyID, String department, String contactPerson, int contactNumber) {
        this.billingID = billingID;
        this.companyID = companyID;
        this.department = department;
        this.contactPerson = contactPerson;
        this.contactNumber = contactNumber;
    }

    public int getBillingID() {
        return billingID;
    }

    public void setBillingID(int billingID) {
        this.billingID = billingID;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }
}
