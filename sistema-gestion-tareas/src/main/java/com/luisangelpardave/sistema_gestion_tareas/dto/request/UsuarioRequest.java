package com.luisangelpardave.sistema_gestion_tareas.dto.request;

import com.luisangelpardave.sistema_gestion_tareas.model.Rol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequest(
        @NotBlank(message = "El nombre de usuario es obligatorio")
        String nombreUsuario,
        @Email(message = "El correo electrónico debe ser válido")
        @NotBlank(message = "El correo electrónico es obligatorio")
        String email,
        @NotBlank(message = "La contraseña es obligatoria")
        String password,
        @NotBlank(message = "El nombre es obligatorio")
        String nombres,
        @NotBlank(message = "Los apellidos son obligatorios")
        String apellidos,
        @NotBlank(message = "El teléfono es obligatorio")
        String telefono,
        @NotBlank(message = "La dirección es obligatoria")
        String direccion,
        Rol rol) {


}
