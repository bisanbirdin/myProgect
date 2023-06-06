package ru.inno.ec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.ec.models.Movie;
import ru.inno.ec.models.Session;

import java.util.List;

public interface MoviesRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByStateNot(Movie.State state);

    List<Movie> findAllBySessionsContains(Session session);

    List<Movie> findAllBySessionsNotContains(Session session);
}
