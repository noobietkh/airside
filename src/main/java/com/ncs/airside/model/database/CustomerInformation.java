package com.ncs.airside.model.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CustomerInformation {

    @Id
    @GeneratedValue
    private int customerID;

    private String department;
    private String contactPerson;
    private int contactNumber;
    private String statusInformation;

    public CustomerInformation() {
    }

    public CustomerInformation(int customerID, String department, String contactPerson, int contactNumber, String statusInformation) {
        this.customerID = customerID;
        this.department = department;
        this.contactPerson = contactPerson;
        this.contactNumber = contactNumber;
        this.statusInformation = statusInformation;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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

    public String getStatusInformation() {
        return statusInformation;
    }

    public void setStatusInformation(String statusInformation) {
        this.statusInformation = statusInformation;
    }
}