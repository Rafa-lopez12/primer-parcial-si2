package com.backend.backend.Producto_Tamaño;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.Producto.Producto;
import com.backend.backend.Producto_Tamaño.DTO.Product_Tamaño_DTO;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/productamaño")
@RequiredArgsConstructor
public class Product_Tamaño_Controller {
    
    private final Product_Tamaño_Service product_Tamaño_Service;

    @PostMapping(value="create")
    public ResponseEntity<?> createProductoTamaño(@RequestBody Product_Tamaño_DTO product_Tamaño_DTO){
        return ResponseEntity.ok(product_Tamaño_Service.createProduct_Tamaño(product_Tamaño_DTO));
    }

    @GetMapping("/por-tamaño/{tamañoId}")
    public ResponseEntity<List<Producto>> getProductosPorTamaño(@PathVariable Integer tamañoId){
        List<Producto> productos=product_Tamaño_Service.getProductosPorTamaño(tamañoId);
        return ResponseEntity.ok(productos);
    }

    @GetMapping()
    public ResponseEntity<List<Product_Tamaño>> getAllProductoTamaño(){
        List<Product_Tamaño> product_Tamaños=product_Tamaño_Service.getAllProductoTamaño();
        return ResponseEntity.ok(product_Tamaños);
    }
}
