package com.essaadani.cinema.entities;


import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.util.List;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    @DecimalMin("1")
   private int numero;
   private double longitude;
   private double latitude;
   private double altitude;

   @ManyToOne
   private Salle salle;

   @OneToMany(mappedBy = "place")
    private List<Ticket> tickets;

}
