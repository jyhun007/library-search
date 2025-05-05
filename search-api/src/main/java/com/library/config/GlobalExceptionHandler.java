package com.library.config;

import com.library.ApiException;
import com.library.ErrorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleApiException(ApiException e) {
        log.error("Api exception occured, className={}, message={}, type={}", e.getClass().getName() ,e.getErrorMessage(), e.getErrorType());
        return ResponseEntity.status(e.getHttpStatus())
                .body(new ErrorResponse( e.getErrorType(), e.getErrorMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("Exception occured, className={}, message={}", e.getClass().getName() ,e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse( ErrorType.UNKNOWN, ErrorType.UNKNOWN.getDescription()));
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> handleBindException(BindException e) {
        log.error("Exception occured, className={}, message={}", e.getClass().getName() ,e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse( ErrorType.INVALID_PARAMETER, createMessage(e)));
    }

    private String createMessage(BindException e) {
        if(e.getFieldError() != null && e.getFieldError().getDefaultMessage() != null){
            return e.getFieldError().getDefaultMessage();
        }

        return e.getFieldErrors().stream()
                .map(FieldError::getField)
                .collect(Collectors.joining(", ")) + " 값들이 정확하지 않습니다";

    }
}
