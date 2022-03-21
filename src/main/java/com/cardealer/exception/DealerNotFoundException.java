package com.cardealer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DealerNotFoundException extends RuntimeException{
    public DealerNotFoundException(String message) {
        super(message);
    }
}
