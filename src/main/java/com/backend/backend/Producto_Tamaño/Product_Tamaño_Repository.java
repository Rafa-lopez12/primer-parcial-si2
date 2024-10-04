package com.backend.backend.Producto_Tamaño;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.backend.Color.Color;
import com.backend.backend.Producto.Producto;
import com.backend.backend.Sucursal.Sucursal;
import com.backend.backend.Tamaño.Tamaño;

@Repository
public interface Product_Tamaño_Repository extends JpaRepository<Product_Tamaño, Product_TamañoId>{
    List<Product_Tamaño> findByTamaño(Tamaño tamaño);
    Optional<Product_Tamaño> findByProductoAndTamañoAndColor(Producto producto, Tamaño tamaño, Color color);
}