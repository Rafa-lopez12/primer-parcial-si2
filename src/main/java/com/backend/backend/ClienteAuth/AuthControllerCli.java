package com.backend.backend.ClienteAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.Auth.LoginRequest;
import com.backend.backend.Auth.RegisterRequest;
import com.backend.backend.Cliente.Cliente;
import com.backend.backend.Usuario.Usuario;

@RestController
@RequestMapping("/auth/cliente")
@RequiredArgsConstructor
public class AuthControllerCli {
    
    private final AuthServiceCli authServiceCli;


    // @PostMapping(value = "login")
    // public ResponseEntity<AuthResponsee> login(@RequestBody ClienteLoginRequest request) {
    //     System.out.println(request);
    //     return ResponseEntity.ok(authServiceCli.loginCliente(request));
    // }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponsee> register(@RequestBody RegisterRequestCli request) {
        return ResponseEntity.ok(authServiceCli.registerCliente(request));
    }

    @GetMapping()
    public ResponseEntity<Cliente> obtenerPerfil() {
        Cliente clienteAutenticado = authServiceCli.getAuthenticatedCliente();
        return ResponseEntity.ok(clienteAutenticado);
    }

    // @PostMapping("/login")
    // public ResponseEntity<AuthResponse> login(@RequestBody ClienteLoginRequest request) {
    //     return ResponseEntity.ok(authServiceCli.login(request));
    // }

    // @PostMapping("/register")
    // public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequestCli request) {
    //     return ResponseEntity.ok(authServiceCli.register(request));
    // }
}
