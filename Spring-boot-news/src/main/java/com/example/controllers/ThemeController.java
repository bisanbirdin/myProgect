package com.example.controllers;

import com.example.services.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/themes")
public class ThemeController {

    private final ThemeService themeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<String> getThemes() {
        return themeService.getThemes();
    }
}
