package com.mezni.examplejpa02.service;

import com.mezni.examplejpa02.dao.MedecinRepository;
import com.mezni.examplejpa02.entities.Medecin;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
@Transactional
public class MedecinServiceImpl implements MedecinService{

    private MedecinRepository medecinRepository;


    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public List<Medecin> saveMedecins(List<Medecin> medecins) {
        return medecinRepository.saveAll(medecins);
    }

    @Override
    public Medecin getMedecinById(Long id) {
        return medecinRepository.findById(id).orElse(null);
    }

    @Override
    public List<Medecin> getAllMedecin() {
        return medecinRepository.findAll();
    }

    @Override
    public Medecin updateMedecin(Long id, String nom, String specialite, String email) {

        Medecin medecinOptional = medecinRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalStateException("Medecin with id : " + id + " not found"));

        if(nom != null &&
           nom.length() >0 &&
           !Objects.equals(medecinOptional.getNom(), nom)){
            medecinOptional.setNom(nom);
        }

         if(specialite != null &&
                specialite.length() > 0 &&
                !Objects.equals(medecinOptional.getSpecialite(), specialite)){
             medecinOptional.setSpecialite(specialite);
         }

         if(email != null &&
            email.length() > 0 &&
            !Objects.equals(medecinOptional.getEmail(), email)){
             medecinOptional.setEmail(email);
         }

        return medecinRepository.save(medecinOptional);
    }

    @Override
    public String deleteMedecin(Long id) {
        medecinRepository.deleteById(id);
        return " Medecin deleted !";
    }
}
