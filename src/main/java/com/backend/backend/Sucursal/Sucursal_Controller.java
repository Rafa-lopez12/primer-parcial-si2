package com.backend.backend.Sucursal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.Sucursal.DTO.Sucursal_Dto;
import com.backend.backend.Usuario.DTO.ErrorResponse;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/sucursal")
@RequiredArgsConstructor
public class Sucursal_Controller {

    private final Sucursal_Service sucursal_Service;

    @PostMapping(value = "create")
    public ResponseEntity<?> createSucursal(@RequestBody Sucursal_Dto sucur_dto){
        try {
            System.out.println(sucur_dto);
            Sucursal sucursal = sucursal_Service.createSucursal(sucur_dto);
            return ResponseEntity.ok(sucursal);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error al crear la sucursal: " + e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<Sucursal>> getAllSucursales() {
        List<Sucursal> sucursal = sucursal_Service.getAllSucursales();
        return ResponseEntity.ok(sucursal);
    }

    @GetMapping("/{id_sucursal}")
    public ResponseEntity<Sucursal> getRolById(@PathVariable("id_sucursal") Integer id_sucursal) {
        Sucursal sucursal = sucursal_Service.getSucursal(id_sucursal);
        return ResponseEntity.ok(sucursal);
    }






}
