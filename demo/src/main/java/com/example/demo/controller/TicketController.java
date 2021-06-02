package com.example.demo.controller;

import com.example.demo.entity.Ticket;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
    @Qualifier("ticketServiceImpl")
    @Autowired
    TicketService ticketService;

    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Ticket ticket = (Ticket) this.ticketService.findById(id);

        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @RequestMapping(value = "/ticket", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket) {
        HttpHeaders headers = new HttpHeaders();
        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.ticketService.save(ticket);
        return new ResponseEntity<>(ticket, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> deleteTicket(@PathVariable("id") Long id) {
        Ticket ticket = (Ticket) this.ticketService.findById(id);

        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.ticketService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = this.ticketService.findAll();

        if (tickets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
}
