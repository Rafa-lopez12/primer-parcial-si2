package com.backend.backend.ClienteAuth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestCli {
    String email;
    String password;
    String nombre;
    String telefono;
}
