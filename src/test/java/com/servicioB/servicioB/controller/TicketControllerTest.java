package com.servicioB.servicioB.controller;

import com.servicioB.servicioB.models.Ticket;
import com.servicioB.servicioB.service.IntegrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TicketControllerTest {

    @Mock
    IntegrationService integrationService;

    TicketController ticketController;

    @BeforeEach
    public void initMocks() {
        ticketController = new TicketController(integrationService);
    }

    @Test
    public void testGetTicketById() throws Exception {

        Ticket ticket = Ticket.builder().id(1).build();
        when(this.integrationService.getById(1)).thenReturn(ResponseEntity.ok().body(ticket));
        ResponseEntity<Ticket> ticket1 = ticketController.getTicketById(1);

        assertEquals(ticket.getId(),ticket1.getBody().getId());

    }

}
