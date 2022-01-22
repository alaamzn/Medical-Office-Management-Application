package com.mezni.examplejpa02.api;

import com.mezni.examplejpa02.entities.Patient;
import com.mezni.examplejpa02.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PatientsController {

    private final PatientService patientService;

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient) {
         return patientService.addPatient(patient);
    }

    @PostMapping("/addPatients")
    public List<Patient> addPatients(@RequestBody List<Patient> patients){
        return patientService.addPatients(patients);
    }

    @GetMapping("/patients")
    public List<Patient> patients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/patientById/{id}")
    public Patient getPatient(@PathVariable Long id){
        return patientService.getPatientById(id);
    }

    @PutMapping(path = "/patient/update/{id}")
    public Patient updatePatient(@PathVariable Long id,
                              @RequestParam(required = false) String nom,
                              @RequestParam(required = false) String email) {
         return patientService.updatePatient(id, nom, email);
     }

    @DeleteMapping("/patient/delete/{id}")
    public String deletePatientById(@PathVariable Long id) {
         return patientService.deletePatient(id);
    }

}
