package com.example.controllers;

import com.example.services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @RequestMapping(method = RequestMethod.GET)
    public List<String> getAllNews(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "3") int size
    ) {
        return newsService.getAllNews(PageRequest.of(page, size));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/source/{source-id}")
    public List<String> getNewsFromSource(
            @PathVariable("source-id") Long sourceId,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "1") int size
    ) {
        return newsService.getNewsFromSource(sourceId, PageRequest.of(page, size));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/theme/{theme-id}")
    public List<String> getNewsOnTheme(
            @PathVariable("theme-id") Long themeId,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "1") int size
    ) {
        return newsService.getNewsOnTheme(themeId, PageRequest.of(page, size));
    }
}
