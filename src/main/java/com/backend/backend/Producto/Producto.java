package com.backend.backend.Producto;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

import com.backend.backend.Categoria.Categoria;
import com.backend.backend.DetalleMov.DetalleMov;
import com.backend.backend.Producto_Tamaño.Product_Tamaño;
import com.backend.backend.Proveedor.Proveedor;
import com.backend.backend.producto_imagen.Producto_img;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "producto", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
    private String nombre;

    @Column()
    private String descripcion;

    @Column()
    private Integer estado;

    @Column()
    private String subcategoria;
    
    @OneToMany(mappedBy = "idProducto", fetch = FetchType.LAZY)
    private List<Producto_img> imagenes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategoria", nullable = false)
    @ToString.Exclude
    private Categoria categoria;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Product_Tamaño> productos= new ArrayList<>();


    public void addDetalle(Product_Tamaño producto_Tamaño) {
        
        productos.add(producto_Tamaño);
        producto_Tamaño.setProducto(this);
    }

    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name = "idProveedor", nullable = false)
    // @ToString.Exclude
    // private Proveedor proveedor;

    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
