package com.backend.backend.Proveedor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.Proveedor.DTO.Proveedor_DTO;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/proveedor")
@RequiredArgsConstructor
public class Proveedor_Controller {
    
    private final Proveedor_Service proveedor_Service;

    @PostMapping(value="create")
    public ResponseEntity<?> createProveedor(@RequestBody Proveedor_DTO proveedor_DTO){
        return ResponseEntity.ok(proveedor_Service.createProveedor(proveedor_DTO));
    }

    @GetMapping()
     public ResponseEntity<List<Proveedor>> getAllProveedores(){
        List<Proveedor> proveedor= proveedor_Service.getAllProveedores();
        return ResponseEntity.ok(proveedor);
    }
}
