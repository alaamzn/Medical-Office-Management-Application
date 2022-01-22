package com.mezni.examplejpa02.dao;

import com.mezni.examplejpa02.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Long> {

}
