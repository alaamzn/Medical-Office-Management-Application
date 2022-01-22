package com.mezni.examplejpa02.service;

import com.mezni.examplejpa02.entities.Medecin;

import java.util.List;

public interface MedecinService {
    Medecin saveMedecin(Medecin medecin);
    List<Medecin> saveMedecins(List<Medecin> medecins);

    Medecin getMedecinById(Long id);
    List<Medecin> getAllMedecin();

    Medecin updateMedecin(Long id, String nom, String specialite, String email);
    String deleteMedecin(Long id);
}
