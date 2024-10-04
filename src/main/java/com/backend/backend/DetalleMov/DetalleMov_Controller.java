package com.backend.backend.DetalleMov;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.Usuario.DTO.ErrorResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/detalleMov")
@RequiredArgsConstructor
public class DetalleMov_Controller {

    private final DetalleMov_Service detalleMov_Service;

    @GetMapping()
    public ResponseEntity<List<DetalleMov>> getAllDetalles(){
        List<DetalleMov> detalleMovs= detalleMov_Service.getAllDetalleMov();
        return ResponseEntity.ok(detalleMovs);
    }
}
