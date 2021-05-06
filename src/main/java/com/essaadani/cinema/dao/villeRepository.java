package com.essaadani.cinema.dao;

import com.essaadani.cinema.entities.Salle;
import com.essaadani.cinema.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface villeRepository extends JpaRepository<Ville, Long> {
}
