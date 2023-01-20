package com.example.referalservice.exceptions.handler;

import com.example.referalservice.dto.response.ErrorResponse;
import com.example.referalservice.exceptions.LimitOfInvitesExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(LimitOfInvitesExceededException.class)
    public ResponseEntity<?>handlerLimitExceededException (LimitOfInvitesExceededException ex){
        return new ResponseEntity(new ErrorResponse(ex.getMessage()), HttpStatus.CONFLICT);
    }
}
