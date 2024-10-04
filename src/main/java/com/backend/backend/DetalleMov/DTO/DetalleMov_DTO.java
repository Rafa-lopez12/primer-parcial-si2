package com.backend.backend.DetalleMov.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleMov_DTO {
    private Integer idMov;
    private Integer idProducto;
    private Integer idTamaño;
    //private Integer idSucursal;
    private Integer idColor;
    private Integer cantidad;
    private Float precio;
}
