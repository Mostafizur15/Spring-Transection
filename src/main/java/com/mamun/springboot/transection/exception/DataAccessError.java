package com.mamun.springboot.transection.exception;

public class DataAccessError extends RuntimeException{
    public DataAccessError(String message) {
        super(message);
    }
}
