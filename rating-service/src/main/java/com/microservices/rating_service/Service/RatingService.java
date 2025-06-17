package com.microservices.rating_service.Service;
import java.util.List;
import com.microservices.rating_service.Entity.Rating;

public interface RatingService {

    Rating createRating(Rating rating);

    List<Rating> getAllRating();

    List<Rating> getRatingbyUserId(String userId);

    List<Rating> getRatingbyHotelId(String HotelId);
    
}