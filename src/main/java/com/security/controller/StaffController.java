package com.security.controller;

import com.security.model.Staff;
import com.security.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/staff")
@CrossOrigin("*")

public class StaffController {
    @Autowired
    public StaffService service;

    @PostMapping
    public Staff add(@RequestBody Staff staff){
        return service.add(staff);
    }
    @GetMapping
    public List<Staff> all(){
        return service.all();
    }
    @GetMapping({"checkNumber"})
    public Optional<Staff> getById(@PathVariable Integer checkNumber){
        return service.getById(checkNumber);
    }
}
