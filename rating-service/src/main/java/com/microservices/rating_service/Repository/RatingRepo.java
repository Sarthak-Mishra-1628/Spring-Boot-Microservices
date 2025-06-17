package com.microservices.rating_service.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.rating_service.Entity.Rating;
import java.util.List;


public interface RatingRepo extends JpaRepository<Rating,String>{

    // Custom Finder Method
    
    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);

}