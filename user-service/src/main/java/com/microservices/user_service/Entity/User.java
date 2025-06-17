package com.microservices.user_service.Entity;
import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    private String user_id;
    
    private String name , email;

    @Transient // Don't Store this in DB
    @Builder.Default
    private List<Rating> ratings = new ArrayList<>();   
}