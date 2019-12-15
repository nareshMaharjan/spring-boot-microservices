package com.naresh.moviecatalogservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieInfo {
    private final String movieId;
    private final String name;
    private final String description;

    @JsonCreator
    public MovieInfo(@JsonProperty("movieId")String movieId,
                     @JsonProperty("name") String name,
                    @JsonProperty("description") String description
    ) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
