package com.mezni.examplejpa02.service;

import com.mezni.examplejpa02.dao.ConsultationRepository;
import com.mezni.examplejpa02.entities.Consultation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


@RequiredArgsConstructor
@Service
@Transactional
public class ConsultationServiceImpl implements ConsultationService{


    private final ConsultationRepository consultationRepository;



    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public List<Consultation> saveConsultations(List<Consultation> consultations) {
        return consultationRepository.saveAll(consultations);
    }

    @Override
    public Consultation getConsultation(Long id) {
        return consultationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Consultation> getConsultations() {
        return consultationRepository.findAll();
    }

    @Override
    public Consultation updateConsultation(Long id,
                                           String dateConsultation,
                                           String rapportConsultation) {

    Consultation consultationToUpdate = consultationRepository.findById(id)
            .orElseThrow(() ->
                    new IllegalStateException("Consultation with id : "+ id + " not found"));

    if(dateConsultation != null &&
       dateConsultation.length() > 0 &&
       !Objects.equals(consultationToUpdate.getDateConsultation(), dateConsultation)){
        consultationToUpdate.setDateConsultation(dateConsultation);
    }

    if(rapportConsultation != null &&
       rapportConsultation.length() > 0 &&
       !Objects.equals(consultationToUpdate.getRapportConsultation(), rapportConsultation)){
        consultationToUpdate.setRapportConsultation(rapportConsultation);
    }

        return consultationRepository.save(consultationToUpdate);
    }

    @Override
    public String deleteConsultation(Long id) {
        consultationRepository.deleteById(id);
        return " Consultation with id : "+ id +" deleted !";
    }
}
