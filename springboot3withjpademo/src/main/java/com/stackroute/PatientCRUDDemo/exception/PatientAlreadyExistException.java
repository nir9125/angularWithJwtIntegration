package com.stackroute.PatientCRUDDemo.exception;

public class PatientAlreadyExistException extends  Exception{
    public PatientAlreadyExistException(String message) {
        super(message);
    }
}
