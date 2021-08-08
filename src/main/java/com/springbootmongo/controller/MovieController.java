package com.springbootmongo.controller;

import com.springbootmongo.model.Movie;
import com.springbootmongo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping({"/", "/movie"})
    public String movie() {
        return "Welcome to movies world!";
    }

    @PostMapping("/movie/add")
    public Movie addMovie(@RequestBody  Movie movie) {
        movieService.addMovie(movie);
        return movie;
    }

    @PutMapping("/movie/update")
    public Movie updateMovie(@RequestBody  Movie movie) {
        movieService.addMovie(movie);
        return movie;
    }

    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable String id) {
        return movieService.getMovie(id);
    }

    @GetMapping("/movie/all")
    public List<Movie> getAllMovies() {
        return movieService.getMovies();
    }
}
