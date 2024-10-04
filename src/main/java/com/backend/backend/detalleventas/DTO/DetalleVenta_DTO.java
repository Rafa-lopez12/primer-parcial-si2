package com.backend.backend.detalleventas.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVenta_DTO {
    private Integer idVenta;
    private Integer idProducto;
    private Integer idTamaño;
    //private Integer idSucursal;
    private Integer idColor;
    private Integer cantidad;
    private Float precio;
}
