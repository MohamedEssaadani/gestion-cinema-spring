package com.essaadani.cinema.dao;

import com.essaadani.cinema.entities.Categorie;
import com.essaadani.cinema.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface SalleRepository extends JpaRepository<Salle, Long> {
}
