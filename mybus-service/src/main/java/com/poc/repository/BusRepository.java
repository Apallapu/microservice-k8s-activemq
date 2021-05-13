package com.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sun.security.krb5.internal.Ticket;

@Repository
public interface BusRepository extends JpaRepository<com.poc.entity.Ticket, Long> {

    public Ticket findByName(String name);

    public Ticket findByNameAndCost(String name, Integer cost);
}
