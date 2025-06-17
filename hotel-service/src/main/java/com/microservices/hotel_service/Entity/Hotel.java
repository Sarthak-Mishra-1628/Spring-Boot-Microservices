package com.microservices.hotel_service.Entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hotel {

    @Id
    private String hotel_id;

    private String name , location;
}