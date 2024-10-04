package com.backend.backend.Producto_Tamaño;

import com.backend.backend.Color.Color;
import com.backend.backend.Producto.Producto;
import com.backend.backend.Sucursal.Sucursal;
import com.backend.backend.Tamaño.Tamaño;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto_tamaño", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product_Tamaño {
    
    @EmbeddedId
    private Product_TamañoId id = new Product_TamañoId();

    @ManyToOne
    @MapsId("productoId")
    @JoinColumn(name = "producto_id")
    @JsonIgnore()
    private Producto producto;

    @ManyToOne
    @MapsId("tamañoId")
    @JoinColumn(name = "tamaño_id")
    private Tamaño tamaño;

    // @ManyToOne
    // @MapsId("sucursalId")
    // @JoinColumn(name="sucursal_id")
    // private Sucursal sucursal;

    @ManyToOne
    @MapsId("colorId")
    @JoinColumn(name="color_id")
    private Color color;

    @Column()
    private Integer cantidad;

    @Column()
    private Float precio;

    

}
