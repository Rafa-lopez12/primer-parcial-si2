package com.backend.backend.detalleventas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVenta_Repository extends JpaRepository<DetalleVenta, Integer> {
    
}
