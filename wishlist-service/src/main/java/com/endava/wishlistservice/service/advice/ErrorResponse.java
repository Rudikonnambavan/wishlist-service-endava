package com.endava.wishlistservice.service.advice;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

    private int status;
    private String message;
}
