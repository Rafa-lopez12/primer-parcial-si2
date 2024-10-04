package com.backend.backend.Funcionalidades;

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
@Table(name = "funcionalidad", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Funcionalidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
    private String funcionalidad;
}
