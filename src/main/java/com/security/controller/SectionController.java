package com.security.controller;

import com.security.model.Section;
import com.security.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/section")
@CrossOrigin("*")
public class SectionController {
    @Autowired
    public SectionService service;
    @PostMapping
    public Section add(@RequestBody Section  section){
        return service.add(section);
    }

    @GetMapping
    public List<Section> all(){
        return service.all();
    }
    @GetMapping("{sectionId}")
    public Optional<Section> getOne(@PathVariable Integer sectionId){
        return service.getOne(sectionId);
    }

    @DeleteMapping("{sectionId}")
    public void deleteMe(@PathVariable Integer sectionId){
        service.deleteMe(sectionId);
    }
    @PutMapping("{sectionId}")
    public Section update(@RequestBody Section  section,@PathVariable Integer sectionId){
        section.setSectionId(sectionId);
        return service.add(section);
    }


}
