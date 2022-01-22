package com.mezni.examplejpa02.service;

import java.util.Date;
import com.mezni.examplejpa02.entities.RendezVous;
import java.util.List;

public interface RendezVousService {
    RendezVous getRendezVous(Long id);
    List<RendezVous> getAllRendezVous();

    RendezVous saveRendezVous(RendezVous rendezVous);
    List<RendezVous> saveAllRendezVous(List<RendezVous> listeRendezVous);

    RendezVous updateRendezVous(Long id, String dateRDV, String heureRDV);
    String deleteRendezVous(Long id);
}
