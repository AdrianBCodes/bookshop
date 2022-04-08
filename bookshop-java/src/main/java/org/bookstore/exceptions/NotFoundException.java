package org.bookstore.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
