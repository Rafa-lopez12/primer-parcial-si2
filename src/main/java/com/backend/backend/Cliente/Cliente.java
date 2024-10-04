package com.backend.backend.Cliente;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente", uniqueConstraints = {@UniqueConstraint(columnNames = {"nroRegistro"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente implements UserDetails {
    @Id
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(length = 30)
    private String telefono;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername(){
        return email;
    }

    @Override
    public String getPassword(){
        return password;
    }


    @Override
    public boolean isAccountNonExpired(){
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
