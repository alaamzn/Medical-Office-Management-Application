package com.mezni.examplejpa02.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class RendezVous {

    @Id @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String dateRDV;
    private String heureRDV;

    // Relation with Patient
    @ManyToOne
    private Patient patient;

    //Relation with Medecin
    @ManyToOne
    private Medecin medecin;

    //Relation with Consultation
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;

}
