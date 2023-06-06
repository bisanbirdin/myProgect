package ru.inno.ec.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.ec.models.Movie;
import ru.inno.ec.repositories.MoviesRepository;
import ru.inno.ec.services.MoviesService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MoviesServiceImpl implements MoviesService {

    private final MoviesRepository moviesRepository;

    @Override
    public List<Movie> getAllMovies() {
        return moviesRepository.findAllByStateNot(Movie.State.DELETED);
    }

    @Override
    public void addMovie(Movie movie) {
        Movie newMovie = Movie.builder()
                .name(movie.getName())
                .description(movie.getDescription())
                .director(movie.getDirector())
                .mainRole(movie.getMainRole())
                .durationMin(movie.getDurationMin())
                .ageLimit(movie.getAgeLimit())
                .state(Movie.State.CONFIRMED)
                .build();

        moviesRepository.save(newMovie);
    }

    @Override
    public void deleteMovie(Long id) {
        Movie movieForDelete = moviesRepository.findById(id).orElseThrow();
        movieForDelete.setState(Movie.State.DELETED);

        moviesRepository.save(movieForDelete);
    }

    @Override
    public Movie getMovie(Long id) {
        return moviesRepository.findById(id).orElseThrow();
    }

    @Override
    public void updateMovie(Long id, Movie movie) {
        Movie movieForUpdate = moviesRepository.findById(id).orElseThrow();

        movieForUpdate.setName(movie.getName());
        movieForUpdate.setDescription(movie.getDescription());
        movieForUpdate.setDirector(movie.getDirector());
        movieForUpdate.setMainRole(movie.getMainRole());
        movieForUpdate.setDurationMin(movie.getDurationMin());
        movieForUpdate.setAgeLimit(movie.getAgeLimit());

        moviesRepository.save(movieForUpdate);
    }
}
