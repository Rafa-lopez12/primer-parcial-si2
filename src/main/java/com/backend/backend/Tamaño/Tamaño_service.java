package com.backend.backend.Tamaño;


import java.util.List;
import org.springframework.stereotype.Service;


import com.backend.backend.Tamaño.DTO.Tamaño_DTO;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class Tamaño_service {
    private final Tamaño_Repository tamaño_Repository;

    public Tamaño createTamaño(Tamaño_DTO tamaño_DTO){
        Tamaño tamaño= Tamaño.builder()
            .nombre(tamaño_DTO.getNombre())
            .build();
        return tamaño_Repository.save(tamaño); 
    }


    public List<Tamaño> getAllTamaños(){
        return tamaño_Repository.findAll();
    }

}
