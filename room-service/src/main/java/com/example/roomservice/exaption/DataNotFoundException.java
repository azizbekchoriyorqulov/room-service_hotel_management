package com.example.roomservice.exaption;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String massage)  { super(massage);
    }
}
