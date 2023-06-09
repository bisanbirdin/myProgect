package com.example.repositories;

import com.example.models.Source;
import com.example.models.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ThemeRepository extends JpaRepository<Theme, Long> {

    List<Theme> findAllBySource(Source source);
}
