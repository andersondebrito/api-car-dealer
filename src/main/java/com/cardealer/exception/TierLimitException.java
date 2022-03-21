package com.cardealer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TierLimitException extends RuntimeException{
    public TierLimitException(String message) {
        super(message);
    }
}
