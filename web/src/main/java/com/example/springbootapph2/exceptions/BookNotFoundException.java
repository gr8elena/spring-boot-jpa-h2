package com.example.springbootapph2.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(){
        super("BookNotFoundException");
    }
}
