package com.ncs.airside.controller;

import com.ncs.airside.model.database.CustomerInformation;
import com.ncs.airside.repository.CustomerInformationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerInformationController {

    @Autowired
    private CustomerInformationRepo customerInformationRepo;

    @GetMapping("/customerInfos")
    public List<CustomerInformation> retrieveAllCustomerInformations(){
        return customerInformationRepo.findAll();
    }

}
