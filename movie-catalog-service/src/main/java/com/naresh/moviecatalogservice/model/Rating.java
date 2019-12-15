package com.naresh.moviecatalogservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating {
    private final String movieId;
    private final int rating;

    @JsonCreator
    public Rating(@JsonProperty("movieId") String movieId,@JsonProperty("rating") int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public int getRating() {
        return rating;
    }
}
