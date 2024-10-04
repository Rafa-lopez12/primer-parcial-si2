package com.backend.backend.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Sucursal_Repository extends JpaRepository<Sucursal, Integer>{
    boolean existsByNombre(String nombre);
}
