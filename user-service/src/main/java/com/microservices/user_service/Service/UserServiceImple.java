package com.microservices.user_service.Service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.user_service.Entity.Hotel;
import com.microservices.user_service.Entity.Rating;
import com.microservices.user_service.Entity.User;
import com.microservices.user_service.Exceptions.ResourceNotFoundException;
import com.microservices.user_service.External.Service.HotelService;
import com.microservices.user_service.Repository.UserRepo;


@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUser_id(userId);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> allUsers= userRepo.findAll();

        for(int i=0;i<allUsers.size();i++){
            Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/get/user/"+allUsers.get(i).getUser_id() , Rating[].class);
            
            List<Rating> ratings_without_hotel = Arrays.stream(ratings).toList();
            allUsers.get(i).setRatings(ratings_without_hotel);

            for(int j=0;j<ratings_without_hotel.size();j++){
                // ResponseEntity<Hotel> forEntity= restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/get/"+ratings_without_hotel.get(j).getHotelId(), Hotel.class);
                // Hotel hotel= forEntity.getBody();

                Hotel hotel = hotelService.getHotel(ratings_without_hotel.get(j).getHotelId());
                ratings_without_hotel.get(j).setHotel(hotel);
            }
        }

        return allUsers;
    }

    @Override
    public User getUserByID(String user_id) {
        User user = userRepo.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("User with given Id => " + user_id + " is not found on Server")); 
        
        Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/get/user/"+user.getUser_id() , Rating[].class);
        
        List<Rating> ratings_without_hotel = Arrays.stream(ratings).toList();
        user.setRatings(ratings_without_hotel);
       
        for(int i=0;i<ratings_without_hotel.size();i++){
            // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/get/"+ratings_without_hotel.get(i).getHotelId(), Hotel.class);
            // Hotel hotel = forEntity.getBody();

            Hotel hotel = hotelService.getHotel(ratings_without_hotel.get(i).getHotelId());
            ratings_without_hotel.get(i).setHotel(hotel);
        }
        
        return user; 
    }
}