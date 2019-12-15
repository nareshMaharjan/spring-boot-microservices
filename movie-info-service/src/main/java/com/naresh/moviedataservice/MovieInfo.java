package com.naresh.moviedataservice;

public class MovieInfo {
    private final String movieId;
    private final String name;
    private final String description;

    public MovieInfo(String movieId, String name, String description) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }
}
