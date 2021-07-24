package com.ncs.airside.controller;

import com.ncs.airside.model.database.Transponder;
import com.ncs.airside.repository.TransponderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransponderController {

    @Autowired
    private TransponderRepo transponderRepo;

    @GetMapping("/transponders")
    public List<Transponder> retrieveAllTransponders(){
        return transponderRepo.findAll();
    }

}
