package com.example.services.impl;


import com.example.models.News;
import com.example.models.Source;
import com.example.models.Theme;
import com.example.repositories.NewsRepository;
import com.example.repositories.SourceRepository;
import com.example.repositories.ThemeRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ServiceImplTest {

    @Mock
    private ThemeRepository themeRepository;
    @Mock
    private SourceRepository sourceRepository;
    @Mock
    private NewsRepository newsRepository;
    @InjectMocks
    private ThemeServiceImpl themeService;
    @InjectMocks
    private SourceServiceImpl sourceService;
    @InjectMocks
    private NewsServiceImpl newsService;

    private List<News> news = new ArrayList<>();
    private List<Theme> themes = new ArrayList<>();
    private List<Source> sources = new ArrayList<>();

    @BeforeEach
    public void setup() {
        news.add(News.builder().id(1L).news("firsNews").build());
        news.add(News.builder().id(2L).news("secondNews").build());
        news.add(News.builder().id(3L).news("thirdNews").build());
        news.add(News.builder().id(4L).news("fourthNews").build());

        themes.add(Theme.builder().id(1L).theme("firstTheme")
                .newsList(new ArrayList<>(Arrays.asList(news.get(0), news.get(1)))).build());
        themes.add(Theme.builder().id(2L).theme("secondTheme")
                .newsList(new ArrayList<>(Arrays.asList(news.get(2)))).build());
        themes.add(Theme.builder().id(3L).theme("thirdTheme")
                .newsList(new ArrayList<>(Arrays.asList(news.get(3)))).build());

        sources.add(Source.builder().id(1L).source("firstSource")
                .themes(new ArrayList<>(Arrays.asList(themes.get(0), themes.get(1)))).build());
        sources.add(Source.builder().id(2L).source("secondSource")
                .themes(new ArrayList<>(Arrays.asList(themes.get(2)))).build());
    }


    @DisplayName("JUnit test for getThemes method")
    @Test
    public void getThemesTest() {
        List<String> expected = new ArrayList<>();
        for (Theme theme : themes) {
            expected.add(theme.getTheme());
        }

        given(themeRepository.findAll()).willReturn(themes);
        List<String> actual = themeService.getThemes();

        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("JUnit test for getSources method")
    @Test
    public void getSourcesTest() {
        List<String> expected = new ArrayList<>();
        for (Source source : sources) {
            expected.add(source.getSource());
        }

        given(sourceRepository.findAll()).willReturn(sources);
        List<String> actual = sourceService.getSources();

        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("JUnit test for getAllNews method")
    @Test
    public void getAllNewsTest() {
        String expected=news.get(0).getNews();

        PageRequest pageRequest=PageRequest.of(0,1);
        given(newsRepository.findAll()).willReturn(news);
        List<String> actual = newsService.getAllNews(PageRequest.of(0,1));

        Assertions.assertEquals(expected, actual);
    }
}