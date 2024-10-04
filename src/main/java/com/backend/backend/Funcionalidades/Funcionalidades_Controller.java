package com.backend.backend.Funcionalidades;

import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/funcionalidades")
@RequiredArgsConstructor
public class Funcionalidades_Controller {
    
    private final Funcionalidades_Service funcionalidades_Service;

    @GetMapping()
    public ResponseEntity<List<Funcionalidades>> getAllFuncionalidades(){
        List<Funcionalidades> funcionalidades=funcionalidades_Service.getAllFuncionalidades();
        return ResponseEntity.ok(funcionalidades);
    }
}
