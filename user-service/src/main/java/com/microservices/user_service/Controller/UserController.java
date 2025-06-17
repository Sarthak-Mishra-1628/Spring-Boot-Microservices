package com.microservices.user_service.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.microservices.user_service.Entity.User;
import com.microservices.user_service.Service.UserService;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
// import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
// import io.github.resilience4j.retry.annotation.Retry;


@RestController
@RequestMapping("/User")
public class UserController {

    // private Logger logger = LoggerFactory.getLogger(UserController.class);;

    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
    
    
    // int retryCount=1;

    @GetMapping("/get/{userId}")
    // @CircuitBreaker(name="Hotel_Rating_Breaker" , fallbackMethod = "RatingHotelFallBack")
    // @Retry(name="Hotel_Rating_Retry" , fallbackMethod = "RatingHotelFallBack")
    @RateLimiter(name="User_Rate_Limiter" , fallbackMethod = "RatingHotelFallBack")
    public ResponseEntity<User> getUserByID(@PathVariable String userId){
        // logger.info("Retrycount : " , retryCount++);

        User user = userService.getUserByID(userId); 
        return ResponseEntity.ok(user);
    }

// 
    // Creating RatingHotelFallBack for Circuit Breaker
    public ResponseEntity<User> RatingHotelFallBack(String userId , Exception exception){
        // logger.info("Fallback is executed becuase service is down : " , exception.getMessage());

        User user = User.builder().email("dummy@gmail.com").name("dummy").build();

        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok( userService.getAllUser()) ;
    }
}

