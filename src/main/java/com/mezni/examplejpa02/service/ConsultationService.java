package com.mezni.examplejpa02.service;

import com.mezni.examplejpa02.entities.Consultation;


import java.util.List;

public interface ConsultationService {

    Consultation saveConsultation(Consultation consultation);
    List<Consultation> saveConsultations(List<Consultation> consultations);

    Consultation getConsultation(Long id);
    List<Consultation> getConsultations();

    Consultation updateConsultation(Long id, String dateConsultation, String rapportConsultation);
    String deleteConsultation(Long id);

}
