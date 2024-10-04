package com.backend.backend.Sucursal.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal_Dto {
    String nombre;
    String ubicacion;
}
