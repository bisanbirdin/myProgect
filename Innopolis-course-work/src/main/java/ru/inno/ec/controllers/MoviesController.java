package ru.inno.ec.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.inno.ec.models.Movie;
import ru.inno.ec.security.details.CustomUserDetails;
import ru.inno.ec.services.MoviesService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/movies")
public class MoviesController {

    private final MoviesService moviesService;

    @GetMapping
    public String getMoviesPage(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model) {
        model.addAttribute("role", customUserDetails.getCustomer().getRole());
        model.addAttribute("movies", moviesService.getAllMovies());
        return "movies/movies_page";
    }

    @PostMapping
    public String addMovie(Movie movie) {
        moviesService.addMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/{movie-id}/delete")
    public String deleteMovie(@PathVariable("movie-id") Long id) {
        moviesService.deleteMovie(id);
        return "redirect:/movies";
    }

    @GetMapping("/{movie-id}")
    public String getMoviePage(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                               @PathVariable("movie-id") Long id, Model model) {
        model.addAttribute("role", customUserDetails.getCustomer().getRole());
        model.addAttribute("movie", moviesService.getMovie(id));
        return "movies/movie_page";
    }

    @PostMapping("/{movie-id}/update")
    public String updateMovie(@PathVariable("movie-id") Long id, Movie movie) {
        moviesService.updateMovie(id, movie);
        return "redirect:/movies/" + id;
    }
}
