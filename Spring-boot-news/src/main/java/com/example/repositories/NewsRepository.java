package com.example.repositories;

import com.example.models.News;
import com.example.models.Source;
import com.example.models.Theme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NewsRepository extends JpaRepository<News, Long> {

    Page<News> findAll(PageRequest pageRequest);

    Page<News> findAllByTheme_Source(Source source, PageRequest pageRequest);

    Page<News> findAllByTheme(Theme theme, PageRequest pageRequest);

    int countAllByTheme(Theme theme);
}
