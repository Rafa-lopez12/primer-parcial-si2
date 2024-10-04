package com.backend.backend.Auth.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_User_Res {
    String username;
    String nombre;
    Integer id_rol;
}
