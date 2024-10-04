package com.backend.backend.DetalleMov;
import jakarta.persistence.Embeddable;

@Embeddable
public class DetalleMovId {
    Integer movimientoId;
    Integer productoId;
    Integer colorId;
    //Integer sucursalId;
    Integer tamañoId;
}
