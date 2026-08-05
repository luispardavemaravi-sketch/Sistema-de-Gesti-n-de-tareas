package com.luisangelpardave.sistema_gestion_tareas.dto.response;

import com.luisangelpardave.sistema_gestion_tareas.model.Rol;

public record UsuarioResponse(Long id,
                              String nombreUsuario,
                              String email,
                              String nombres,
                              String apellidos,
                              String telefono,
                              String direccion,
                              Rol rol,
                              boolean estado
) {
}
