package com.backend.backend.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.backend.Cliente.DTO.Cliente_DTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Cliente_Service {
    
    private final Cliente__Repository cliente__Repository;
    private final PasswordEncoder passwordEncoder;

    public Cliente createCliente(Cliente_DTO cliente_DTO){
        Cliente cliente= Cliente.builder()
            .email(cliente_DTO.getEmail())
            .password(passwordEncoder.encode(cliente_DTO.getPassword()))
            .nombre(cliente_DTO.getNombre())
            .telefono(cliente_DTO.getTelefono())
            .build();

        cliente__Repository.save(cliente);
        return cliente;
    }

}
