package com.ncs.airside.controller;

import com.ncs.airside.model.database.BillingInformation;
import com.ncs.airside.repository.BillingInformationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillingInformationController {

    @Autowired
    private BillingInformationRepo billingInformationRepo;

    @GetMapping("/billingInfos")
    public List<BillingInformation> retrieveAllBillingInformations(){
        return billingInformationRepo.findAll();
    }


}