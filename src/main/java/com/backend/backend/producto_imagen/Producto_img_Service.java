package com.backend.backend.producto_imagen;
import java.util.List;
import org.springframework.stereotype.Service;

import com.backend.backend.Producto.Producto;
import com.backend.backend.Producto.Producto_Repository;
import com.backend.backend.producto_imagen.DTO.Producto_img_DTO;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class Producto_img_Service {
    private final Producto_img_Repository producto_img_Repository;
    private final Producto_Repository producto_Repository;

    public Producto_img createProductoImg(Producto_img_DTO producto_img_DTO){
        Producto producto = producto_Repository.findById(producto_img_DTO.getIdProducto())
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        Producto_img producto_img= Producto_img.builder()

            .img_url(producto_img_DTO.getImg_url())
            .idProducto(producto)
            .build();
        return producto_img_Repository.save(producto_img);    
    }

    public List<Producto_img> getAllProductoImg(){
        return producto_img_Repository.findAll();
    }


}
