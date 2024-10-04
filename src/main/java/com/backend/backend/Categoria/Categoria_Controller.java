package com.backend.backend.Categoria;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.Categoria.DTO.Categoria_DTO;

import lombok.RequiredArgsConstructor;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categoria")
@RequiredArgsConstructor
public class Categoria_Controller {

    private final Categoria_Service categoria_Service;


    @PostMapping(value="create")
    public ResponseEntity<?> createCategoria(@RequestBody Categoria_DTO categoria_DTO){
        return ResponseEntity.ok(categoria_Service.createCategoria(categoria_DTO));
    }

    @GetMapping()
    public ResponseEntity<List<Categoria>> getAllCategorias(){
        List<Categoria> categoria= categoria_Service.getAllCategorias();
        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Integer id, @RequestBody Categoria_DTO categoria_DTO){
        Categoria categoria=categoria_Service.updateCategoria(id, categoria_DTO);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable Integer id){
        categoria_Service.deleteCategoria(id);
        return ResponseEntity.ok().body("Categoria desactivada correctamente");
    }


    @DeleteMapping("/activate/{id}")
    public ResponseEntity<?> activateCategoria(@PathVariable Integer id){
        categoria_Service.activateCategoria(id);
        return ResponseEntity.ok().body("Categoria activada correctamente");
    }


}
