package com.backend.backend.carrito;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.Cliente.Cliente;

public interface Carrito_Repository extends JpaRepository<Carrito, Integer> {
    void deleteAllByCliente(Cliente cliente);
}
