package com.luisangelpardave.sistema_gestion_tareas.service.impl;

import com.luisangelpardave.sistema_gestion_tareas.dto.mapper.UsuarioMapper;
import com.luisangelpardave.sistema_gestion_tareas.dto.request.UsuarioRequest;
import com.luisangelpardave.sistema_gestion_tareas.dto.response.UsuarioResponse;
import com.luisangelpardave.sistema_gestion_tareas.model.Usuario;
import com.luisangelpardave.sistema_gestion_tareas.repository.UsuarioRepository;

import com.luisangelpardave.sistema_gestion_tareas.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsuarioResponse registrarUsuario(UsuarioRequest usuarioRequest) {
        if (usuarioRepository.existsByEmail(usuarioRequest.email())) {
            throw new RuntimeException("El correo electrónico ya está registrado");
        }
        if (usuarioRepository.existsByNombreUsuario(usuarioRequest.nombreUsuario())) {
            throw new RuntimeException("El nombre de usuario ya está registrado");
        }

        Usuario usuario = usuarioMapper.toEntity(usuarioRequest);
        usuario.setPassword(passwordEncoder.encode(usuarioRequest.password()));

        Usuario guardado = usuarioRepository.save(usuario);
        return usuarioMapper.toResponse(guardado);
    }

    @Override
    public UsuarioResponse obtenerUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        return usuarioMapper.toResponse(usuario);
    }

    @Override
    public UsuarioResponse actualizarUsuario(Long id, UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));

        usuario.setNombres(usuarioRequest.nombres());
        usuario.setApellidos(usuarioRequest.apellidos());
        usuario.setTelefono(usuarioRequest.telefono());
        usuario.setDireccion(usuarioRequest.direccion());

        Usuario actualizado = usuarioRepository.save(usuario);
        return usuarioMapper.toResponse(actualizado);
    }
}