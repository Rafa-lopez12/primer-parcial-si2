package com.backend.backend.Usuario.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO {
    String username;
    String nombre;
    String apellido;
    String email;
    String password;
    Integer id_rol;
}
