package com.microservices.rating_service.Exceptions;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.microservices.rating_service.Payload.APIResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> handleResourceNotFoundException(ResourceNotFoundException exception){
        String message = exception.getMessage();

        APIResponse response = APIResponse.builder().message(message).success(false).status(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<APIResponse>(response,HttpStatus.NOT_FOUND);
    }
}