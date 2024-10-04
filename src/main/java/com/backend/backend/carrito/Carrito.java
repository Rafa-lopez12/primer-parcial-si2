package com.backend.backend.carrito;

import com.backend.backend.Cliente.Cliente;
import com.backend.backend.Color.Color;
import com.backend.backend.Producto.Producto;
import com.backend.backend.Tamaño.Tamaño;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carrito", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Carrito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProducto", nullable = false)
    @ToString.Exclude
    private Producto producto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idColor", nullable = false)
    @ToString.Exclude
    private Color color;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTamaño", nullable = false)
    @ToString.Exclude
    private Tamaño tamaño;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCliente", nullable = false)
    @ToString.Exclude
    private Cliente cliente;

    @Column()
    private Integer cantidad;

    @Column()
    private Float precio;

}
