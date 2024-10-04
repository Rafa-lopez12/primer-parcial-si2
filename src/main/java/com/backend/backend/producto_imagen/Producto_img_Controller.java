package com.backend.backend.producto_imagen;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.Producto.Producto;
import com.backend.backend.producto_imagen.DTO.Producto_img_DTO;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/productimg")
@RequiredArgsConstructor
public class Producto_img_Controller {
    
    private final Producto_img_Service producto_img_Service;

    @PostMapping(value="create")
    public ResponseEntity<?> createProductoImg(@RequestBody Producto_img_DTO producto_img_DTO){
        return ResponseEntity.ok(producto_img_Service.createProductoImg(producto_img_DTO));
    }

    @GetMapping()
    public ResponseEntity<List<Producto_img>> getAllProductosImg(){
        List<Producto_img> producto_imgs=producto_img_Service.getAllProductoImg();
        return ResponseEntity.ok(producto_imgs);
    }



}
