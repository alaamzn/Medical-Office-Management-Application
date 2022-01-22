package com.mezni.examplejpa02.api;

import com.mezni.examplejpa02.entities.Medecin;
import com.mezni.examplejpa02.service.MedecinService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class MedecinsController {

    private final MedecinService medecinService;


    @PostMapping("/addMedecin")
    public Medecin saveMedecin(@RequestBody Medecin medecin){
        return medecinService.saveMedecin(medecin);
    }

    @PostMapping("/addMedecins")
    public List<Medecin> saveMedecins(@RequestBody List<Medecin> medecins){
        return medecinService.saveMedecins(medecins);
    }

    @GetMapping("/medecin/{id}")
    public Medecin getMedecinById(@PathVariable Long id){
        return medecinService.getMedecinById(id);
    }

    @GetMapping("/medecins")
    public List<Medecin> getAllMedecin(){
        return medecinService.getAllMedecin();
    }

    @PutMapping("/medecin/update/{id}")
    public Medecin updateMedecin(@PathVariable Long id,
                                 @RequestParam(required = false) String nom,
                                 @RequestParam(required = false) String specialite,
                                 @RequestParam(required = false) String email){
        return medecinService.updateMedecin(id, nom, specialite, email);
    }

    @DeleteMapping("/medecin/delete/{id}")
    public String deleteMedecin(@PathVariable Long id){
        return medecinService.deleteMedecin(id);
    }
}
