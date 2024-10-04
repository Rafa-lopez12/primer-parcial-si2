package com.backend.backend.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Categoria_Repository extends JpaRepository< Categoria, Integer> {
    boolean existsByNombre(String nombre);
}
