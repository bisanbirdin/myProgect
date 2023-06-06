package com.example.services.impl;

import com.example.models.Source;
import com.example.repositories.SourceRepository;
import com.example.services.SourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class SourceServiceImpl implements SourceService {

    private final SourceRepository sourceRepository;

    @Override
    public List<String> getSources() {
        List<Source> sources = sourceRepository.findAll();
        List<String> sourceList = new ArrayList<>();
        for (Source source : sources) {
            sourceList.add(source.getSource());
        }
        return sourceList;
    }
}
