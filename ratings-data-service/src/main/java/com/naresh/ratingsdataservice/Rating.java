package com.naresh.ratingsdataservice;

public class Rating {
    private final String movieId;
    private final int rating;

    public Rating(String movieId, int rating) {
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
