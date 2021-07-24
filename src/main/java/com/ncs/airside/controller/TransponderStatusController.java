package com.ncs.airside.controller;

import com.ncs.airside.model.database.Transponder;
import com.ncs.airside.model.database.TransponderStatus;
import com.ncs.airside.repository.TransponderRepo;
import com.ncs.airside.repository.TransponderStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransponderStatusController {

    @Autowired
    private TransponderStatusRepo transponderStatusRepo;

    @GetMapping("/transponderStatuses")
    public List<TransponderStatus> retrieveAllTransponderStatuses(){
        return transponderStatusRepo.findAll();
    }

}
