package com.essaadani.cinema.dao;

import com.essaadani.cinema.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categorieRepository extends JpaRepository<Categorie, Long> {
}
