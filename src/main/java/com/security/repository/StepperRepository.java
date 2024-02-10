package com.security.repository;

import com.security.model.Stepper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepperRepository extends JpaRepository<Stepper,Integer> {
}
