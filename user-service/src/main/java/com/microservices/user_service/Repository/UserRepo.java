package com.microservices.user_service.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.user_service.Entity.User;

public interface UserRepo extends JpaRepository<User, String>{

}
