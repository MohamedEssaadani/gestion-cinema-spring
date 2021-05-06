package com.essaadani.cinema.dao;

import com.essaadani.cinema.entities.Cinema;
import com.essaadani.cinema.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface filmRepository extends JpaRepository<Film, Long> {
}
