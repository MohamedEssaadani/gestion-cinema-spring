package com.essaadani.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Categorie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(length = 25)
    private String nom;
    @OneToMany(mappedBy = "categorie")
    private Collection<Film> films;
}
