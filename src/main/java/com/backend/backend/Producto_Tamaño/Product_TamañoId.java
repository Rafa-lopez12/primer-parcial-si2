package com.backend.backend.Producto_Tamaño;

import jakarta.persistence.Embeddable;

@Embeddable
public class Product_TamañoId {
    private Integer productoId;
    private Integer tamañoId;
    private Integer colorId;
}
