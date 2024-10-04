package com.backend.backend.MovimientoInv;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.backend.backend.MovimientoInv.DTO.MovimientoInv_DTO;

import com.backend.backend.Usuario.DTO.ErrorResponse;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/movinv")
@RequiredArgsConstructor
public class MovimientoInv_Controller {
    private final MoviemientoInv_Service moviemientoInv_Service;

    @PostMapping(value="create")
    public ResponseEntity<MovimientoInv> createMovInv(@RequestBody MovimientoInv_DTO movimientoInv_DTO){
        MovimientoInv movimientoInv= moviemientoInv_Service.createMov(movimientoInv_DTO);
        return ResponseEntity.ok(movimientoInv);
    }


    @GetMapping()
    public ResponseEntity<List<MovimientoInv>> getAllMovimientoInv(){
        List<MovimientoInv> movimientoInvs= moviemientoInv_Service.getAllMovimientos();
        return ResponseEntity.ok(movimientoInvs);
    }
}
