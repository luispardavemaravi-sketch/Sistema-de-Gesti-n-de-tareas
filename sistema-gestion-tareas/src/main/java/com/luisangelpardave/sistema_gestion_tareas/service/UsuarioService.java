package com.luisangelpardave.sistema_gestion_tareas.service;

import com.luisangelpardave.sistema_gestion_tareas.dto.request.UsuarioRequest;
import com.luisangelpardave.sistema_gestion_tareas.dto.response.UsuarioResponse;
import com.luisangelpardave.sistema_gestion_tareas.model.Usuario;

public interface UsuarioService {

    UsuarioResponse registrarUsuario(UsuarioRequest usuarioRequest  );

    UsuarioResponse obtenerUsuarioPorId(Long id);

    UsuarioResponse actualizarUsuario(Long id , UsuarioRequest usuarioRequest);
}
