package com.backend.backend.carrito;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.backend.Cliente.Cliente;
import com.backend.backend.Cliente.Cliente__Repository;
import com.backend.backend.Color.Color;
import com.backend.backend.Color.Color_Repository;
import com.backend.backend.Producto.Producto;
import com.backend.backend.Producto.Producto_Repository;
import com.backend.backend.Tamaño.Tamaño;
import com.backend.backend.Tamaño.Tamaño_Repository;
import com.backend.backend.carrito.DTO.Carrito_DTO;
import com.backend.backend.producto_imagen.DTO.Producto_img_DTO;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class Carrito_Service {
    private final Carrito_Repository carrito_Repository;
    private final Producto_Repository producto_Repository;
    private final Color_Repository color_Repository;
    private final Tamaño_Repository tamaño_Repository;
    private final Cliente__Repository cliente__Repository;


    public Carrito createCarrito(Carrito_DTO carrito_DTO){
        
        Tamaño tamaño = tamaño_Repository.findById(carrito_DTO.getIdTamaño())
                .orElseThrow(() -> new IllegalArgumentException("Tamaño no encontrado"));
            
        Color color = color_Repository.findById(carrito_DTO.getIdColor())
                .orElseThrow(() -> new IllegalArgumentException("Color no encontrado")); 
            
        Producto producto = producto_Repository.findById(carrito_DTO.getIdProducto())
                .orElseThrow(() -> new IllegalArgumentException("producto no encontrado"));
        
        Cliente cliente = cliente__Repository.findByEmail(carrito_DTO.getIdCliente())
                .orElseThrow(() -> new IllegalArgumentException("cliente no encontrado")); 
        
        Carrito carrito= Carrito.builder()
                .cliente(cliente)
                .color(color)
                .producto(producto)
                .tamaño(tamaño)
                .cantidad(carrito_DTO.getCantidad())
                .precio(carrito_DTO.getPrecio())
                .build();
        return carrito_Repository.save(carrito);        
            
    }


    public List<Carrito> getAllCarrito(){
        return carrito_Repository.findAll();
    }


    @Transactional
    public void deleteCarrito(String id){
        Cliente cliente=cliente__Repository.findByEmail(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + id));  

        carrito_Repository.deleteAllByCliente(cliente);
    }

    public void deleteIdcarrito(Integer id){
        Carrito carrito= carrito_Repository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Carrito no encontrado: " + id));
        carrito_Repository.delete(carrito);              
    }
}
