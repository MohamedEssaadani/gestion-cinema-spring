package com.essaadani.cinema.dao;

import com.essaadani.cinema.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cinemaRepository extends JpaRepository<Cinema, Long> {
}
