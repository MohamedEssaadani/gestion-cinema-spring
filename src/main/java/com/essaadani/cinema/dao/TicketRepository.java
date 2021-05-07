package com.essaadani.cinema.dao;

import com.essaadani.cinema.entities.Categorie;
import com.essaadani.cinema.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
