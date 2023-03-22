package com.example.springbootapph2.exceptions;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(){
        super("Country Not Found Exception!");
    }
}
