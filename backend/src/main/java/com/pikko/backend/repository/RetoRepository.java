package com.pikko.backend.repository;

import com.pikko.backend.model.Reto;
import com.pikko.backend.model.enums.EstadoModeracion;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RetoRepository extends JpaRepository<Reto, Long> {
    List<Reto> findByEstadoModeracion(EstadoModeracion estadoModeracion);
    Optional<Reto> findByIdAndEstadoModeracion(Long id, EstadoModeracion estadoModeracion);
}