package com.microservices.hotel_service.Controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.microservices.hotel_service.Entity.Hotel;
import com.microservices.hotel_service.Service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/new")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.creaHotel(hotel));
    }

    @GetMapping("/get/{hotelId}")
    public ResponseEntity<Hotel> getHotelbyId(@PathVariable String hotelId){
        return ResponseEntity.ok(hotelService.getHotelbyId(hotelId));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Hotel>> getAll(){
        return ResponseEntity.ok(hotelService.getAll());
    }
}
