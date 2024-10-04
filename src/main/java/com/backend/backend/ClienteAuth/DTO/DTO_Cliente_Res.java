package com.backend.backend.ClienteAuth.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Cliente_Res {
    String email;
    String nombre;
}
