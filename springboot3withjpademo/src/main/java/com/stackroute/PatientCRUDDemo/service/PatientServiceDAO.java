package com.stackroute.PatientCRUDDemo.service;

import com.stackroute.PatientCRUDDemo.exception.PatientAlreadyExistException;
import com.stackroute.PatientCRUDDemo.exception.PatientIdDoesNotExistException;
import com.stackroute.PatientCRUDDemo.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientServiceDAO {

    public Patient addPatient(Patient patient) throws PatientAlreadyExistException;
    public List<Patient> viewAllPatients();

    //delete
    boolean deletePatientbyId(int pId) throws PatientIdDoesNotExistException;

    public Patient updatePatient(Patient patient) throws PatientIdDoesNotExistException;
    //update
    // address

    public List<Patient> getPatientByName(String name);

    public List<Patient> getPatientIdLessthen(int id);

     public Optional<Patient> getPatientByPatientId(int id);

     public List<Patient> getPatientByProblem(String name);


}
