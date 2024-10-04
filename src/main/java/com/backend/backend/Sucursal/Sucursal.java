package com.backend.backend.Sucursal;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "sucursal", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sucursal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(length = 30)
    private String ubicacion;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sucursal sucursal = (Sucursal) o;
        return Objects.equals(id, sucursal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
