package com.pikko.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pikko.backend.dto.RetoDTO;
import com.pikko.backend.service.RetoService;



@RestController
@RequestMapping("/api/retos")
public class RetoController {
    private final RetoService retoService;

    public RetoController(RetoService retoService) {
        this.retoService = retoService;
    }

    @GetMapping
    public List<RetoDTO> listar() {
        return retoService.listarRetos();
    }

    @GetMapping("/{id}")
    public RetoDTO obtener(@PathVariable Long id) {
        return retoService.obtenerReto(id);
    }
}
