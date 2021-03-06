package com.essaadani.cinema.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

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
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Ticket> tickets;

}
