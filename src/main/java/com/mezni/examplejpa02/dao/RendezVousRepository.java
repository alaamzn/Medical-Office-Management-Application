package com.mezni.examplejpa02.dao;

import com.mezni.examplejpa02.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    //List<RendezVous> findByMedecin(Medecin medecin);
}
