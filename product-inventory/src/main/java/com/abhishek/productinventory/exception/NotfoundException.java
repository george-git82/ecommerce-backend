package com.abhishek.productinventory.exception;

public class NotfoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotfoundException(String message) {
        super(message);
        System.err.println("Custom ERROR: " + message);
    }
}
