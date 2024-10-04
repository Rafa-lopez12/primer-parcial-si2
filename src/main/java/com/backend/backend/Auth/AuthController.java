package com.backend.backend.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.Usuario.Usuario;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value="register")
    public ResponseEntity<AuthResponse> login(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @GetMapping()
    public ResponseEntity<Usuario> getAuthentificationUsuario(){
        Usuario usuario=authService.getAuthenticatedUsuario();
        return ResponseEntity.ok(usuario);
    }

}
