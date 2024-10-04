package com.backend.backend.Usuario;

import com.backend.backend.Administrador.Administrador;
import com.backend.backend.Administrador.Administrador_Repository;
import com.backend.backend.Rol.Rol;
import com.backend.backend.Rol.Rol_Repository;
import com.backend.backend.Sucursal.Sucursal;
import com.backend.backend.Sucursal.Sucursal_Repository;
import com.backend.backend.Usuario.DTO.DTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Usuario_Service {
    private final Usuario_Repository usuarioRepository;
    private final Administrador_Repository administradorRepository;
    private final Rol_Repository rolRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario createUsuario(DTO dto_usuario) {
        if (usuarioRepository.existsById(dto_usuario.getUsername())) {
            throw new RuntimeException("El número de registro ya existe");
        }
        Rol rol1 = rolRepository.getReferenceById(dto_usuario.getId_rol());


        Usuario usuario = Usuario.builder()
                .username(dto_usuario.getUsername())
                .password(passwordEncoder.encode(dto_usuario.getPassword()))
                .nombre(dto_usuario.getNombre())
                .apellido(dto_usuario.getApellido())
                .email(dto_usuario.getEmail())
                .estado(1)
                .rol(rol1)
                .build();

       
        usuarioRepository.save(usuario);
        Rol rol = usuario.getRol();
        if (rol.getId() == 1) {
            Administrador admin = Administrador.builder()
                    .nroRegistro(dto_usuario.getUsername())
                    .build();
            administradorRepository.save(admin);
        } 
        return usuario;

    }


    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario updateUsuario(String nroRegistro, DTO dto_usuario) {
        Usuario usuario = usuarioRepository.findById(nroRegistro)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el número de registro: " + nroRegistro));

        Rol rol = rolRepository.getReferenceById(dto_usuario.getId_rol());
        usuario.setNombre(dto_usuario.getNombre());
        usuario.setApellido(dto_usuario.getApellido());
        usuario.setEmail(dto_usuario.getEmail());
        usuario.setRol(rol);

        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuarioByNroRegistro(String nroRegistro) {
        return usuarioRepository.findById(nroRegistro)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el número de registro: " + nroRegistro));
    }
}
