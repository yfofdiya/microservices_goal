package com.practice.exception;

public class BlankFieldException extends RuntimeException {
    public BlankFieldException(String message) {
        super(message);
    }
}
