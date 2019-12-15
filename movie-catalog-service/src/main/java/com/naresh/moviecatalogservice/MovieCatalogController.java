package com.naresh.moviecatalogservice;

import com.naresh.moviecatalogservice.model.CatalogItem;
import com.naresh.moviecatalogservice.model.UserRating;
import com.naresh.moviecatalogservice.service.MovieInfoService;
import com.naresh.moviecatalogservice.service.UserRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private MovieInfoService movieInfoService;

    @Autowired
    private UserRatingService userRatingService;


//    @Autowired
//    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        UserRating userRating = userRatingService.getUserRating(userId);

        return  userRating.getRatings().stream().map(rating -> {

//            MovieInfo movieInfo = webClientBuilder.build()
//                    .get()
//                    .uri("http://localhost:8082/movies/" + rating.getMovieId())
//                    .retrieve()
//                    .bodyToMono(MovieInfo.class)
//                    .block();

            return movieInfoService.getCatalogItem(rating);
        }).collect(Collectors.toList());

    }



}
