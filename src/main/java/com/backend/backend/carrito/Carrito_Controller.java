package com.backend.backend.carrito;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.backend.backend.Usuario.DTO.ErrorResponse;
import com.backend.backend.carrito.DTO.Carrito_DTO;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/tienda")
@RequiredArgsConstructor
public class Carrito_Controller {

    private final Carrito_Service carrito_Service;


    @PostMapping("/carrito/create")
    public ResponseEntity<?> createCarrito(@RequestBody Carrito_DTO carrito_DTO){
        Carrito carrito = carrito_Service.createCarrito(carrito_DTO);
        return ResponseEntity.ok(carrito);
    }

    
    @GetMapping("/carrito")
    public ResponseEntity<List<Carrito>> getAllCarrito(){
        List<Carrito> carritos=carrito_Service.getAllCarrito();
        return ResponseEntity.ok(carritos);
    }

    @DeleteMapping("/carrito/{id}")
    public ResponseEntity<?> deleteCarrito(@PathVariable String id){
        
        carrito_Service.deleteCarrito(id);
        return ResponseEntity.ok().body("Carrito vaciado");
    }

    @DeleteMapping("/carrito/one/{id}")
    public ResponseEntity<?> deleteIdCarrito(@PathVariable Integer id){
        carrito_Service.deleteIdcarrito(id);
        return ResponseEntity.ok().body("producto sacado del carrito");
    }

}
