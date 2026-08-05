package com.luisangelpardave.sistema_gestion_tareas.repository;

import com.luisangelpardave.sistema_gestion_tareas.model.Rol;
import com.luisangelpardave.sistema_gestion_tareas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //búsquedas exactas
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

    Optional<Usuario> findByEmail(String email);


    // búsqueda multiple
    Optional<Usuario> findByNombreUsuarioOrEmail(String nombreUsuario, String email);

    // búsqueda por estado
    List<Usuario> findByEstadoTrue();

    List<Usuario> findByEstadoFalse();


    // búsqueda por rol
    List<Usuario> findByRol(Rol rol);

    // Búsquedas por coincidencia (Buscador en un panel de admin)
    List<Usuario> findByNombreUsuarioContainingIgnoreCase(String nombreUsuario);

    // Verificaciones de existencia (Optimización para registros)
    boolean existsByNombreUsuario(String nombreUsuario);

    boolean existsByEmail(String email);
}
