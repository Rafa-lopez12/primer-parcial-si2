package com.backend.backend.Usuario;

import com.backend.backend.Usuario.DTO.DTO;
import com.backend.backend.Usuario.DTO.DTO_Response;
import com.backend.backend.Usuario.DTO.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class Usuario_Controller {

    private final Usuario_Service usuarioService;

    @PostMapping(value = "create")
    public ResponseEntity<?> createAdministrador(@RequestBody DTO dto_usuario) {
        try {
            //System.out.println(dto_usuario + "hola mundo");
            Usuario usuario = usuarioService.createUsuario(dto_usuario);
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            System.out.println("hola mundo");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error al crear el usuario: " + e.getMessage()));
        }
    }


    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{nro_registro}")
    public ResponseEntity<?> updateUsuario(@PathVariable("nro_registro") String nroRegistro, @RequestBody DTO dto_usuario) {
        try {
            Usuario usuario = usuarioService.updateUsuario(nroRegistro, dto_usuario);
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error al actualizar el usuario: " + e.getMessage()));
        }
    }

    @GetMapping("/{nro_registro}")
    public ResponseEntity<DTO_Response> getUsuarioByNroRegistro(@PathVariable("nro_registro") String nroRegistro) {
        Usuario usuario = usuarioService.getUsuarioByNroRegistro(nroRegistro);
        DTO_Response user = DTO_Response.builder()
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .username(usuario.getUsername())
                .email(usuario.getEmail())
                .id_rol(usuario.getRol().getId())
                .build();
        return ResponseEntity.ok(user);
    }
}
