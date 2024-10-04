package com.backend.backend.ventas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import com.backend.backend.Usuario.DTO.ErrorResponse;
import com.backend.backend.ventas.Dto.Ventas_DTO;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/venta")
@RequiredArgsConstructor
public class Ventas_Controller {
    private final Ventas_Service ventas_Service;

    @PostMapping(value="create")
    public ResponseEntity<Ventas> createVenta(@RequestBody Ventas_DTO ventas_DTO){
        Ventas ventas=ventas_Service.createVenta(ventas_DTO);
        return ResponseEntity.ok(ventas);
    }
    
    @GetMapping()
    public ResponseEntity<List<Ventas>> getAllVenta(){
        List<Ventas> ventas=ventas_Service.getAllventas();
        return ResponseEntity.ok(ventas);
    }
}
