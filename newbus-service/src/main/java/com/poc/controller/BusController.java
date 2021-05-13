package com.poc.controller;

import com.poc.model.Ticket;
import com.poc.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus/v1")
public class BusController {


    @Autowired
    BusService busService;

    @PostMapping("/create-bus-ticket")
    public String createTicket(@RequestBody Ticket ticket) {

        return busService.createTicket(ticket);

    }

    @GetMapping("/get-bus-ticket/{id}")
    public Ticket getTicketById(@PathVariable Long id) {

        return busService.getTicketById(id);

    }

    @GetMapping("/get-All-tickets")
    public List<Ticket> getAllTickets() {

        return busService.getAllTickets();

    }

    @DeleteMapping("/delete-bus-ticket/{id}")
    public void deleteTicketById(@PathVariable Long id) {

        busService.deleteTicketById(id);

    }

}
