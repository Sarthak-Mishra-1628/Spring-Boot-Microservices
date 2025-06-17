package com.microservices.rating_service.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("Resource Not FOund on Server !!!");
    }

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
