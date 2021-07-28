package com.ncs.airside.controller;

import com.ncs.airside.model.database.Transponder;
import com.ncs.airside.model.database.VehicleInformation;
import com.ncs.airside.repository.TransponderRepo;
import com.ncs.airside.repository.VehicleInformationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleInformationController {

    private static Logger logger = LoggerFactory.getLogger(VehicleInformationController.class);

    @Autowired
    private VehicleInformationRepo vehicleInformationRepo;

    @GetMapping("/vehicleInfos")
    public List<VehicleInformation> retrieveAllVehicleInformations(){
        return vehicleInformationRepo.findAll();
    }

}
