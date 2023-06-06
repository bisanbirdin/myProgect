package com.example.services.impl;

import com.example.models.Theme;
import com.example.repositories.ThemeRepository;
import com.example.services.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ThemeServiceImpl implements ThemeService {

    private final ThemeRepository themeRepository;

    @Override
    public List<String> getThemes() {
        List<Theme> themes = themeRepository.findAll();
        List<String> themeList = new ArrayList<>();
        for (Theme theme : themes) {
            themeList.add(theme.getTheme());
        }
        return themeList;
    }
}
