package com.cardealer.exception;

public class DealerNotFoundExceptionResponse {

    private String userIdentifier;

    public DealerNotFoundExceptionResponse(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }
}
