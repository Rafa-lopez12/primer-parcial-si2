package com.backend.backend.Rol.DTO;

import java.util.List;

import com.backend.backend.Rol_Funcional.DTO.Rol_Funcional_DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Rol {
    String nombre;
    String descripcion;
    private List<Rol_Funcional_DTO> rol_funcional;
}
