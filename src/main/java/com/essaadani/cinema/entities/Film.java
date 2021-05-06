package com.essaadani.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5, max = 15)
    private String titre;

    @NotNull
    @Size(min = 5, max = 15)
    private String realisateur;

    @NotNull
    @Size(min = 10, max = 50)
    private String description;

    private Date dateSortie;

    private double duree;
    @NotNull
    private String photo;

    @OneToMany(mappedBy = "film")
    private Collection<Projection> projections;

    @ManyToOne
    private Categorie categorie;
}
