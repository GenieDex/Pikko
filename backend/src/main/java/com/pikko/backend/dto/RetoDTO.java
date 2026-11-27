package com.pikko.backend.dto;

import java.time.LocalDate;
import com.pikko.backend.model.enums.Categoria;
import com.pikko.backend.model.enums.TipoPrueba;
import com.pikko.backend.model.Reto;

public record RetoDTO(
    Long id,
    String titulo,
    String descripcion,
    Categoria categoria,
    TipoPrueba tipoPrueba,
    LocalDate fechaInicio,
    LocalDate fechaFin,
    String nombreCreador) {

    public static RetoDTO desde(Reto reto){
        return new RetoDTO(
            reto.getId(),
            reto.getTitulo(),
            reto.getDescripcion(),
            reto.getCategoria(),
            reto.getTipoPrueba(),
            reto.getFechaInicio(),
            reto.getFechaFin(),
            reto.getCreador().getNombreUsuario()
        );
    }
}
