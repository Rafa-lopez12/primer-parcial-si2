package com.backend.backend.ventas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ventas_Repository extends JpaRepository<Ventas, Integer> {
    
}
