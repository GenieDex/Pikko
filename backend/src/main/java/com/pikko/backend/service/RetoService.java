package com.pikko.backend.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.pikko.backend.dto.RetoDTO;
import com.pikko.backend.model.enums.EstadoModeracion;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.pikko.backend.repository.RetoRepository;

@Service 
@Transactional(readOnly = true)
public class RetoService {
    private final RetoRepository retoRepository;

    public RetoService(RetoRepository retoRepository){
        this.retoRepository = retoRepository;
    }

    public List<RetoDTO> listarRetos(){
        return retoRepository.findByEstadoModeracion(EstadoModeracion.APROBADO)
        .stream()
        .map(RetoDTO::desde)
        .toList();

    }

    public RetoDTO obtenerReto(Long id){
        return retoRepository.findByIdAndEstadoModeracion(id, EstadoModeracion.APROBADO)
        .map(RetoDTO::desde)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reto no encontrado"));
    }
}
