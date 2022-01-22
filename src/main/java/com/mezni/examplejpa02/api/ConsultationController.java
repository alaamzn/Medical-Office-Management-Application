package com.mezni.examplejpa02.api;


import com.mezni.examplejpa02.entities.Consultation;
import com.mezni.examplejpa02.service.ConsultationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ConsultationController {

    private final ConsultationService consultationService;


    @PostMapping("/addConsultation")
    public Consultation saveConsultation(@RequestBody Consultation consultation){
        return consultationService.saveConsultation(consultation);
    }

    @PostMapping("/addConsultations")
    public List<Consultation> saveConsultations(@RequestBody List<Consultation> consultations){
        return consultationService.saveConsultations(consultations);
    }

    @GetMapping("/consultation/{id}")
    public Consultation getConsultation(@PathVariable Long id){
        return consultationService.getConsultation(id);
    }

    @GetMapping("/consultations")
    public List<Consultation> getConsultations(){
        return consultationService.getConsultations();
    }

    @PutMapping("/consultation/update/{id}")
    public Consultation updateConsultation(@PathVariable Long id,
                                           @RequestParam(required = false) String dateConsultation,
                                           @RequestParam(required = false) String rapportConsultation){
        return consultationService.updateConsultation(id, dateConsultation, rapportConsultation);
    }

    @DeleteMapping("/consultation/{id}")
    public String deleteConsultation(@PathVariable Long id){
        return consultationService.deleteConsultation(id);
    }


}
