package com.ncs.airside.model.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CompanyInformation {

    @Id
    @GeneratedValue
    private int companyId;

    private String companyName;
    private int customerId;
    private int billingID;

    public CompanyInformation() {
    }

    public CompanyInformation(int companyId, String companyName, int customerId, int billingID) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.customerId = customerId;
        this.billingID = billingID;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBillingID() {
        return billingID;
    }

    public void setBillingID(int billingID) {
        this.billingID = billingID;
    }
}
