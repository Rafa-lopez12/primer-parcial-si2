package com.backend.backend.Tamaño;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tamaño_Repository extends JpaRepository<Tamaño, Integer> {
    boolean existsByNombre(String nombre);
}