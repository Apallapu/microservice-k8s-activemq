package com.poc.service;

import com.poc.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BusService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${newbus.url}")
    private String busURL;


    public String createTicket(Ticket ticket) {
        jmsTemplate.convertAndSend("ticketTopic", ticket);
        return "Done";
    }



    public Ticket getTicketById(Long id) {
        String url = new StringBuilder(busURL).append("/get-bus-ticket/").append(id).toString();
        return restTemplate.getForObject(url, Ticket.class);
    }

    public List<Ticket> getAllTickets() {
        String url = new StringBuilder(busURL).append("/get-All-tickets").toString();
        return restTemplate.getForObject(url, List.class);
    }

    public void deleteTicketById(Long id) {
        String url = new StringBuilder(busURL).append("/delete-bus-ticket/").append(id).toString();
        restTemplate.delete(url);
    }

}


