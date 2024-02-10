package com.security.repository;

import com.security.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District,Integer> {
    List<District> findByRegion_RegionId(Integer regionId);
}
