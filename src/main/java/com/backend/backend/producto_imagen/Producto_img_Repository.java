package com.backend.backend.producto_imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.backend.Producto.Producto;

import java.util.List;

@Repository
public interface Producto_img_Repository extends JpaRepository<Producto_img, Long> {
     List<Producto_img> findByIdProducto(Producto producto);
}
