package com.example.services;


import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface NewsService {
    List<String> getAllNews(PageRequest of);

    List<String> getNewsFromSource(Long sourceId, PageRequest of);

    List<String> getNewsOnTheme(Long themeId, PageRequest of);
}
