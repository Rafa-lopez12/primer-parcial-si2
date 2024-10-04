package com.backend.backend.Proveedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Proveedor_Repository extends JpaRepository<Proveedor, Integer> {
    boolean existsByNombre(String nombre);
}
