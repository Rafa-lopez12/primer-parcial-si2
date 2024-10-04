package com.backend.backend.MovimientoInv;

import java.util.ArrayList;
import java.util.List;


import com.backend.backend.DetalleMov.DetalleMov;
import com.backend.backend.Proveedor.Proveedor;
import com.backend.backend.Sucursal.Sucursal;
import com.backend.backend.Usuario.Usuario;
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
@Table(name = "movimientoInv", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MovimientoInv {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER) // Cambio aquí
    @JoinColumn(name = "idUsuario", nullable = false)
    @ToString.Exclude
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER) // Cambio aquí
    @JoinColumn(name = "idProveedor", nullable = false)
    @ToString.Exclude
    private Proveedor proveedor;

    @ManyToOne(fetch = FetchType.EAGER) // Cambio aquí
    @JoinColumn(name = "idSucursal", nullable = false)
    @ToString.Exclude
    private Sucursal sucursal;

    @Column(name="fechaRegistro")
    private LocalDate fechaColumna; 

    @Column()
    private Float montoTotal;

    @OneToMany(mappedBy = "movimientoInv", cascade = CascadeType.ALL)
    @Builder.Default
    private List<DetalleMov> detalles= new ArrayList<>();


    public void addDetalle(DetalleMov detalle) {
        
        detalles.add(detalle);
        detalle.setMovimientoInv(this);
    }



}
