package com.essaadani.cinema.dao;

import com.essaadani.cinema.entities.Categorie;
import com.essaadani.cinema.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface salleRepository extends JpaRepository<Salle, Long> {
}
