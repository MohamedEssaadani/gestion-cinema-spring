package com.essaadani.cinema.dao;

import com.essaadani.cinema.entities.Cinema;
import com.essaadani.cinema.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface placeRepository extends JpaRepository<Place, Long> {
}
