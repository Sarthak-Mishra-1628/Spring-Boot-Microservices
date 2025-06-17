package com.microservices.hotel_service.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.hotel_service.Entity.Hotel;


public interface HotelRepo extends JpaRepository<Hotel,String> {

}
