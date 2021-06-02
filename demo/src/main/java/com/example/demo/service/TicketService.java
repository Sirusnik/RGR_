package com.example.demo.service;

import com.example.demo.entity.Ticket;

public interface TicketService extends GeneralService <Ticket>{
    Ticket findByTour(String tour);
}
