package com.essaadani.cinema.dao;

import com.essaadani.cinema.entities.Projection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectionRepository extends JpaRepository<Projection, Long> {
}
