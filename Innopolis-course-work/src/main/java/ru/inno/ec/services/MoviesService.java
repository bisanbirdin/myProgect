package ru.inno.ec.services;

import ru.inno.ec.models.Movie;

import java.util.List;

public interface MoviesService {
    List<Movie> getAllMovies();

    void addMovie(Movie movie);

    void deleteMovie(Long id);

    Movie getMovie(Long id);

    void updateMovie(Long id, Movie movie);
}
