package com.example.springbootapph2.exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(){
        super("Author Not Found Exception");
    }
}
