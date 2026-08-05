package com.luisangelpardave.sistema_gestion_tareas.controller;

import com.luisangelpardave.sistema_gestion_tareas.dto.request.UsuarioRequest;
import com.luisangelpardave.sistema_gestion_tareas.dto.response.UsuarioResponse;
import com.luisangelpardave.sistema_gestion_tareas.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<UsuarioResponse> registrar(@Valid @RequestBody UsuarioRequest request) {
        UsuarioResponse response = usuarioService.registrarUsuario(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> obtenerPorId(@PathVariable Long id) {
        UsuarioResponse response = usuarioService.obtenerUsuarioPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> actualizar(@PathVariable Long id,
                                                      @Valid @RequestBody UsuarioRequest request) {
        UsuarioResponse response = usuarioService.actualizarUsuario(id, request);
        return ResponseEntity.ok(response);
    }
}