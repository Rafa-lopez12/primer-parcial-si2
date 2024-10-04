package com.backend.backend.Rol_Funcional;

import java.util.ArrayList;

import com.backend.backend.Funcionalidades.Funcionalidades;
import com.backend.backend.Rol.Rol;
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
@Table(name = "rol_funcional", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rol_Funcional {
    
    @EmbeddedId
    private Rol_FuncionalId id = new Rol_FuncionalId();

    @ManyToOne
    @MapsId("rolId")
    @JoinColumn(name = "rol_id")
    @JsonIgnore()
    private Rol rol;

    @ManyToOne
    @MapsId("funcionalidadId")
    @JoinColumn(name="funcionalidad_id")
    private Funcionalidades funcionalidades;
}
