package com.mezni.examplejpa02.service;

import com.mezni.examplejpa02.dao.PatientRepository;
import com.mezni.examplejpa02.entities.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class PatientServiceImpl implements PatientService{


    private final PatientRepository patientRepository;


    public Patient addPatient(Patient patient) {
//        Optional<Patient> patientOptional = patientRepository
//                .findPatientByEmail(patient.getEmail());
//
//        if(!patientOptional.isPresent()){
//            throw new IllegalStateException("Email taken");
//        }

        return patientRepository.save(patient);
        //System.out.println(patient);
    }

    public List<Patient> addPatients(List<Patient> patients){
        return patientRepository.saveAll(patients);
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Transactional
    public Patient updatePatient(Long id, String nom, String email) {
        Patient patient = patientRepository.findById(id).
                orElseThrow(() ->
                    new IllegalStateException(
                            "Patient with id :" + id +" not found")
                );

        if(nom != null &&
           nom.length() > 0 &&
           !Objects.equals(patient.getNom() ,nom)){
            patient.setNom(nom);
        }

        if(email != null &&
           email.length() > 0 &&
           !Objects.equals(patient.getEmail(), email)){

//            Optional<Patient> patientOptional =
//                    patientRepository.findPatientByEmail(email);
//            if(!patientOptional.isPresent()){
//                throw new IllegalStateException("Email is taken");
//            }

            patient.setEmail(email);
        }

        return patientRepository.save(patient);
    }

    public String deletePatient(Long id) {
        patientRepository.deleteById(id);
        return "Patient deleted" +id;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
