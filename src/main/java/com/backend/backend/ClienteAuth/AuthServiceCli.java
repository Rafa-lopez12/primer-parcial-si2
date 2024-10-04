package com.backend.backend.ClienteAuth;

import com.backend.backend.Cliente.Cliente;
import com.backend.backend.Cliente.Cliente__Repository;
import com.backend.backend.ClienteAuth.DTO.DTO_Cliente_Res;
import com.backend.backend.JWT.JwtClienteService;
import com.backend.backend.JWT.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthServiceCli {
    private final Cliente__Repository clienteRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtClienteService jwtClienteService;
    private final AuthenticationManager authenticationManager;

    // public AuthResponse login(ClienteLoginRequest request) {
    //     // Autenticación del cliente
    //     authenticationManager.authenticate(
    //             new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
    //     );

    //     UserDetails user = clienteRepository.findByEmail(request.getEmail())
    //             .orElseThrow(() -> new RuntimeException("Cliente no encontrado con el username: " + request.getEmail()));
        
    //     String token = jwtService.getTokenForCliente(user);
    //     Cliente cliente = clienteRepository.findById(user.getUsername()).orElseThrow();

    //     DTO_Cliente_Res clienteRes = DTO_Cliente_Res.builder()
    //             .email(user.getUsername())
    //             .nombre(cliente.getNombre())
    //             .build();

    //     return AuthResponse.builder()
    //             .token(token)
    //             .cliente(clienteRes)
    //             .build();
    // }

    // public AuthResponse register(RegisterRequestCli request) {
    //     Cliente cliente = Cliente.builder()
    //             .email(request.getEmail())
    //             .password(passwordEncoder.encode(request.getPassword()))
    //             .nombre(request.getNombre())
    //             .telefono(request.getTelefono())
    //             .build();
        
    //     clienteRepository.save(cliente);
    //     return AuthResponse.builder()
    //             .token(jwtService.getTokenForCliente(cliente))
    //             .build();
    // }

    // public AuthResponsee loginCliente(ClienteLoginRequest request) {
    //     authenticationManager.authenticate(
    //         new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
    //     );

    //     Cliente cliente = clienteRepository.findByEmail(request.getEmail())
    //             .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    //     System.out.println(cliente);
    //     String token = jwtClienteService.getToken(cliente);

    //     return AuthResponsee.builder()
    //             .token(token)
    //             // .user(DTO_Cliente_Res.builder()
    //             //         .email(cliente.getEmail())
    //             //         .nombre(cliente.getNombre())
    //             //         .build())
    //             .build();
    // }

    public AuthResponsee registerCliente(RegisterRequestCli request) {
        Cliente cliente = Cliente.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .nombre(request.getNombre())
                .telefono(request.getTelefono())
                .build();

        clienteRepository.save(cliente);

        return AuthResponsee.builder()
                .token(jwtClienteService.getToken(cliente))
                .build();
    }


    public Cliente getAuthenticatedCliente() {
        // Obtener la autenticación actual del contexto de seguridad
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            
            // Si el principal es un UserDetails, obtenemos el nombre de usuario
            if (principal instanceof UserDetails) {
                String email = ((UserDetails) principal).getUsername();

                // Buscar el cliente en el repositorio por email
                return clienteRepository.findByEmail(email)
                        .orElseThrow(() -> new RuntimeException("Cliente no encontrado con el email: " + email));
            } else if (principal instanceof String) {
                // Si el principal es directamente el email como string
                return clienteRepository.findByEmail((String) principal)
                        .orElseThrow(() -> new RuntimeException("Cliente no encontrado con el email: " + principal));
            }
        }
        throw new RuntimeException("No hay cliente autenticado");
    }

}
