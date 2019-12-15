package com.naresh.ratingsdataservice;

import java.util.Arrays;
import java.util.List;

public class UserRating {
    private final String userId;
    private final List<Rating> ratings;

    public UserRating(String userId, List<Rating> ratings) {
        this.userId = userId;
        this.ratings = ratings;
    }

    public String getUserId() {
        return userId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public static UserRating initData(String userId) {
        UserRating userRating = new UserRating(userId, Arrays.asList(
                new Rating("100", 3),
                new Rating("200", 4),
                new Rating("500", 5)
        ));
       return userRating;
    }
}
