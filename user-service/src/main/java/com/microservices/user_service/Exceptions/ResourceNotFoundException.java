package com.microservices.user_service.Exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
        super("Resource Not Found on Server !!!");
    }

    public ResourceNotFoundException(String msg){
        super(msg);
    }

}
