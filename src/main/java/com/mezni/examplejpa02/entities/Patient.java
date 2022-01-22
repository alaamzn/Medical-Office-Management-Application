package com.mezni.examplejpa02.entities;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient {

    @Id @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String nom;
    private String email;
    // Relation with RendezVous
    @OneToMany(mappedBy = "patient")
    private Collection<RendezVous> listeRendezVous;

}
