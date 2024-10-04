package com.backend.backend.Proveedor;

import java.util.List;
import org.springframework.stereotype.Service;

import com.backend.backend.Proveedor.DTO.Proveedor_DTO;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class Proveedor_Service {
    
    private final Proveedor_Repository proveedor_Repository;

    public Proveedor createProveedor(Proveedor_DTO proveedor_DTO){
        Proveedor proveedor= Proveedor.builder()
            .nombre(proveedor_DTO.getNombre())
            .build();
        return proveedor_Repository.save(proveedor);
    }

    public List<Proveedor> getAllProveedores(){
        return proveedor_Repository.findAll();
    } 
}
