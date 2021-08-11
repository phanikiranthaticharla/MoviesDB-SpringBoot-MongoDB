package com.springbootmongo.service;

import com.springbootmongo.model.Movie;
import com.springbootmongo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@CacheConfig(cacheNames = "Movie")
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    /**
     * Ideally this method should be used by administrators
     * and not open for clients
     * @param movie
     */
    @Override
    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    /**
     * Get a movie based on the id
     * This feature will be rarely used.
     * Use search instead
     * @param id
     * @return
     */
    @Override
    public Movie getMovie(String id) {
        return movieRepository.findAll().stream().filter(movie -> movie.getId().equals(id)).findFirst().get();
    }

    /**
     * Search for a movie based on the query paramater passed
     * @param queryStr Search String
     * @return
     */
    @Override
    @Cacheable(key = "#queryStr")
    public List<Movie> findMovies(String queryStr) {
        String queryInLower = queryStr.toLowerCase();
        List<Movie> moviesFound = new ArrayList<>();
        Stream<Movie> streams = movieRepository.findAll().stream();
        streams.forEach(movie -> {
            if(movie.getMovieName().toLowerCase().contains(queryInLower) || movie.getMovieDescription().toLowerCase().contains(queryInLower)
                    || movie.getActors().toString().toLowerCase().contains(queryInLower)
            || movie.getLanguage().toLowerCase().equals(queryInLower)) {
                moviesFound.add(movie);
            }
        });
        return moviesFound;
    }
}
