package com.cardealer.exception;

public class TierLimitExceptionResponse {

    private String userIdentifier;

    public TierLimitExceptionResponse(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }
}
