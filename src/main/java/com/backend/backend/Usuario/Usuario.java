package com.backend.backend.Usuario;

import com.backend.backend.Administrador.Administrador;
import com.backend.backend.Rol.Rol;
import com.backend.backend.Sucursal.Sucursal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario", uniqueConstraints = {@UniqueConstraint(columnNames = {"nroRegistro"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Ignorar propiedades de Hibernate
public class Usuario implements UserDetails {
    @Id
    @Column(length = 20, nullable = false, unique = true)
    private String username;


    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(nullable = false, length = 30)
    private String apellido;

    @Column(length = 254)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column()
    private Integer estado;


    @ManyToOne(fetch = FetchType.EAGER) // Cambio aquí
    @JoinColumn(name = "idRol", nullable = false)
    @ToString.Exclude
    private Rol rol;

    // @ManyToOne(fetch = FetchType.EAGER) // Cambio aquí
    // @JoinColumn(name = "idSucursal", nullable = false)
    // @ToString.Exclude
    // private Sucursal sucursal;

    

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.MERGE)
    @JsonIgnore
    private Administrador administrador;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol.getNombre()));
    }
    

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;


    }

    


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
