package com.ncs.airside.controller;

import com.ncs.airside.Exception.CustomerInformationNotFoundException;
import com.ncs.airside.model.database.CustomerInformation;
import com.ncs.airside.repository.CustomerInformationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerInformationController {

    private static Logger logger = LoggerFactory.getLogger(CustomerInformationController.class);

    @Autowired
    private CustomerInformationRepo customerInformationRepo;

    @GetMapping("/customerInfos")
    public List<CustomerInformation> retrieveAllCustomerInformations(){
        logger.info("The current thread name is "+Thread.currentThread().getName());
        return customerInformationRepo.findAll();
    }

    @GetMapping("/customerInfos/{customerID}")
    public CustomerInformation retrieveCustomerInformation(@PathVariable int customerID){
        Optional<CustomerInformation> custInfoOptional = customerInformationRepo.findByCustomerID(customerID);

        if (!custInfoOptional.isPresent()){
            throw new CustomerInformationNotFoundException("id- "+customerID);
        }

        return custInfoOptional.get();
    }

    @DeleteMapping("/customerInfos/{customerID}")
    public void deleteCustomerInformation(@PathVariable int customerID){
        customerInformationRepo.deleteById(customerID);
    }

    @PostMapping("/customerInfos")
    public ResponseEntity<Object> createCustomerInformation(@RequestBody CustomerInformation customerInformation){

        CustomerInformation savedCustomerInformation = customerInformationRepo.save(customerInformation);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest() //get the current request url which is '/customerInfos'
                .path("/{id}") //append '{id}' to  '/customerInfos' to become '/customerInfos/{id}'
                .buildAndExpand(savedCustomerInformation.getCustomerID()) //replace 'id'
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
