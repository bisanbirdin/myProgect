package com.example.controllers;

import com.example.services.NewsService;
import com.example.services.impl.ReportServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/example")
public class Example {

    private final ReportServiceImpl reportService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllNews() {
        reportService.writeToCsv();
        return "writing";
    }
}
