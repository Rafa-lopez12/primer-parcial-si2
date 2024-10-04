package com.backend.backend.Funcionalidades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Funcionalidad_Repository extends JpaRepository<Funcionalidades, Integer> {
}
