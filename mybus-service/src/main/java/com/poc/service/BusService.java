package com.poc.service;

import com.poc.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.poc.exception.TicketIdNotFoundException;
import com.poc.exception.TicketUpdateException;
import com.poc.repository.BusRepository;

import java.util.List;

@Service
public class BusService {


    @Autowired
    BusRepository busRepository;

    public com.poc.entity.Ticket createTicket(com.poc.entity.Ticket ticket) {
        return busRepository.save(ticket);
    }

    public Ticket updateTicket(Ticket ticket, Long id) {
        Ticket updatedTicket = busRepository.findById(id).orElseThrow(()->new TicketUpdateException(HttpStatus.NOT_FOUND.value(),"Ticket Id Not Found for update the record"));
        updatedTicket.setCost(ticket.getCost());
        updatedTicket.setName(ticket.getName());
        updatedTicket.setTicket_from(ticket.getTicket_from());
        updatedTicket.setTicket_to(ticket.getTicket_to());

        return busRepository.save(updatedTicket);
    }

    public Ticket getTicketById(Long id) {
        return busRepository.findById(id).orElseThrow(()->new TicketIdNotFoundException(HttpStatus.NOT_FOUND.value(),"Ticket Id Not Found"));
    }

    public List<Ticket> getAllTickets() {

        return busRepository.findAll();
    }

    public void deleteTicketById(Long id) {
        busRepository.deleteById(id);
    }

}

