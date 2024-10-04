package com.backend.backend.Sucursal;



import org.springframework.stereotype.Service;

import com.backend.backend.Sucursal.DTO.Sucursal_Dto;

import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Sucursal_Service {
    private final Sucursal_Repository sucursal_Repository;

    public Sucursal createSucursal(Sucursal_Dto sucursalDto){
        if (sucursal_Repository.existsByNombre(sucursalDto.getNombre())) {
            throw new RuntimeException("El rol ya existe");
        }

        Sucursal sucursal = Sucursal.builder()
                .nombre(sucursalDto.getNombre())
                .ubicacion(sucursalDto.getUbicacion())
                .build();
        return sucursal_Repository.save(sucursal);
    }

    public List<Sucursal> getAllSucursales() {
        return sucursal_Repository.findAll();
    }

    public Sucursal getSucursal(Integer id){
        return sucursal_Repository.getReferenceById(id);
    }

}
