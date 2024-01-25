package com.stackroute.PatientCRUDDemo.exception;

public class PatientIdDoesNotExistException extends Exception{
    public PatientIdDoesNotExistException(String message) {
        super(message);
    }
}
