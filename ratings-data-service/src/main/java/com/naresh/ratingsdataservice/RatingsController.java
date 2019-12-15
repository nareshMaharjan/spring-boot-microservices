package com.naresh.ratingsdataservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsController {


        @RequestMapping("/movies/{movieId}")
        public Rating getMovieRating(@PathVariable("movieId") String movieId) {
            return new Rating(movieId, 4);
        }

        @RequestMapping("/users/{userId}")
        public UserRating getUserRatings(@PathVariable("userId") String userId) {
            UserRating userRating = UserRating.initData(userId);
            return userRating;

        }
}
