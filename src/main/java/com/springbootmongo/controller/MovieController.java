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

    /**
     * Endpoint to add a new movie.
     * Ideally this method should endpoint should not be exposed to clients.
     * @param movie
     * @return
     */
    @PostMapping("/movie/add")
    public Movie addMovie(@RequestBody  Movie movie) {
        movieService.addMovie(movie);
        return movie;
    }

    /**
     * Endpoint to update an existing movie.
     * Ideally this method should endpoint should not be exposed to clients.
     * @param movie
     * @return
     */
    @PutMapping("/movie/update")
    public Movie updateMovie(@RequestBody  Movie movie) {
        movieService.addMovie(movie);
        return movie;
    }

    /**
     * Endpoint to obtain a movie based on Id
     * This will be a rarely used feature.
     * Use search endpoint instead
     * @param id
     * @return
     */
    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable String id) {
        return movieService.getMovie(id);
    }

    /**
     * Endpoint for searching a movie based on the query parameter passed
     * @param query
     * @return
     */
    @GetMapping("/movie/search")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Movie> findMovies(@RequestParam(required = false) String query) {
        return movieService.findMovies(query);
    }

    /**
     * Endpoint to list all movies present in the database
     * @return
     */
    @GetMapping("/movie/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Movie> getAllMovies() {
        return movieService.getMovies();
    }
}
