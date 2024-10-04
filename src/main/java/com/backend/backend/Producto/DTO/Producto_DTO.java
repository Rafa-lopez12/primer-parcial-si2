package com.backend.backend.Producto.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import com.backend.backend.Producto_Tamaño.DTO.Product_Tamaño_DTO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producto_DTO {
    String nombre;
    String descripcion;
    String subcategoria;
    Integer idCategoria;
    List<String> imagenUrl;
    List<Product_Tamaño_DTO> product_Tamaños;

}
