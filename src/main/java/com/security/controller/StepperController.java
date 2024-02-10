package com.security.controller;


import com.security.model.Stepper;
import com.security.service.StepperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/stepper")
@CrossOrigin("*")

public class StepperController {
    @Autowired
    public StepperService service;

    @PostMapping
    public Stepper add(@RequestBody Stepper stepper){
        return service.add(stepper);
    }
    @GetMapping
    public List<Stepper> all(){
        return service.all();
    }

    @GetMapping("{checkNumber}")
    public Optional<Stepper> getById(@PathVariable Integer checkNumber){
        return service.getById(checkNumber);
    }
}
