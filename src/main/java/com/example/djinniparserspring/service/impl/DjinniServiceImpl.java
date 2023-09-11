package com.example.djinniparserspring.service.impl;

import com.example.djinniparserspring.data.DjinniRepository;
import com.example.djinniparserspring.entities.Vacancy;
import com.example.djinniparserspring.service.DjinniService;
import org.springframework.stereotype.Service;

@Service
public class DjinniServiceImpl implements DjinniService {
    private final DjinniRepository djinniRepository;

    public DjinniServiceImpl(DjinniRepository djinniRepository) {
        this.djinniRepository = djinniRepository;
    }

    @Override
    public Vacancy save(Vacancy vacancy){
        if (vacancy == null) return null;
        return djinniRepository.save(vacancy);
    }
}
