package com.essaadani.cinema.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
public class Ville {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=5, max=15)
    private String nom;
    private double longitude;
    private double latitude;
    private double altitude;

    @OneToMany(mappedBy = "ville")
    private List<Cinema> cinemas;
}
