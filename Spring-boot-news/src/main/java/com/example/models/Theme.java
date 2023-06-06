package com.example.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String theme;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private Source source;

    @OneToMany(mappedBy = "theme", fetch = FetchType.EAGER)
    private List<News> newsList;
}
