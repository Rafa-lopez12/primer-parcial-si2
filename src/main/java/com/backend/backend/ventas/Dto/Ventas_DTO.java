package com.backend.backend.ventas.Dto;

import java.time.LocalDate;
import java.util.List;

import com.backend.backend.detalleventas.DTO.DetalleVenta_DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ventas_DTO {

    private String idCliente;
    private List<DetalleVenta_DTO> detalles;
    private LocalDate fechaRegistro;
    private Float montoTotal;
}
