package com.essaadani.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Projection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateProjection;
    private double prix;

    @OneToMany(mappedBy = "projection")
    private Collection<Ticket> tickets;

    @ManyToOne
    private Film film;
    @ManyToOne
    private Salle salle;
    @ManyToOne
    private Seance seance;

}
