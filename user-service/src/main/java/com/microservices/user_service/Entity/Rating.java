package com.microservices.user_service.Entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    @Id
    private String ratingId;

    private String userId , hotelId;

    private int rating;

    private String feedback;

    private Hotel hotel;
}
