package com.microservices.hotel_service.Service;
import java.util.List;
import com.microservices.hotel_service.Entity.Hotel;

public interface HotelService {

    Hotel creaHotel(Hotel hotel);

    List<Hotel> getAll();

    Hotel getHotelbyId(String hotel_id);
}