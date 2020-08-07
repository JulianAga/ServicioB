package com.servicioB.servicioB.service;

import com.servicioB.servicioB.models.Logger;
import com.servicioB.servicioB.repository.LoggerRepository;
import com.servicioB.servicioB.service.integration.IntegrationComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class IntegrationService {

    IntegrationComponent integrationComponent;

    LoggerRepository loggerRepository;

    @Autowired
    public IntegrationService(IntegrationComponent integrationComponent, LoggerRepository loggerRepository) {
        this.integrationComponent = integrationComponent;
        this.loggerRepository = loggerRepository;
    }

    public void saveLog(Logger logger){
        this.loggerRepository.save(logger);
    }

    public ResponseEntity getById(Integer id){
       return this.integrationComponent.getById(id);
    }

}
