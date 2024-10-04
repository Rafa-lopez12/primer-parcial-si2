package com.backend.backend.carrito.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Carrito_DTO {
    Integer idProducto;
    Integer idTamaño;
    Integer idColor;
    String idCliente;
    Float precio;
    Integer cantidad;
}
