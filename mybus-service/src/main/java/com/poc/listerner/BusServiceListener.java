package com.poc.listerner;

import com.poc.model.Ticket;
import com.poc.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class BusServiceListener {

    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    BusService busService;

    @JmsListener(destination = "ticketTopic", containerFactory = "myFactory")
    public void receiveMessage(Ticket ticket) {
        com.poc.entity.Ticket ticketEntity = new  com.poc.entity.Ticket();
        ticketEntity.setCost(ticket.getCost());
        ticketEntity.setName(ticket.getName());
        ticketEntity.setTicket_from(ticket.getTicket_from());
        ticketEntity.setTicket_to(ticket.getTicket_to());
        busService.createTicket(ticketEntity);

    }

}

