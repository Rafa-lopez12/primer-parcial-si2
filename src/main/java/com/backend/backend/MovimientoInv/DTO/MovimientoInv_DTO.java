package com.backend.backend.MovimientoInv.DTO;

import java.time.LocalDate;
import java.util.List;

import com.backend.backend.DetalleMov.DTO.DetalleMov_DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoInv_DTO {
    private String idUsuario;
    private Integer idProveedor;
    private Integer idSucursal;
    private List<DetalleMov_DTO> detalles;
    private LocalDate fechaColumna;
    private Float montoTotal;
}

