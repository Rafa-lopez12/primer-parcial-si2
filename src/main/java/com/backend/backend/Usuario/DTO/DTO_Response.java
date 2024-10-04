package com.backend.backend.Usuario.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Response {

    String username;
    String ci;
    String nombre;
    String apellido;
    String email;
    Integer id_rol;
}
