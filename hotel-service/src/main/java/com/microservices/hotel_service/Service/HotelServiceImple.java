package com.microservices.hotel_service.Service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservices.hotel_service.Entity.Hotel;
import com.microservices.hotel_service.Exceptions.ResourceNotFoundException;
import com.microservices.hotel_service.Repository.HotelRepo;

@Service
public class HotelServiceImple implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel creaHotel(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setHotel_id(id);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel getHotelbyId(String hotel_id) {
        return hotelRepo.findById(hotel_id).orElseThrow( () -> new ResourceNotFoundException("Hotel with given id => '" + hotel_id + "' is not found on server!!!"));
    }
}