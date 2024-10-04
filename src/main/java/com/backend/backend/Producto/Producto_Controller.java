package com.backend.backend.Producto;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.backend.backend.Producto.DTO.Producto_DTO;
import com.backend.backend.Sucursal.DTO.Sucursal_Dto;
import com.backend.backend.Usuario.DTO.ErrorResponse;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/producto")
@RequiredArgsConstructor
public class Producto_Controller {
    private final Producto_Service producto_Service;

    @PostMapping(value="create")
    public ResponseEntity<?> createProducto(@RequestBody Producto_DTO producto_DTO){
        return ResponseEntity.ok(producto_Service.createProducto(producto_DTO));
    }

    @GetMapping()
    public ResponseEntity<List<Producto>> getAllProducto(){
        List<Producto> productos=producto_Service.getAllProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Integer id){
        Producto producto= producto_Service.getProductoById(id);
        return ResponseEntity.ok(producto);
    }

    @GetMapping("/img/{id}")
    public ResponseEntity<Producto> getProductoImg(@PathVariable Integer id){
        Producto producto=producto_Service.getProductoImg(id);
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Integer id, @RequestBody Producto_DTO producto_DTO){
        Producto updatedProducto = producto_Service.updateProducto(id, producto_DTO);
        return ResponseEntity.ok(updatedProducto);
    }
}


