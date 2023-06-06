package com.example.services.impl;

import com.example.models.Source;
import com.example.models.Theme;
import com.example.repositories.NewsRepository;
import com.example.repositories.SourceRepository;
import com.example.repositories.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

@Service
@RequiredArgsConstructor
@EnableScheduling
public class ReportServiceImpl {

    private final SourceRepository sourceRepository;
    private final ThemeRepository themeRepository;
    private final NewsRepository newsRepository;

    @Scheduled(cron = "${interval-in-cron}")
    public void writeToCsv() {
        MyThread thread = new MyThread();
        thread.start();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            List<Source> sources = sourceRepository.findAll();
            for (Source source : sources) {
                String currentSource = source.getSource();
                String fileName = currentSource + ".csv";
                File csvOutput = new File(fileName);
                List<Theme> themes = themeRepository.findAllBySource(source);
                try (PrintWriter printWriter = new PrintWriter(csvOutput)) {
                    for (Theme theme : themes) {
                        printWriter.write(theme.getTheme() + ", " + newsRepository.countAllByTheme(theme) + "\n");
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
