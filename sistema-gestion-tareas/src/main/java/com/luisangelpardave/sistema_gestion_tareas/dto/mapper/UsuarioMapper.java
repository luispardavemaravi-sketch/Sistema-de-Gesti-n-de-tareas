package com.luisangelpardave.sistema_gestion_tareas.dto.mapper;

import com.luisangelpardave.sistema_gestion_tareas.dto.request.UsuarioRequest;
import com.luisangelpardave.sistema_gestion_tareas.dto.response.UsuarioResponse;
import com.luisangelpardave.sistema_gestion_tareas.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequest request) {
        return Usuario.builder()
                .nombreUsuario(request.nombreUsuario())
                .email(request.email())
                .password(request.password()) // se encripta en el Service, no aquí
                .nombres(request.nombres())
                .apellidos(request.apellidos())
                .telefono(request.telefono())
                .direccion(request.direccion())
                .rol(request.rol())
                .estado(true) // todo usuario nuevo nace activo
                .build();
    }

    public UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNombreUsuario(),
                usuario.getEmail(),
                usuario.getNombres(),
                usuario.getApellidos(),
                usuario.getTelefono(),
                usuario.getDireccion(),
                usuario.getRol(),
                usuario.isEstado()
        );
    }
}