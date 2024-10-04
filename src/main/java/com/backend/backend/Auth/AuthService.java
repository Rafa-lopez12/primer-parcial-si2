package com.backend.backend.Auth;

import com.backend.backend.Auth.DTO.DTO_User_Res;
import com.backend.backend.JWT.JwtService;
import com.backend.backend.Rol.Rol;
import com.backend.backend.Rol.Rol_Repository;
import com.backend.backend.Sucursal.Sucursal;
import com.backend.backend.Sucursal.Sucursal_Repository;
import com.backend.backend.Usuario.Usuario;
import com.backend.backend.Usuario.Usuario_Repository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final Usuario_Repository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final Rol_Repository rol_Repository;
    private final Sucursal_Repository sucursal_Repository;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        Usuario usuario=userRepository.getReferenceById(user.getUsername());
        DTO_User_Res userRes= DTO_User_Res.builder()
                .username(user.getUsername())
                .nombre(usuario.getNombre())
                .id_rol(usuario.getRol().getId())
                .build();

        return AuthResponse.builder()
                .token(token)
                .user(userRes)
                .build();
    }


    public AuthResponse register(RegisterRequest request) {

         Rol rolAdministrador = rol_Repository.findById(1)
         .orElseThrow(() -> new RuntimeException("Rol 'administrador' no encontrado"));


        Usuario user = Usuario.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode( request.getPassword()))
            .nombre(request.getNombre())
            .apellido(request.getApellido())
            .email(request.getEmail())
            .estado(1)
            .rol(rolAdministrador)
            .build();
        
        userRepository.save(user);
        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
        
    }

    public Usuario getAuthenticatedUsuario() {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
           
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                String username = ((UserDetails) principal).getUsername();
                
                return userRepository.findById(username)
                        .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el número de registro: " + username));
            } else if (principal instanceof String) {
               
                return userRepository.findById((String) principal)
                        .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el número de registro: " + principal));
            }
        }
        throw new RuntimeException("No hay usuario autenticado");
    }


}
