package com.backend.backend.Categoria.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Categoria_DTO {
    String nombre;
    String[] subcategoria;
}
