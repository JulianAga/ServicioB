package com.servicioB.servicioB.controller;

import com.servicioB.servicioB.models.Logger;
import com.servicioB.servicioB.models.Ticket;
import com.servicioB.servicioB.service.IntegrationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private IntegrationService integrationService;

    @Autowired
    public TicketController(IntegrationService integrationService) {
        this.integrationService = integrationService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message ="ticket y fecha de uso"),
            @ApiResponse(code = 404, message ="ticket no encontrado")
    })
    public ResponseEntity getTicketById(@PathVariable Integer id){
        ResponseEntity<Ticket> ticket = integrationService.getById(id);
        Logger logger = Logger.builder().date(LocalDateTime.now())
                .discount(ticket.getBody().getDiscount())
                .number(ticket.getBody().getNumber())
                .id(ticket.getBody().getId())
                .build();

        integrationService.saveLog(logger);
        return integrationService.getById(id);
    }

}
