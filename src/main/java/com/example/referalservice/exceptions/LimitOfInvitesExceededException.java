package com.example.referalservice.exceptions;

public class LimitOfInvitesExceededException extends RuntimeException{
    public LimitOfInvitesExceededException(String message){
        super(message);
    }
}

