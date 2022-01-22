package com.mezni.examplejpa02.service;

import com.mezni.examplejpa02.dao.RendezVousRepository;
import com.mezni.examplejpa02.entities.RendezVous;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
@Transactional
public class RendezVousServiceImpl implements RendezVousService{

    private RendezVousRepository rendezVousRepository;


    @Override
    public RendezVous getRendezVous(Long id) {
        return rendezVousRepository.findById(id).orElse(null);
    }

    @Override
    public List<RendezVous> getAllRendezVous() {
        return rendezVousRepository.findAll();
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public List<RendezVous> saveAllRendezVous(List<RendezVous> listeRendezVous) {
        return rendezVousRepository.saveAll(listeRendezVous);
    }

    @Override
    public RendezVous updateRendezVous(Long id, String dateRDV, String heureRDV) {

        RendezVous rendezVousToUpdate = rendezVousRepository
                .findById(id)
                .orElseThrow(() ->
                        new IllegalStateException("Rendez vous with id : " + id + "not found !"));

        if(dateRDV != null &&
           dateRDV.length() > 0 &&
           !Objects.equals(rendezVousToUpdate.getDateRDV(), dateRDV)){
            rendezVousToUpdate.setDateRDV(dateRDV);
        }

        if(heureRDV != null &&
           heureRDV.length() > 0 &&
           !Objects.equals(rendezVousToUpdate.getHeureRDV(), heureRDV)){
            rendezVousToUpdate.setHeureRDV(heureRDV);
        }
        return rendezVousRepository.save(rendezVousToUpdate);
    }

    @Override
    public String deleteRendezVous(Long id) {
        rendezVousRepository.deleteById(id);
        return  "RendezVous deleted !";
    }
}
