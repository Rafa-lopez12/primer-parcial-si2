package com.backend.backend.producto_imagen;
import com.backend.backend.Producto.Producto;
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
@Table(name = "producto_img", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Producto_img {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
    private String img_url;

    @ManyToOne(fetch = FetchType.EAGER) // Cambio aquí
    @JoinColumn(name = "idProducto", nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private Producto idProducto;
}
