package com.example.services.impl;

import com.example.models.News;
import com.example.models.Source;
import com.example.models.Theme;
import com.example.repositories.NewsRepository;
import com.example.repositories.SourceRepository;
import com.example.repositories.ThemeRepository;
import com.example.services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final SourceRepository sourceRepository;
    private final ThemeRepository themeRepository;

    @Override
    public List<String> getAllNews(PageRequest pageRequest) {
        Page<News> news = newsRepository.findAll(pageRequest);
        List<String> newsList = new ArrayList<>();
        for (News currentNews : news) {
            newsList.add(currentNews.getNews());
        }
        return newsList;
    }

    @Override
    public List<String> getNewsFromSource(Long sourceId, PageRequest pageRequest) {
        Source source = sourceRepository.findById(sourceId).orElseThrow();
        Page<News> news = newsRepository.findAllByTheme_Source(source, pageRequest);
        List<String> newsList = new ArrayList<>();
        for (News currentNews : news) {
            newsList.add(currentNews.getNews());
        }
        return newsList;
    }

    @Override
    public List<String> getNewsOnTheme(Long themeId, PageRequest pageRequest) {
        Theme theme = themeRepository.findById(themeId).orElseThrow();
        Page<News> news = newsRepository.findAllByTheme(theme, pageRequest);
        List<String> newsList = new ArrayList<>();
        for (News currentNews : news) {
            newsList.add(currentNews.getNews());
        }
        return newsList;
    }
}
