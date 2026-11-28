package com.pikko.backend.dto;

import com.pikko.backend.model.Usuario;
import com.pikko.backend.model.enums.Rol;
public record UsuarioDTO (
    Long id, 
    String nombreUsuario,
    String email,
    String nombre,
    String apellidos,
    Rol rol)
    {
        public static UsuarioDTO desde(Usuario usuario){
            return new UsuarioDTO(
                usuario.getId(),
                usuario.getNombreUsuario(),
                usuario.getEmail(),
                usuario.getNombre(),
                usuario.getApellidos(),
                usuario.getRol()
            );
    }
}
