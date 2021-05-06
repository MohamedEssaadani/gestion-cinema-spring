package com.essaadani.cinema.dao;

import com.essaadani.cinema.entities.Place;
import com.essaadani.cinema.entities.Projection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface projectionRepository extends JpaRepository<Projection, Long> {
}
