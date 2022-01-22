package com.mezni.examplejpa02.dao;

import com.mezni.examplejpa02.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    //@Query("select p from patient p where p.email = ?1")
    Optional<Patient> findPatientByEmail(String email);
}
