package com.backend.backend.Rol;

import java.util.ArrayList;
import java.util.List;

import com.backend.backend.Rol_Funcional.Rol_Funcional;
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
@Table(name = "rol", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(length = 100)
    private String descripcion;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Rol_Funcional> rol_funcional= new ArrayList<>();

    public void addRol_Fun(Rol_Funcional rol_Funcional) {
        
        rol_funcional.add(rol_Funcional);
        rol_Funcional.setRol(this);
    }
}
