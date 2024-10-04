// package com.backend.backend.inventario;
// import com.backend.backend.Producto.Producto;
// import com.backend.backend.Sucursal.Sucursal;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// import jakarta.persistence.*;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// @Entity
// @Table(name = "inventario", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
// public class Inventario {
//     @EmbeddedId
//     private InventarioId id = new InventarioId();

//     @ManyToOne
//     @MapsId("productoId")
//     @JoinColumn(name = "producto_id")
//     private Producto idProducto;

//     @ManyToOne
//     @MapsId("sucursalId")
//     @JoinColumn(name = "tamaño_id")
//     private Sucursal idSucursal;

//     @Column()
//     private Integer cantidad;
// }
