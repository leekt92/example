package com.ken207.example1.exception;

public class BizRuntimeException extends RuntimeException{
    private String message;

    public BizRuntimeException(String message) {
        super(message);
    }

}
