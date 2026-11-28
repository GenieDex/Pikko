package com.pikko.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

public record RegistroRequest(
    @NotBlank(message = "Introduce un nombre de usuario")
    @Size(min = 3, max = 30, message = "El nombre debe tener entre 3 y 30 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Solo letras, números y guion bajo.")
    String nombreUsuario,

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no tiene un formato válido")
    String email,

    @Size(min = 8, max = 64, message = "La contraseña debe tener entre 8 y 64 caracteres.")
    @NotBlank(message = "Introduce una contraseña.")
    String password,

    @Size(max = 30, message = "No debe superar los 30 caracteres.")
    String nombre,

    @Size(max = 30, message = "No debe superar los 30 caracteres.")
    String apellidos
) { 
}
