package com.backend.backend.detalleventas;

import jakarta.persistence.Embeddable;

@Embeddable
public class DetalleVentaId {
    
    Integer ventaId;
    Integer productoId;
    Integer colorId;
    //Integer sucursalId;
    Integer tamañoId;
}
