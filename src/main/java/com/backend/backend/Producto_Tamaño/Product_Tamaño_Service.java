package com.backend.backend.Producto_Tamaño;


import java.util.List;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import com.backend.backend.Color.Color;
import com.backend.backend.Color.Color_Repository;
import com.backend.backend.Producto.Producto;
import com.backend.backend.Producto.Producto_Repository;
import com.backend.backend.Producto_Tamaño.DTO.Product_Tamaño_DTO;

import com.backend.backend.Sucursal.Sucursal_Repository;
import com.backend.backend.Tamaño.Tamaño;
import com.backend.backend.Tamaño.Tamaño_Repository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class Product_Tamaño_Service {
    
    private final Product_Tamaño_Repository product_Tamaño_Repository;
    private final Producto_Repository producto_Repository;
    private final Tamaño_Repository tamaño_Repository;
    private final Sucursal_Repository sucursal_Repository;
    private final Color_Repository color_Repository;

    public Product_Tamaño createProduct_Tamaño(Product_Tamaño_DTO product_Tamaño_DTO){
        Producto producto = producto_Repository.findById(product_Tamaño_DTO.getProductoId())
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        Tamaño tamaño = tamaño_Repository.findById(product_Tamaño_DTO.getTamañoId())
                 .orElseThrow(() -> new IllegalArgumentException("Tamaño no encontrado"));
        
        
        
        Color color = color_Repository.findById(product_Tamaño_DTO.getColorId())
        .orElseThrow(() -> new IllegalArgumentException("color no encontrado"));

        Product_Tamaño product_Tamaño= Product_Tamaño.builder()
            .producto(producto)
            .tamaño(tamaño)
           
            .color(color)
            .cantidad(product_Tamaño_DTO.getCantidad())
            .precio(product_Tamaño_DTO.getPrecio())
            .build();
        return product_Tamaño_Repository.save(product_Tamaño);
            
    }


    public List<Producto> getProductosPorTamaño(Integer tamañoId){
        Tamaño tamaño= tamaño_Repository.findById(tamañoId)
            .orElseThrow(()-> new IllegalArgumentException("tamaño no encontrado"));
        List<Product_Tamaño> relaciones = product_Tamaño_Repository.findByTamaño(tamaño);
        
        return relaciones.stream()
            .map(Product_Tamaño::getProducto)
            .collect(Collectors.toList());
    }


    public List<Product_Tamaño> getAllProductoTamaño(){
        return product_Tamaño_Repository.findAll();
    }

}
