package com.security.service;

import com.security.model.Section;
import com.security.repository.SectionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SectionService {
    @Autowired
    public SectionRepository repository;

    public Section add(Section section) {
        return repository.save(section);
    }

    public List<Section> all() {
        return repository.findAll();
    }

    public Optional<Section> getOne(Integer sectionId) {
        return repository.findById(sectionId);
    }

    public void deleteMe(Integer sectionId) {
        repository.deleteById(sectionId);
    }

    @Transactional
    public void updateSection(Integer sectionId, String sectionName) {
        Section section=repository.findById(sectionId)
                .orElseThrow(()->new IllegalStateException("Not Found"));

        if (sectionName!=null &&!sectionName.isEmpty()&&!Objects.equals(section.getSectionName(),sectionName)){
            section.setSectionName(sectionName);
        }
    }
}
