package com.essaadani.cinema.dao;

import com.essaadani.cinema.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface FilmRepository extends JpaRepository<Film, Long> {
}
