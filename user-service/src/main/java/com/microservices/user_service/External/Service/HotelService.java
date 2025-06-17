package com.microservices.user_service.External.Service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.microservices.user_service.Entity.Hotel;


@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotel/get/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);


}
