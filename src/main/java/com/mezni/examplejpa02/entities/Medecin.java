package com.mezni.examplejpa02.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Medecin")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Medecin {

    @Id @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String nom;
    private String specialite;
    private String email;
    // Relation with RendezVous
    @OneToMany(
            mappedBy = "medecin"
    )

    private Collection<RendezVous> listeRendezVous;
}
