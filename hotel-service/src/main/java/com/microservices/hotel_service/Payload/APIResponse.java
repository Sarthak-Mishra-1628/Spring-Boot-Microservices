package com.microservices.hotel_service.Payload;
import org.springframework.http.HttpStatus;
import lombok.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class APIResponse {

    public String message;
    public boolean success;
    public HttpStatus status;

}
