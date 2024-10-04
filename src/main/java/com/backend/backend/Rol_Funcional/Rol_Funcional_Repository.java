package com.backend.backend.Rol_Funcional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface Rol_Funcional_Repository extends JpaRepository<Rol_Funcional, Integer> {
    
}
