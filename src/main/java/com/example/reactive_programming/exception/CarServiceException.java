package com.example.reactive_programming.exception;

public class CarServiceException extends RuntimeException {
    public CarServiceException(String message) {
        super(message);
    }
}
