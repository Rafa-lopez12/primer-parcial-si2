package com.backend.backend.Cliente.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente_DTO {
    
    String email;
    String password;
    String nombre;
    String telefono;
}
