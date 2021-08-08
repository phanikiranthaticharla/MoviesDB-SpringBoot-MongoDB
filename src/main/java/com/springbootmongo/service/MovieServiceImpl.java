package com.springbootmongo.service;

import com.springbootmongo.model.Movie;
import com.springbootmongo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public void addMovie(Movie movie) {
        System.out.println(movie.getMovieName());
        System.out.println(movie.getReleaseYr());
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovie(String id) {
        return movieRepository.findAll().stream().filter(movie -> movie.getId().equals(id)).findFirst().get();
    }

    @Override
    public List<Movie> findMovies(String name) {
        String nameInLower = name.toLowerCase();
        List<Movie> moviesFound = new ArrayList<>();
        Stream<Movie> streams = movieRepository.findAll().stream();
        streams.forEach(movie -> {
            if(movie.getMovieName().toLowerCase().contains(nameInLower) || movie.getMovieDescription().toLowerCase().contains(nameInLower)
                    || movie.getActors().toString().toLowerCase().contains(nameInLower)) {
                moviesFound.add(movie);
            }
        });
        return moviesFound;
    }
}
