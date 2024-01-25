package com.stackroute.PatientCRUDDemo.service;

import com.stackroute.PatientCRUDDemo.exception.PatientAlreadyExistException;
import com.stackroute.PatientCRUDDemo.exception.PatientIdDoesNotExistException;
import com.stackroute.PatientCRUDDemo.model.Patient;
import com.stackroute.PatientCRUDDemo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientServiceDAO{
    @Autowired
    PatientRepository repository;
    @Override
    public Patient addPatient(Patient patient) throws PatientAlreadyExistException {
       Patient patient1 ;
        Optional<Patient> optionalPatient = repository.findById(patient.getPatientId());
        if(optionalPatient.isPresent()){
            throw new PatientAlreadyExistException("Duplicate PatiendId");
        }
        else
            patient1 = repository.save(patient);
            return patient1;
    }
    @Override
    public List<Patient> viewAllPatients() {
        return repository.findAll();
    }

    @Override
    public boolean deletePatientbyId(int pId) throws PatientIdDoesNotExistException {

        Optional<Patient> optionalPatient = repository.findById(pId);
        if(optionalPatient.isPresent()){
            repository.deleteById(pId);
            return true;
        }else
            throw new PatientIdDoesNotExistException("Patient Id is not available in DB");
    }

    @Override
    public Patient updatePatient(Patient patient) throws PatientIdDoesNotExistException {
        Optional<Patient> optionalPatient = repository.findById(patient.getPatientId());
        if(optionalPatient.isPresent()){
            return repository.save(patient);
        }else
            throw new PatientIdDoesNotExistException("Patient Id is not Available in DB");
    }

    @Override
    public List<Patient> getPatientByName(String name) {

       return repository.findByPatientName(name);
    }

    @Override
    public List<Patient> getPatientIdLessthen(int id) {
        return repository.findByPatientIdLessThan(id);
    }

    @Override
    public Optional<Patient> getPatientByPatientId(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Patient> getPatientByProblem(String name) {
        return repository.findByProblem(name);
    }


}
