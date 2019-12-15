package com.naresh.moviecatalogservice.service;

import com.naresh.moviecatalogservice.model.CatalogItem;
import com.naresh.moviecatalogservice.model.MovieInfo;
import com.naresh.moviecatalogservice.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            }
    )
    public CatalogItem getCatalogItem(Rating rating) {
        MovieInfo movieInfo = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), MovieInfo.class);
        return new CatalogItem(movieInfo.getName(), movieInfo.getDescription(), rating.getRating());
    }


    public CatalogItem getFallbackCatalogItem(Rating rating) {
        return new CatalogItem("No movie", "", 0);
    }
}
