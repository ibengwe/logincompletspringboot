package com.security.service;

import com.security.model.Staff;
import com.security.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    @Autowired
    public StaffRepository repository;

    public Staff add(Staff staff) {
        return repository.save(staff);
    }

    public List<Staff> all() {
        return repository.findAll();
    }

    public Optional<Staff> getById(Integer checkNumber) {
        return repository.findById(checkNumber);
    }
}
