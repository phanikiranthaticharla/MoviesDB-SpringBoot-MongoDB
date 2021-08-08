package com.springbootmongo.service;

import com.springbootmongo.model.Movie;

import java.util.List;

public interface MovieService {
    public void addMovie(Movie movie);
    public List<Movie> getMovies();
    public Movie getMovie(String id);
    public List<Movie> findMovies(String name);
}
