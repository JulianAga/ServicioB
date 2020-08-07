package com.servicioB.servicioB.service.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class IntegrationComponent {

    public static final String URL = "http://localhost:8081/ticket/";

    RestTemplate rest;

    @PostConstruct
    private void init(){
        rest = new RestTemplate();
    }

    public ResponseEntity getById(Integer id){
        return rest.getForEntity(URL + id,String.class);
    }

}
