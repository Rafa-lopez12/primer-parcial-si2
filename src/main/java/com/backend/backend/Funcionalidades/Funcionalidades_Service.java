package com.backend.backend.Funcionalidades;


import java.util.List;

import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Funcionalidades_Service {

    private final Funcionalidad_Repository funcionalidad_Repository;


    public List<Funcionalidades> getAllFuncionalidades(){
        return funcionalidad_Repository.findAll();
    }

    
}
