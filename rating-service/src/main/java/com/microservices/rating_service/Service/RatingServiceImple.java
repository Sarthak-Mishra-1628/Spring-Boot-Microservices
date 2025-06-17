package com.microservices.rating_service.Service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservices.rating_service.Entity.Rating;
import com.microservices.rating_service.Repository.RatingRepo;


@Service
public class RatingServiceImple implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Rating createRating(Rating rating){
        String ratingId=UUID.randomUUID().toString();
        rating.setRatingId(ratingId);
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingbyUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingbyHotelId(String hotelId){
        return ratingRepo.findByHotelId(hotelId);
    }
}