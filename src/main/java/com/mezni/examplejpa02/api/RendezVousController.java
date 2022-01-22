package com.mezni.examplejpa02.api;

import com.mezni.examplejpa02.entities.RendezVous;
import com.mezni.examplejpa02.service.RendezVousService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class RendezVousController {

    private final RendezVousService rendezVousService;



    @GetMapping("/rendezVous")
    public List<RendezVous> getAllRendezVous(){
        return  rendezVousService.getAllRendezVous();
    }

    @GetMapping("/rendezVous/{id}")
    public RendezVous getRendezVous(@PathVariable Long id){
        return rendezVousService.getRendezVous(id);
    }

    @PostMapping("/rendezvous/addRendezVous")
    public RendezVous addRendezVous(@RequestBody RendezVous rendezVous){
        return rendezVousService.saveRendezVous(rendezVous);
    }

    @PostMapping("/rendezVous/addallRendezVous")
    public List<RendezVous> addAllRendezvous(@RequestBody List<RendezVous> listeRendezVous){
        return rendezVousService.saveAllRendezVous(listeRendezVous);
    }

    @PutMapping("/rendezvous/update/{id}")
    public RendezVous updateRendezVous(@PathVariable Long id,
                                       @RequestParam(required = false) String dateRDV,
                                       @RequestParam(required = false) String heureRDV){
        return rendezVousService.updateRendezVous(id, dateRDV, heureRDV);
    }

    @DeleteMapping("/rendezVous/delete/{id}")
    public String deleteRendezVous(@PathVariable Long id){
        return rendezVousService.deleteRendezVous(id);
    }

}
