package com.essaadani.cinema.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, max = 15)
    private String nomClient;
    private double prix;
    @DecimalMin("1")
    private int codePayement;
    private boolean reservee;


    @ManyToOne
    private Place place;

    @ManyToOne
    private ProjectionFilm projectionFilm;

}
