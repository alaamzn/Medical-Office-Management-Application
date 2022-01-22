package com.mezni.examplejpa02.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Consultation {

    @Id @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String dateConsultation;
    private String rapportConsultation;

    // Relation with RendezVous
    @OneToOne
    private RendezVous rendezVous;
}
