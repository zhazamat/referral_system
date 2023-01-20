package com.example.referalservice.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    String message;
    String description;

    public ErrorResponse(String message) {
        this.message = message;
    }
}
