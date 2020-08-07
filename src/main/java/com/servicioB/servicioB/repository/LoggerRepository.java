package com.servicioB.servicioB.repository;

import com.servicioB.servicioB.models.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends JpaRepository<Logger,Integer> {
}
