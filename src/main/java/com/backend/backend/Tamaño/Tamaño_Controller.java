package com.backend.backend.Tamaño;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.Tamaño.DTO.Tamaño_DTO;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/tamaño")
@RequiredArgsConstructor

public class Tamaño_Controller {

    private final Tamaño_service tamaño_service;


    @PostMapping(value="create")
    public ResponseEntity<?> createTamaño(@RequestBody Tamaño_DTO tamaño_DTO){
        return ResponseEntity.ok(tamaño_service.createTamaño(tamaño_DTO));
    }


    @GetMapping()
    public ResponseEntity<List<Tamaño>> getAllTamaños(){
        List<Tamaño> tamaños= tamaño_service.getAllTamaños();
        return ResponseEntity.ok(tamaños);
    }

}
