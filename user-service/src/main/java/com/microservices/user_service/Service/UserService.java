package com.microservices.user_service.Service;
import java.util.List;
import com.microservices.user_service.Entity.User;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUser();
    User getUserByID(String user_id);

}
