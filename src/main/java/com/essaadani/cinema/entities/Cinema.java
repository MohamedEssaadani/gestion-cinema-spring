package com.essaadani.cinema.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Cinema {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, max = 15)
    private String nom;
    private double longitude;
    private double latitude;
    private double altitude;
    @DecimalMin("1")
    private int nombreSalles;

    @ManyToOne
    private Ville ville;

    @OneToMany(mappedBy = "cinema")
    private List<Salle> salle;
}
