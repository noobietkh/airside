package com.ncs.airside.controller;

import com.ncs.airside.model.database.CompanyInformation;
import com.ncs.airside.repository.CompanyInformationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyInformationController {

    private static Logger logger = LoggerFactory.getLogger(CompanyInformationController.class);

    @Autowired
    private CompanyInformationRepo companyInformationRepo;

    @GetMapping("/companyInformations")
    public List<CompanyInformation> retrieveAllCompanyInformations(){
        return companyInformationRepo.findAll();
    }


}
