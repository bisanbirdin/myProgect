package com.example;

import com.example.repositories.NewsRepository;
import com.example.repositories.SourceRepository;
import com.example.repositories.ThemeRepository;
import com.example.services.impl.NewsServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewsProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsProjectApplication.class, args);
    }
}
