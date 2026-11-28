package com.pikko.backend.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.pikko.backend.dto.RegistroRequest;
import com.pikko.backend.dto.UsuarioDTO;
import com.pikko.backend.model.Usuario;
import com.pikko.backend.repository.UsuarioRepository;

@Service 
@Transactional 
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioDTO registrar(RegistroRequest request) {
        if (usuarioRepository.existsByEmail(request.email())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ese email ya está en uso");
        }else if (usuarioRepository.existsByNombreUsuario(request.nombreUsuario())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ese nombre de usuario ya está en uso");
        }else{
            Usuario usuario = new Usuario(request.nombreUsuario(), request.email(), passwordEncoder.encode(request.password()));
            usuario.setNombre(request.nombre());
            usuario.setApellidos(request.apellidos());
            usuarioRepository.save(usuario);
            return UsuarioDTO.desde(usuario);
        }
        
    }

}
