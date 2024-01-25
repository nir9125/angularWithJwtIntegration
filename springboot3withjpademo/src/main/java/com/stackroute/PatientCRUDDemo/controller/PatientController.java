package com.stackroute.PatientCRUDDemo.controller;


import com.stackroute.PatientCRUDDemo.exception.PatientAlreadyExistException;
import com.stackroute.PatientCRUDDemo.exception.PatientIdDoesNotExistException;
import com.stackroute.PatientCRUDDemo.model.Patient;
import com.stackroute.PatientCRUDDemo.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class PatientController {
    @Autowired
    PatientServiceImpl service;

    @PostMapping("/addpatient")
    public ResponseEntity<?> addPatient(@RequestBody Patient patient){
        try {
            Patient patient1 = service.addPatient(patient);
            return new ResponseEntity<Patient>(patient1, HttpStatus.CREATED);
        } catch (PatientAlreadyExistException e) {
            return  new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }
    @GetMapping("viewall")
    public ResponseEntity<?> viewAllPatients(){
        List<Patient> patientList = service.viewAllPatients();
         return  new ResponseEntity<List>(patientList,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{pid}")
    public ResponseEntity<?> deletePatient(@PathVariable("pid") String id){
        try {
            boolean result = service.deletePatientbyId(Integer.parseInt(id));
            return new ResponseEntity<String>("Patient Record Deleted", HttpStatus.OK);
        } catch (PatientIdDoesNotExistException e) {
            return new ResponseEntity<String>("Patient Id Does exist in DB",HttpStatus.CONFLICT);
        }
        catch (NumberFormatException exception){
            return new ResponseEntity<String>("Patient Id always be a number",HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePatient(@RequestBody Patient patient){
        try {
            Patient patient1 = service.updatePatient(patient);
            return new ResponseEntity<Patient>(patient1,HttpStatus.OK);
        } catch (PatientIdDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/viewbyname/{pname}")
    public ResponseEntity<?> viewByName(@PathVariable String pname){
        List<Patient> patientList = service.getPatientByName(pname);
        return new ResponseEntity<List>(patientList,HttpStatus.OK);
    }

    @GetMapping("viewbyid/{pid}")
    public Optional<Patient> viewByPatientId(@PathVariable int pid){
        return service.getPatientByPatientId(pid);
    }

    @GetMapping("abcd/{pid}")
    public ResponseEntity<?> xyz(@PathVariable int pid){
        List<Patient> patientList = service.getPatientIdLessthen(pid);
        return new ResponseEntity<List>(patientList,HttpStatus.OK);
    }

 @GetMapping("viewbyprbm/{pname}")
    public ResponseEntity<?> getPatientByProblemName(@PathVariable String pname){
        List<Patient> patientList = service.getPatientByProblem(pname);
        return new ResponseEntity<List>(patientList,HttpStatus.OK);
 }
}
