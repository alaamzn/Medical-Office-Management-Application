package com.mezni.examplejpa02.service;

import com.mezni.examplejpa02.entities.Patient;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public interface PatientService {


    Patient addPatient(Patient patient);
    List<Patient> addPatients(List<Patient> patients);
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    Patient updatePatient(Long id, String nom, String email);
    String deletePatient(Long id);

}
