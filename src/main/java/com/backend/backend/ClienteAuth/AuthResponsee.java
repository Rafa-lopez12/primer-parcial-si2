package com.backend.backend.ClienteAuth;

import com.backend.backend.ClienteAuth.DTO.DTO_Cliente_Res;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponsee {
    private String token;
    private DTO_Cliente_Res cliente;  // Cambiar a DTO_Cliente_Res para clientes
}
