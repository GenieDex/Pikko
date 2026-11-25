package com.pikko.backend.repository;

import com.pikko.backend.model.Participacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipacionRepository extends JpaRepository<Participacion, Long> {
}