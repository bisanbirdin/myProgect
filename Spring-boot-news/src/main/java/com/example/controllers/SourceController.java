package com.example.controllers;

import com.example.services.SourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sources")
public class SourceController {

    private final SourceService sourceService;

    @RequestMapping(method = RequestMethod.GET)
    public List<String> getSources() {
        return sourceService.getSources();
    }
}
