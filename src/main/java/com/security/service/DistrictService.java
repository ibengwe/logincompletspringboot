package com.security.service;

import com.security.model.District;
import com.security.model.Region;
import com.security.repository.DistrictRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DistrictService {
    @Autowired
    public DistrictRepository repository;

    public District add(District district) {
        return repository.save(district);
    }

    public List<District> all() {
        return repository.findAll();
    }

    public Optional<District> findOne(Integer districtId) {
        return repository.findById(districtId);
    }

    public void deleteMe(Integer districtId) {
        repository.deleteById(districtId);
    }

    @Transactional
    public void updateDistrict(Integer districtId, String districtName, Integer regionId) {
        District  district=repository.findById(districtId)
                .orElseThrow(()->new IllegalStateException("Not Found"));
        if (districtName!=null &&!districtName.isEmpty() &&!Objects.equals(district.getDistrictName(),districtName)){
            district.setDistrictName(districtName);
        }
        if (regionId!=null){
            Region region=new Region();
            region.setRegionId(regionId);
            district.setRegion(region);
        }


    }

    public List<District> getDistrictsByRegionId(Integer regionId) {
        return repository.findByRegion_RegionId(regionId);
    }
}
