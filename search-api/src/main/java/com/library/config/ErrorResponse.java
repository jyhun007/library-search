package com.library.config;

import com.library.ErrorType;
import lombok.AllArgsConstructor;


public record ErrorResponse(ErrorType errorType,String errorMessage ) { }
