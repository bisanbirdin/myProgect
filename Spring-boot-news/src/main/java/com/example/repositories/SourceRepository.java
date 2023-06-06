package com.example.repositories;

import com.example.models.Source;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceRepository extends JpaRepository<Source, Long> {
}
