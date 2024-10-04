package com.backend.backend.ventas;

import java.util.ArrayList;
import java.util.List;

import com.backend.backend.Cliente.Cliente;
import com.backend.backend.DetalleMov.DetalleMov;
import com.backend.backend.detalleventas.DetalleVenta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ventas", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ventas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER) // Cambio aquí
    @JoinColumn(name = "idCliente", nullable = false)
    @ToString.Exclude
    private Cliente cliente;


    @Column(name="fechaRegistro")
    private LocalDate fechaRegistro; 

    @Column()
    private Float montoTotal;

    @Column()
    private Integer estado;

    @OneToMany(mappedBy = "ventas", cascade = CascadeType.ALL)
    @Builder.Default
    private List<DetalleVenta> detalles= new ArrayList<>();


    public void add(DetalleVenta detalle) {
        
        detalles.add(detalle);
        detalle.setVentas(this);
    }

}