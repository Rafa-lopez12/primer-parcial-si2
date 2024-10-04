package com.backend.backend.DetalleMov;

import com.backend.backend.Color.Color;
import com.backend.backend.MovimientoInv.MovimientoInv;
import com.backend.backend.Producto.Producto;
import com.backend.backend.Sucursal.Sucursal;
import com.backend.backend.Tamaño.Tamaño;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_movimiento", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DetalleMov {
    
    @EmbeddedId
    private DetalleMovId id = new DetalleMovId();

    @ManyToOne
    @MapsId("movimientoId")
    @JoinColumn(name = "movimiento_id")
    @JsonIgnore()
    private MovimientoInv movimientoInv;

    // @ManyToOne
    // @MapsId("sucursalId")
    // @JoinColumn(name="sucursal_id")
    // private Sucursal sucursal;

    @ManyToOne
    @MapsId("productoId")
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @MapsId("tamañoId")
    @JoinColumn(name = "tamaño_id")
    private Tamaño tamaño;

    @ManyToOne
    @MapsId("colorId")
    @JoinColumn(name="color_id")
    private Color color;

    @Column()
    private Integer cantidad;

    @Column()
    private Float precio;


}
