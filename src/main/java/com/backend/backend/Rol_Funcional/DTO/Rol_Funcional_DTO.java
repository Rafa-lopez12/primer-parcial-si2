package com.backend.backend.Rol_Funcional.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rol_Funcional_DTO {
    private Integer idRol;
    private Integer idFuncionalidad;


    public Integer getIdFuncionalidad() {
        return idFuncionalidad;
    }
}
