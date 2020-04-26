package com.stacksimplify.restservices.exceptions;

public class UserExistsException extends Exception {
    private static final long serialVersionUID = 1234234L;

    public UserExistsException(String message) {
        super(message);
    }
}
