package com.backend.backend.Producto_Tamaño.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product_Tamaño_DTO {
    Integer tamañoId;
    Integer productoId;
    Integer colorId;
    Integer cantidad;
    Float precio;
}
