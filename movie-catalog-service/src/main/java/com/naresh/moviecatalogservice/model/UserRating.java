package com.naresh.moviecatalogservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRating {
    private final String userId;
    private final List<Rating> ratings;

    @JsonCreator
    public UserRating(@JsonProperty("userId") String userId,@JsonProperty("ratings") List<Rating> ratings) {
        this.userId = userId;
        this.ratings = ratings;
    }

    public String getUserId() {
        return userId;
    }

    public List<Rating> getRatings() {
        return this.ratings != null ? ratings : new ArrayList<>();
    }

    public static UserRating initData(String userId) {
        UserRating userRating = new UserRating(userId, Arrays.asList(
                new Rating("100", 3),
                new Rating("200", 4)
        ));
       return userRating;
    }
}
