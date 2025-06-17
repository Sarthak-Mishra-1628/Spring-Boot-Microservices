package com.microservices.rating_service.Entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Rating {

    @Id
    private String ratingId;

    private String userId , hotelId;

    private int rating;

    private String feedback;
}

