package com.backend.backend.Cliente;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.Cliente.DTO.Cliente_DTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class Cliente_Controller {
    
    private final Cliente_Service cliente_Service;

    @PostMapping(value="create")
    public ResponseEntity<?> createCliente(@RequestBody Cliente_DTO cliente_DTO){
        Cliente cliente=cliente_Service.createCliente(cliente_DTO);
        return ResponseEntity.ok(cliente);
    }
    
}
