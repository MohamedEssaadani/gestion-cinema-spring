package com.essaadani.cinema.dao;

import com.essaadani.cinema.entities.Categorie;
import com.essaadani.cinema.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface seanceRepository extends JpaRepository<Seance, Long> {
}
