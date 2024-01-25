package com.stackroute.PatientCRUDDemo.repository;

import com.stackroute.PatientCRUDDemo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

    List<Patient> findByPatientName(String name);
    List<Patient> findByPatientIdLessThan(int pid);
    List<Patient> findByProblem(String pbm);


}
