package com.microservices.user_service.External.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.microservices.user_service.Entity.Rating;


@FeignClient(name="RATING-SERVICE")
public interface RatingService {

    @PostMapping("/ratings/new")
    Rating createRating(Rating rating);
}