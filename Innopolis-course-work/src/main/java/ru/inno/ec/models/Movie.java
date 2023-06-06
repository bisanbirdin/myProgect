package ru.inno.ec.models;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.Check;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(exclude = "sessions")
@ToString(exclude = "sessions")
public class Movie {

    public enum State {
        CONFIRMED, DELETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private String director;

    @Column(name = "main_role")
    private String mainRole;

    @Column(name = "duration_min", nullable = false)
    @Check(constraints = "duration_min>0")
    private Integer durationMin;

    @Column(name = "age_limit")
    private Integer ageLimit;

    @ManyToMany
    @JoinTable(joinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "session_id", referencedColumnName = "id")})
    private Set<Session> sessions;

    @Enumerated(value = EnumType.STRING)
    private State state;
}
