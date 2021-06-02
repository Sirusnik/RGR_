package com.example.demo.repository;

import com.example.demo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "ticket", path = "ticket")
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Ticket findTicketById(Long id);

    Ticket findTicketByTour(String tour);

}
