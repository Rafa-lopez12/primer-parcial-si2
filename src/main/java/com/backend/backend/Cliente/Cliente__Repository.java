package com.backend.backend.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Cliente__Repository extends JpaRepository<Cliente, String>{
    Optional<Cliente> findByEmail(String email);
}
