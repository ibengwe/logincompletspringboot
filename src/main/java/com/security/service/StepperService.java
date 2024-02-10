package com.security.service;

import com.security.model.Stepper;
import com.security.repository.StepperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StepperService {
    @Autowired
    public StepperRepository repository;

    public Stepper add(Stepper stepper) {
        return repository.save(stepper);
    }

    public List<Stepper> all() {
        return repository.findAll();
    }

    public Optional<Stepper> getById(Integer checkNumber) {
        return repository.findById(checkNumber);
    }
}
