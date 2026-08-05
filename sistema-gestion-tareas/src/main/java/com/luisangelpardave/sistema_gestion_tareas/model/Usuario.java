package com.luisangelpardave.sistema_gestion_tareas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Credenciales de acceso
    @NotNull(message = "El nombre de usuario no puede estar vacio.")
    @Column(nullable = false, length = 50, unique = true)
    private String nombreUsuario;

    @Email(message = "El correo electrónico debe ser válido")
    @NotBlank(message = "El correo no puede estar en blanco")
    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @NotBlank(message = "La contraseña no puede estar en blanco")
    @Column(nullable = false)
    private String password;

    //Datos personales

    @NotBlank(message = "El nombre no puede estar vacio ")
    @Column(nullable = false, length = 50)
    private String nombres;

    @NotBlank(message = "Los apellidos no pueden estar vacios")
    @Column(nullable = false, length = 50)
    private String apellidos;

    @Column(nullable = false, length = 20, unique = true)
    private String telefono;

    @Column(nullable = false, length = 100)
    private String direccion;


    // Autorizacion y estado
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol; // usuario or ADMINISTRADOR

    @Column(nullable = false)
    private boolean estado = true;  // TRUE = ACTIVO  OR FALSE = APAGADO

}