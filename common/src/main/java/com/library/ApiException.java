package com.library;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {

    private final ErrorType errorType;
    private final String errorMessage;
    private final HttpStatus httpStatus;


    public ApiException(ErrorType errorType, String errorMessage, HttpStatus httpStatus) {
        this.errorType = errorType;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }


}
