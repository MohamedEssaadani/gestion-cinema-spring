package com.essaadani.cinema.dao;

import com.essaadani.cinema.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface VilleRepository extends JpaRepository<Ville, Long> {
}
