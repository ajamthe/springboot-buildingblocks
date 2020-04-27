package com.stacksimplify.restservices.exceptions;

import com.stacksimplify.restservices.exceptions.CustomErrorDetails;
import com.stacksimplify.restservices.exceptions.UsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

//@RestControllerAdvice
public class GlobalRestControllerAdviceExceptionHandler {
    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomErrorDetails usernameNotFound(UsernameNotFoundException ex) {
        return new CustomErrorDetails(new Date(), "From RestContollerAdvice", ex.getMessage());
    }
}
