package com.backend.backend.producto_imagen.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producto_img_DTO {
    String img_url;
    Integer idProducto;
}
