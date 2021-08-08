package com.springbootmongo.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Movie {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public int getReleaseYr() {
        return releaseYr;
    }

    public void setReleaseYr(int releaseYr) {
        this.releaseYr = releaseYr;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    @Id
    private String id;
    private String movieName;
    private String movieDescription;
    private int releaseYr;
    List<String> actors;

}
