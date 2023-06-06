package ru.inno.ec.models;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.Check;

import java.time.LocalTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(exclude = {"movies", "customers"})
@ToString(exclude = {"movies", "customers"})
public class Session {

    public enum State {
        CONFIRMED, DELETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String hall;

    @Check(constraints = "price>0")
    private Integer price;

    @Column(name = "start_time")
    private LocalTime startTime;

    @ManyToMany(mappedBy = "sessions", fetch = FetchType.EAGER)
    private Set<Movie> movies;

    @ManyToMany(mappedBy = "sessions", fetch = FetchType.EAGER)
    private Set<Customer> customers;

    @Enumerated(value = EnumType.STRING)
    private State state;
}
