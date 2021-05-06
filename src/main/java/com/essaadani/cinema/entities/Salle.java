package com.essaadani.cinema.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, max = 15)
    private String nom;
    @DecimalMin("1")
    private int nombrePlaces;

    @ManyToOne
    private Cinema cinema;

    @OneToMany
    private List<Place> places;
}
